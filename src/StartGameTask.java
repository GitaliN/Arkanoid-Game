import java.util.List;
import biuoop.GUI;

/**
 * @author Gitali Naim
 */
public class StartGameTask implements Task<Void> {
    private GUI gui;
    private AnimationRunner animationRunner;
    private List<LevelInformation> levels;

    /**
     * constructor of Start game task.
     *
     * @param gui - the gui
     * @param animationRunner - the animation runner
     * @param levels - the levels
     */
    public StartGameTask(GUI gui, AnimationRunner animationRunner,
                         List<LevelInformation> levels) {
        this.gui = gui;
        this.animationRunner = animationRunner;
        this.levels = levels;
    }

    /**
     * Run void.
     *
     * @return null
     */
    public Void run() {
        GameFlow gf = new GameFlow(this.animationRunner, this.gui.getKeyboardSensor(), this.gui.getDialogManager());
        gf.runLevels(this.levels);
        return null;
    }
}