package ThreadNumbers;

import java.util.Random;

/**
 * Complex thread that contains a large int array
 * When ran, infinitely increments a random value of the array
 */
public class ComplexThread extends Thread{
    private int[] arr;
    public ComplexThread () {
        arr = new int[10000];
    }

    @Override
    public void run() {
        Random rand = new Random();
        while (true) {
            arr[rand.nextInt(arr.length)]++;
        }
    }
}

/*
Stopped at 17010
 */