package Semaphores;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

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
        while (true) {
            i = rand.nextInt(20000);
            j = rand.nextInt(20000);
            add = i + j;
            subtract = i - j;
            multiply = i * j;
            output = "Number 1: " + i + "\nNumber 2: " + j + "\nAdd: " + add + "\nSubtract: " + subtract + "\nMultiply: " + multiply + "\n\n";
            file = semaphore.takeFile();
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
            semaphore.giveFile(file);
            file = null;
        }
    }
}
