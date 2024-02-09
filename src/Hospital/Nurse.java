package Hospital;

public class Nurse extends Thread{
    private IntakeQueue queue;
    private Hospital hospital;
    public Nurse (IntakeQueue queue, Hospital hospital) {
        this.queue = queue;
        this.hospital = hospital;
    }
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
            while (doctor == null) {
                if (next.getType() == IntakeType.Emergency && hospital.emergencyDoctorAvailable()) {
                    doctor = hospital.takeEmergencyDoctor();
                    doctorIsEmergency = true;
                }else if (hospital.generalDoctorAvailable()) {
                    doctor = hospital.takeGeneralDoctor();
                    doctorIsEmergency = false;
                }
            }
            doctor.addToQueue(next);
            if (doctorIsEmergency) {
                hospital.giveEmergencyDoctor(doctor);
            }else{
                hospital.giveGeneralDoctor(doctor);
            }
            doctor = null;
        }
    }
}
