package com.example;

public class ThreadExample2 {
	public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 is running");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 is running");
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("All threads are done");
    }
}
