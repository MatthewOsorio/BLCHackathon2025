package com.roomie.questionnaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireService {
    private QuestionnaireRepository questionnaireRepository;

    @Autowired
    public QuestionnaireService(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    private boolean validateQuestionnaire(Questionnaire questionnaire){
        if (questionnaire == null) return false;

        return isNotEmpty(questionnaire.getResponseOne())
            && isNotEmpty(questionnaire.getResponseTwo())
            && isNotEmpty(questionnaire.getResponseThree())
            && isNotEmpty(questionnaire.getResponseFour())
            && isNotEmpty(questionnaire.getResponseFive());
    }

    private boolean isNotEmpty(String value){
        return value != null && !value.trim().isEmpty();
    }

    public void savQuestionnaire(Questionnaire questionnaire) {
        if(!validateQuestionnaire(questionnaire)){
            throw new IllegalStateException("Invalid questionaire responses.");
        }

        questionnaireRepository.save(questionnaire);
    }

    public Questionnaire getByStudentId(Long studentId) {
        return questionnaireRepository.findQuestionnaireByStudentId(studentId).orElseThrow(() -> new IllegalStateException("User has not done the questionnaire."));
    }
    
}
