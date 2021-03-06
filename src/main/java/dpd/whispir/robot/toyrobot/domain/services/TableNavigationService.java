package dpd.whispir.robot.toyrobot.domain.services;

import dpd.whispir.robot.toyrobot.domain.exceptions.LocationDoesNotExistsException;
import dpd.whispir.robot.toyrobot.domain.exceptions.RobotOverboardException;
import dpd.whispir.robot.toyrobot.domain.model.*;
import org.springframework.stereotype.Component;

/**
 * A <code>TableNavigationService</code> is a service that ables the robot to move around a table and makes sure
 * the robot does not fall out from the table.
 */
@Component
public class TableNavigationService implements TableNavigationServiceInterface {

    /**
     * Moves the robot where it is facing along the table
     *
     * @param table
     * @param robot
     * @throws RobotOverboardException
     */
    public Robot moveRobot(Table table, Robot robot) throws RobotOverboardException {

        if (robot.getDirection().getAxis().equals(Axis.X)) {
            int xCoordinate = robot.getPosition().getX() + 1 * robot.getDirection().getCoefficient();

            if (xCoordinate < 0 || xCoordinate > table.getWidth()) {
                throw new RobotOverboardException("Robot Overboard!");
            }

        } else {
            int yCoordinate = robot.getPosition().getY() + 1 * robot.getDirection().getCoefficient();

            if (yCoordinate < 0 || yCoordinate > table.getLength()) {
                throw new RobotOverboardException("Robot Overboard!");
            }
        }

        robot.move();
        return robot;
    }

    /**
     * Initializes the robot for the given table
     *
     * @param table
     * @param coordinates
     * @param direction
     * @return
     */
    public Robot initializeRobot(Table table, Coordinates coordinates, Direction direction) throws LocationDoesNotExistsException {

        if (!table.coordinatesExists(coordinates)) {
            throw new LocationDoesNotExistsException("Coordinates not applicable for the table");
        }

        return new Robot(coordinates, direction);
    }

}
