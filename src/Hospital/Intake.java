package Hospital;

public class Intake {
    private IntakeType type;
    private int severity;
    public Intake (IntakeType type, int severity) {
        this.type = type;
        this.severity = severity;
        System.out.println("New Intake Created\n Type: " + type + "\nSeverity: " + severity + "\n");
    }

    public IntakeType getType () {
        return type;
    }
    public int getSeverity () {
        return severity;
    }

}
