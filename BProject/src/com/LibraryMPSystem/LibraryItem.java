package com.LibraryMPSystem;

public class LibraryItem {
    protected String title;
    protected String author;  // Change the access modifier to protected

    public LibraryItem(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "LibraryItem [Title=" + title + ", Author=" + author + "]";
    }
    
    public void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}
