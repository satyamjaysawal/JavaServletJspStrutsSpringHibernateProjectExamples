package com.example;

public class ThreadExample3 {
	public static void main(String[] args) {
        System.out.println("Thread is running");
        try {
            Thread.sleep(2000); // Pause for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread resumed");
    }
}
