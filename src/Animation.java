import biuoop.DrawSurface;

/**
 * @author Gitali Naim
 */

public interface Animation {

    /**
     * This function draws the current state of the animation object on the screen.
     *
     * @param d the DrawSurface
     */
    void doOneFrame(DrawSurface d);

    /**
     * This function tells if the animation should stop.
     *
     * @return true if the animation should stop, false otherwise
     */
    boolean shouldStop();
}