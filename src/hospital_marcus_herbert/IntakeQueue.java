package hospital_marcus_herbert;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Priority queue that will store the intakes for both the Nurse and the Doctor
 * Just uses a PriorityBlockingQueue and defines a comparator to use on the Intakes
 * Comparator is based on type primarily, and severity next
 */

public class IntakeQueue extends PriorityBlockingQueue<Intake> {

    /**
     * creates the queue with the comparator
     * uses 25 as initial capacity
     */
    public IntakeQueue () {
        super (25, new Comparator<Intake> () {
            @Override
            public int compare(Intake o1, Intake o2) {//comparator that compares intakes based on type, and severity as a tie breaker
                if (o2.getType() == o1.getType()) {
                    return o2.getSeverity() - o1.getSeverity();
                }
                if (o2.getType() == IntakeType.Emergency) {
                    return 1;
                }
                return -1;
            }
        });
    }

    /**
     *
     * @return the intake taken from the queue
     */
    public synchronized Intake dequeue () {
        return poll();
    }

    /**
     *
     * @param in adds this intake to the priority queue based on the comparator
     */
    public synchronized void addIntake (Intake in) {
        add(in);
    }
}
