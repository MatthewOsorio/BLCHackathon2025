package com.roomie.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roomie.matchgenerator.MatchGeneratorService;
import com.roomie.authentication.LoginRequest;
import com.roomie.matches.Matches;
import com.roomie.matches.MatchesService;
import com.roomie.questionnaire.Questionnaire;
import com.roomie.questionnaire.QuestionnaireService;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

	private final StudentRepository studentRepository;
	private final QuestionnaireService questionnaireService;
	private final MatchGeneratorService matchesGeneratorService;
	private final MatchesService matchesService;

	@Autowired
	public StudentService(StudentRepository studentRepository, QuestionnaireService questionnaireService, MatchGeneratorService matchesGeneratorService, MatchesService matchesService){
		this.studentRepository = studentRepository;
		this.questionnaireService = questionnaireService;
		this.matchesGeneratorService = matchesGeneratorService;
		this.matchesService = matchesService;
	}

	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public Student getStudent(Long studentId) {
		Optional<Student> studentOptional  = studentRepository.findById(studentId);

		if (!studentOptional.isPresent()){
			throw new IllegalStateException("student with id " + studentId + " does not exists");
		}

		return studentOptional.get();
	}

	public void addNewStudent(Student student) {
		Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

		if (studentOptional.isPresent()){
			throw new IllegalStateException("Email taken");
		}

		studentRepository.save(student);
	}

    public void deleteStudent(Long studentId) {
		boolean exist = studentRepository.existsById(studentId);

		if(!exist){
			throw new IllegalStateException("student with id " + studentId + " does not exists");
		}

		studentRepository.deleteById(studentId);
	}

	@Transactional
	public void updateStudent(Long studentId, String name, String email){
		Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exist"));

		if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
			student.setName(name);
		}

		if(email != null && name.length() > 0 && !Objects.equals(student.getEmail(), email)){
			Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
			if (studentOptional.isPresent()){
				throw new IllegalStateException("email taken");
			}
			student.setEmail(email);
		}
	}

	public Questionnaire getStudentQuestionnaire(Long studentId) {
		return questionnaireService.getByStudentId(studentId);
    }

	@Transactional
	public void submitQuestionnaire(Long studentId, Questionnaire questionnaire){
		Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exists"));
		questionnaire.setStudent(student);
		questionnaireService.saveQuestionnaire(questionnaire);
	}

	public void generateMatches(Long studentId){
		List<Student> students = studentRepository.findAllExcept(studentId);
		List<Long> studentIds= students.stream()
			.map(Student::getId)
			.collect(Collectors.toList());

		Questionnaire studentQuestionnaire = questionnaireService.getByStudentId(studentId);
		List<Questionnaire> allQuestionnaires = questionnaireService.getListOfQuestionnaireByStudentIds(studentIds);

		matchesGeneratorService.generateAndSaveMatches(studentQuestionnaire, allQuestionnaires);

	}	

	public List<Matches> getMatchesByPrimaryStudentId(Long studentId){
		return matchesService.getMatchesByPrimaryStudentId(studentId);
	}

	public List<String> getUserAddresses(Long studentId){
		Optional<Student> student = studentRepository.findById(studentId);
		if(!student.isPresent()){
			throw new IllegalStateException("student with id " + studentId + " does not exist");
		}

		Student currentStudent  = student.get();

		return currentStudent.getAddresses();
	}

	public void addAddressToStudent(Long studentId, String address){
		Optional<Student> student = studentRepository.findById(studentId);
		if(!student.isPresent()){
			throw new IllegalStateException("student with id " + studentId + " does not exist");
		}

		Student currentStudent  = student.get();

		currentStudent.appendAddress(address);

		studentRepository.save(currentStudent);
	}

	public void removeAddressFromStudent(Long studentId, String address){
		Optional<Student> student = studentRepository.findById(studentId);
		if(!student.isPresent()){
			throw new IllegalStateException("student with id " + studentId + " does not exist");
		}

		Student currentStudent  = student.get();

		currentStudent.removeAddress(address);
	}

	public boolean checkCredentials(LoginRequest loginRequest){
		Optional<Student> studentOptional = studentRepository.findStudentByEmail(loginRequest.getEmail());

		if(!studentOptional.isPresent()){
			return false;
		}
		
		Student student = studentOptional.get();

		if(!student.getPassword().equals(loginRequest.getPassword())){
			return false;
		}

		return true;
		
	}	

	public Student findStudentByEmail(String email){
		Optional<Student> newStudent = studentRepository.findStudentByEmail(email);

		if(!newStudent.isPresent()){
			throw new IllegalStateException("Email incorrect");
		}

		return newStudent.get();
	}

	public void saveStudent(Student student){
		studentRepository.save(student);
	}
}
