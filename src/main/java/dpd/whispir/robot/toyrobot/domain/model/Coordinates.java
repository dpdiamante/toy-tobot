package dpd.whispir.robot.toyrobot.domain.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }

        if (!(that instanceof Coordinates)) {
            return false;
        }

        Coordinates thatCoordinate = (Coordinates) that;
        return x == thatCoordinate.x &&
                y == thatCoordinate.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }
}
