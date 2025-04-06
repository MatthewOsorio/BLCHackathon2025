package com.roomie.matches;

public class MatchesDTO {
    private Long matchId;
    private Long primaryStudentId;
    private Long secondaryStudentId;
    private Integer score;

    public MatchesDTO() {}

    public MatchesDTO(Matches mathces) {
        this.matchId = mathces.getId();
        this.primaryStudentId = mathces.getPrimaryStudent().getId();
        this.secondaryStudentId = mathces.getSecondaryStudent().getId();
        this.score = mathces.getScore();
    }

    public Long getMatchId() {
        return matchId;
    }

    public Long getPrimaryStudentId() {
        return primaryStudentId;
    }

    public Long getSecondaryStudentId() {
        return secondaryStudentId;
    }

    public Integer getScore() {
        return score;
    }
}
