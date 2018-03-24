package dpd.whispir.robot.toyrobot.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * The <code>DirectionTest</code> validates the correctness of the behavior of the
 * {@link dpd.whispir.robot.toyrobot.domain.model.Direction}
 */
public class DirectionTest {

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
