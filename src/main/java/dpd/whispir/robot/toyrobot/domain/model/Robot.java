package dpd.whispir.robot.toyrobot.domain.model;

/**
 * A <code>Robot</code> represents the robot that will be manipulated to move along the table surface
 */
public class Robot {

    private Coordinates position;

    private Direction direction;

    /**
     * Instantiates a <code>Robot</code> given its location as coordinates and where it is facing as
     * a <code>Direction</code> object.
     * @param position
     * @param direction
     */
    public  Robot(Coordinates position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public void turnLeft() {
        this.direction = this.direction.turnLeft();
    }

    public void turnRight() {
        this.direction = this.direction.turnRight();
    }

    public Coordinates getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    /**
     * Moves this robot along the direction it is facing
     */
    public void move() {

        if (this.direction.getAxis().equals(Axis.X)) {
            int newXCoordinate = position.getX() + 1 * this.direction.getCoefficient();

            this.position = new Coordinates(newXCoordinate, this.position.getY());

        } else {
            int newYCoordinate = position.getY() + 1 * this.direction.getCoefficient();

            this.position = new Coordinates(this.position.getX(), newYCoordinate);
        }

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.position.getX()).append(",");
        builder.append(this.position.getY()).append(",");
        builder.append(this.direction.toString());

        return builder.toString();
    }

}
