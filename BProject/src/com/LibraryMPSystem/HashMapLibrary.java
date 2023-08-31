package com.LibraryMPSystem;


import java.util.*;

public class HashMapLibrary {
    HashMap<String, Book> bookHashMap= new HashMap<>();

  

    public void addBook(Book book) throws InvalidBookException {
        if (bookHashMap.containsKey(book.getISBN())) {
            throw new InvalidBookException("Book with ISBN " + book.getISBN() + " already exists.");
        }
        bookHashMap.put(book.getISBN(), book);
    }

    public void displayBooks() {
        for (Book book : bookHashMap.values()) {
            System.out.println(book);
        }
    }
}
