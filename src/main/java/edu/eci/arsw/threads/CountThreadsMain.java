/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */
public class CountThreadsMain {
    
    public static void main(String a[]){
        System.out.println("Running");
        CountThread runnableCountThread = new CountThread(0,100);
        Thread thread1 = new Thread(runnableCountThread);

        CountThread runnableCountThread2 = new CountThread(100,300);
        Thread thread2 = new Thread(runnableCountThread2);
        CountThread runnableCountThread3 = new CountThread(-100,0);
        Thread thread4 = new Thread(runnableCountThread3);
        CountThread runnableCountThread4 = new CountThread(-500,-400);
        Thread thread5 = new Thread(runnableCountThread4);
        CountThread runnableCountThread5 = new CountThread(-400,-200);
        Thread thread6 = new Thread(runnableCountThread5);
        CountThread runnableCountThread6 = new CountThread(1000,1200);
        Thread thread3 = new Thread(runnableCountThread6);

        thread1.start();
        thread2.start();
        thread3.start();

    }
    
}
