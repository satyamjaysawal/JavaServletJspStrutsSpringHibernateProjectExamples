package com.LibraryMPSystem;

import java.util.*;

public class MapLibrary {
  Map<String, Book> bookMap = new HashMap<>();

  
    public void addBook(Book book) {
        bookMap.put(book.getISBN(), book);
    }

    public void displayBooks() {
        for (Book book : bookMap.values()) {
            System.out.println(book);
        }
    }

    public Book getBookByBname(String bname) {
        return bookMap.get(bname);
    }
}

