package com.example;

class SharedResource {
    private boolean isProduced = false;

    public synchronized void produce() {
        while (isProduced) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Producing...");
        isProduced = true;
        notify();
    }

    public synchronized void consume() {
        while (!isProduced) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consuming...");
        isProduced = false;
        notify();
    }
}

public class ThreadExample6 {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resource.produce();
            }
        });

        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resource.consume();
            }
        });

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

