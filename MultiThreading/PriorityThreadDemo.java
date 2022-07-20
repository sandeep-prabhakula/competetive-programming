package com.sandeepprabhakula.MultiThreadingTuts;

public class PriorityThreadDemo {
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
        },"Hi Thread");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("hello");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Hello Thread");
        t1.setPriority(Thread.MIN_PRIORITY);  // Least Priority
//        t1.setPriority(Thread.NORM_PRIORITY); // Normal Priority
        t2.setPriority(Thread.MAX_PRIORITY);  // Highest Priority
        t1.start();
        Thread.sleep(10);
        t2.start();
        // Threads are alive
//        System.out.println(t1.isAlive());
//        System.out.println(t2.isAlive());
        t1.join();
        t2.join();
//        System.out.println(t1.getName());
//        System.out.println(t2.getName());

        // Threads aren't alive
//        System.out.println(t1.isAlive());
//        System.out.println(t2.isAlive());
        System.out.println("Bye");
    }
}
