import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Gitali Naim
 */
public class WinterBlue implements LevelInformation {

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
     * Constructor of Winter Blue level.
     */
    public WinterBlue() {
        this.numberOfBalls = 3;
        this.ballsVelocities = new ArrayList<Velocity>();
        this.ballsVelocities.add(Velocity.fromAngleAndSpeed(300, 5));
        this.ballsVelocities.add(Velocity.fromAngleAndSpeed(60, 5));
        this.ballsVelocities.add(Velocity.fromAngleAndSpeed(360, 5));
        this.paddleSpeed = 9;
        this.paddleWidth = 250;
        this.levelName = "Winter Blue";
        this.background = new WinterBlueBackground();
        this.blocks = new ArrayList<Block>();

        // Create the blocks
        Random rand = new Random();

        int x = 10;
        int y = 90;

        for (int i = 0; i < 7; i++) {

            // Create random color of each row
            int colorR = rand.nextInt(255) + 1;
            int colorG = rand.nextInt(255) + 1;
            int colorB = rand.nextInt(255) + 1;
            Color randomColor = new Color(colorR, colorG, colorB);

            // Create one block's row
            for (int j = 0; j < 15; j++) {
                Rectangle rect = new Rectangle(new Point(x, y), 52, 30);
                Block block = new Block(rect, randomColor, 1);
                this.blocks.add(block);
                x += 52;
            }
            y += 30;
            x = 10;
        }

        this.numberOfBlocksToRemove = 105;

        // Create the balls
        this.balls = new ArrayList<Ball>();
        this.balls.add(new Ball(300, 400, 5, java.awt.Color.WHITE));
        this.balls.add(new Ball(500, 400, 5, java.awt.Color.WHITE));
        this.balls.add(new Ball(400, 350, 5, java.awt.Color.WHITE));
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
        this.balls.add(new Ball(400, 350, 5, java.awt.Color.WHITE));
        return this.balls;
    }
}
