package ThreadNumbers;

public class BasicThreadsTest {
    public static void main (String[] args) {
        while (true) {
            new BasicThread().start();
        }
    }
}
