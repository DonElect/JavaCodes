package com.donatus.models;

import com.donatus.services.StudentServices;

public class Student extends Person implements StudentServices {
    private int priority = 1;
    private  String studentClass;


    public Student(String name, int age, String ID, String studentClass) {
        super(name, age, ID);
        this.studentClass = studentClass;
    }

    public String getStudentClass() {
        return studentClass;
    }

    @Override
    public void bookRequest(String bookName) {
        // Senior students have a higher priority than junior students
        if((getStudentClass().equalsIgnoreCase("SS3")) ||
                (getStudentClass().equalsIgnoreCase("SS2")) ||
                (getStudentClass().equalsIgnoreCase("SS1"))){
            priority = 2;
            PriorityGenerator newPerson = new PriorityGenerator(priority, bookName, getName());
            newPerson.addToQueue(newPerson);
        }
        else {
            PriorityGenerator newPerson = new PriorityGenerator(priority, bookName, getName());
            newPerson.addToQueue(newPerson);
        }
    }

    @Override
    public void takeACourse(String subject, Staffs staffs) {
        if (staffs.getSubjectTaught() == subject){
            staffs.teach();
        }
        else
            System.out.println("I don't teach "+subject+". I am a "+staffs.getSubjectTaught()+ " teacher.");
    }
}
