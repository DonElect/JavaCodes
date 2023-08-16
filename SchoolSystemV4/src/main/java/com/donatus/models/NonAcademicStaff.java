package com.donatus.models;

import com.donatus.services.NonAcademicStaffServices;

import java.util.Map;
import java.util.Scanner;

public abstract class NonAcademicStaff extends Staffs {
    private String jobTitle;
    public NonAcademicStaff(String firstName, String lastName, int age, String email, String address, String highestQualification,String jobTitle) {
        super(firstName, lastName, age, email, address, highestQualification);
        this.jobTitle = jobTitle;
    }
}
