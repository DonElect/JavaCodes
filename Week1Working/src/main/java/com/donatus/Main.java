package com.donatus;

import com.donatus.models.Staffs;
import com.donatus.models.Student;

public class Main {

    public static void main(String[] args) {
        Staffs principal = new Staffs("Donatus", 32, "1234567", Duties.PRINCIPAL, "None");
        Staffs chemistryTeacher = principal.hire("James", 31, "23455", Duties.ACADEMIC, "Chemistry");
        Staffs librarian = new Staffs("Jane", 31, "56789", Duties.LIBRARIAN, null);

        Student student1 = new Student("Mary", 15, "10001", "SS1");

        librarian.updateLibrary();

        student1.takeACourse("Chemistry", chemistryTeacher);
        principal.admitStudent("Blessing", 16, "10002", "SS2");
        principal.expel("Blessing");

        student1.bookRequest("Mathematics");
        principal.bookRequest("Mathematics");
        librarian.releaseBooks();
    }
}
