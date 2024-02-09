package Hospital;

public class Nurse extends Thread{
    private IntakeQueue queue;
    private Hospital hospital;
    public Nurse (IntakeQueue queue, Hospital hospital) {
        this.queue = queue;
        this.hospital = hospital;
    }
    public void addToQueue (Intake intake) {
        queue.addIntake(intake);
    }
}
