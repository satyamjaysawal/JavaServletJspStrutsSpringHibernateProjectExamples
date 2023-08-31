package com.exampleAbstraction;


public class DVD extends Item {
 private String director;

 public DVD(int id, String title, int year, String director) {
     super(id, title, year);
     this.director = director;
 }

 public String getDirector() {
     return director;
 }

 @Override
 public String getType() {
     return "DVD";
 }

 @Override
 public String toString() {
     return super.toString() + ", director=" + director;
 }
}
