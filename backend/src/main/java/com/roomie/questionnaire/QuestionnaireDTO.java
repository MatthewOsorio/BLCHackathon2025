package com.roomie.questionnaire;

public class QuestionnaireDTO {
    private Long id;
    private String responseOne;
    private String responseTwo;
    private String responseThree;
    private String responseFour;
    private String responseFive;
    private Long studentId;

    public QuestionnaireDTO(Questionnaire questionare) {
        this.id = questionare.getId();
        this.responseOne = questionare.getResponseOne();
        this.responseTwo = questionare.getResponseTwo();
        this.responseThree = questionare.getResponseThree();
        this.responseFour = questionare.getResponseFour();
        this.responseFive = questionare.getResponseFive();
        this.studentId = questionare.getStudent().getId();
    }

    public Long getId() {
        return id;
    }

    public String getResponseOne() {
        return responseOne;
    }

    public String getResponseTwo() {
        return responseTwo;
    }

    public String getResponseThree() {
        return responseThree;
    }

    public String getResponseFour() {
        return responseFour;
    }

    public String getResponseFive() {
        return responseFive;
    }

    public Long getStudentId() {
        return studentId;
    }
}
