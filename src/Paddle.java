import java.awt.Color;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author Gitali Naim
 */

public class Paddle implements Sprite, Collidable {

    private biuoop.KeyboardSensor keyboard;
    private Rectangle rect;
    private java.awt.Color color;
    private int speed;
    private int width;

    /**
     * Constructor of paddle.
     *
     * @param keyboardSensor - the keyboard sensor
     * @param speed - the speed of the paddle
     * @param width - the width of the paddle
     */
    public Paddle(KeyboardSensor keyboardSensor, int speed, int width) {
        this.keyboard = keyboardSensor;
        this.rect = new Rectangle(new Point(400 - (width / 2), 550), width, 20);
        this.color = new Color(73, 146, 239);
        this.speed = speed;
        this.width = width;
    }

    /**
     * Constructor of paddle.
     *
     * @param keyboardSensor - the keyboard sensor
     */
    public Paddle(KeyboardSensor keyboardSensor) {
        this.keyboard = keyboardSensor;
        this.rect = new Rectangle(new Point(320, 550), 160, 20);
        this.color = new Color(73, 146, 239);
    }

    /**
     * Move the paddle to the left side.
     */
    public void moveLeft() {
        double newX = this.rect.getUpperLeft().getX() - this.speed;
        for (int i = this.speed; i > 0; i--) {
            if (newX > 10) {
                this.rect.getUpperLeft().setX(newX);
                break;
            } else {
                newX = this.rect.getUpperLeft().getX() - i;
            }
        }
    }

    /**
     * Move the paddle to the right side.
     */
    public void moveRight() {
        double newX = this.rect.getUpperLeft().getX() + this.speed;
        for (int i = this.speed; i > 0; i--) {
            if (newX + this.rect.getWidth() < 790) {
                this.rect.getUpperLeft().setX(newX);
                break;
            } else {
                newX = this.rect.getUpperLeft().getX() + i;
            }
        }
    }

    /**
     * Notify the paddle that time has passed and check if right or left keys are pressed.
     */
    @Override
    public void timePassed() {
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        } else if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    /**
     * Draw the paddle on the given surface.
     *
     * @param d - the surface
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());

        d.setColor(Color.black);
        d.drawRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());

    }

    /**
     * Gets the collision rectangle.
     *
     * @return the collision rectangle
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    /**
     * The paddle divided to 5 areas, this function checks in which area the ball hit the paddle.
     *
     * @param collisionPoint - the collision point of the ball with the paddle
     * @return the collision area - in range 1 - 5 .
     */
    public int getCollisionArea(Point collisionPoint) {
        double diff = this.rect.getWidth() / 5;
        double rectUpperLeftX = this.rect.getUpperLeft().getX();
        double collitionPointX = collisionPoint.getX();
        double distance = collitionPointX - rectUpperLeftX;
        return (int) ((distance / diff) + 1);
    }

    /**
     * Action when a ball hits the paddle.
     *
     * @param hitter - the ball that hit the block
     * @param collisionPoint - the collision point of the ball with the paddle
     * @param currentVelocity - the current velocity of the ball
     * @return the new velocity of the ball according the collision area
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {

        //check if the ball hits one of the upper vertex of the paddle
        if (this.rect.getUpperLeft().equals(collisionPoint)) {
            return Velocity.fromAngleAndSpeed(300, currentVelocity.getSpeed());
        } else if (this.rect.getUpperRight().equals(collisionPoint)) {
            return Velocity.fromAngleAndSpeed(60, currentVelocity.getSpeed());
        }

        //check if the ball hits one of the right or left ribs of the paddle
        Line leftPaddle = new Line(this.rect.getUpperLeft(), this.rect.getDownerLeft());
        Line rightPaddle = new Line(this.rect.getUpperRight(), this.rect.getDownerRight());
        if (leftPaddle.isPointInLine(collisionPoint) || rightPaddle.isPointInLine(collisionPoint)) {
            return new Velocity(currentVelocity.getDx() * -1, currentVelocity.getDy());
        }
        int collitionArea = getCollisionArea(collisionPoint);
        Velocity newVelocity = null;

        //check in which area on the paddle the ball hits and create new velocity according that
        switch (collitionArea) {
            case 1:
                newVelocity = Velocity.fromAngleAndSpeed(300, currentVelocity.getSpeed());
                break;
            case 2:
                newVelocity = Velocity.fromAngleAndSpeed(330, currentVelocity.getSpeed());
                break;
            case 3:
                newVelocity = new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * -1);
                break;
            case 4:
                newVelocity = Velocity.fromAngleAndSpeed(30, currentVelocity.getSpeed());
                break;
            case 5:
                newVelocity = Velocity.fromAngleAndSpeed(60, currentVelocity.getSpeed());
                break;
            default:
                break;
        }
        return newVelocity;
    }

    /**
     * Add the paddle to the game.
     *
     * @param g - the game
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}