package Hospital;

import java.util.Random;

public class Main {
    public static void main (String[] args) {
        Hospital hospital = new Hospital(1, 2);
        Random rand = new Random();
        boolean sendToEmergency;
        IntakeType type = null;
        Intake next;
        int numberOfIntakes = 25;
        Intake[] intakes = new Intake[numberOfIntakes];
        for (int i = 0; i < numberOfIntakes; i++) {
            sendToEmergency  = rand.nextBoolean();
            switch (rand.nextInt(3)) {
                case 0:
                    type = IntakeType.Emergency;
                    break;
                case 1:
                    type = IntakeType.Appointment;
                    break;
                case 2:
                    type = IntakeType.General;
                    break;
            }
            next = new Intake(type, rand.nextInt(5), i+1);
            if (sendToEmergency) {
                hospital.addToEmergency(next);
            }else{
                hospital.addToFrontDesk(next);
            }
        }
    }
}
