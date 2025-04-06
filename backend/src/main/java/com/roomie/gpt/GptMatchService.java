package com.roomie.gpt;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatCompletion;
import com.openai.models.ChatCompletionCreateParams;
import com.openai.models.ChatModel;
import com.roomie.questionnaire.Questionnaire;

@Service
public class GptMatchService {
    private final OpenAIClient client;

    public GptMatchService(){
        String apiKey = System.getProperty("OPENAI_API_KEY");
        client = OpenAIOkHttpClient.builder().apiKey(apiKey).build();
    }

    public JsonNode generateMatchesForStudent(Questionnaire studentQuestionnaire, List<Questionnaire> allQuestionnaires) {
        StringBuilder secondaryAnswers  = new StringBuilder();
        for (Questionnaire q : allQuestionnaires) {
            secondaryAnswers.append(q.toString()).append("\n");
        }

        String prompt = String.format("""
                These are questions from a questionnaire we are making people fill out to determine if they
                would be compatible as roomates:
                    1. What does a "clean" space mean to you, and whats your threshold before something feels messy or unlivable?
                    2. When you're overwhelmed or stressed, how does that usually show up in your space or behavior at home?
                    3. When you're annoyed about something small a roommate does, how do you usually bring it up-or do you let it slide?
                    4. What's a past roommate conflict you've had, and how did you handle it?
                    5. What are your non-negotiables in a roommate situation? What's something small that ended up being a big deal for you in the past?

                Here is the primary user responses: 
                    %s

                Here is all the secondary reponses:
                    %s

                Based on the primary user and the list of secondary users' questionnaires, rank them on compatibility from 1 to 10. Only return the the top 10 highest matches.
                Return your answer as JSON in this format, and do not return anything else.
                {
                "matches": [
                    {
                    "studentId": 123,
                    "score": 9,
                    },
                    {
                    "studentId": 456,
                    "score": 4,
                    }
                ]
                }
                """, studentQuestionnaire, secondaryAnswers);

        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
            .addUserMessage(prompt)
            .model(ChatModel.GPT_4O)
            .build();

        ChatCompletion chatCompletion = client.chat().completions().create(params);
        Optional<String> messageContent = chatCompletion.choices().get(0).message().content();

        if (!messageContent.isPresent()){
            throw new IllegalStateException("Could not get GPT Response");
        }   
        
        try{
            String gptResponse  = messageContent.get().replaceAll("^```json", "").replaceAll("```$", "").trim();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(gptResponse);
            return root.get("matches");
        }catch(JsonProcessingException err){
            throw new IllegalStateException("Failed to parse GPT response", err);
        }
    }

}
