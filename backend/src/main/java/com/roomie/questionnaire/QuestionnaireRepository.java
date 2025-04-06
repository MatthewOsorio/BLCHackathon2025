package com.roomie.questionnaire;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long>{
    Optional<Questionnaire> findQuestionnaireByStudentId(Long id);
}
