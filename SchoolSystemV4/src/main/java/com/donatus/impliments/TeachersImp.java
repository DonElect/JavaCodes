package com.donatus.impliments;

import com.donatus.models.Students;
import com.donatus.models.Teachers;
import com.donatus.services.TeachersServices;

import java.util.Map;
import java.util.Scanner;

public class TeachersImp extends Teachers implements TeachersServices {

    public TeachersImp(String firstName, String lastName, int age, String email, String address, String highestQualification, String subjectTaught) {
        super(firstName, lastName, age, email, address, highestQualification, subjectTaught);
    }

    @Override
    public void teach() {
        Map<String, TeachersImp> teachersList = new PrincipalImp().getStaffList();
        if(!teachersList.isEmpty()) {
            if (getSubjectTaught().equalsIgnoreCase("Physics")) {
                System.out.println("Today i will be taking you in Physics");
                System.out.println("""
                        Hooke's Law states that provided the elastic limit\s
                        of an elastic material is not exceeded, the extension e is\s
                        directly proportional to the applied force or load
                        """);
            } else if (getSubjectTaught().equalsIgnoreCase("Chemistry")) {
                System.out.println("Today i will be taking you in Chemistry");
                System.out.println("""
                        The law of definite proportion states that\s
                        when two or more elements combine to form a\s
                        compound, they do so in simple whole number ratio by mass or weight
                        """);
            } else if (getSubjectTaught().equalsIgnoreCase("Literature")) {
                System.out.println("Today i will be taking you in Literature");
                System.out.println("We will be discussing the book THINGS FALL APART by Chino Echebe." + "\n");
            } else if (getSubjectTaught().equalsIgnoreCase("Accounting")) {
                System.out.println("Today i will be taking you in Accounting");
                System.out.println("How do you balance a sheet?" + "\n");
            } else {
                System.out.println("I am your " + getSubjectTaught() + ". What do you know about" + getSubjectTaught() + "\n");
            }
        }
        else System.out.println("No teacher employed yet\n");
    }

    @Override
    public void scoreStudent() {
        Map<String, StudentImp> studentList = new PrincipalImp().getStudentList();
        if(!studentList.isEmpty()){
            Scanner sc = new Scanner(System.in);
            for(Students student : studentList.values()){
                System.out.print(student.getFirstName()+ " score: ");
                int score = sc.nextInt();
                student.setScore(score);
                if(score < 45){
                    student.setStrikes(student.getStrikes()+1);
                }
            }
            System.out.println("Done Scoring Students.");
        }

    }
    @Override
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


    @Override
    public String toString() {
        return "Teachers{" +
                "name='" + getFirstName()+" "+getLastName()+ '\''+
                "subjectTaught='" + getSubjectTaught() + '\'' +
                '}';
    }
}
