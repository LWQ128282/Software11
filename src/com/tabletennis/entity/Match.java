package com.tabletennis.entity;

public class Match {
    private Integer matchId;
    private String matchName;
    private String matchTime;
    private String location;

    public Match() {}

    public Match(Integer matchId, String matchName, String matchTime, String location) {
        this.matchId = matchId;
        this.matchName = matchName;
        this.matchTime = matchTime;
        this.location = location;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}