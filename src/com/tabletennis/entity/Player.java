package com.tabletennis.entity;

public class Player {
    private Integer id;
    private String name;
    private Integer age;
    private String team;

    public Player() {}

    public Player(Integer id, String name, Integer age, String team) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.team = team;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}