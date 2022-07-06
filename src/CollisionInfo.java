/**
 * @author Gitali Naim
 */
public class CollisionInfo {

    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * Constructor of collision information.
     *
     * @param collisionPoint - the collision point
     * @param collisionObject - the collision object
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * The point at which the collision occurs.
     *
     * @return the point which the collision occurs
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * The collidable object involved in the collision.
     *
     * @return the collidable object
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}