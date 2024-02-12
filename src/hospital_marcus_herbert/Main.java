package hospital_marcus_herbert;

import java.util.Random;

/**
 * Starts the hospital simulation
 */

public class Main {
    public static void main (String[] args) {
        Hospital hospital = new Hospital(1, 2);
        Random rand = new Random();
        boolean sendToEmergency;
        IntakeType type = null;
        Intake next;
        int numberOfIntakes = 25;
        //randomly create intakes
        for (int i = 0; i < numberOfIntakes; i++) {
            sendToEmergency  = rand.nextBoolean();
            switch (rand.nextInt(3)) {//randomly picking the type of the intake
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

/*
Sample Output for entire Simulation:

New Intake Created
Intake ID: 1
Type: Emergency
Severity: 1

Intake ID: 1
Type: Emergency
Severity: 1
Added to Emergency queue

New Intake Created
Intake ID: 2
Type: Emergency
Severity: 2

Intake ID: 2
Type: Emergency
Severity: 2
Added to Front Desk queue

New Intake Created
Intake ID: 3
Type: Emergency
Severity: 4

Intake ID: 2
Type: Emergency
Severity: 2
Processed by nurse

Intake ID: 1
Type: Emergency
Severity: 1
started treatment

Intake ID: 1
Type: Emergency
Severity: 1
Processed by nurse

Intake ID: 3
Type: Emergency
Severity: 4
Added to Front Desk queue

Intake ID: 2
Type: Emergency
Severity: 2
started treatment

New Intake Created
Intake ID: 4
Type: Appointment
Severity: 1

Intake ID: 4
Type: Appointment
Severity: 1
Sent to front desk

Intake ID: 4
Type: Appointment
Severity: 1
Added to Front Desk queue

New Intake Created
Intake ID: 5
Type: Appointment
Severity: 4

Intake ID: 5
Type: Appointment
Severity: 4
Sent to front desk

Intake ID: 5
Type: Appointment
Severity: 4
Added to Front Desk queue

New Intake Created
Intake ID: 6
Type: Appointment
Severity: 0

Intake ID: 6
Type: Appointment
Severity: 0
Sent to front desk

Intake ID: 6
Type: Appointment
Severity: 0
Added to Front Desk queue

New Intake Created
Intake ID: 7
Type: General
Severity: 2

Intake ID: 7
Type: General
Severity: 2
Sent to front desk

Intake ID: 7
Type: General
Severity: 2
Added to Front Desk queue

New Intake Created
Intake ID: 8
Type: General
Severity: 2

Intake ID: 8
Type: General
Severity: 2
Sent to front desk

Intake ID: 8
Type: General
Severity: 2
Added to Front Desk queue

New Intake Created
Intake ID: 9
Type: General
Severity: 3

Intake ID: 9
Type: General
Severity: 3
Added to Front Desk queue

New Intake Created
Intake ID: 10
Type: Appointment
Severity: 1

Intake ID: 10
Type: Appointment
Severity: 1
Added to Front Desk queue

New Intake Created
Intake ID: 11
Type: Emergency
Severity: 3

Intake ID: 11
Type: Emergency
Severity: 3
Added to Front Desk queue

New Intake Created
Intake ID: 12
Type: Appointment
Severity: 4

Intake ID: 12
Type: Appointment
Severity: 4
Added to Front Desk queue

New Intake Created
Intake ID: 13
Type: Emergency
Severity: 4

Intake ID: 13
Type: Emergency
Severity: 4
Added to Front Desk queue

New Intake Created
Intake ID: 14
Type: Appointment
Severity: 3

Intake ID: 14
Type: Appointment
Severity: 3
Added to Front Desk queue

New Intake Created
Intake ID: 15
Type: Appointment
Severity: 0

Intake ID: 15
Type: Appointment
Severity: 0
Sent to front desk

Intake ID: 15
Type: Appointment
Severity: 0
Added to Front Desk queue

New Intake Created
Intake ID: 16
Type: General
Severity: 0

Intake ID: 16
Type: General
Severity: 0
Sent to front desk

Intake ID: 16
Type: General
Severity: 0
Added to Front Desk queue

New Intake Created
Intake ID: 17
Type: General
Severity: 2

Intake ID: 17
Type: General
Severity: 2
Added to Front Desk queue

New Intake Created
Intake ID: 18
Type: Emergency
Severity: 0

Intake ID: 18
Type: Emergency
Severity: 0
Added to Front Desk queue

New Intake Created
Intake ID: 19
Type: Appointment
Severity: 1

Intake ID: 19
Type: Appointment
Severity: 1
Added to Front Desk queue

New Intake Created
Intake ID: 20
Type: Emergency
Severity: 4

Intake ID: 20
Type: Emergency
Severity: 4
Added to Front Desk queue

New Intake Created
Intake ID: 21
Type: Appointment
Severity: 4

Intake ID: 21
Type: Appointment
Severity: 4
Sent to front desk

Intake ID: 21
Type: Appointment
Severity: 4
Added to Front Desk queue

New Intake Created
Intake ID: 22
Type: General
Severity: 3

Intake ID: 22
Type: General
Severity: 3
Added to Front Desk queue

New Intake Created
Intake ID: 23
Type: General
Severity: 1

Intake ID: 23
Type: General
Severity: 1
Sent to front desk

Intake ID: 23
Type: General
Severity: 1
Added to Front Desk queue

New Intake Created
Intake ID: 24
Type: General
Severity: 3

Intake ID: 24
Type: General
Severity: 3
Sent to front desk

Intake ID: 24
Type: General
Severity: 3
Added to Front Desk queue

New Intake Created
Intake ID: 25
Type: General
Severity: 2

Intake ID: 25
Type: General
Severity: 2
Added to Front Desk queue

Intake ID: 1
Type: Emergency
Severity: 1
ended treatment

Intake ID: 3
Type: Emergency
Severity: 4
started treatment

Intake ID: 3
Type: Emergency
Severity: 4
Processed by nurse

Intake ID: 2
Type: Emergency
Severity: 2
ended treatment

Intake ID: 3
Type: Emergency
Severity: 4
ended treatment

Intake ID: 13
Type: Emergency
Severity: 4
started treatment

Intake ID: 13
Type: Emergency
Severity: 4
Processed by nurse

Intake ID: 13
Type: Emergency
Severity: 4
ended treatment

Intake ID: 20
Type: Emergency
Severity: 4
started treatment

Intake ID: 20
Type: Emergency
Severity: 4
Processed by nurse

Intake ID: 20
Type: Emergency
Severity: 4
ended treatment

Intake ID: 11
Type: Emergency
Severity: 3
started treatment

Intake ID: 11
Type: Emergency
Severity: 3
Processed by nurse

Intake ID: 11
Type: Emergency
Severity: 3
ended treatment

Intake ID: 18
Type: Emergency
Severity: 0
started treatment

Intake ID: 18
Type: Emergency
Severity: 0
Processed by nurse

Intake ID: 21
Type: Appointment
Severity: 4
Processed by nurse

Intake ID: 21
Type: Appointment
Severity: 4
started treatment

Intake ID: 18
Type: Emergency
Severity: 0
ended treatment

Intake ID: 21
Type: Appointment
Severity: 4
ended treatment

Intake ID: 8
Type: General
Severity: 2
started treatment

Intake ID: 8
Type: General
Severity: 2
Processed by nurse

Intake ID: 8
Type: General
Severity: 2
ended treatment

Intake ID: 12
Type: Appointment
Severity: 4
started treatment

Intake ID: 12
Type: Appointment
Severity: 4
Processed by nurse

Intake ID: 12
Type: Appointment
Severity: 4
ended treatment

Intake ID: 5
Type: Appointment
Severity: 4
Processed by nurse

Intake ID: 5
Type: Appointment
Severity: 4
started treatment

Intake ID: 5
Type: Appointment
Severity: 4
ended treatment

Intake ID: 7
Type: General
Severity: 2
started treatment

Intake ID: 7
Type: General
Severity: 2
Processed by nurse

Intake ID: 7
Type: General
Severity: 2
ended treatment

Intake ID: 17
Type: General
Severity: 2
started treatment

Intake ID: 17
Type: General
Severity: 2
Processed by nurse

Intake ID: 17
Type: General
Severity: 2
ended treatment

Intake ID: 14
Type: Appointment
Severity: 3
started treatment

Intake ID: 14
Type: Appointment
Severity: 3
Processed by nurse

Intake ID: 14
Type: Appointment
Severity: 3
ended treatment

Intake ID: 4
Type: Appointment
Severity: 1
started treatment

Intake ID: 4
Type: Appointment
Severity: 1
Processed by nurse

Intake ID: 4
Type: Appointment
Severity: 1
ended treatment

Intake ID: 25
Type: General
Severity: 2
started treatment

Intake ID: 25
Type: General
Severity: 2
Processed by nurse

Intake ID: 25
Type: General
Severity: 2
ended treatment

Intake ID: 23
Type: General
Severity: 1
started treatment

Intake ID: 23
Type: General
Severity: 1
Processed by nurse

Intake ID: 23
Type: General
Severity: 1
ended treatment

Intake ID: 22
Type: General
Severity: 3
Processed by nurse

Intake ID: 22
Type: General
Severity: 3
started treatment

Intake ID: 22
Type: General
Severity: 3
ended treatment

Intake ID: 10
Type: Appointment
Severity: 1
started treatment

Intake ID: 10
Type: Appointment
Severity: 1
Processed by nurse

Intake ID: 10
Type: Appointment
Severity: 1
ended treatment

Intake ID: 9
Type: General
Severity: 3
started treatment

Intake ID: 9
Type: General
Severity: 3
Processed by nurse

Intake ID: 9
Type: General
Severity: 3
ended treatment

Intake ID: 16
Type: General
Severity: 0
started treatment

Intake ID: 16
Type: General
Severity: 0
Processed by nurse

Intake ID: 16
Type: General
Severity: 0
ended treatment

Intake ID: 24
Type: General
Severity: 3
started treatment

Intake ID: 24
Type: General
Severity: 3
Processed by nurse

Intake ID: 24
Type: General
Severity: 3
ended treatment

Intake ID: 19
Type: Appointment
Severity: 1
started treatment

Intake ID: 19
Type: Appointment
Severity: 1
Processed by nurse

Intake ID: 19
Type: Appointment
Severity: 1
ended treatment

Intake ID: 15
Type: Appointment
Severity: 0
started treatment

Intake ID: 15
Type: Appointment
Severity: 0
Processed by nurse

Intake ID: 15
Type: Appointment
Severity: 0
ended treatment

Intake ID: 6
Type: Appointment
Severity: 0
started treatment

Intake ID: 6
Type: Appointment
Severity: 0
Processed by nurse

Intake ID: 6
Type: Appointment
Severity: 0
ended treatment
 */
