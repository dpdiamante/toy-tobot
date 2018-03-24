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
}
