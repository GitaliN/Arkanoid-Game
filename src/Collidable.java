/**
 * @author Gitali Naim
 */

public interface Collidable {

    /**
     * Gets collision rectangle.
     *
     * @return the collision rectangle
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     *
     * @param hitter - the ball that hit the block
     * @param collisionPoint - the collision point
     * @param currentVelocity - the current velocity of the ball
     * @return the new velocity expected after the hit (based on the force the object inflicted on us)
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}