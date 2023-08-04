package com.donatus.services;

import com.donatus.Duties;
import com.donatus.models.Staffs;

public interface Principal {
    Staffs hire(String name, int age, String ID, Duties role, String subjectTaught);
    void expel(String name);
    void admitStudent(String name, int age, String ID, String studentClass);

}
