package com.donatus.impliments;

import com.donatus.models.Applicants;
import com.donatus.models.Principal;
import com.donatus.services.PrincipalServices;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PrincipalImp extends Principal implements PrincipalServices {
    public PrincipalImp(String firstName, String lastName, int age, String email, String address, String highestQualification) {
        super(firstName, lastName, age, email, address, highestQualification);
    }

    public PrincipalImp() {

    }

    public void sortStudents(){
        for(StudentImp student : studentList.values()){
            if(student.getField().equalsIgnoreCase("SCIENCE")){
                scienceStudents.put(student.getFirstName(), student);
                System.out.println(student.getFirstName()+ " is in SCIENCE");
            }
            else if(student.getField().equalsIgnoreCase("ART")){
                artStudents.put(student.getFirstName(), student);
                System.out.println(student.getFirstName()+ " is in ART.");
            }
            else if(student.getField().equalsIgnoreCase("COMMERCE")){
                commercialStudents.put(student.getFirstName(), student);
                System.out.println(student.getFirstName()+ " is in COMMERCE.");
            }
            else {
                System.out.println(student.getFirstName() + " provided an invalid class interest. And has been expelled" + "\n");
                studentList.remove(student.getFirstName());
            }
        }
        System.out.println("Student have been sorted into Art, Science and Commerce."+"\n");
    }

    public void hire() {
        List<ApplicantImp> staffApplicationList = new ApplicantImp().getStaffApplicationList();
        for(Applicants applicant : staffApplicationList){
            if((applicant.getAge() <= 50 && applicant.getAge() >= 20) && (applicant.getExamScore() >= 70)){
                staffList.put(applicant.getSubjectTaught(), new TeachersImp(applicant.getFirstName(), applicant.getLastName(),
                        applicant.getAge(), applicant.getEmail(), applicant.getAddress(),
                        applicant.getHighestQualification(), applicant.getSubjectTaught()));

                System.out.println(applicant.getFirstName()+" application was ACCEPTED. Exam score is "+applicant.getExamScore());
            }
            else {
                System.out.println(applicant.getFirstName()+" application was REJECTED. Exam score is "+applicant.getExamScore());
            }
        }
        System.out.println("No of applicants "+staffApplicationList.size()+". Hired "+staffList.size()+"\n");
    }

    public void addStaff(TeachersImp teacher){
        staffList.put(teacher.getSubjectTaught(), teacher);
    }
    public void addStaff(NonAcademicImp cleaner){
        nonAcademicList.put(cleaner.getFirstName(), cleaner);
    }
    public void addStudent(StudentImp student){
        studentList.put(student.getFirstName(), student);
    }
    public void fire(String firstName) {
        if(staffList.containsKey(firstName)){
            staffList.remove(firstName);
            System.out.println(firstName+ " has been fired." +"\n");
        }
        else
            System.out.println("No staff with that name here.");
    }

    public void admit() {
        List<ApplicantImp> studentApplicationList = new ApplicantImp().getStudentApplicationList();
        for(Applicants applicant : studentApplicationList){
            if((applicant.getAge() <= 18) && (applicant.getAdmissionExamScore() >= 70)){
                studentList.put(applicant.getFirstName(), new StudentImp(applicant.getFirstName(),applicant.getLastName(),
                        applicant.getAge(), applicant.getField(), applicant.getGrade()));

                System.out.println(applicant.getFirstName()+" application was ACCEPTED. Exam score is "+applicant.getAdmissionExamScore());
            }
            else {
                System.out.println(applicant.getFirstName()+" application was REJECTED. Exam score is "+applicant.getAdmissionExamScore());
            }
        }
        System.out.println("No of applicants "+studentApplicationList.size()+". Admitted "+studentList.size()+"\n");
    }

    public void expel() {
//
        for (Map.Entry<String, StudentImp> student : studentList.entrySet()){
            if(student.getValue().getStrikes() >= 3){
                studentList.remove(student.getValue().getFirstName());
                if(scienceStudents.containsKey(student.getValue().getFirstName())){
                    scienceStudents.remove(student.getValue().getFirstName());
                }
                else if(artStudents.containsKey(student.getValue().getFirstName())){
                    artStudents.remove(student.getValue().getFirstName());
                }
                else commercialStudents.remove(student.getValue().getFirstName());
                System.out.println(student.getValue().getFirstName()+ " has been expelled." +"\n");
            }
            else
                System.out.println("No student to expel");
        }
    }


    public void expel(String firstName) {
        if(studentList.containsKey(firstName)){
            if(studentList.get(firstName).getStrikes() >= 3){
                studentList.remove(firstName);
                System.out.println(firstName+ " has been expelled."+"\n");
            }
            else
                System.out.println(firstName+ " still has "+ (3-studentList.get(firstName).getStrikes()) + " and could not be expelled."  +"\n");
        }
        else
            System.out.println("No student with that name in this school."+"\n");
    }
    @Override
    public void strike(){
        Scanner sc = new Scanner(System.in);
        System.out.println("First name of student you want to give a strike: ");
        String firstName = sc.next();
        if (studentList.containsKey(firstName)){
            studentList.get(firstName).setStrikes(studentList.get(firstName).getStrikes()+1);
        }
        else
            System.out.println("No student with such name in this school\n");
    }

    @Override
    public void displayStudentList() {
        for (StudentImp student : studentList.values()){
            System.out.println("Students{" +
                    "firstName='" + student.getFirstName() + '\'' +
                    ", lastName='" +student.getLastName() + '\'' +
                    ", age=" + student.getAge() +
                    ", field='" + student.getField() + '\'' +
                    ", strikes=" + student.getStrikes() +
                    ", grade='" + student.getGrade() + '\'' +
                    ", score=" + student.getScore() +
                    '}');
        }
    }

    @Override
    public void displayScienceList() {
        for (StudentImp student : scienceStudents.values()){
            System.out.println("Students{" +
                    "firstName='" + student.getFirstName() + '\'' +
                    ", lastName='" +student.getLastName() + '\'' +
                    ", age=" + student.getAge() +
                    ", field='" + student.getField() + '\'' +
                    ", strikes=" + student.getStrikes() +
                    ", grade='" + student.getGrade() + '\'' +
                    ", score=" + student.getScore() +
                    '}');
        }
    }

    @Override
    public void displayArtList() {
        for (StudentImp student : artStudents.values()){
            System.out.println("Students{" +
                    "firstName='" + student.getFirstName() + '\'' +
                    ", lastName='" +student.getLastName() + '\'' +
                    ", age=" + student.getAge() +
                    ", field='" + student.getField() + '\'' +
                    ", strikes=" + student.getStrikes() +
                    ", grade='" + student.getGrade() + '\'' +
                    ", score=" + student.getScore() +
                    '}');
        }
    }

    @Override
    public void displayCommerceList() {
        for (StudentImp student : commercialStudents.values()){
            System.out.println("Students{" +
                    "firstName='" + student.getFirstName() + '\'' +
                    ", lastName='" +student.getLastName() + '\'' +
                    ", age=" + student.getAge() +
                    ", field='" + student.getField() + '\'' +
                    ", strikes=" + student.getStrikes() +
                    ", grade='" + student.getGrade() + '\'' +
                    ", score=" + student.getScore() +
                    '}');
        }
    }

    @Override
    public void displayStaffList() {
        for (TeachersImp staff : staffList.values()){
            System.out.println("Students{" +
                    "firstName='" + staff.getFirstName() + '\'' +
                    ", lastName='" +staff.getLastName() + '\'' +
                    ", age=" + staff.getAge() +
                    ", email='" + staff.getEmail() + '\'' +
                    ", address=" + staff.getAddress() +
                    ", qualification='" + staff.getHighestQualification() + '\'' +
                    ", subjectTaught=" + staff.getSubjectTaught() +
                    '}');
        }
    }

}
