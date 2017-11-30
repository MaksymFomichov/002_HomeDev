package com.gmail.fomichov.m.model;

public class Skill {
    private Long id;
    private String skill;

    public Skill() {
    }

    public Skill(Long id, String skill) {
        this.id = id;
        this.skill = skill;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Skill withId(Long id) {
        this.id = id;
        return this;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Skill withSkill(String skill) {
        this.skill = skill;
        return this;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", skill='" + skill + '\'' +
                '}';
    }
}
