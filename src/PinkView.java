import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Gitali Naim
 */
public class PinkView implements LevelInformation {

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
     * Constructor of Pink View level.
     */
    public PinkView() {
        this.numberOfBalls = 2;
        this.ballsVelocities = new ArrayList<Velocity>();
        this.ballsVelocities.add(Velocity.fromAngleAndSpeed(300, 8));
        this.ballsVelocities.add(Velocity.fromAngleAndSpeed(60, 8));
        this.paddleSpeed = 9;
        this.paddleWidth = 80;
        this.levelName = "Pink View";
        this.background = new PinkViewBackground();
        this.blocks = new ArrayList<Block>();

        // Create the blocks
        int x = 800 - 60;
        int y = 100;
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {

            // Create random color of each row
            int colorR = rand.nextInt(255) + 1;
            int colorG = rand.nextInt(255) + 1;
            int colorB = rand.nextInt(255) + 1;
            Color randomColor = new Color(colorR, colorG, colorB);

            // Create one block's row
            for (int j = 0; j < 10 - i; j++) {
                Rectangle rect = new Rectangle(new Point(x, y), 50, 30);
                Block block = new Block(rect, randomColor);
                this.blocks.add(block);
                x -= 50;
            }
            y += 30;
            x = 800 - 60;
        }

        this.numberOfBlocksToRemove = 40;

        // Create the balls
        this.balls = new ArrayList<Ball>();
        this.balls.add(new Ball(300, 400, 5, java.awt.Color.WHITE));
        this.balls.add(new Ball(500, 400, 5, java.awt.Color.WHITE));
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
        this.balls.add(new Ball(300, 400, 5, java.awt.Color.WHITE));
        this.balls.add(new Ball(500, 400, 5, java.awt.Color.WHITE));
        return this.balls;
    }
}
