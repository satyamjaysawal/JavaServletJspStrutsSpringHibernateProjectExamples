package com.LibraryMPSystem;



import java.util.*;

public class ListLibrary {
   List<Book> bookList= new ArrayList<>();


    public void addBook(Book book) {
        bookList.add(book);
    }

    public void displayBooks() {
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public Book searchBook(String ISBN) {
        for (Book book : bookList) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    public boolean removeBook(Book book) {
        return bookList.remove(book);
    }
}
