package com.roomie.questionnaire;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long>{
    Optional<Questionnaire> findQuestionnaireByStudentId(Long studentId);

    List<Questionnaire> findByStudentIdIn(List<Long> studentIds);
}
