import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * @author Gitali Naim
 */

public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /**
     * constructor of Animation runner.
     *
     * @param gui - the gui
     * @param framesPerSecond - the frames per second
     * @param sleeper - the sleeper
     */
    public AnimationRunner(GUI gui, int framesPerSecond, Sleeper sleeper) {
        this.gui = gui;
        this.framesPerSecond = framesPerSecond;
        this.sleeper = sleeper;
    }

    /**
     * this function takes an Animation object and runs it.
     *
     * @param animation - the animation object
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;

        while (!animation.shouldStop()) {

            //timing
            long startTime = System.currentTimeMillis();
            DrawSurface d = this.gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * This function gives access to gui.
     *
     * @return the gui
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * This function changes the gui according to the received value.
     *
     * @param g - the gui
     */
    public void setGui(GUI g) {
        this.gui = g;
    }

    /**
     * This function gives access to FramesPerSecond.
     *
     * @return FramesPerSecond
     */
    public int getFramesPerSecond() {
        return framesPerSecond;
    }

    /**
     * This function changes the framesPerSecond according to the received value.
     *
     * @param framesPerSec - frames per second
     */
    public void setFramesPerSecond(int framesPerSec) {
        this.framesPerSecond = framesPerSec;
    }

    /**
     * This function gives access to sleeper.
     *
     * @return the sleeper
     */
    public Sleeper getSleeper() {
        return sleeper;
    }

    /**
     * This function changes the sleeper according to the received value.
     *
     * @param sleep - the sleeper
     */
    public void setSleeper(Sleeper sleep) {
        this.sleeper = sleep;
    }
}