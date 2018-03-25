package dpd.whispir.robot.toyrobot.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Checks if the behavior of the Robot class is correct
 */
public class RobotTest {

    /**
     * Checks if the behavior of the move method is correct
     */
    @Test
    public void testMove() {
        Coordinates coordinates = new Coordinates(1,1);
        Robot robot = new Robot(coordinates, Direction.NORTH);

        robot.move();

        assertEquals(new Coordinates(1,2), robot.getPosition());
    }

    /**
     * Tests how the toString() works for the Robot class
     */
    @Test
    public void testStringRepresentation() {
        Coordinates coordinates = new Coordinates(1,1);
        Robot robot = new Robot(coordinates, Direction.NORTH);

        assertEquals("1,1,NORTH", robot.toString());
    }

}
