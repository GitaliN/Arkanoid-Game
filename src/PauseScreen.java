import java.awt.Color;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author Gitali Naim
 */

public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * constructor of Pause screen.
     *
     * @param k - the KeyboardSensor
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * This function draws the current state of the animation object on the screen.
     *
     * @param d - the DrawSurface
     */
    @Override
    public void doOneFrame(DrawSurface d) {

        // the drawing behind the text
        d.setColor(Color.BLACK);
        d.fillCircle(400, 300, 280);

        d.setColor(Color.WHITE);
        d.fillCircle(400, 300, 250);

        d.setColor(Color.BLACK);
        d.fillRectangle(250, 150, 100, 300);
        d.fillRectangle(450, 150, 100, 300);

        // the text
        d.setColor(Color.RED);
        d.drawText(d.getWidth() / 5, d.getHeight() / 2, "paused -- press space to continue", 32);

        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
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