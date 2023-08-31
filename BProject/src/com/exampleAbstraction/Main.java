package com.exampleAbstraction;

public class Main {
 public static void main(String[] args) {
     Library library = new Library();

     Item book = new Book(1, "The Great Gatsby", 1925, "F. Scott Fitzgerald");
     Item dvd = new DVD(2, "Inception", 2010, "Christopher Nolan");

     library.addItem(book);
     library.addItem(dvd);

     library.displayItems();
 }
}
