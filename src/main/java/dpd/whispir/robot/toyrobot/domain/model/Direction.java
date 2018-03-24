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

    public static final String STR_NORTH = "NORTH";

    public static final String STR_SOUTH = "SOUTH";

    public static final String STR_EAST = "EAST";

    public static final String STR_WEST = "WEST";

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

    /**
     * Returns an instance of direction depending on the code argument
     *
     * @param code must be either 'NORTH', 'SOUTH', 'EAST' or 'WEST'
     * @return An instance of Direction depending on the code argument.
     */
    public static Direction directionOf(String code) {

        if (!(code.trim().equalsIgnoreCase(STR_NORTH) || code.trim().equalsIgnoreCase(STR_SOUTH)
                || code.trim().equalsIgnoreCase(STR_EAST) || code.trim().equalsIgnoreCase(STR_WEST))) {
            throw new IllegalArgumentException("Argument should be either 'NORTH', 'EAST', 'SOUTH' or 'WEST");
        }

        if (code.trim().equalsIgnoreCase(STR_NORTH)) {
            return NORTH;
        } else if (code.trim().equalsIgnoreCase(STR_SOUTH)){
            return SOUTH;
        } else if (code.trim().equalsIgnoreCase(STR_EAST)) {
            return EAST;
        } else {
            return WEST;
        }
    }

    @Override
    public String toString() {

        if (this.equals(NORTH)) {
            return STR_NORTH;
        } else if (this.equals(SOUTH)) {
            return STR_SOUTH;
        } else if (this.equals(EAST)) {
            return STR_EAST;
        } else {
            return STR_WEST;
        }
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
