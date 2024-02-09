package Hospital;

public class Intake {
    private IntakeType type;
    private int severity;
    private int intakeID;
    public Intake (IntakeType type, int severity, int intakeID) {
        this.type = type;
        this.severity = severity;
        System.out.println("New Intake Created\n" + toString());
        this.intakeID = intakeID;
    }
    @Override
    public synchronized String toString () {
        return "Intake ID: " + intakeID + "\nType: " + type + "\nSeverity: " + severity + "\n";
    }

    public IntakeType getType () {
        return type;
    }
    public int getSeverity () {
        return severity;
    }

}
