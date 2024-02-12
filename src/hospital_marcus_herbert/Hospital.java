package hospital_marcus_herbert;

/**
 * The Hospital simulated
 * Contains a Nurse at both the front desk and at emergency
 * Emergency Nurse only takes emergency type intakes
 * Contains 2 stacks of Doctors, one of which exclusive to emergency intakes, the other shared between all types
 */

public class Hospital {
    private Nurse emergencyNurse;
    private Nurse frontDeskNurse;
    private DoctorStack emergencyDoctors;
    private DoctorStack generalDoctors;

    /**
     * Creates the hospital with given amounts of doctors in each queue
     *
     * @param numberOfEmergencyDoctors
     * @param numberOfGeneralDoctors
     */
    public Hospital (int numberOfEmergencyDoctors, int numberOfGeneralDoctors) {
        Doctor nextDoctor;
        emergencyDoctors = new DoctorStack();
        for (int i = 0; i < numberOfEmergencyDoctors; i++) {
            nextDoctor = new Doctor();
            emergencyDoctors.push(nextDoctor);
            nextDoctor.start();
        }
        generalDoctors = new DoctorStack();
        for (int i = 0; i < numberOfGeneralDoctors; i++) {
            nextDoctor = new Doctor();
            generalDoctors.push(nextDoctor);
            nextDoctor.start();
        }
        emergencyNurse = new Nurse(new IntakeQueue(), this);
        emergencyNurse.start();
        frontDeskNurse = new Nurse(new IntakeQueue(), this);
        frontDeskNurse.start();
    }

    /**
     * If the given intake is not of type emergency, sends to front desk
     * Otherwise, adds to emergency queue
     *
     * @param intake
     */
    public synchronized void addToEmergency (Intake intake) {
        if (intake.getType() != IntakeType.Emergency) {
            System.out.println(intake + "Sent to front desk\n");
            addToFrontDesk(intake);
        }
        else {
            emergencyNurse.addToQueue(intake);
            System.out.println(intake + "Added to Emergency queue\n");
        }
    }

    /**
     * Adds the intake to the front desk queue
     *
     * @param intake
     */
    public synchronized void addToFrontDesk (Intake intake) {
        frontDeskNurse.addToQueue(intake);
        System.out.println(intake + "Added to Front Desk queue\n");
    }

    /**
     *
     * @return the doctor taken from the queue
     */
    public synchronized Doctor takeEmergencyDoctor () {
        while (emergencyDoctors.top == null) {
            try {
                wait();
            }
            catch (InterruptedException e) {

            }
        }
        return emergencyDoctors.pop();
    }

    /**
     *
     * @return the doctor taken from the queue
     */
    public synchronized Doctor takeGeneralDoctor () {
        while (generalDoctors.top == null) {
            try {
                wait();
            }
            catch (InterruptedException e) {

            }
        }
        return generalDoctors.pop();
    }

    /**
     * give back a doctor to the queue
     *
     * @param doctor
     */
    public synchronized void giveEmergencyDoctor (Doctor doctor) {
        emergencyDoctors.push(doctor);
    }

    /**
     * give back a doctor to the queue
     *
     * @param doctor
     */
    public synchronized void giveGeneralDoctor (Doctor doctor) {
        generalDoctors.push(doctor);
    }

    /**
     *
     * @return true if the emergency doctor queue is not empty
     */
    public synchronized boolean emergencyDoctorAvailable () {
        return !(emergencyDoctors.top == null);
    }

    /**
     *
     * @return true if the general doctor queue is not empty
     */
    public synchronized boolean generalDoctorAvailable () {
        return !(generalDoctors.top == null);
    }

    /**
     * implements the stack for where to store the doctors
     */
    private class DoctorStack {

        private DoctorNode top;

        /**
         *
         * @param doctor pushes this doctor to the stack
         */
        public void push (Doctor doctor) {
            DoctorNode d = new DoctorNode();
            d.doctor = doctor;
            if (top != null) {
                d.next = top;
            }
            top = d;
        }

        /**
         *
         * @return the doctor taken from the stack
         */
        public Doctor pop () {
            DoctorNode d = top;
            top = top.next;
            return d.doctor;
        }

        /**
         * implements a node for the doctors to be stored in the stack
         */
        private class DoctorNode {
            private DoctorNode next;
            private Doctor doctor;
        }
    }
}
