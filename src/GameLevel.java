import java.awt.Color;
import java.util.List;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Game level.
 *
 * @author Gitali Naim
 */
public class GameLevel implements Animation {
    private static int frameWidth = 800;
    private static int frameHeight = 600;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter remainingBlocks;
    private Counter remainingBalls;
    private Counter score;
    private Counter lives;
    private AnimationRunner runner;
    private boolean running;
    private Paddle paddle;
    private KeyboardSensor keyboardSensor;
    private LevelInformation levelInfo;

    /**
     * Constructor of GameLevel.
     *
     * @param levelInfo - the level information
     * @param keyboardSensor -  the keyboard sensor
     * @param animationRunner - the animation runner
     * @param lives - the counter of lives
     * @param remainingBlocks - the number of  remaining blocks in the game
     * @param remainingBalls - the number of remaining balls in the game
     * @param score - the counter of score
     */
    public GameLevel(LevelInformation levelInfo, KeyboardSensor keyboardSensor, AnimationRunner animationRunner,
                     Counter lives, Counter remainingBlocks, Counter remainingBalls, Counter score) {
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.runner = animationRunner;
        this.keyboardSensor = keyboardSensor;
        this.remainingBlocks = remainingBlocks;
        this.remainingBalls = remainingBalls;
        this.score = score;
        this.lives = lives;
        this.levelInfo = levelInfo;
    }

    /**
     * Add collidable object to the game environment.
     *
     * @param c - the collidable object to add the game
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * Remove collidable object from the game environment.
     *
     * @param c - the collidable object to remove from the game
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    /**
     * Add sprite object to the game environment.
     *
     * @param s - the sprite object to add the game
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * Remove sprite object from the game environment.
     *
     * @param s - the sprite object to remove from the game
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }

    /**
     * Initialize a new game, create the Blocks, Ball and Paddle and add them to the game.
     */
    public void initialize() {

        // Background
        this.addSprite(this.levelInfo.getBackground());

        // Create all Hit Listeners
        HitListener scoreListener = new ScoreTrackingListener(this.score);
        HitListener blockRemover = new BlockRemover(this, this.remainingBlocks);
        HitListener ballRemover = new BallRemover(this, this.remainingBalls);
        HitListener ballAdder = new BallAdder(this, this.remainingBalls);

        // Create the level's name
        LevelName levelName = new LevelName(this.levelInfo.levelName());
        levelName.addToGame(this);

        // Create the Score Indicator
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.score);
        scoreIndicator.addToGame(this);

        // Create the lives Indicator
        LivesIndicator livesIndicator = new LivesIndicator(this.lives);
        livesIndicator.addToGame(this);

        // Create the bounding blocks and draws them
        Rectangle leftRect = new Rectangle(new Point(0, 20), 10, frameHeight);
        Block leftBorder = new Block(leftRect, Color.BLACK, 0);
        leftBorder.addToGame(this);

        Rectangle rightRect = new Rectangle(new Point(frameWidth - 10, 20), 10, frameHeight);
        Block rightBorder = new Block(rightRect, Color.BLACK, 0);
        rightBorder.addToGame(this);

        Rectangle upperRect = new Rectangle(new Point(0, 20), frameWidth, 10);
        Block upperBorder = new Block(upperRect, Color.BLACK, 0);
        upperBorder.addToGame(this);

        Rectangle downerRect = new Rectangle(new Point(0, frameHeight - 2), frameWidth, 16);
        Block downerBorder = new Block(downerRect, Color.BLACK, 0);
        downerBorder.addHitListener(ballRemover);
        downerBorder.addToGame(this);

        // Create the blocks
        List<Block> blocks = this.levelInfo.blocks();
        for (Block block : blocks) {
            block.addToGame(this);
            block.addHitListener(blockRemover);
            block.addHitListener(scoreListener);
        }
    }

    /**
     * Run one turn of the game.
     */
    public void playOneTurn() {
        this.createBallsOnTopOfPaddle();

        // countdown before turn starts.
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));

        this.running = true;
        this.runner.run(this);
        this.removeSprite(this.paddle);
        this.removeCollidable(this.paddle);
    }

    /**
     * create the balls and the paddle.
     */
    private void createBallsOnTopOfPaddle() {

        // Crate the balls
        List<Velocity> ballsVelocities = this.levelInfo.initialBallVelocities();
        List<Ball> balls = this.levelInfo.balls();

        for (int i = 0; i < this.levelInfo.numberOfBalls(); i++) {
            balls.get(i).setEnvironment(this.environment);
            balls.get(i).setVelocity(ballsVelocities.get(i));
            balls.get(i).addToGame(this);
            this.remainingBalls.increase(1);
        }

        // Create the paddle
        this.paddle = new Paddle(this.keyboardSensor, this.levelInfo.paddleSpeed(), this.levelInfo.paddleWidth());
        this.paddle.addToGame(this);
    }

    /**
     * This function draws the current state of the animation object on the screen.
     *
     * @param d - the DrawSurface
     */
    @Override
    public void doOneFrame(DrawSurface d) {

        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();

        if (this.keyboardSensor.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(
                    this.keyboardSensor, "space", new PauseScreen(this.keyboardSensor)));
        }

        if (this.remainingBlocks.getValue() == 0 || this.remainingBalls.getValue() == 0) {
            this.running = false;
        }
    }

    /**
     * This function tells is the animation should stop.
     *
     * @return true if the animation should stop, false otherwise
     */
    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}