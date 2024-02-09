package Hospital;

import java.util.Comparator;

public class IntakeQueue {
    private IntakeNode front;
    private IntakeNode rear;
    private Comparator<Intake> comparator;
    public IntakeQueue () {
        front = null;
        rear = null;
        comparator = new Comparator<Intake> () {
            @Override
            public int compare(Intake o1, Intake o2) {
                if (o1.getType() == o2.getType()) {
                    return o1.getSeverity() - o2.getSeverity();
                }
                if (o1.getType() == IntakeType.Emergency) {
                    return 1;
                }
                return -1;
            }
        };
    }

    public synchronized Intake dequeue () {
        if (front == null) {
            return null;
        }
        IntakeNode temp = front;
        front = front.back;
        if (front != null) {
            front.next = null;
        }
        return temp.intake;
    }

    public synchronized void addIntake (Intake in) {
        IntakeNode toAdd = new IntakeNode();
        toAdd.intake = in;
        if (rear == null) {
            front = toAdd;
            rear = toAdd;
        }else{
            IntakeNode current = rear;
            while (current.next != null && comparator.compare(toAdd.intake, current.intake) < 0) {
                current = current.next;
            }
            toAdd.next = current;
            toAdd.back = current.back;
            if (current.back != null) {
                current.back.next = toAdd;
            }
            current.back = toAdd;
        }
        traverse();
    }

    public synchronized void traverse () {
        System.out.println("*** start of traverse ***");
        IntakeNode current = rear;
        while (current != front) {
            System.out.println(current.intake);
        }
        System.out.println(current.intake);
        System.out.println("*** end of traverse ***");
    }

    private class IntakeNode{
        IntakeNode next;
        IntakeNode back;
        Intake intake;
    }
}
