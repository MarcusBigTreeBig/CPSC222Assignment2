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
                treat(queue.dequeue());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public synchronized void addToQueue (Intake intake) {
        queue.addIntake(intake);
    }
    public void treat (Intake intake) throws InterruptedException {
        System.out.println(intake + "started treatment\n");
        if (intake != null) {
            wait(1500 + (intake.getSeverity()-1)*200);
        }
        System.out.println(intake + "ended treatment\n");
    }
}
