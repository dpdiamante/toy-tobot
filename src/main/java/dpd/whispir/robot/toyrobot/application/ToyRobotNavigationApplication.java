package dpd.whispir.robot.toyrobot.application;

import dpd.whispir.robot.toyrobot.application.model.Command;
import dpd.whispir.robot.toyrobot.domain.exceptions.LocationDoesNotExistsException;
import dpd.whispir.robot.toyrobot.domain.exceptions.RobotOverboardException;
import dpd.whispir.robot.toyrobot.domain.model.Coordinates;
import dpd.whispir.robot.toyrobot.domain.model.Direction;
import dpd.whispir.robot.toyrobot.domain.model.Robot;
import dpd.whispir.robot.toyrobot.domain.model.Table;
import dpd.whispir.robot.toyrobot.domain.services.TableNavigationServiceInterface;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ToyRobotNavigationApplication implements ToyRobotNavigationApplicationInterface {

    private static final String PLACE_COMMAND = "PLACE";

    private static final String MOVE_COMMAND = "MOVE";

    private static final String FACE_LEFT_COMMAND = "LEFT";

    private static final String FACE_RIGHT_COMMAND = "RIGHT";

    private static final String REPORT_COMMAND = "REPORT";

    private static final List<String> DIRECTION_LIST =
            Arrays.asList("NORTH", "SOUTH", "EAST", "WEST");

    @Autowired
    private final TableNavigationServiceInterface tableNavigationService;

    private final Table table;

    private Robot robot;

    public ToyRobotNavigationApplication(TableNavigationServiceInterface tableNavigationService) {
        this.tableNavigationService = tableNavigationService;
        this.table = new Table(5,5);
    }

    public void handle(Command command, UserInterfacePort interfacePort) {

        if (command.getCommand().equalsIgnoreCase(PLACE_COMMAND)) {
            try {
                initializeRobot(command);
            } catch(LocationDoesNotExistsException ldne) {

            }
        } else if (this.robot != null && command.getCommand().equalsIgnoreCase(MOVE_COMMAND)) {
            try {
                this.robot = this.tableNavigationService.moveRobot(table, this.robot);
            } catch (RobotOverboardException roe) {

            }
        } else if (this.robot != null && command.getCommand().equalsIgnoreCase(FACE_LEFT_COMMAND)) {
            this.robot.turnLeft();
        } else if (this.robot != null && command.getCommand().equalsIgnoreCase(FACE_RIGHT_COMMAND)) {
            this.robot.turnRight();
        } else if (this.robot != null && command.getCommand().equalsIgnoreCase(REPORT_COMMAND)) {
            interfacePort.showReport(this.robot);
        }
    }

    private void initializeRobot(Command command) throws LocationDoesNotExistsException {

        if (!StringUtils.isNumeric(command.getCommandParameters().get(0))
                || !StringUtils.isNumeric(command.getCommandParameters().get(1))
                || !DIRECTION_LIST.contains(command.getCommandParameters().get(2))) {

            return;
        }

        int x = Integer.parseInt(command.getCommandParameters().get(0));
        int y = Integer.parseInt(command.getCommandParameters().get(1));

        Coordinates coordinates = new Coordinates(x, y);
        Direction direction = Direction.directionOf(command.getCommandParameters().get(2));

        this.robot = tableNavigationService.initializeRobot(this.table, coordinates, direction);
    }

}
