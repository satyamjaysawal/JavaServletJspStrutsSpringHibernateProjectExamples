package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExample8 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            final int taskNumber = i;
            executorService.execute(() -> {
                System.out.println("Task " + taskNumber + " is running");
            });
        }

        executorService.shutdown();
    }
}
