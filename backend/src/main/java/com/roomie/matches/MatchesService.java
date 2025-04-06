package com.roomie.matches;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.roomie.student.Student;
import com.roomie.student.StudentRepository;

@Service
public class MatchesService {

    private MatchesRepository matchesRepository;
    private StudentRepository studentRepository;

    @Autowired
    public MatchesService(MatchesRepository matchesRepository, StudentRepository studentRepository) {
        this.matchesRepository = matchesRepository;
        this.studentRepository = studentRepository;
    }
    
    public List<Matches> getMatchesByPrimaryStudentId(Long studentId){
        return matchesRepository.findByPrimaryStudentId(studentId);
    }

    public void saveMatches(JsonNode matches, Student primaryStudent){

        for (JsonNode match : matches){
            Long studentMatchId = match.get("studentId").asLong();
            Student secondaryStudent = studentRepository.findById(studentMatchId)
            .orElseThrow(() -> new IllegalStateException("Student not found with id " + studentMatchId));                int score = match.get("score").asInt();

            Matches newMatch = new Matches();
            newMatch.setPrimaryStudent(primaryStudent);
            newMatch.setSecondaryStudent(secondaryStudent);
            newMatch.setScore(score);

            matchesRepository.save(newMatch);
            
        }
    }

    public void likeStudent(Long studentWhoLikedId, Long otherStudentId){
        Optional<Student> liker = studentRepository.findById(studentWhoLikedId);
        if(!liker.isPresent()){
			throw new IllegalStateException("student with id " + studentWhoLikedId + " does not exists");
        }

        Student studentWhoLiked = liker.get();
        Optional<Student> otherStudent = studentRepository.findById(otherStudentId);
        if(!otherStudent.isPresent()){
			throw new IllegalStateException("student with id " + otherStudentId + " does not exists");
        }

        Student likeRecipient = otherStudent.get();

        Match


    }
}

