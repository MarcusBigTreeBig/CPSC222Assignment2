package semaphores_marcus_herbert;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Creates 15 threads that want to write results to 5 files in a semaphore
 */

public class Main {
    public static void main (String[] args) throws IOException {
        MultiFileSemaphore semaphore = new MultiFileSemaphore();
        int numberOfFiles = 5;
        //creating files
        for (int i = 0; i < numberOfFiles; i++) {
            semaphore.giveFile(new FileWriter("File" + i + ".txt"));
        }
        FileWritingThread[] files = new FileWritingThread[15];
        //starting threads
        for (int i = 0; i < files.length; i++) {
            files[i] = new FileWritingThread(semaphore);
            files[i].start();
        }
    }
}

/*
Some Output to a file:

Number 1: 7220
Number 2: 2898
Add: 10118
Subtract: 4322
Multiply: 20923560

Number 1: 2126
Number 2: 1145
Add: 3271
Subtract: 981
Multiply: 2434270

Number 1: 8319
Number 2: 17109
Add: 25428
Subtract: -8790
Multiply: 142329771

Number 1: 8732
Number 2: 14608
Add: 23340
Subtract: -5876
Multiply: 127557056
 */
