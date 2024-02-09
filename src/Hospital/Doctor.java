package Hospital;

public class Doctor extends Thread{
    private IntakeQueue queue;

    public Doctor () {
        queue = new IntakeQueue();
    }

    @Override
    public void run() {
        while (true) {
            try {
                process(queue.dequeue());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void process (Intake intake) throws InterruptedException {
        if (intake != null) {
            wait(1500 + (intake.getSeverity()-1)*200);
        }
    }
}
