package dpd.whispir.robot.toyrobot.application;

import dpd.whispir.robot.toyrobot.domain.model.Robot;

/**
 * A <code>UserInterfacePort</code> represents a screen that a user will be interacting with for the
 * Toy Robot Navigation application
 */
public interface UserInterfacePort {

    /**
     * Shows the current state of the Robot
     *
     * @param robot
     */
    void showReport(Robot robot);

}
