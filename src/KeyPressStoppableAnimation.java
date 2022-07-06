import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author Gitali Naim
 */

public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * constructor of KeyPressStoppableAnimation.
     *
     * @param sensor - a KeyboardSensor
     * @param key - a string
     * @param animation - an animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    /**
     * This function draws the current state of the animation object on the screen.
     *
     * @param d - the DrawSurface
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);

        // fix the bug
        if (this.sensor.isPressed(this.key) && !isAlreadyPressed) {
            this.stop = true;
        } else {
            isAlreadyPressed = false;
        }
    }

    /**
     * This function tells if the animation should stop.
     *
     * @return true if the animation should stop, false otherwise
     */
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}