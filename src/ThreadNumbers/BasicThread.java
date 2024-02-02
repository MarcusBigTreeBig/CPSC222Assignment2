package ThreadNumbers;

public class BasicThread extends Thread{
    private static int numberOfThreads = 0;
    public BasicThread () {
        numberOfThreads++;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(numberOfThreads);
        }
    }
}

/*
Stopped at 221816
 */