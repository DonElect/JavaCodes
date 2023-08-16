package com.donatus.impliments;

import com.donatus.models.Applicants;
import com.donatus.services.ApplicantServices;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ApplicantImp extends Applicants implements ApplicantServices {

    private ApplicantImp(String firstName, String lastName, int age, String field, String grade, int admissionExamScore) {
        super(firstName, lastName, age, field, grade, admissionExamScore);

    }
    public ApplicantImp() {
    }

    private ApplicantImp(String firstName, String lastName, int age, String email, String address, String highestQualification, String subjectTaught, int examScore) {
        super(firstName, lastName, age, email, address, highestQualification, subjectTaught, examScore);
    }

    public void apply(){
        Scanner sc = new Scanner(System.in);
        //sc.nextLine();
        System.out.println("--------------------------------------------------------");
        byte choice =0;
        try {
            System.out.print("Are you applying as  teacher or a student?"+"\nFor Staff Application, enter 1, for student enter 2: ");
            choice = sc.nextByte();
        }catch (InputMismatchException e){
            System.out.println("Invalid entry");
        }


        if(choice == 1){
            System.out.println("You are applying as a Staff.");
            System.out.println("----------Applicant Details--------");
            System.out.print("First name: ");
            String firstName =sc.next();

            System.out.print("Last name: ");
            String lastName = sc.next();

            System.out.print("Age: "); //System.out.print("");
            int age = sc.nextInt();
            //String firstName, String lastName, byte age, String email, String address, String highestQualification, String subjectTaught
            System.out.print("Email: ");
            String email = sc.next();

            System.out.print("Address: ");
            String address = sc.next();

            System.out.print("Highest Educational Qualification: ");
            String highestQualification = sc.next();

            System.out.print("Subject you teach: ");
            String subjectTaught = sc.next();

            System.out.print("Your Application Exam score: ");
            int examScore = sc.nextInt();

            staffApplicationList.add(new ApplicantImp(firstName, lastName, age, email, address, highestQualification, subjectTaught, examScore));
            System.out.println("Application Received." + "\nYou will be contacted if you meet our requirements."+"\n");
        }
        else if (choice == 2){
            System.out.println("You are applying as a Student.");
            System.out.println("---------Applicant Details--------");
            System.out.print("First name: ");
            String firstName =sc.next();

            System.out.print("Last name: ");
            String lastName = sc.next();

            System.out.print("Age: ");
            int age = sc.nextInt();

            System.out.print("Field (Science/Art/Commerce): ");
            String field = sc.next();

            System.out.print("Grade (Jss1, Jss2, SS1, etc.): ");
            String grade = sc.next();

            System.out.print("What was your score(over 100): ");
            int admissionExamScore = sc.nextInt();

            studentApplicationList.add(new ApplicantImp(firstName, lastName, age, field, grade, admissionExamScore));
            System.out.println("Application Received." + "\nYou will be contacted if you meet our requirements."+"\n");
        }
        else
            System.out.println("Invalid choice. Good bye.");
    }

    public List<ApplicantImp> getStudentApplicationList(){
        return studentApplicationList;
    }
    public List<ApplicantImp> getStaffApplicationList(){
        return staffApplicationList;
    }
}
