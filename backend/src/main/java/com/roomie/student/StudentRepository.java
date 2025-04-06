package com.roomie.student;

import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    
    Optional<Student> findStudentByEmail(String email);

    @Query("SELECT s FROM Student s WHERE s.id <> :id")
    List<Student> findAllExcept(@Param("id") Long id);
}
