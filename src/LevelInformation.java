import java.util.List;

/**
 * @author Gitali Naim
 *
 * This interface represents a Level information.
 */

public interface LevelInformation {
    /**
     * this function return the number of balls.
     *
     * @return the number of balls
     */
    int numberOfBalls();

    /**
     * this function returns a list of ball's velocities.
     *
     * @return list of ball's velocities
     */
    List<Velocity> initialBallVelocities();

    /**
     * this function returns the speed of the paddle.
     *
     * @return the speed of the paddle
     */
    int paddleSpeed();

    /**
     * this function returns the width of the paddle.
     *
     * @return the width of the paddle
     */
    int paddleWidth();

    /**
     * this function returns string of the level's name.
     *
     * @return a string of the level's name
     */
    String levelName();

    /**
     * this function returns the background of a level.
     *
     * @return the background of a level
     */
    Sprite getBackground();

    /**
     * this function returns a list of blocks,
     * each block contains its size, color and location.
     *
     * @return a list of blocks
     */
    List<Block> blocks();

    /**
     * this function returns a list of balls.
     *
     * @return a list of balls
     */
    List<Ball> balls();

    /**
     * this function returns the number of blocks that left on the screen.
     *
     * @return the the number of blocks that left on the screen
     */
    int numberOfBlocksToRemove();
}