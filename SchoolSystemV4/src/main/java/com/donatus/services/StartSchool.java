package com.donatus.services;

import com.donatus.impliments.*;
import com.donatus.models.*;
import com.donatus.models.Principal.*;

import java.util.Scanner;
public class StartSchool {
    public static void startSchool(){
        PrincipalImp principal = new PrincipalImp("Donatus", "Okpala", 42,
                "electroodob@gmail.com", "Decagon", "B.Tech");
        ApplicantImp newApplicant = new ApplicantImp();
        StudentImp student = new StudentImp("Blessing", "Ene",
                15, "Science", "SS3");
        principal.addStudent(student);

        TeachersImp teacher = new TeachersImp("Mike", "John",32,
                "mikejohn@hgmail.com", "Ohen Street",
                "B.Tech", "Physics");
        principal.addStaff(teacher);

        NonAcademicImp cleaner = new NonAcademicImp("Jane", "Long",
                36, "janelong@gmail.com", "Long-house", "High school", "Cleaner");
        principal.addStaff(cleaner);

        Scanner sc = new Scanner(System.in);
        String command = "no";
        do{
            System.out.println("For list of commands, type help." +
                    "\nWhat would you like to do: ");
            command = sc.nextLine();
            if(command.equalsIgnoreCase("applicant")){
                do{
                    newApplicant.apply();
                    System.out.print("Are you done(yes or no): ");
                }while(sc.nextLine().equalsIgnoreCase("no"));
                System.out.println(" ");
            }
            else if (command.equalsIgnoreCase("admit")) {
                principal.admit();
            }
            else if(command.equalsIgnoreCase("sort-students")){
                principal.sortStudents();
            }
            else if (command.equalsIgnoreCase("expel")){
                principal.expel();
            }
            else if(command.equalsIgnoreCase("hire")){
                principal.hire();
            }
            else if(command.equalsIgnoreCase("fire")){
                System.out.println("Who do you want to fire?: ");
                System.out.println("");
                String name = sc.nextLine();
                principal.fire(name);
            }
            else if(command.equalsIgnoreCase("take-class")){
                System.out.print("Which subject: ");
                String subject = sc.nextLine();
                student.takeClass(subject);
                System.out.println("");
            }
            else if(command.equalsIgnoreCase("teach")){
                teacher.teach();
            }
            else if(command.equalsIgnoreCase("score-student")){
                teacher.scoreStudent();
            }
            else if(command.equalsIgnoreCase("teacher-strike")){
                teacher.strike();
            }
            else if(command.equalsIgnoreCase("principal-strike")){
                principal.strike();
            }
            else if(command.equalsIgnoreCase("cleaner-strike")){
                cleaner.strike();
            }
            else if(command.equalsIgnoreCase("clean")){
                cleaner.clean("Toilet");
            }
            else if(command.equalsIgnoreCase("student-list")){
                principal.displayStudentList();
            }
            else if(command.equalsIgnoreCase("science-list")){
                principal.displayScienceList();
            }
            else if(command.equalsIgnoreCase("art-list")){
                principal.displayArtList();
            }
            else if(command.equalsIgnoreCase("commerce-list")){
                principal.displayCommerceList();
            }
            else if(command.equalsIgnoreCase("staff-list")){
                principal.displayStaffList();
            }
            else if(command.equalsIgnoreCase("help")){
                System.out.println("To take in NEW APPLICANTS (Teachers or Student), enter: applicant" +
                        "\nTo ADMIT new Student from the applicant list, enter: admit" +
                        "\nTo EXPEL students with 3 strikes, enter: expel" +
                        "\nTo HIRE new teachers from the application list, enter: hire" +
                        "\nTo FIRE a teacher, enter: fire" +
                        "\nTo TAKE A CLASS, enter: take-class" +
                        "\nTo SCORE each student, enter: score-student" +
                        "\nFor teacher to STRIKE a student, enter: teacher-strike" +
                        "\nTo SORT students, enter: sort-students" +
                        "\nFor Principal to STRIKE a student, enter: principal-strike" +
                        "\nFor Non-Academic staff to STRIKE a student, enter: cleaner-strike" +
                        "\nTo clean, enter: clean" +
                        "\nTo DISPLAY student list enter, 'student-list', 'science-list', 'art-list' or 'commerce-list'" +
                        "\nTo teach, enter: teach" +
                        "\nTo DISPLAY staffs, enter: staff-list");
            }

            System.out.print("Is school over?(yes or no): ");
        }while(sc.nextLine().equalsIgnoreCase("no"));
    }
}
