package com.donatus.impliments;

import com.donatus.models.NonAcademicStaff;
import com.donatus.services.NonAcademicStaffServices;

import java.util.Map;
import java.util.Scanner;

public class NonAcademicImp extends NonAcademicStaff implements NonAcademicStaffServices {
    public NonAcademicImp(String firstName, String lastName, int age, String email, String address, String highestQualification, String jobTitle) {
        super(firstName, lastName, age, email, address, highestQualification, jobTitle);
    }

    public void clean(String where) {
        System.out.println("Alright.");
        System.out.println("Done cleaning the "+where+". \n");
    }

    public void strike(){
        Scanner sc = new Scanner(System.in);
        System.out.println("First name of student you want to give a strike: ");
        String firstName = sc.next();
        Map<String, StudentImp> studentList = new PrincipalImp().getStudentList();
        if (studentList.containsKey(firstName)){
            studentList.get(firstName).setStrikes(studentList.get(firstName).getStrikes()+1);
        }
        else
            System.out.println("No student with such name in this school\n");
    }
}
