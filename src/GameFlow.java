import java.util.List;
import biuoop.DialogManager;
import biuoop.KeyboardSensor;

/**
 * @author Gitali Naim
 */

public class GameFlow {

    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private Counter lives;
    private Counter score;
    private Counter remainingBlocks;
    private Counter remainingBalls;
    private boolean isWin;
    private DialogManager dialog;

    /**
     * constructor of Game flow.
     *
     * @param ar - the AnimationRunner
     * @param ks - the KeyboardSensor
     * @param dialog - the dialog manager
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, DialogManager dialog) {
        this.keyboardSensor = ks;
        this.animationRunner = ar;
        this.lives = new Counter(7);
        this.score = new Counter(0);
        this.isWin = true;
    }

    /**
     * this function gets a list of levelInformation objects and runs them.
     *
     * @param levels - a list of levelInformation objects
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {

            this.remainingBlocks = new Counter(levelInfo.numberOfBlocksToRemove());
            this.remainingBalls = new Counter(0);

            GameLevel level = new GameLevel(levelInfo,
                    this.keyboardSensor,
                    this.animationRunner,
                    this.lives,
                    this.remainingBlocks,
                    this.remainingBalls,
                    this.score);

            level.initialize();

            while (this.remainingBlocks.getValue() > 0 && this.lives.getValue() > 0) {
                level.playOneTurn();
                if (this.remainingBlocks.getValue() != 0) {
                    this.lives.decrease(1);
                }
            }

            if (this.remainingBlocks.getValue() == 0) {
                this.score.increase(100);
            }

            if (this.lives.getValue() == 0) {
                this.isWin = false;
                break;
            }
        }

        this.animationRunner.run(new KeyPressStoppableAnimation(
                this.keyboardSensor, "space", new EndScreen(this.keyboardSensor, this.isWin, this.score)));
    }
}