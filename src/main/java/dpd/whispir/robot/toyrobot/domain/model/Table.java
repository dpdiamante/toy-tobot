package dpd.whispir.robot.toyrobot.domain.model;

/**
 * Represents the table that the robot will be playing around
 */
public class Table {

    private final int length;

    private final int width;

    /**
     * Instantiates a table with a given length and width
     * @param length
     * @param width
     */
    public Table(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    /**
     * Checks if the (x,y) coordinates exists in the table
     *
     * @param coordinates
     * @return
     */
    public boolean coordinatesExists(Coordinates coordinates) {

        if (horizontalPointExists(coordinates.getX()) && verticalPointExists(coordinates.getY())) {
            return true;
        }

        return false;
    }

    private boolean verticalPointExists(int y) {
        if (y < 0 || y > this.length) {
            return false;
        }

        return true;
    }

    private boolean horizontalPointExists(int x) {
        if (x < 0 || x > this.width) {
            return false;
        }

        return true;
    }
}
