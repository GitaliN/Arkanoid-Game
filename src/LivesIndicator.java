import java.awt.Color;

import biuoop.DrawSurface;

/**
 * @author Gitali Naim
 */

public class LivesIndicator implements Sprite {

    private Counter lives;

    /**
     * Constructor of LivesIndicator.
     *
     * @param lives - the number of lives of the player in the game
     */
    public LivesIndicator(Counter lives) {
        this.lives = lives;
    }

    /**
     * Draw the number of lives on the screen.
     *
     * @param d - a surface
     */
     @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(210, 213, 219));
        d.fillRectangle(0, 0, 50, 20);
        d.setColor(Color.black);
        d.drawText(70, 17, "Lives: " + String.valueOf(this.lives.getValue()), 17);
    }

    /**
     * Notify the sprite that time has passed.
     */
     @Override
    public void timePassed() {
    }

    /**
     * Add the lives indicator to the game.
     *
     * @param game - a game
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}