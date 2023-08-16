package com.donatus.services;

public interface PrincipalServices {
    void hire();
    void fire(String firstName);
    void admit();
    void expel();
    void expel(String firstName);
    void strike();
    void displayStudentList();
    void displayScienceList();
    void displayArtList();
    void displayCommerceList();
    void displayStaffList();
}
