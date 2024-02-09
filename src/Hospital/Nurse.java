package Hospital;

/**
 * Nurse for the hospital simulation
 * Has a queue of intakes that have not yet been processed
 * Sends the intakes to doctors in the hospital
 */

public class Nurse extends Thread{
    private IntakeQueue queue;
    private Hospital hospital;

    /**
     * Creates a nurse
     *
     * @param queue for the intakes that have not yet been processed.
     * @param hospital hospital it's part of, used to access the doctors
     */
    public Nurse (IntakeQueue queue, Hospital hospital) {
        this.queue = queue;
        this.hospital = hospital;
    }

    /**
     *
     * @param intake adds to the Nurse's queue
     */
    public synchronized void addToQueue (Intake intake) {
        queue.addIntake(intake);
    }
    @Override
    public void run () {
        Intake next;
        Doctor doctor = null;
        boolean doctorIsEmergency = false;
        while (true) {
            next = queue.dequeue();
            if (next != null) {//while there is no intake to process
                while (doctor == null) {//need an available doctor
                    if (next.getType() == IntakeType.Emergency && hospital.emergencyDoctorAvailable()) {//one of the doctors is exclusively for emergency
                        doctor = hospital.takeEmergencyDoctor();
                        doctorIsEmergency = true;
                    } else if (hospital.generalDoctorAvailable()) {
                        doctor = hospital.takeGeneralDoctor();
                        doctorIsEmergency = false;
                    }
                }
                doctor.addToQueue(next);
                System.out.println(next + "Processed by nurse\n");
                if (doctorIsEmergency) {
                    hospital.giveEmergencyDoctor(doctor);
                } else {
                    hospital.giveGeneralDoctor(doctor);
                }
                doctor = null;
            }
        }
    }
}
