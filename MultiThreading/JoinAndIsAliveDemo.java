package com.sandeepprabhakula.MultiThreadingTuts;

public class JoinAndIsAliveDemo {
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("hi");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("hello");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        Thread.sleep(10);
        t2.start();
        System.out.println(t1.isAlive());
        System.out.println(t2.isAlive());
        t1.join();
        t2.join();
        System.out.println(t1.isAlive());
        System.out.println(t2.isAlive());
        System.out.println("Bye");
    }
}
