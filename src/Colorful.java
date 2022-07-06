import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 * @author Gitali Naim
 */
public class Colorful implements LevelInformation {

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
     * Constructor of colorful level.
     */
    public Colorful() {
        this.numberOfBalls = 4;
        this.ballsVelocities = new ArrayList<Velocity>();
        this.ballsVelocities.add(Velocity.fromAngleAndSpeed(310, 7));
        this.ballsVelocities.add(Velocity.fromAngleAndSpeed(315, 7));
        this.ballsVelocities.add(Velocity.fromAngleAndSpeed(320, 7));
        this.ballsVelocities.add(Velocity.fromAngleAndSpeed(325, 7));
        this.paddleSpeed = 8;
        this.paddleWidth = 180;
        this.levelName = "Colorful";
        this.background = new ImageBackground(this.getBackgroundImage());
        this.blocks = new ArrayList<Block>();

        // Create the blocks
        Random rand = new Random();

        int x = 62;
        int y = 90;

        for (int i = 0; i < 5; i++) {

            // Create random color of each row
            int colorR = rand.nextInt(255) + 1;
            int colorG = rand.nextInt(255) + 1;
            int colorB = rand.nextInt(255) + 1;
            Color randomColor = new Color(colorR, colorG, colorB);

            // Create one block's row
            for (int j = 0; j < 13; j++) {
                Rectangle rect = new Rectangle(new Point(x, y), 52, 30);

                Block block = ((i == 0 || i == 4 || j == 0 || j == 12 || j == 6) ? new Block(
                rect, new Color(117, 117, 117), 2) : new Block(rect, randomColor, 1));
                this.blocks.add(block);
                x += 52;
            }
            y += 30;
            x = 62;
        }

        this.numberOfBlocksToRemove = 65;

        // Create the balls
        this.balls = new ArrayList<Ball>();
        this.balls.add(new Ball(400, 500, 5, java.awt.Color.WHITE));
        this.balls.add(new Ball(400, 500, 5, java.awt.Color.WHITE));
        this.balls.add(new Ball(400, 500, 5, java.awt.Color.WHITE));
        this.balls.add(new Ball(400, 500, 5, java.awt.Color.WHITE));
    }

    /**
     * Get the image background.
     *
     * @return the image background
     */
    public Image getBackgroundImage() {
        try {
            return ImageIO.read(new File("src/spiners.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
     * this function returns a list of blocks, each block contains its size, color
     * and location.
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
        this.balls.add(new Ball(400, 500, 5, java.awt.Color.WHITE));
        this.balls.add(new Ball(400, 500, 5, java.awt.Color.WHITE));
        this.balls.add(new Ball(400, 500, 5, java.awt.Color.WHITE));
        return this.balls;
    }
}