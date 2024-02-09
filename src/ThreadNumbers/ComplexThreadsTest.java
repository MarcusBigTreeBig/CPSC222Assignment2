package ThreadNumbers;

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
