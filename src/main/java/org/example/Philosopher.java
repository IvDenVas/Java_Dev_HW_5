package org.example;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
    Semaphore semaphore;
    private int countEating = 0;
    private final int philosopherNumber;

    public Philosopher(Semaphore semaphore, int philosopherNumber) {
        this.semaphore = semaphore;
        this.philosopherNumber = philosopherNumber;
    }

    public void run() {
        try {
            while (countEating < 3) {
                System.out.println("Филосов " + philosopherNumber + " подходит к столу");
                semaphore.acquire();
                System.out.println("Филосов " + philosopherNumber + " садится за стол и кушает");
                sleep(500);
                countEating++;
                System.out.println("Филосов " + philosopherNumber + " выходит из-за стола и размышляет");
                semaphore.release();
                sleep(4000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
