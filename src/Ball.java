import java.awt.Color;

import biuoop.DrawSurface;

/**
 * @author Gitali Naim
 */

public class Ball implements Sprite {

    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity v;
    private Frame frame;
    private GameEnvironment environment;

    /**
     * constructor of ball.
     *
     * @param ball - a ball
     */
    public Ball(Ball ball) {
        this.center = ball.center;
        this.r = ball.r;
        this.color = ball.color;
        this.environment = ball.environment;
        this.frame = ball.frame;
        this.v = ball.v;
    }

    /**
     * constructor of ball.
     *
     * @param center - the center point of the ball
     * @param r - the length of the radius of the ball
     * @param color - the color of the ball
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
    }

    /**
     * constructor of ball.
     *
     * @param x - the x value of the center point of the ball
     * @param y - the y value of the center point of the ball
     * @param r - the size of the radius of the ball
     * @param color - the color of the ball
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
    }

    /**
     * constructor of ball.
     *
     * @param x - the x value of the center point of the ball
     * @param y - the y value of the center point of the ball
     * @param r - the size of the radius of the ball
     * @param color - the color of the ball
     * @param environment - the game environment
     */
    public Ball(int x, int y, int r, java.awt.Color color, GameEnvironment environment) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.environment = environment;
    }

    /**
     * This function set game environment to the ball.
     *
     * @param gameEnvironment - the game environment.
     */
    public void setEnvironment(GameEnvironment gameEnvironment) {
        this.environment = gameEnvironment;
    }


    /**
     * This function gives access to x value of the center point of the ball.
     *
     * @return the x value of the center point of the ball
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * This function gives access to y value of the center point of the ball.
     *
     * @return the y value of the center point of the ball
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * This function gives access to the size of the radius of the ball.
     *
     * @return the size of the radius of the ball
     */
    public int getSize() {
        return this.r;
    }

    /**
     * This function gives access to the color of the ball.
     *
     * @return the color of the ball
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * This function draw the ball on the given DrawSurface.
     *
     * @param surface - a surface on which the ball will be drawn
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.BLACK);
        surface.drawCircle(this.getX(), this.getY(), this.r);

        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.r);
    }

    /**
     * This function changes the velocity according to the received value.
     *
     * @param newVelocity - a new velocity value that will enter to a ball instance
     */
    public void setVelocity(Velocity newVelocity) {
        this.v = newVelocity;
    }

    /**
     * This function changes the velocity according to the received value.
     *
     * @param dx - a new x value that will enter to a ball instance
     * @param dy - a new y value that will enter to a ball instance
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * This function changes the velocity according to the received value.
     *
     * @param x - a new x value that will enter to a ball instance
     * @param y - a new y value that will enter to a ball instance
     */
    public void setCenter(double x, double y) {
        this.center = new Point(x, y);
    }

    /**
     * This function gives access to velocity value.
     *
     * @return the velocity value of the ball
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * This function changes the frame according to the received value.
     *
     * @param newFrame - a new frame value that will enter to a ball instance
     */
    public void setFrame(Frame newFrame) {
        this.frame = newFrame;
    }

    /**
     * This function gives access to frame value.
     *
     * @return the frame value of the ball
     */
    public Frame getFrame() {
        return this.frame;
    }

    /**
     * This function checks if the ball passes his frame.
     *
     * @return true if the ball passes his frame, false otherwise
     */
    public boolean isBallOverFlow() {
        return (this.center.getX() + this.r > this.frame.getX() + this.frame.getWidth()
                || this.center.getX() - this.r < this.frame.getX()
                || this.center.getY() + this.r > this.frame.getY() + this.frame.getHeight()
                || this.center.getY() - this.r < this.frame.getY());
    }

    /**
     * This function checks if the next step of x pass the frame.
     *
     * @param vel - the velocity of the ball
     * @param radius - the radius of the ball
     * @return true if the next step of x pass the frame, false otherwise
     */
    public boolean isBallCanMoveX(Velocity vel, int radius) {
        return (this.center.getX() + vel.getDx() + radius > this.frame.getX() + this.frame.getWidth()
                || this.center.getX() + vel.getDx() - radius < this.frame.getX());
    }

    /**
     * This function checks if the next step of y pass the frame.
     *
     * @param vel - the velocity of the ball
     * @param radius - the radius of the ball
     * @return true if the next step of y pass the frame, false otherwise
     */
    public boolean isBallCanMoveY(Velocity vel, int radius) {
        return (this.center.getY() + vel.getDy() + radius > this.frame.getY() + this.frame.getHeight()
                || this.center.getY() + vel.getDy() - radius < this.frame.getY());
    }

    /**
     * This function handle when the ball hits the frame.
     */
    public void handleFrameCollition() {
        if (this.getFrame() != null) {
            if (this.isBallOverFlow()) {
                if (this.isBallCanMoveX(this.getVelocity(), 0)) {
                    this.getVelocity().setDx(this.getVelocity().getDx() * -1);
                }
                if (this.isBallCanMoveY(this.getVelocity(), 0)) {
                    this.getVelocity().setDy(this.getVelocity().getDy() * -1);
                }
            } else {
                if (this.isBallCanMoveX(this.getVelocity(), this.r)) {
                    this.getVelocity().setDx(this.getVelocity().getDx() * -1);
                }
                if (this.isBallCanMoveY(this.getVelocity(), this.r)) {
                    this.getVelocity().setDy(this.getVelocity().getDy() * -1);
                }
            }
        }
    }

    /**
     * This function move the ball according the velocity.
     */
    public void moveOneStep() {
        Velocity vel = this.getVelocity();
        if (vel != null) {
            this.handleFrameCollition();
            if (this.environment != null) {
                Point nextMove = vel.applyToPoint(this.center);
                Line trajectory = new Line(nextMove, this.center);
                CollisionInfo collisionInfo = this.environment.getClosestCollision(trajectory);
                if (collisionInfo != null) {
                    this.setCenter(collisionInfo.collisionPoint().getX() - vel.getDx(),
                            collisionInfo.collisionPoint().getY() - vel.getDy());
                    Velocity newVelocity = collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint(),
                            vel);
                    this.setVelocity(newVelocity);
                } else {
                    this.center = new Point(nextMove);
                }
            }
        }
    }

    /**
     * Notify the ball that time has passed to move the ball.
     */
    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * Add the ball to the game.
     *
     * @param game - the game
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }

    /**
     * Remove the ball from the game.
     *
     * @param game - the game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}