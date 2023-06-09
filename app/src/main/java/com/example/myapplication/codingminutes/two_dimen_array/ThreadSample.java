package com.example.myapplication.codingminutes.two_dimen_array;

import java.util.Set;

public class ThreadSample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i <= 10; i++) {
                System.out.println(i);
            }

        });
        thread.start();
        System.out.println("THREAD NAME::"+thread.getName());
        System.out.println("THREAD NAME::"+thread.isAlive());
        Thread.sleep(2000);
        checkStatus(thread);
    }

   static void checkStatus(Thread thread){
       System.out.println("THREAD AFTER::"+thread.isAlive());
   }
}
