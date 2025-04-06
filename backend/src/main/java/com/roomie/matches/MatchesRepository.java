package com.roomie.matches;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roomie.student.Student;


@Repository
public interface MatchesRepository extends JpaRepository<Matches, Long>{
    List<Matches> findByPrimaryStudentId(Long studentId);
    Optional<Matches> findByPrimaryStudentAndSecondaryStudent(Student primary, Student secondary);
}
