package com.donatus.models;

import com.donatus.Duties;
import com.donatus.services.Librarian;
import com.donatus.services.Principal;
import com.donatus.services.StaffServices;

import java.io.*;
import java.util.*;

public class Staffs extends Person implements Principal, StaffServices, Librarian {
    private Duties role;
    private String subjectTaught;
    private final int priority = 5;

    public static HashMap<String, Integer> libraryBooks = new HashMap<>();
    HashMap<String, Student> studentList = new HashMap<>();

    public Staffs(String name, int age, String ID, Duties role, String subjectTaught) {
        super(name, age, ID);
        this.role = role;
        this.subjectTaught = subjectTaught;
    }


    @Override
    public Staffs hire(String name, int age, String ID, Duties role, String subjectTaught) {
        Staffs staffs = null;

        if (getRole() == Duties.PRINCIPAL){
            staffs = new Staffs(name, age, ID, role, subjectTaught);
        }
        return staffs;
    }

    protected String getSubjectTaught(){
        return subjectTaught;
    }

    public Duties getRole(){
        Staffs staffs =null;
        return this.role;
    }


    @Override
    public void updateLibrary() {
        if(getRole() == Duties.LIBRARIAN){
            File file = new File("/Users/mac/Documents/Books.csv");
            String line = "";
            try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
                while ((line = reader.readLine()) != null){
                    String[] row = line.split(",");
                    if(!(row[0].equals("TITLE")))
                        libraryBooks.put(row[0], Integer.parseInt(row[1]));
                    System.out.println(" ");
                    for (String books : row)
                        System.out.printf("%-20s", books);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("\n");
            System.out.println("Done adding books to shelves!");
        }
        else
            System.out.println("You are not a LIBRARIAN!" +"\n");
    }

    @Override
    public void bookRequest(String bookName) {
        PriorityGenerator newPerson = new PriorityGenerator(priority, bookName, getName());
        newPerson.addToQueue(newPerson);
    }


    @Override
    public void releaseBooks() {
        if(getRole() == Duties.LIBRARIAN){
            Queue<PriorityGenerator> bookQueue = new PriorityGenerator().getBookQueue();
            Iterator<PriorityGenerator> iterator = bookQueue.iterator();
            while (iterator.hasNext()){
                PriorityGenerator newStaff = bookQueue.poll();
                assert newStaff != null;
                processRequest(newStaff.getBookName(), newStaff.getNameOfStaffOrStudent());
            }
        }
        else
            System.out.println("You are not a LIBRARIAN!");
    }

    @Override
    public void processRequest(String bookName, String staffName) {
        if(libraryBooks.containsKey(bookName.toUpperCase())){
            if(libraryBooks.get(bookName.toUpperCase()) > 0){
                System.out.println("--------------------");
                System.out.println(bookName+ " is a wonderful book. Have fun reading "+staffName+ ".");
                libraryBooks.replace(bookName.toUpperCase(), libraryBooks.get(bookName.toUpperCase()),
                        libraryBooks.get(bookName.toUpperCase())-1);
            }
            else {
                System.out.println("------------------");
                System.out.println("Book taken");
            }
        }
        else {
            System.out.println("Invalid book name."+ "\n" + "Pick from the following:");
            System.out.println("------------------------");
            for (String book : libraryBooks.keySet())
                System.out.println(book);
        }
    }

    @Override
    public void teach() {
        System.out.println("Good day Class. My name is "+getName()+ ". I am your "+getSubjectTaught()+ " teacher.");
    }

    @Override
    public void expel(String name) {
        if(getRole() == Duties.PRINCIPAL) {
            if(studentList.containsKey(name)){
                studentList.remove(name);
                System.out.println(name+ " has been expelled!" +"\n");
            }
            else
                System.out.println("No student by the name " +name+ " was admitted in the school." +"\n");
        }
        else
            System.out.println("Only the PRINCIPAL of the school can expel a student." +"\n");
    }

    @Override
    public void admitStudent(String name, int age, String ID, String studentClass) {
        if(getRole() == Duties.PRINCIPAL) {
            if(!(studentList.containsKey(name))){
                studentList.put(name, new Student(name, age, ID, studentClass));
                System.out.println(name+ " has been admitted!" +"\n");
            }
            else
                System.out.println("Student with that name already admitted" +"\n");
        }
        else
            System.out.println("Only the PRINCIPAL of the school can admit new students." +"\n");
    }

    @Override
    public String toString() {
        return "Staffs{" +
                "role=" + role +
                ", subjectTaught='" + subjectTaught + '\'' +
                ", priority=" + priority +
                '}';
    }
}
