package com.example;

import java.util.concurrent.Semaphore;

class ResourcePool {
    private final Semaphore semaphore;

    public ResourcePool(int capacity) {
        this.semaphore = new Semaphore(capacity);
    }

    public void acquireResource() {
        try {
            semaphore.acquire();
            System.out.println("Resource acquired, available permits: " + semaphore.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void releaseResource() {
        semaphore.release();
        System.out.println("Resource released, available permits: " + semaphore.availablePermits());
    }
}

public class ThreadExample9 {
    public static void main(String[] args) {
        ResourcePool resourcePool = new ResourcePool(3);

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                resourcePool.acquireResource();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                resourcePool.releaseResource();
            });
            thread.start();
        }
    }
}
