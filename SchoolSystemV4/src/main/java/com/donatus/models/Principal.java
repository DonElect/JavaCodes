package com.donatus.models;
;
import com.donatus.impliments.NonAcademicImp;
import com.donatus.impliments.StudentImp;
import com.donatus.impliments.TeachersImp;

import java.util.HashMap;
import java.util.Map;

public abstract class Principal extends Staffs  {

    protected static Map<String, StudentImp> studentList = new HashMap();
    protected static Map<String, StudentImp> scienceStudents = new HashMap<>();
    protected static Map<String, StudentImp> artStudents = new HashMap<>();
    protected static Map<String, StudentImp> commercialStudents = new HashMap<>();
    protected static Map<String, TeachersImp> staffList = new HashMap();
    protected static Map<String, NonAcademicImp> nonAcademicList = new HashMap();

    protected Principal(String firstName, String lastName, int age, String email, String address, String highestQualification) {
        super(firstName, lastName, age, email, address, highestQualification);
    }

    protected Principal(){

    }


    public Map<String, StudentImp> getStudentList() {
        return this.studentList;
    }


    public Map<String, TeachersImp> getStaffList() {
        return staffList;
    }

    public Map<String, StudentImp> getScienceStudents() {
        return this.scienceStudents;
    }

    public Map<String, StudentImp> getArtStudents() {
        return this.artStudents;
    }

    public Map<String, StudentImp> getCommercialStudents() {
        return this.commercialStudents;
    }
}
