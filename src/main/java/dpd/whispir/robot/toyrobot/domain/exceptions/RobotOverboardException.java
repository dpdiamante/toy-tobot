package dpd.whispir.robot.toyrobot.domain.exceptions;

/**
 * A <code>RobotOverboardException</code> is an exception signifying that the robot fell off the table.
 */
public class RobotOverboardException extends Exception {

    public RobotOverboardException(String message) {
        super(message);
    }

}
