package com.example;

public class ThreadExample1 {
	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
            System.out.println("Thread is running");
        });
        thread.start();
	}
}
