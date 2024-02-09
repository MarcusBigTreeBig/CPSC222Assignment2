package Hospital;

/**
 * An intake for the hospital simulation
 * Has an ID that is given to it
 * Has a type and severity that affect how it is handled by the nurses, doctors
 */

public class Intake {
    private IntakeType type;
    private int severity;
    private int intakeID;

    /**
     * Creates an Intake
     * All values are given by the input of this method
     *
     * @param type
     * @param severity
     * @param intakeID
     */
    public Intake (IntakeType type, int severity, int intakeID) {
        this.type = type;
        this.severity = severity;
        this.intakeID = intakeID;
        System.out.println("New Intake Created\n" + toString());
    }

    /**
     *
     * @return the ID, Type, and Severity as a string
     */
    @Override
    public synchronized String toString () {
        return "Intake ID: " + intakeID + "\nType: " + type + "\nSeverity: " + severity + "\n";
    }

    /**
     *
     * @return the type of the Intake
     */
    public IntakeType getType () {
        return type;
    }

    /**
     *
     * @return the severity of the Intake
     */
    public int getSeverity () {
        return severity;
    }

}
