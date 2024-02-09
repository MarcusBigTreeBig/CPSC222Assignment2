package Hospital;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Priority queue that will store the intakes for both the Nurse and the Doctor
 * Just uses a PriorityBlockingQueue and defines a comparator to use on the Intakes
 * Comparator is based on type primarily, and severity next
 */

public class IntakeQueue extends PriorityBlockingQueue<Intake> {
//    private IntakeNode front;
//    private IntakeNode rear;
//    private Comparator<Intake> comparator;
//    public IntakeQueue () {
//        front = null;
//        rear = null;
//        comparator = new Comparator<Intake> () {
//            @Override
//            public int compare(Intake o1, Intake o2) {
//                if (o1.getType() == o2.getType()) {
//                    return o1.getSeverity() - o2.getSeverity();
//                }
//                if (o1.getType() == IntakeType.Emergency) {
//                    return 1;
//                }
//                return -1;
//            }
//        };
//    }

    /**
     * creates the queue with the comparator
     * uses 25 as initial capacity
     */
    public IntakeQueue () {
        super (25, new Comparator<Intake> () {
            @Override
            public int compare(Intake o1, Intake o2) {
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
//        if (front == null) {
//            return null;
//        }
//        IntakeNode temp = front;
//        front = front.back;
//        if (front != null) {
//            front.next = null;
//        }
//        return temp.intake;
        return poll();
    }

    /**
     *
     * @param in adds this intake to the priority queue based on the comparator
     */
    public synchronized void addIntake (Intake in) {
//        IntakeNode toAdd = new IntakeNode();
//        toAdd.intake = in;
//        if (rear == null) {
//            front = toAdd;
//            rear = toAdd;
//        }else{
//            IntakeNode current = rear;
//            while (current.next != null && comparator.compare(toAdd.intake, current.intake) < 0) {
//                current = current.next;
//            }
//            toAdd.next = current;
//            toAdd.back = current.back;
//            if (current.back != null) {
//                current.back.next = toAdd;
//            }
//            current.back = toAdd;
//        }
//        traverse();
        add(in);
    }

//    public synchronized void traverse () {
//        System.out.println("*** start of traverse ***");
//        IntakeNode current = rear;
//        while (current != front) {
//            System.out.println(current.intake);
//        }
//        System.out.println(current.intake);
//        System.out.println("*** end of traverse ***");
//    }

//    private class IntakeNode{
//        IntakeNode next;
//        IntakeNode back;
//        Intake intake;
//    }
}
