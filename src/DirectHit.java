import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gitali Naim
 */
public class DirectHit implements LevelInformation {

    private int numberOfBalls;
    private List<Velocity> ballsVelocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;
    private int numberOfBlocksToRemove;
    private List<Ball> balls;

    /**
     * Constructor of Direct hit level.
     */
    public DirectHit() {
        this.numberOfBalls = 1;
        this.ballsVelocities = new ArrayList<Velocity>();
        this.ballsVelocities.add(Velocity.fromAngleAndSpeed(360, 5));
        this.paddleSpeed = 8;
        this.paddleWidth = 100;
        this.levelName = "Direct Hit";
        this.background = new DirectHitBackground();
        this.blocks = new ArrayList<Block>();
        Rectangle rect = new Rectangle(new Point(381, 146), 40, 40);
        Block block = new Block(rect, new Color(255, 102, 102));
        this.blocks.add(block);
        this.numberOfBlocksToRemove = 1;
        this.balls = new ArrayList<Ball>();
        this.balls.add(new Ball(400, 500, 5, java.awt.Color.WHITE));
    }

    /**
     * this function return the number of balls.
     *
     * @return the number of balls
     */
    @Override
    public int numberOfBalls() {
        return this.numberOfBalls;
    }

    /**
     * this function returns a list of ball's velocities.
     *
     * @return list of ball's velocities
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        return this.ballsVelocities;
    }

    /**
     * this function returns the speed of the paddle.
     *
     * @return the speed of the paddle
     */
    @Override
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    /**
     * this function returns the width of the paddle.
     *
     * @return the width of the paddle
     */
    @Override
    public int paddleWidth() {
        return this.paddleWidth;
    }

    /**
     * this function returns string of the level's name.
     *
     * @return a string of the level's name
     */
    @Override
    public String levelName() {
        return this.levelName;
    }

    /**
     * this function returns the background of the level.
     *
     * @return the background of the level
     */
    @Override
    public Sprite getBackground() {
        return this.background;
    }

    /**
     * this function returns a list of blocks,
     * each block contains its size, color and location.
     *
     * @return a list of blocks
     */
    @Override
    public List<Block> blocks() {
        return this.blocks;
    }

    /**
     * this function returns the number of blocks that left on the screen.
     *
     * @return the the number of blocks that left on the screen
     */
    @Override
    public int numberOfBlocksToRemove() {
        return this.numberOfBlocksToRemove;
    }

    /**
     * this function returns a list of balls.
     *
     * @return a list of balls
     */
    @Override
    public List<Ball> balls() {
        this.balls = new ArrayList<Ball>();
        this.balls.add(new Ball(400, 500, 5, java.awt.Color.WHITE));
        return this.balls;
    }
}
