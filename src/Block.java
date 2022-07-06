import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import biuoop.DrawSurface;

/**
 * @author Gitali Naim
 */
public class Block implements Collidable, Sprite, HitNotifier {

    private Rectangle rect;
    private java.awt.Color color;
    private int healthPoints;
    private List<HitListener> hitListeners;

    /**
     * constructor of Block.
     *
     * @param rect  - the rectangle
     * @param color - the color
     */
    public Block(Rectangle rect, java.awt.Color color) {
        this.color = color;
        this.rect = rect;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * constructor of Block.
     *
     * @param rect        - the rect
     * @param color       - the color
     * @param healthPoint - the health point
     */
    public Block(Rectangle rect, java.awt.Color color, int healthPoint) {
        this.color = color;
        this.rect = rect;
        this.healthPoints = healthPoint;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * Gets collision rectangle.
     *
     * @return the collision rectangle
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    /**
     * This function draw the Block on the given DrawSurface.
     *
     * @param surface - a surface on which the Block will be drawn
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());

        Line upperLine = new Line(this.rect.getUpperLeft(), this.rect.getUpperRight());
        Point upperMiddle = upperLine.middle();

        Line leftLine = new Line(this.rect.getDownerLeft(), this.rect.getUpperLeft());
        Point leftMiddle = leftLine.middle();

        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
    }

    /**
     * Action when a ball hits the block.
     *
     * @param hitter          - the ball that hit the block
     * @param collisionPoint  - the collision point
     * @param currentVelocity - the current velocity
     * @return the new ball's velocity
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if (this.healthPoints > 0) {
            this.healthPoints -= 1;
            this.changeColor();
        }
        List<Line> rectRibs = this.rect.getRibs();
        Velocity newVelocity = new Velocity(currentVelocity.getDx(), currentVelocity.getDy());

        // check which rib of the block the ball has hit and create a new velocity by that.
        if (rectRibs.get(0).isPointInLine(collisionPoint) || rectRibs.get(2).isPointInLine(collisionPoint)) {
            newVelocity = new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * -1);
        } else if (rectRibs.get(1).isPointInLine(collisionPoint) || rectRibs.get(3).isPointInLine(collisionPoint)) {
            newVelocity = new Velocity(currentVelocity.getDx() * -1, currentVelocity.getDy());
        }
        this.notifyHit(hitter);
        return newVelocity;
    }

    /**
     * change color of block.
     */
    private void changeColor() {
        this.color = new Color(150, 150, 150);
    }

    /**
     * Notify the block that time has passed.
     */
    @Override
    public void timePassed() {
    }

    /**
     * Add the Block to the game.
     *
     * @param game - the game
     */
    public void addToGame(GameLevel game) {
        game.addCollidable(this);
        game.addSprite(this);
    }

    /**
     * Add the hit listener to the block.
     *
     * @param hl - the hit listener
     */
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * Remove the hit listener from the block.
     *
     * @param hl - the hit listener
     */
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * Function that notify about an hit in a block.
     *
     * @param hitter - a ball that hit the block
     */
    private void notifyHit(Ball hitter) {

        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);

        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * Function that return the health point of the block.
     *
     * @return the health point of the block
     */
    public int getHitPoints() {
        return this.healthPoints;
    }

    /**
     * Function that remove collidables and sprites from the game.
     *
     * @param game - the game
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }
}