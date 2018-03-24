package dpd.whispir.robot.toyrobot.domain.model;

import java.util.Objects;

/**
 * A <code>Direction</code> represents where a robot is currently facing. This is represented by which
 * axis in the cartesian plane the robot is currently aligned for movement and if it is moving towards
 * the positive or negative direction in either axis.
 */
public class Direction {

    public static final Direction NORTH = new Direction(Axis.Y, 1);

    public static final Direction EAST = new Direction(Axis.X, 1);

    public static final Direction SOUTH = new Direction(Axis.Y, -1);

    public static final Direction WEST = new Direction(Axis.X, -1);

    private final Axis axis;

    private final int coefficient;

    /**
     * Instantiates a new <code>Direction</code> object. The <code>Axis</code> represents the axis where the
     * movement of the robot lies and the <code>coefficient</code> is if it will be moving along the positive
     * (upwards for y axis and eastward for y axis) or negative direction (downwards for y axis or westward for
     * x axis).
     * @param axis The axis where the robot will be moving along
     * @param coefficient 1 for positive direction, -1 otherwise.
     */
    public Direction(Axis axis, int coefficient) {

        if (!(coefficient == 1 || coefficient == -1)) {
            throw new IllegalArgumentException("Coefficient should be either 1 or -1");
        }

        this.axis = axis;
        this.coefficient = coefficient;
    }

    public Axis getAxis() {
        return this.axis;
    }

    public int getCoefficient() {
        return this.coefficient;
    }

    /**
     *
     * @return the new <code>Direction</code> after turning left from this direction
     */
    public Direction turnLeft() {

        Direction newDirection;

        if (axis.equals(Axis.Y)) {
            newDirection = new Direction(Axis.X, this.coefficient * -1);
        } else {
            newDirection = new Direction(Axis.Y, this.coefficient * 1);
        }

        return newDirection;
    }

    /**
     *
     * @return the new <code>Direction</code> after turning right from this direction
     */
    public Direction turnRight() {

        Direction newDirection;

        if (axis.equals(Axis.Y)) {
            newDirection = new Direction(Axis.X, this.coefficient * 1);
        } else {
            newDirection = new Direction(Axis.Y, this.coefficient * -1);
        }

        return newDirection;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }

        if (!(that instanceof Direction)) {
            return false;
        }

        Direction thatDirection = (Direction) that;
        return coefficient == thatDirection.coefficient && axis == thatDirection.axis;
    }

    @Override
    public int hashCode() {
        return Objects.hash(axis, coefficient);
    }


}
