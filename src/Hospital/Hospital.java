package Hospital;

public class Hospital {
    private Nurse emergencyNurse;
    private Nurse frontDeskNurse;
    private DoctorStack emergencyDoctors;
    private DoctorStack generalDoctors;

    public Hospital (int numberOfEmergencyDoctors, int numberOfGeneralDoctors) {
        emergencyDoctors = new DoctorStack();
        for (int i = 0; i < numberOfEmergencyDoctors; i++) {
            emergencyDoctors.push(new Doctor());
        }
        generalDoctors = new DoctorStack();
        for (int i = 0; i < numberOfGeneralDoctors; i++) {
            generalDoctors.push(new Doctor());
        }
        emergencyNurse = new Nurse(new IntakeQueue(), this);
        frontDeskNurse = new Nurse(new IntakeQueue(), this);
    }

    public synchronized void addToEmergency (Intake intake) {
        if (intake.getType() != IntakeType.Emergency) {
            addToFrontDesk(intake);
            System.out.println(intake + "Sent to front desk");
        }
        else {
            emergencyNurse.addToQueue(intake);
            System.out.println(intake + "Added to Emergency queue\n");
        }
    }
    public synchronized void addToFrontDesk (Intake intake) {
        frontDeskNurse.addToQueue(intake);
        System.out.println(intake + "Added to Front Desk queue\n");
    }

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

    public synchronized void giveEmergencyDoctor (Doctor doctor) {
        emergencyDoctors.push(doctor);
    }
    public synchronized void giveGeneralDoctor (Doctor doctor) {
        generalDoctors.push(doctor);
    }

    public synchronized boolean emergencyDoctorAvailable () {
        return !(emergencyDoctors.top == null);
    }
    public synchronized boolean generalDoctorAvailable () {
        return !(generalDoctors.top == null);
    }

    private class DoctorStack {

        private DoctorNode top;

        public void push (Doctor doctor) {
            DoctorNode d = new DoctorNode();
            d.doctor = doctor;
            if (top != null) {
                d.next = top;
            }
            top = d;
        }

        public Doctor pop () {
            DoctorNode d = top;
            top = top.next;
            return d.doctor;
        }

        private class DoctorNode {
            private DoctorNode next;
            private Doctor doctor;
        }
    }
}
