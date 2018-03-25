package dpd.whispir.robot.toyrobot.domain.services;

import dpd.whispir.robot.toyrobot.domain.exceptions.LocationDoesNotExistsException;
import dpd.whispir.robot.toyrobot.domain.exceptions.RobotOverboardException;
import dpd.whispir.robot.toyrobot.domain.model.Coordinates;
import dpd.whispir.robot.toyrobot.domain.model.Direction;
import dpd.whispir.robot.toyrobot.domain.model.Robot;
import dpd.whispir.robot.toyrobot.domain.model.Table;

/**
 * A <code>TableNavigationServiceInterface</code> is a service that ables the robot to move around a table and makes sure
 * the robot does not fall out from the table.
 */
public interface TableNavigationServiceInterface {

    /**
     * Moves the robot where it is facing along the table
     *
     * @param table
     * @param robot
     * @throws RobotOverboardException
     */
    Robot moveRobot(Table table, Robot robot) throws RobotOverboardException;

    /**
     * Initializes the robot for the given table
     *
     * @param table
     * @param coordinates
     * @param direction
     * @return
     */
    Robot initializeRobot(Table table, Coordinates coordinates, Direction direction) throws LocationDoesNotExistsException;
}
