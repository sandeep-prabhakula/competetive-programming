package com.sandeepprabhakula.MultiThreadingTuts;

public class Tutorial1 {
    public static void main(String[] args) {
        Test t = new Test();
        t.start();
        Runnable r = new Test1();
//        t1.start(); no start method for runnable interface;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread t1 = new Thread(r);
        t1.start();
    }
}
class Test extends Thread{
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("hi");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Test1 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
