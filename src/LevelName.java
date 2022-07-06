import java.awt.Color;
import biuoop.DrawSurface;

/**
 * @author Gitali Naim
 */
public class LevelName implements Sprite {

    private String name;

    /**
     * Constructor of LevelName.
     *
     * @param name - the name of the level
     */
    public LevelName(String name) {
        this.name = name;
    }

    /**
     * Notify the sprite that time has passed.
     */
     @Override
    public void timePassed() {
    }

    /**
     * Draw the name of the level to the screen.
     *
     * @param d - the surface
     */
     @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(210, 213, 219));
        d.fillRectangle(0, 0, 800, 20);
        d.setColor(Color.black);
        d.drawText(550, 17, "Level Name: " + this.name, 17);
    }

    /**
     * Add the name of the level to the game.
     *
     * @param game - a game
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}