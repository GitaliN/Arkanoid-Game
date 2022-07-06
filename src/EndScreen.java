import java.awt.Color;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author Gitali Naim
 */
public class EndScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private boolean isWin;
    private Counter score;

    /**
     * constructor of Pause screen.
     *
     * @param k - the KeyboardSensor
     * @param isWin - a boolean variable that tells if the player is win or not
     * @param score - the score counter
     */
    public EndScreen(KeyboardSensor k, boolean isWin, Counter score) {
        this.keyboard = k;
        this.stop = false;
        this.isWin = isWin;
        this.score = score;
    }

    /**
     * This function draws the current state of the animation object on the screen.
     *
     * @param d - the DrawSurface
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.RED);
        d.drawText(d.getWidth() / 4, d.getHeight() / 2,
                (this.isWin ? "You Win!" : "Game Over.") + " Your score is: " + this.score.getValue(), 32);
    }

    /**
     * This function tells is the animation should stop.
     *
     * @return true if the animation should stop, false otherwise
     */
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}