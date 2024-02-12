package threadNumbers_marcus_herbert;

/**
 * Creates complex threads
 * Prints out how many have been created each time it creates a thread
 */
public class ComplexThreadsTest {
    public static void main (String[] args) {
        int i = 0;
        while (true) {
            new ComplexThread().start();
            System.out.println(++i);
        }
    }
}

/*
Stopped at 17010
 */

/*
Some output:

1490
1491
1492
1493
1494
1495
1496
1497
1498
1499
1500
1501
1502
1503
 */
