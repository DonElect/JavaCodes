package com.donatus.services;

public interface Librarian {
    void processRequest(String bookName, String staffName);
    void updateLibrary();
    void releaseBooks();
}
