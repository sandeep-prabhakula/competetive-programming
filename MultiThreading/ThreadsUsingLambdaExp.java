package com.sandeepprabhakula.MultiThreadingTuts;

public class ThreadsUsingLambdaExp {
    public static void main(String[] args) {
        // Anonymous Classes
//        Runnable obj1 = new Runnable() {
//
//            @Override
//            public void run() {
//                for(int i=0;i<5;i++){
//                    System.out.println("hi");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
//        };
//
//        Runnable obj2 = new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0;i<5;i++){
//                    System.out.println("hello");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
//        };

        // lambda Expressions
        Runnable obj1 = ()->{
            for(int i=0;i<5;i++){
                System.out.println("hi");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Runnable obj2 = ()->{
            for(int i=0;i<5;i++){
                System.out.println("hello");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        t1.start();
        try{
            Thread.sleep(10);
        }catch (Exception e){
            System.out.println(e);
        }
        t2.start();
    }
}

