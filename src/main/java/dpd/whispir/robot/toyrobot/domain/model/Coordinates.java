package dpd.whispir.robot.toyrobot.domain.model;

/**
 * A <code>Coordinates</code> represents a location in a cartesian plane which will be how the table in this
 * exercise will be imagined as.
 */
public class Coordinates {

    private final int x;

    private final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
