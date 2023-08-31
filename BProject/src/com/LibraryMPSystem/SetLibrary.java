package com.LibraryMPSystem;


import java.util.*;

public class SetLibrary {
  Set<Book> bookSet= new HashSet<>();

   

    public void addBook(Book book) {
        bookSet.add(book);
    }

    public void displayBooks() {
        for (Book book : bookSet) {
            System.out.println(book);
        }
    }

    public boolean containsBook(Book book) {
        return bookSet.contains(book);
    }
}
