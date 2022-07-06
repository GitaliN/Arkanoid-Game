import java.awt.Color;

import biuoop.DrawSurface;

/**
 * @author Gitali Naim
 *
 * This class represent the background of WideEasy level.
 */
public class WideEasyBackground implements Sprite {

    /**
     * Draw the sprite to the screen.
     *
     * @param d - the surface
     */
    @Override
    public void drawOn(DrawSurface d) {

        // background
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());

        // sunlights
        int x = 10;
        int y = 300;
        while (x <= 790) {
            d.setColor(new Color(239, 231, 176));
            d.drawLine(150, 150, x, y);
            x += 7;
        }

        // sun
        d.setColor(new Color(239, 231, 176));
        d.fillCircle(150, 150, 60);
        d.setColor(new Color(236, 215, 73));
        d.fillCircle(150, 150, 50);
        d.setColor(new Color(255, 225, 24));
        d.fillCircle(150, 150, 40);

        // sky
        d.setColor(new Color(51, 153, 255));
        for (int i = 0; i < 900; i += 90) {
            d.fillCircle(i, -25, 100);
        }

        d.setColor(new Color(102, 178, 255));
        for (int i = 0; i < 900; i += 90) {
            d.fillCircle(i, -25, 90);
        }

        d.setColor(new Color(153, 204, 255));
        for (int i = 0; i < 900; i += 90) {
            d.fillCircle(i, -25, 80);
        }

        // land
        d.setColor(new Color(153, 76, 0));
        for (int i = 0; i < 1000; i += 300) {
            d.fillCircle(i, 800, 300);
        }
    }

    /**
     * Notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
    }
}