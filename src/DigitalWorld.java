import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 * @author Gitali Naim
 */
public class DigitalWorld implements LevelInformation {

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
     * Constructor of Digital World level.
     */
    public DigitalWorld() {
        this.numberOfBalls = 2;
        this.ballsVelocities = new ArrayList<Velocity>();
        this.ballsVelocities.add(Velocity.fromAngleAndSpeed(300, 5));
        this.ballsVelocities.add(Velocity.fromAngleAndSpeed(60, 5));
        this.paddleSpeed = 8;
        this.paddleWidth = 150;
        this.levelName = "Galaxy World";
        this.background = new ImageBackground(this.getBackgroundImage());
        this.blocks = new ArrayList<Block>();

        // Create the blocks
        int colorR = 117;
        int colorG = 117;
        int colorB = 117;
        Color randomColor = new Color(colorR, colorG, colorB);

        int x = 60;
        int y = 100;

        for (int i = 0; i < 2; i++) {

            // Create one block's row
            for (int j = 0; j < 2; j++) {
                Rectangle rect = new Rectangle(new Point(x, y), 80, 80);
                Block block = new Block(rect, randomColor, 2);
                this.blocks.add(block);
                x += 80;
            }
            y += 80;
            x = 60;
        }

        this.numberOfBlocksToRemove = 4;

        // Create the balls
        this.balls = new ArrayList<Ball>();
        this.balls.add(new Ball(300, 400, 5, java.awt.Color.WHITE));
        this.balls.add(new Ball(500, 400, 5, java.awt.Color.WHITE));
    }

    /**
     * Get the image background.
     *
     * @return the image background
     */
    public Image getBackgroundImage() {
        try {
            return ImageIO.read(new File("src/galaxy.jpg"));
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
        this.balls.add(new Ball(300, 400, 5, java.awt.Color.WHITE));
        this.balls.add(new Ball(500, 400, 5, java.awt.Color.WHITE));
        return this.balls;
    }
}