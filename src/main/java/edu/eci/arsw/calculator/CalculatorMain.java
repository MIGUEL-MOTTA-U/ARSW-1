package edu.eci.arsw.calculator;


import edu.eci.arsw.math.PiDigits;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class CalculatorMain extends PiDigits {
    public static final int NUMBER_OF_DIGITS = 100000; // A Million of digits of PI
    public static void main(String a[]) {
        LocalDateTime t1 = LocalDateTime.now();
        getDigits(0,100,100);
        LocalDateTime t2 = LocalDateTime.now();
        System.out.println("Duration: " + Duration.between(t1, t2).toMillis());

        LocalDateTime t3 = LocalDateTime.now();
        getDigits(0,200,200);
        LocalDateTime t4 = LocalDateTime.now();
        System.out.println("Duration: " + Duration.between(t3, t4).toMillis());
    }

    public static byte[] getDigits(int start, int count, int nThreads) {
        if (nThreads < 1) throw new RuntimeException("Minimum number of threads is 1");
        int divisions = (NUMBER_OF_DIGITS + nThreads - 1) / nThreads;
        int remaining = NUMBER_OF_DIGITS % divisions;

        // CODE:
        ArrayList<Thread> threads = new ArrayList<>();
        ArrayList<ThreadCalculator> calculators = new ArrayList<>();

        for(int i = 0; i < nThreads; i ++){
            int begin = i*divisions + start;
            int take = (NUMBER_OF_DIGITS < (i+1)*divisions ? remaining : divisions);
            ThreadCalculator threadCalculator = new ThreadCalculator(begin,take);
            Thread t = new Thread(threadCalculator);
            t.start();
            threads.add(t);
            calculators.add(threadCalculator);
        }

        for(Thread t: threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        StringBuilder result = new StringBuilder();
        for(ThreadCalculator t: calculators){
            result.append(t.getResult());
        }

        System.out.println("Finished result with: "+nThreads + "\nResult: " + result);

        return null;
    }
}
