package com.donatus.models;

import com.donatus.impliments.ApplicantImp;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public abstract class Applicants extends Students{

    private String email;
    private String address;
    private String highestQualification;
    private String subjectTaught;
    private int examScore;
    private int admissionExamScore;

    protected static List<ApplicantImp> studentApplicationList = new ArrayList<>();
    protected static List<ApplicantImp> staffApplicationList = new ArrayList<>();
    protected Applicants(String firstName, String lastName, int age, String field, String grade, int admissionExamScore) {
        super(firstName, lastName, age, field, grade);
        this.admissionExamScore = admissionExamScore;
    }

    protected Applicants(){

    }

    protected Applicants(String firstName, String lastName, int age, String email, String address, String highestQualification, String subjectTaught, int examScore){
        super(firstName, lastName, age);
        this.email = email;
        this.address = address;
        this.highestQualification = highestQualification;
        this.subjectTaught = subjectTaught;
        this.examScore = examScore;
    }

    public int getAdmissionExamScore() {
        return admissionExamScore;
    }

    public int getExamScore() {
        return examScore;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getHighestQualification() {
        return highestQualification;
    }


    public String getSubjectTaught() {
        return subjectTaught;
    }

}
