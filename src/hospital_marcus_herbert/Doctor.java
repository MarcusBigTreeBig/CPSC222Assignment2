package hospital_marcus_herbert;

/**
 * Doctor for the hospital simulation
 * Has a queue of intakes to be treated by it
 */

public class Doctor extends Thread{
    private IntakeQueue queue;

    /**
     * Creates a Doctor with an empty queue for intakes
     */
    public Doctor () {
        queue = new IntakeQueue();
    }

    /**
     * treats intakes until queue is empty
     */
    @Override
    public void run() {
        while (true) {
            try {
                Intake next = queue.dequeue();
                if (next != null) {
                    treat(next);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     *
     * @param intake adds this intake to the queue
     */
    public synchronized void addToQueue (Intake intake) {
        queue.addIntake(intake);
    }

    /**
     * treating intake
     * takes more time for higher severity
     *
     * @param intake
     * @throws InterruptedException
     */
    public synchronized void treat (Intake intake) throws InterruptedException {
        System.out.println(intake + "started treatment\n");
        sleep(1500 + (intake.getSeverity()-1)*200);
        System.out.println(intake + "ended treatment\n");
    }
}
