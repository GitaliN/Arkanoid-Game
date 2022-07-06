import java.awt.Color;
import biuoop.DrawSurface;

/**
 * @author Gitali Naim
 */
public class ScoreIndicator implements Sprite {

    private Counter score;

    /**
     * Constructor of ScoreIndicator.
     *
     * @param score - the number of the points (the score) that the player have
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    /**
     * Notify the sprite that time has passed.
     */
     @Override
    public void timePassed() {
    }

    /**
     * Draw the number of score on the screen.
     *
     * @param d - a surface
     */
     @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(210, 213, 219));
        d.fillRectangle(0, 0, 400, 20);
        d.setColor(Color.black);
        d.drawText(350, 17, "Score: " + String.valueOf(this.score.getValue()), 17);
    }

    /**
     * Add the score indicator to the game.
     *
     * @param game - a game
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}
