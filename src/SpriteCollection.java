import java.util.ArrayList;
import java.util.List;

import biuoop.DrawSurface;

/**
 * @author Gitali Naim
 */
public class SpriteCollection {

    private List<Sprite> sprites = new ArrayList<Sprite>();

    /**
     * Add sprite to the sprites list.
     *
     * @param s - sprite to add
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * Remove sprite from the sprites list.
     *
     * @param s - sprite to remove
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }


    /**
     * Call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {

        List<Sprite> spritesL = new ArrayList<Sprite>(this.sprites);

        for (Sprite sprite : spritesL) {
            sprite.timePassed();
        }
    }

    /**
     * Call drawOn(d) on all sprites.
     *
     * @param d - a surface
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite : sprites) {
            sprite.drawOn(d);
        }
    }
}