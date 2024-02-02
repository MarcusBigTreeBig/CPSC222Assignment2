package ThreadNumbers;

public class ComplexThreadsTest {
    public static void main (String[] args) {
        int i = 0;
        while (true) {
            new ComplexThread().start();
            System.out.println(++i);
        }
    }
}
