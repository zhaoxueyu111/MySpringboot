package com.zxy.springboot.javatest;


import java.security.PrivateKey;

class MyThread1 implements Runnable{
    private String name;
    public MyThread1(String name){
        this.name=name;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(name+"运行,i="+i);
        }
    }
}
class MyThread2 extends Thread{
    private String name;
    public MyThread2(String name){
        this.name=name;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(name+"运行,i="+i);
        }
    }
}

public class MyThread {
    public static void main(String args[]){

        MyThread2 m11=new MyThread2("线程c");
        MyThread2 m22=new MyThread2("线程d");
        Thread t3=new Thread(m11);
        Thread t4=new Thread(m22);
        t3.start();
        t4.start();
    }
}
