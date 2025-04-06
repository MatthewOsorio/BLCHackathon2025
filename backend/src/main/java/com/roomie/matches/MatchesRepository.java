package com.roomie.matches;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.roomie.student.Student;


@Repository
public interface MatchesRepository extends JpaRepository<Matches, Long>{
    List<Matches> findByPrimaryStudentId(Long studentId);
    Optional<Matches> findByPrimaryStudentAndSecondaryStudent(Student primary, Student secondary);

    @Query("SELECT m FROM Matches m WHERE m.primaryStudent.id = :studentId OR m.secondaryStudent.id = :studentId")
    List<Matches> findMatchesInvolvingStudent(Long studentId);}
