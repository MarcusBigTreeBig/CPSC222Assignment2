package Hospital;

import java.util.Random;

public class Main {
    public static void main (String[] args) {
        Hospital hospital = new Hospital(1, 2);
        Random rand = new Random();
        boolean sendToEmergency;
        IntakeType type = null;
        Intake next;
        for (int i = 0; i < 25; i++) {
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
            next = new Intake(type, rand.nextInt(5));
            if (sendToEmergency) {
                hospital.addToEmergency(next);
            }else{
                hospital.addToFrontDesk(next);
            }
        }
    }
}
