import java.util.ArrayList;
import java.util.List;

/**
 * @author Gitali Naim
 */
public class GameEnvironment {

    private List<Collidable> collidables = new ArrayList<Collidable>();

    /**
     * Add the given collidable to the environment.
     *
     * @param c - the collidable object to add the game
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * Remove the given collidable from the environment.
     *
     * @param c - the collidable object to remove from the game
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }

    /**
     * Assume an object moving from line.start to line.end.
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory - the trajectory of the ball
     * @return collisionInfo - the information about the closest collision that is going to occur.
     * If this object will not collide with any of the collidables in this collection, return null
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<Collidable> coll = new ArrayList<Collidable>(this.collidables);
        CollisionInfo collisionInfo = null;
        for (Collidable collidable : collidables) {
            Rectangle rect = collidable.getCollisionRectangle();
            Point closestPoint = trajectory.closestIntersectionToStartOfLine(rect);
            if (closestPoint != null) {
                collisionInfo = new CollisionInfo(closestPoint, collidable);
                break;
            }
        }
        return collisionInfo;
    }
}