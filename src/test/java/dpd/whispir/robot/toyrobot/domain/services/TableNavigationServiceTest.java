package dpd.whispir.robot.toyrobot.domain.services;

import dpd.whispir.robot.toyrobot.domain.exceptions.RobotOverboardException;
import dpd.whispir.robot.toyrobot.domain.model.Coordinates;
import dpd.whispir.robot.toyrobot.domain.model.Direction;
import dpd.whispir.robot.toyrobot.domain.model.Robot;
import dpd.whispir.robot.toyrobot.domain.model.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TableNavigationServiceTest {

    private TableNavigationService tableNavigationService;
    private Table table;

    @Before
    public void setUp() {
        this.tableNavigationService = new TableNavigationService();
        this.table = new Table(5,5);
    }

    @After
    public void tearDown() {
        this.tableNavigationService = null;
    }

    @Test(expected = RobotOverboardException.class)
    public void testRobotOverboardAtNorthEastCornerWhenMovingNorth() throws RobotOverboardException {
        Robot robot = new Robot(new Coordinates(5,5), Direction.NORTH);
        tableNavigationService.moveRobot(table, robot);
    }

    @Test(expected = RobotOverboardException.class)
    public void testRobotOverboardAtNorthEastCornerWhenMovingEast() throws RobotOverboardException  {
        Robot robot = new Robot(new Coordinates(5,5), Direction.EAST);
        tableNavigationService.moveRobot(table, robot);
    }

    @Test(expected = RobotOverboardException.class)
    public void testRobotOverboardAtSouthEastCornerWhenMovingSouth() throws RobotOverboardException {
        Robot robot = new Robot(new Coordinates(5,0), Direction.SOUTH);
        tableNavigationService.moveRobot(table, robot);
    }

    @Test(expected = RobotOverboardException.class)
    public void testRobotOverboardAtSouthEastCornerWhenMovingEast() throws RobotOverboardException {
        Robot robot = new Robot(new Coordinates(5,0), Direction.EAST);
        tableNavigationService.moveRobot(table, robot);
    }

    @Test(expected = RobotOverboardException.class)
    public void testRobotOverboardAtNorthWestCornerWhenMovingNorth() throws RobotOverboardException {
        Robot robot = new Robot(new Coordinates(0,5), Direction.NORTH);
        tableNavigationService.moveRobot(table, robot);
    }

    @Test(expected = RobotOverboardException.class)
    public void testRobotOverboardAtNorthWestCornerWhenMovingWest() throws RobotOverboardException {
        Robot robot = new Robot(new Coordinates(0,5), Direction.WEST);
        tableNavigationService.moveRobot(table, robot);
    }

    @Test(expected = RobotOverboardException.class)
    public void testRobotOverboardAtSouthWestCornerWhenMovingSouth() throws RobotOverboardException {
        Robot robot = new Robot(new Coordinates(0,0), Direction.SOUTH);
        tableNavigationService.moveRobot(table, robot);
    }

    @Test(expected = RobotOverboardException.class)
    public void testRobotOverboardAtSouthWestCornerWhenMovingWest() throws RobotOverboardException {
        Robot robot = new Robot(new Coordinates(0,0), Direction.WEST);
        tableNavigationService.moveRobot(table, robot);
    }

    @Test(expected = RobotOverboardException.class)
    public void testRobotOverboardAtTopWhenMovingNorth() throws RobotOverboardException {
        Robot robot = new Robot(new Coordinates(3,5), Direction.NORTH);
        tableNavigationService.moveRobot(table, robot);
    }

    @Test(expected = RobotOverboardException.class)
    public void testRobotOverboardAtRightSideWhenMovingEast() throws RobotOverboardException {
        Robot robot = new Robot(new Coordinates(5,3), Direction.EAST);
        tableNavigationService.moveRobot(table, robot);
    }

    @Test(expected = RobotOverboardException.class)
    public void testRobotOverboardAtBottomWhenMovingSouth() throws RobotOverboardException {
        Robot robot = new Robot(new Coordinates(3, 0), Direction.SOUTH);
        tableNavigationService.moveRobot(table, robot);
    }

    @Test(expected = RobotOverboardException.class)
    public void testRobotOverboardAtLeftSideWhenMovingWest() throws RobotOverboardException {
        Robot robot = new Robot(new Coordinates(0, 3), Direction.WEST);
        tableNavigationService.moveRobot(table, robot);
    }

    @Test
    public void testRobotMovementAtNorthEastCornerWhenMovingSouth() throws RobotOverboardException {
        Robot robot = new Robot(new Coordinates(5,5), Direction.SOUTH);
        Robot updatedRobot = tableNavigationService.moveRobot(table, robot);

        assertEquals(new Coordinates(5, 4), updatedRobot.getPosition());
    }

    @Test
    public void testRobotMovementAtNorthEastCornerWhenMovingWest() throws RobotOverboardException  {
        Robot robot = new Robot(new Coordinates(5,5), Direction.WEST);
        Robot updatedRobot = tableNavigationService.moveRobot(table, robot);

        assertEquals(new Coordinates(4,5), updatedRobot.getPosition());
    }

    @Test
    public void testRobotMovementAtSouthEastCornerWhenMovingNorth() throws RobotOverboardException {
        Robot robot = new Robot(new Coordinates(5,0), Direction.NORTH);
        Robot updatedRobot = tableNavigationService.moveRobot(table, robot);

        assertEquals(new Coordinates(5,1), updatedRobot.getPosition());
    }

    @Test
    public void testRobotMovementAtSouthEastCornerWhenMovingWest() throws RobotOverboardException {
        Robot robot = new Robot(new Coordinates(5,0), Direction.WEST);
        Robot updatedRobot = tableNavigationService.moveRobot(table, robot);

        assertEquals(new Coordinates(4,0), updatedRobot.getPosition());
    }

    @Test
    public void testRobotMovementAtNorthWestCornerWhenMovingSouth() throws RobotOverboardException {
        Robot robot = new Robot(new Coordinates(0,5), Direction.SOUTH);
        Robot updatedRobot = tableNavigationService.moveRobot(table, robot);

        assertEquals(new Coordinates(0,4), updatedRobot.getPosition());
    }

    @Test
    public void testRobotMovementAtNorthWestCornerWhenMovingEast() throws RobotOverboardException {
        Robot robot = new Robot(new Coordinates(0,5), Direction.EAST);
        Robot updatedRobot = tableNavigationService.moveRobot(table, robot);

        assertEquals(new Coordinates(1,5), updatedRobot.getPosition());
    }

    @Test
    public void testRobotMovementAtSouthWestCornerWhenMovingNorth() throws RobotOverboardException {
        Robot robot = new Robot(new Coordinates(0,0), Direction.NORTH);

        Robot updatedRobot = tableNavigationService.moveRobot(table, robot);
        assertEquals(new Coordinates(0,1), updatedRobot.getPosition());
    }

    @Test
    public void testRobotMovementAtSouthWestCornerWhenMovingEast() throws RobotOverboardException {
        Robot robot = new Robot(new Coordinates(0,0), Direction.EAST);
        Robot updatedRobot = tableNavigationService.moveRobot(table, robot);

        assertEquals(new Coordinates(1,0), updatedRobot.getPosition());
    }

    @Test
    public void testRobotMovementAtTopWhenMovingSouth() throws RobotOverboardException {
        Robot robot = new Robot(new Coordinates(3,5), Direction.SOUTH);
        Robot updatedRobot = tableNavigationService.moveRobot(table, robot);

        assertEquals(new Coordinates(3,4), updatedRobot.getPosition());
    }

    @Test
    public void testRobotMovementAtRightSideWhenMovingWest() throws RobotOverboardException {
        Robot robot = new Robot(new Coordinates(5,3), Direction.WEST);
        Robot updatedRobot = tableNavigationService.moveRobot(table, robot);

        assertEquals(new Coordinates(4,3), updatedRobot.getPosition());
    }

    @Test
    public void testRobotMovementAtBottomWhenMovingNorth() throws RobotOverboardException {
        Robot robot = new Robot(new Coordinates(3, 0), Direction.NORTH);
        Robot updatedRobot = tableNavigationService.moveRobot(table, robot);

        assertEquals(new Coordinates(3,1), updatedRobot.getPosition());
    }

    @Test
    public void testRobotMovementAtLeftSideWhenMovingEast() throws RobotOverboardException {
        Robot robot = new Robot(new Coordinates(0, 3), Direction.EAST);
        Robot updatedRobot = tableNavigationService.moveRobot(table, robot);

        assertEquals(new Coordinates(1,3), updatedRobot.getPosition());
    }
}
