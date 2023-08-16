package com.donatus.impliments;

import com.donatus.models.Principal;
import com.donatus.models.Students;
import com.donatus.services.StudentServices;

import java.util.Map;

public class StudentImp extends Students implements StudentServices {
    public StudentImp(String firstName, String lastName, int age, String field, String grade) {
        super(firstName, lastName, age, field, grade);
    }

    @Override
    public void takeClass(String subject) {
        Map<String, TeachersImp> teachersList = new PrincipalImp().getStaffList();
        if(teachersList.containsKey(subject)){
            System.out.println("Hello class. My name is "+ teachersList.get(subject).getFirstName()+
                    ". I am your "+teachersList.get(subject).getSubjectTaught() +" teacher.");
            teachersList.get(subject).teach();
        }
        else
            System.out.println("We are yet to employ a "+ subject+ " teacher.");
    }
}
