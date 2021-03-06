package dpd.whispir.robot.toyrobot.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * The <code>DirectionTest</code> validates the correctness of the behavior of the
 * {@link dpd.whispir.robot.toyrobot.domain.model.Direction}
 */
public class DirectionTest {

    /**
     * Checks if Direction will not be instantiated if value of coefficient is less than -1
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBadCreationWithNegativeCoefficient() {
        new Direction(Axis.X, -2);
    }

    /**
     * Checks if the Direction will not be instantiated if the value of coefficient is 0
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBadCreationWithZeroCoefficient() {
        new Direction(Axis.X, 0);
    }

    /**
     * Checks if the Direction will not be instantiated if the value of coefficient is greater than 1
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBadCreationWithPositiveCoefficient() {
        new Direction(Axis.X, 2);
    }

    /**
     * Checks if the equality logic of Direction is working
     */
    @Test
    public void testEquality() {
        assertEquals(Direction.NORTH, new Direction(Axis.Y, 1));
        assertEquals(Direction.EAST, new Direction(Axis.X, 1));
        assertEquals(Direction.SOUTH, new Direction(Axis.Y, -1));
        assertEquals(Direction.WEST, new Direction(Axis.X, -1));

        assertEquals(Direction.NORTH, Direction.directionOf("NORTH"));
        assertEquals(Direction.EAST, Direction.directionOf("EAST"));
        assertEquals(Direction.SOUTH, Direction.directionOf("SOUTH"));
        assertEquals(Direction.WEST, Direction.directionOf("WEST"));
    }

    /**
     * Checks if the toString() is working as expected
     */
    @Test
    public void testStringCode() {
        assertEquals("NORTH", Direction.NORTH.toString());
        assertEquals("SOUTH", Direction.SOUTH.toString());
        assertEquals("EAST", Direction.EAST.toString());
        assertEquals("WEST", Direction.WEST.toString());
    }

    /**
     * Checks if the turn left logic is working
     */
    @Test
    public void testTurnLeft() {
        assertEquals(Direction.NORTH.turnLeft(), Direction.WEST);
        assertEquals(Direction.WEST.turnLeft(), Direction.SOUTH);
        assertEquals(Direction.SOUTH.turnLeft(), Direction.EAST);
        assertEquals(Direction.EAST.turnLeft(), Direction.NORTH);
    }

    /**
     * Checks if the turn right logic is working
     */
    @Test
    public void testTurnRight() {
        assertEquals(Direction.NORTH.turnRight(), Direction.EAST);
        assertEquals(Direction.WEST.turnRight(), Direction.NORTH);
        assertEquals(Direction.SOUTH.turnRight(), Direction.WEST);
        assertEquals(Direction.EAST.turnRight(), Direction.SOUTH);
    }

}
