package com.LibraryMPSystem;


import java.util.*;

public class TreeMapLibrary {
    TreeMap<String, Book> bookTreeMap= new TreeMap<>();

   

    public void addBook(Book book) {
        bookTreeMap.put(book.getISBN(), book);
    }

    public void displayBooks() {
        for (Book book : bookTreeMap.values()) {
            System.out.println(book);
        }
    }

    public void displayBooksSorted() {
        for (Map.Entry<String, Book> entry : bookTreeMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

}
