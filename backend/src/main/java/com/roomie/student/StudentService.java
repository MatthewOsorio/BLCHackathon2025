package com.roomie.student;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roomie.questionnaire.Questionnaire;
import com.roomie.questionnaire.QuestionnaireService;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

	private final StudentRepository studentRepository;
	private final QuestionnaireService questionnaireService;

	@Autowired
	public StudentService(StudentRepository studentRepository, QuestionnaireService questionnaireService){
		this.studentRepository = studentRepository;
		this.questionnaireService = questionnaireService;
	}

	public List<Student> getStudents() {
		return studentRepository.findAll();
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
		questionnaireService.savQuestionnaire(questionnaire);
	}

}
