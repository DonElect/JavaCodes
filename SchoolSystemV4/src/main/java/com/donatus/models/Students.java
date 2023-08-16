package com.donatus.models;

import com.donatus.impliments.TeachersImp;
import com.donatus.services.StudentServices;

import java.util.Map;

public abstract class Students {
    private String firstName;
    private String lastName;
    private int age;
    private String field;
    private int strikes;
    private String grade;
    private int score;

    public Students(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    public Students(String firstName, String lastName, int age, String field, String grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.field = field;
        this.grade = grade;
    }

    public Students() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getField() {
        return field;
    }


    public int getStrikes() {
        return strikes;
    }

    public void setStrikes(int strikes) {
        this.strikes = strikes;
    }

    public String getGrade() {
        return grade;
    }


    public  int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
