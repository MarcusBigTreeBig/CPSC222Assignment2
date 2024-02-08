package Semaphores;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main (String[] args) throws IOException {
        MultiFileSemaphore semaphore = new MultiFileSemaphore();
        int numberOfFiles = 5;
        for (int i = 0; i < numberOfFiles; i++) {
            semaphore.giveFile(new FileWriter("File" + i + ".txt"));
        }
        FileWritingThread[] files = new FileWritingThread[15];
        for (int i = 0; i < files.length; i++) {
            files[i] = new FileWritingThread(semaphore);
            files[i].start();
        }
    }
}
