package dpd.whispir.robot.toyrobot.application;

import dpd.whispir.robot.toyrobot.application.model.Command;

/**
 * Responsible for handling the navigation of a {@link dpd.whispir.robot.toyrobot.domain.model.Robot} around a
 * {@link dpd.whispir.robot.toyrobot.domain.model.Table} depending on the {@link dpd.whispir.robot.toyrobot.application.model.Command}.
 */
public interface ToyRobotNavigationApplicationInterface {

    /**
     * Handles the navigation of a Robot around the table associated to the application through the Command parameter.
     *
     * @param command The command for the robot
     * @param interfacePort
     */
    void handle(Command command, UserInterfacePort interfacePort);
}
