package ThreadNumbers;

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
