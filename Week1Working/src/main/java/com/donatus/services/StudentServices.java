package com.donatus.services;

import com.donatus.models.Staffs;

public interface StudentServices {
    void bookRequest(String bookName);
    void takeACourse(String subject, Staffs staffs);
}
