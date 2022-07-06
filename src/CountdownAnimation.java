import java.awt.Color;
import biuoop.DrawSurface;

/**
 * @author Gitali Naim
 */

public class CountdownAnimation implements Animation {
    private boolean stop;
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private long startTime;
    private long milliSecondLeftToSleep;

    /**
     * constructor of Countdown Animation.
     *
     * @param numOfSeconds - the number of seconds of displaying the count down animation
     * @param countFrom - the number to count down from
     * @param gameScreen - the game screen
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.stop = false;
        this.numOfSeconds = (long) (numOfSeconds * 1000);
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.startTime = System.currentTimeMillis();
        this.milliSecondLeftToSleep = (long) this.numOfSeconds / countFrom;
    }

    /**
     * This function changes the background according to the received value.
     *
     * @param d - the drawSurface
     * @param color - the color of the background
     */
    public void setBackground(DrawSurface d, Color color) {
        d.setColor(color);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
    }

    /**
     * This function draws the current state of the animation object on the screen.
     *
     * @param d - the DrawSurface
     */
    @Override
    public void doOneFrame(DrawSurface d) {

        d.setColor(new Color(245, 226, 240));
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());

        if (this.countFrom == 0) {
            this.stop = true;
        }

        this.gameScreen.drawAllOn(d);

        // draw 3 2 1
        d.drawText(385, 400, String.valueOf(countFrom), 60);
        if (System.currentTimeMillis() - this.startTime > this.milliSecondLeftToSleep) {
            this.startTime = System.currentTimeMillis();
            this.countFrom--;
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

