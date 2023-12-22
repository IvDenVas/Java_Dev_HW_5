package org.example;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3,true);
        for (int i = 1; i < 6; i++) {
            new Philosopher(semaphore, i).start();
        }
    }
}
