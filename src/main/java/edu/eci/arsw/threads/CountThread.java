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
public class CountThread implements Runnable{
    private  int a;
    private  int b;
    private String name;
    public CountThread(int a, int b, String name) {
        this.a = a;
        this.b = b;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("The CountThread started running...");
        print();
    }

    private void print(){
        for (int i = a; i <= b; i ++ ){
            System.out.println(name + ":\t" + i);
        }
    }
}
