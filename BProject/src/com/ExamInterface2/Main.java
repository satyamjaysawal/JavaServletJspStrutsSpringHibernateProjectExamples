package com.ExamInterface2;


public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        System.out.println("Circle Area: " + circle.calculateArea());
        System.out.println("Circle Perimeter: " + circle.calculatePerimeter());
    }
}
