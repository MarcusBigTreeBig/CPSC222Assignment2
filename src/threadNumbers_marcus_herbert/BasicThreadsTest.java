package threadNumbers_marcus_herbert;

/**
 * Creates simple threads that only print how many threads have been created infinitely
 */

public class BasicThreadsTest {
    public static void main (String[] args) {
        while (true) {
            new BasicThread().start();
        }
    }
}

/*
Stopped at 221816
 */

/*
Some Output:
19224
19224
19224
19224
19224
19224
19224
19224
19224
19224
19224
19224
19224
19224
 */