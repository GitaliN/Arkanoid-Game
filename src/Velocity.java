/**
 * @author Gitali Naim
 */
public class Velocity {

    private double dx;
    private double dy;

    /**
     * constructor of velocity.
     *
     * @param dx - the change in position of the point on the 'x' axis
     * @param dy - the change in position of the point on the 'y' axis
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * This function take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     *
     * @param p - center point of the ball
     * @return new point with position (x+dx, y+dy)
     */
    public Point applyToPoint(Point p) {
        double newX = p.getX() + this.dx;
        double newY = p.getY() + this.dy;
        return new Point(newX, newY);
    }

    /**
     * This function calculate the velocity according the angle and the speed.
     *
     * @param angle - the angle of the velocity
     * @param speed - the speed of the velocity
     * @return a new velocity instance
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        angle = Math.toRadians(angle - 90);
        double dx = Math.cos(angle) * speed;
        double dy = Math.sin(angle) * speed;
        return new Velocity(dx, dy);
    }

    /**
     * This function gives access to dx value.
     *
     * @return the dx value
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * This function gives access to dy value.
     *
     * @return the dy value
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * This function changes the dx according to the received value.
     *
     * @param newDx - a new dx value that will enter to a velocity instance
     */
    public void setDx(double newDx) {
        this.dx = newDx;
    }

    /**
     * This function changes the dy according to the received value.
     *
     * @param newDy - a new dy value that will enter to a velocity instance
     */
    public void setDy(double newDy) {
        this.dy = newDy;
    }

    /**
     * This function calculates the speed of the ball.
     *
     * @return the speed of the ball
     */
    public double getSpeed() {
        return Math.sqrt((this.dx * this.dx) + (this.dy * this.dy));
    }
}