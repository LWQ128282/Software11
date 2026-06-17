    private Integer matchId;
    private Integer playerId;
    private String round;

    public Schedule() {}

    public Schedule(Integer scheduleId, Integer matchId, Integer playerId, String round) {
        this.scheduleId = scheduleId;
        this.matchId = matchId;
        this.playerId = playerId;
        this.round = round;
    }

    public Integer getScheduleId() {
