package com.roomie.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roomie.matches.Matches;
import com.roomie.matches.MatchesDTO;
import com.roomie.matches.MatchesRepository;
import com.roomie.questionnaire.Questionnaire;
import com.roomie.questionnaire.QuestionnaireDTO;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;
    private final MatchesRepository matchesRepository;

    @Autowired
    public StudentController(StudentService studentService, MatchesRepository matchesRepository) {
        this.studentService = studentService;
        this.matchesRepository = matchesRepository;
    }

    @GetMapping
	public List<StudentDTO> getStudents() {
        return studentService.getStudents().stream().map(StudentDTO::new).toList();
	}

    @GetMapping(path = "{studentId}")
    public StudentDTO getStudent(@PathVariable("studentId") Long studentId){        
        return new StudentDTO(studentService.getStudent(studentId));
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    };

    @PutMapping(path="{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId, @RequestParam(required = false) String name, @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);
    }

    @GetMapping(path="{studentId}/questionnaire")
    public QuestionnaireDTO getStudentQuestionnaire(@PathVariable("studentId") Long studentId){
        return new QuestionnaireDTO(studentService.getStudentQuestionnaire(studentId));
    }
    
    @PostMapping(path="{studentId}/questionnaire")
    public void submitQuestionnaire(@PathVariable("studentId") Long studentId, @RequestBody Questionnaire questionnaire){
        studentService.submitQuestionnaire(studentId, questionnaire);
        studentService.generateMatches(studentId);
    }

    @GetMapping(path="{studentId}/matches")
    public List<MatchesDTO> getStudentMatches(@PathVariable("studentId") Long studentId){
        List<Matches> matchesList = matchesRepository.findByPrimaryStudentId(studentId);
    
        return matchesList.stream().map(m -> new MatchesDTO(m)).toList();
    }
}
