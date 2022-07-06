import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gitali Naim
 */
public class WideEasy implements LevelInformation {

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
     * Constructor of Wide Easy level.
     */
    public WideEasy() {
        this.numberOfBalls = 10;
        this.ballsVelocities = new ArrayList<Velocity>();
        this.paddleSpeed = 4;
        this.paddleWidth = 650;
        this.levelName = "Wide Easy";
        this.background = new WideEasyBackground();
        this.blocks = new ArrayList<Block>();
        this.balls = new ArrayList<Ball>();

        // Create the blocks
        int x = 10;
        int y = 300;

        for (int i = 0; i < 15; i++) {
            Color blockColor;
            switch (i) {
                case 0:
                case 1:
                    blockColor = Color.RED;
                    break;
                case 2:
                case 3:
                    blockColor = Color.ORANGE;
                    break;
                case 4:
                case 5:
                    blockColor = Color.YELLOW;
                    break;
                case 6:
                case 7:
                case 8:
                    blockColor = Color.GREEN;
                    break;
                case 9:
                case 10:
                    blockColor = Color.BLUE;
                    break;
                case 11:
                case 12:
                    blockColor = Color.PINK;
                    break;
                case 13:
                case 14:
                    blockColor = Color.CYAN;
                    break;
                default:
                    blockColor = Color.BLACK;
                    break;
            }
            Rectangle rect = new Rectangle(new Point(x, y), 52, 30);
            Block block = new Block(rect, blockColor, 1);
            this.blocks.add(block);
            x += 52;
        }

        this.numberOfBlocksToRemove = 15;

        int ballX = 350;
        int ballY = 350;

        // Create left side balls
        for (int i = this.numberOfBalls / 2; i >= 1; i--) {
            Ball ball = new Ball(ballX, ballY, 5, java.awt.Color.BLACK);
            this.balls.add(ball);
            ballX -= 50;
            ballY += 50 - i * 8;
        }

        ballX = 450;
        ballY = 350;

        // Create left side balls
        for (int i = this.numberOfBalls / 2; i >= 1; i--) {
            Ball ball = new Ball(ballX, ballY, 5, java.awt.Color.BLACK);
            this.balls.add(ball);
            ballX += 50;
            ballY += 50 - i * 8;
        }

        // Set left Balls Velocities
        for (int i = 330; i > 280; i -= 10) {
            this.ballsVelocities.add(Velocity.fromAngleAndSpeed(i, 7));
        }

        // Set right Balls Velocities
        for (int i = 30; i < 80; i += 10) {
            this.ballsVelocities.add(Velocity.fromAngleAndSpeed(i, 7));
        }

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
        int ballX = 350;
        int ballY = 350;

        // Create left side balls
        for (int i = this.numberOfBalls / 2; i >= 1; i--) {
            Ball ball = new Ball(ballX, ballY, 5, java.awt.Color.BLACK);
            this.balls.add(ball);
            ballX -= 50;
            ballY += 50 - i * 8;
        }

        ballX = 450;
        ballY = 350;

        // Create left side balls
        for (int i = this.numberOfBalls / 2; i >= 1; i--) {
            Ball ball = new Ball(ballX, ballY, 5, java.awt.Color.BLACK);
            this.balls.add(ball);
            ballX += 50;
            ballY += 50 - i * 8;
        }
        return this.balls;
    }
}