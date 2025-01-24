package edu.eci.arsw.calculator;

import edu.eci.arsw.math.Main;
import edu.eci.arsw.math.PiDigits;

public class ThreadCalculator implements Runnable{
    private int a;
    private int b;
    private String result = "";
    ThreadCalculator(int start, int count){
        this.a = start;
        this.b = count;
    }

    @Override
    public void run(){
        calculateResult();
    }

    private void calculateResult(){
        result = Main.bytesToHex(PiDigits.getDigits(a, b));
    }

    public String getResult() {
        return result;
    }
}
