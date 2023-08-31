package com.exampleAbstraction;



public class Book extends Item {
 private String author;

 public Book(int id, String title, int year, String author) {
     super(id, title, year);
     this.author = author;
 }

 public String getAuthor() {
     return author;
 }

 @Override
 public String getType() {
     return "Book";
 }

 @Override
 public String toString() {
     return super.toString() + ", author=" + author;
 }
}
