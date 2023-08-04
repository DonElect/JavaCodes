package com.donatus.models;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityGenerator implements Comparable<PriorityGenerator>{
    private int priority;
    private String bookName;
    private String nameOfStaffOrStudent;
    public static Queue<PriorityGenerator> bookQueue = new PriorityQueue<>();

    public PriorityGenerator(int priority, String bookName, String nameOfStaffOrStudent) {
        this.priority = priority;
        this.bookName = bookName;
        this.nameOfStaffOrStudent = nameOfStaffOrStudent;
    }

    public PriorityGenerator(){

    }

    public Queue<PriorityGenerator> getBookQueue(){
        return bookQueue;
    }

    public void addToQueue(PriorityGenerator newPriority){
        bookQueue.add(newPriority);
    }

    public int getPriority() {
        return priority;
    }

    public String getBookName() {
        return bookName;
    }

    public String getNameOfStaffOrStudent() {
        return nameOfStaffOrStudent;
    }

    @Override
    public int compareTo(PriorityGenerator o) {
        return o.priority > this.priority ? 1 : -1;
    }
}
