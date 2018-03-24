package dpd.whispir.robot.toyrobot.domain.model;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Checks and validates the correctness of the behavior of <code>Table</code>
 */
public class TableTest {

    /**
     * Test the coordinate exists behavior work
     */
    @Test
    public void testCoordinatesExists() {
        Table table = new Table(5, 8);

        assertTrue(table.coordinatesExists(new Coordinates(0, 0)));
        assertTrue(table.coordinatesExists(new Coordinates(3, 3)));
        assertTrue(table.coordinatesExists(new Coordinates(5, 5)));
        assertTrue(table.coordinatesExists(new Coordinates(8, 5)));
    }

    /**
     * Test the coordinate exists behavior work
     */
    @Test
    public void testCoordinatesDoesNotExists() {
        Table table = new Table(5, 8);

        assertFalse(table.coordinatesExists(new Coordinates(-1, 0)));
        assertFalse(table.coordinatesExists(new Coordinates(0, -1)));
        assertFalse(table.coordinatesExists(new Coordinates(8, 8)));
        assertFalse(table.coordinatesExists(new Coordinates(10, 5)));
    }

}
