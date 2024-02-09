package Semaphores;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Thread that when run, makes 2 random numbers
 * Adds, subtracts, and multiplies these numbers
 * Writes all 5 results to a file in a semaphore
 */

public class FileWritingThread extends Thread{
    MultiFileSemaphore semaphore;
    public FileWritingThread (MultiFileSemaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int i;
        int j;
        int add;
        int subtract;
        int multiply;
        String output;
        FileWriter file;
        for (int k = 0; k < 1000; k++) { //does not run infinitely as to not create very large files
            i = rand.nextInt(20000);
            j = rand.nextInt(20000);
            add = i + j;
            subtract = i - j;
            multiply = i * j;
            output = "Number 1: " + i + "\nNumber 2: " + j + "\nAdd: " + add + "\nSubtract: " + subtract + "\nMultiply: " + multiply + "\n\n";
            file = semaphore.takeFile();//accessing the file, start of critical section
            try {
                file.write(output);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                file.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            semaphore.giveFile(file); //releasing the file, end of critical section
            file = null;
        }
    }
}
