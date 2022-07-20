package com.sandeepprabhakula.MultiThreadingTuts;

public class InterThreadCommunication {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}
class Q{
    int num ;
    boolean valueSet = false;
    public synchronized void put(int num){
        while(valueSet){
            try {wait();}catch (Exception e){}
        }
        System.out.println("Put : "+num);
        this.num = num;
        valueSet = true;
        notify(); //notify the consumer that setting the value is completed;
    }
    public synchronized void get(){
        while(!valueSet){
            try {wait();}catch (Exception e){}
        }
        System.out.println("Get : "+num);
        valueSet = false;
        notify(); //notify the producer taking the value is completed
    }
}
class Producer implements Runnable{
    Q q;

    public Producer(Q q) {
        this.q = q;
        Thread t = new Thread(this,"Producer");
        t.start();
    }

    @Override
    public void run() {

        for(int i=1;i<=10;i++){
            q.put(i);
            try {Thread.sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);}
        }
    }
}
class Consumer implements Runnable{
    Q q;

    public Consumer(Q q) {
        this.q = q;
        Thread t = new Thread(this,"Consumer");
        t.start();
    }

    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            q.get();
            try {Thread.sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);}
        }
    }
}
