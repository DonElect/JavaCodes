package com.donatus.models;

public abstract class Person {
    private String name;
    private int age;
    private String ID;

    public Person(String name, int age, String ID) {
        this.name = name;
        this.age = age;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getID() {
        return ID;
    }

}
