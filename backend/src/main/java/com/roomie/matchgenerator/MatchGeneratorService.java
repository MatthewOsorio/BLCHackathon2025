package com.roomie.matchgenerator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.roomie.gpt.GptMatchService;
import com.roomie.matches.MatchesService;
import com.roomie.questionnaire.Questionnaire;

@Service
public class MatchGeneratorService {

    private final GptMatchService gptMatchService;
    private final MatchesService matchesService;

    @Autowired
    public MatchGeneratorService(GptMatchService gptMatchService, MatchesService matchesService){
        this.gptMatchService = gptMatchService;
        this.matchesService = matchesService;
    }

    public void generateAndSaveMatches(Questionnaire studentQuestionnaire, List<Questionnaire> allQuestionnaires) {
        JsonNode matches = gptMatchService.generateMatchesForStudent(studentQuestionnaire, allQuestionnaires);
        matchesService.saveMatches(matches, studentQuestionnaire.getStudent());
    }
}
