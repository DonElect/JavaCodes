package com.donatus.models;

import java.util.HashMap;
import java.util.Map;

public abstract class Teachers extends Staffs  {
        String subjectTaught;
        protected static Map<String, Integer> studentScores = new HashMap<>();
    protected Teachers(String firstName, String lastName, int age, String email, String address, String highestQualification, String subjectTaught) {
        super(firstName, lastName, age, email, address, highestQualification);
        this.subjectTaught = subjectTaught;
    }

    public String getSubjectTaught() {
        return subjectTaught;
    }

}
