package com.tabletennis.entity;

public class Score {
    private Integer id;
    private Integer matchId;
    private Integer playerId;
    private Integer score;

    public Score(){}

    public Score(Integer id,Integer matchId,Integer playerId,Integer score){
        this.id=id;
        this.matchId=matchId;
        this.playerId=playerId;
        this.score=score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}