package Hospital;

import java.util.Comparator;

public class IntakeQueue {
    private IntakeNode front;
    private IntakeNode rear;
    public IntakeQueue () {
        front = null;
        rear = null;
    }

    public synchronized Intake dequeue () {
        if (front == null) {
            return null;
        }
        IntakeNode temp = front;
        front = front.back;
        front.next = null;
        return temp.intake;
    }

    public synchronized void addIntake (Intake in) {
        IntakeNode current = rear;
        IntakeNode toAdd = new IntakeNode();
        toAdd.intake = in;
        if (rear == null) {
            rear = toAdd;
            front = toAdd;
        }else {
            Comparator<IntakeType> comp = new Comparator<IntakeType>() {
                @Override
                public int compare(IntakeType o1, IntakeType o2) {
                    if (o1 == o2) {
                        return 0;
                    }
                    if (o1 == IntakeType.Appointment) {
                        return -1;
                    }
                    if (o1 == IntakeType.General && o2 == IntakeType.Emergency) {
                        return -1;
                    }
                    if (o1 == IntakeType.General) {
                        return 1;
                    }
                    if (o2 == IntakeType.Emergency) {
                        return -1;
                    }
                    return 1;
                }
            };
            while (current != null && comp.compare(toAdd.intake.getType(), current.intake.getType()) < 0) {
                current = current.next;
            }
            while (current != null && toAdd.intake.getSeverity() < current.intake.getSeverity()) {
                current = current.next;
            }
            toAdd.next = current;
            if (current != null && current.back != null) {
                toAdd.back = current.back.next;
                current.back.next = toAdd;
                current.back = toAdd;
            }
        }
    }

    private class IntakeNode{
        IntakeNode next;
        IntakeNode back;
        Intake intake;
    }
}
