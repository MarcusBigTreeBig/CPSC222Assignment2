package Hospital;

public class Hospital {
    private Nurse emergency;
    private Nurse frontDesk;
    private DoctorStack doctors;

    public Hospital (int numberOfDoctors) {
        doctors = new DoctorStack();
        for (int i = 0; i < numberOfDoctors; i++) {
            doctors.push(new Doctor());
        }
    }

    public void addToEmergency (Intake intake) {
        if (intake.getType() != IntakeType.Emergency) {
            addToFrontDesk(intake);
        }
        else {
            emergency.addToQueue(intake);
        }
    }
    public void addToFrontDesk (Intake intake) {
        frontDesk.addToQueue(intake);
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
