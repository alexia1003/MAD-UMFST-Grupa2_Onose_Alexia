package com.example.lab6_ex4_mad;
public class Participant {
    private String name;
    private String surname;
    private int score;

    public Participant(String name, String surname, int score) {
        this.name = name;
        this.surname = surname;
        this.score = score;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return name + " " + surname + " - Score: " + score;
    }
}
