package com.example;
public class ThreadExample7 {
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

        Thread thread1 = new Thread(() -> {
            threadLocal.set(10);
            System.out.println("Thread 1: " + threadLocal.get());
        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set(20);
            System.out.println("Thread 2: " + threadLocal.get());
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
