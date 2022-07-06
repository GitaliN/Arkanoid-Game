import java.awt.Image;
import biuoop.DrawSurface;

/**
 * @author Gitali Naim
 */
public class ImageBackground implements Sprite {
    private Image image;

    /**
     * constructor of ImageBackground.
     *
     * @param image a given image.
     */
    public ImageBackground(Image image) {
        this.image = image;
    }

    /**
     * Draw the sprite to the screen.
     *
     * @param d - the surface
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.drawImage(0, 0, this.image);
    }

    /**
     * Notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
    }
}