import java.awt.Color;

import biuoop.DrawSurface;

/**
 * @author Gitali Naim
 *
 * This class represent the background of PinkView level.
 */
public class PinkViewBackground implements Sprite {

    /**
     * Draw the sprite to the screen.
     *
     * @param d - the surface
     */
    @Override
    public void drawOn(DrawSurface d) {

        //background
        d.setColor(new Color(243, 168, 227));
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());

        //flowers
        for (int i = 0; i < 6; i++) {
            d.setColor(new Color(234, 9, 186));
            d.fillCircle(270 + 100 * i, 550, 15);
            d.setColor(new Color(234, 9, 186));
            d.fillCircle(230 + 100 * i, 550, 15);
            d.setColor(new Color(234, 9, 186));
            d.fillCircle(250 + 100 * i, 530, 15);
            d.setColor(new Color(234, 9, 186));
            d.fillCircle(250 + 100 * i, 570, 15);
            d.setColor(Color.YELLOW);
            d.fillCircle(250 + 100 * i, 550, 10);
        }

        for (int i = 0; i < 6; i++) {
            d.setColor(new Color(234, 9, 186));
            d.fillCircle(770, 550 - 95 * i, 15);
            d.setColor(new Color(234, 9, 186));
            d.fillCircle(730, 550 - 95 * i, 15);
            d.setColor(new Color(234, 9, 186));
            d.fillCircle(750, 530 - 95 * i, 15);
            d.setColor(new Color(234, 9, 186));
            d.fillCircle(750, 570 - 95 * i, 15);
            d.setColor(Color.YELLOW);
            d.fillCircle(750, 550 - 95 * i, 10);
        }

        for (int i = 0; i < 7; i++) {
            d.setColor(new Color(234, 9, 186));
            d.fillCircle(770 - 100 * i, 75, 15);
            d.setColor(new Color(234, 9, 186));
            d.fillCircle(730 - 100 * i, 75, 15);
            d.setColor(new Color(234, 9, 186));
            d.fillCircle(750 - 100 * i, 55, 15);
            d.setColor(new Color(234, 9, 186));
            d.fillCircle(750 - 100 * i, 95, 15);
            d.setColor(Color.YELLOW);
            d.fillCircle(750 - 100 * i, 75, 10);

        }

        for (int i = 0; i < 6; i++) {
            d.setColor(new Color(234, 9, 186));
            d.fillCircle(70, 75 + 95 * i, 15);
            d.setColor(new Color(234, 9, 186));
            d.fillCircle(30, 75 + 95 * i, 15);
            d.setColor(new Color(234, 9, 186));
            d.fillCircle(50, 55 + 95 * i, 15);
            d.setColor(new Color(234, 9, 186));
            d.fillCircle(50, 95 + 95 * i, 15);
            d.setColor(Color.YELLOW);
            d.fillCircle(50, 75 + 95 * i, 10);
        }

        // the building
        d.setColor(Color.DARK_GRAY);
        d.fillRectangle(50, 410, 130, 190);
        d.setColor(new Color(180, 255, 255));

        // the windows
        int x = 60;
        int y = 420;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                d.fillRectangle(x, y, 18, 27);
                x += 23;
            }
            d.setColor(new Color(204 + i * 10, 255, 255));

            x = 60;
            y += 33;
        }

        d.setColor(Color.GRAY);
        d.fillRectangle(98, 350, 35, 60);

        d.setColor(Color.LIGHT_GRAY);
        d.fillRectangle(110, 150, 10, 200);

        d.setColor(new Color(249, 249, 32));
        d.fillCircle(114, 145, 12);

        d.setColor(new Color(234, 9, 186));
        d.fillCircle(114, 145, 8);

        d.setColor(Color.WHITE);
        d.fillCircle(114, 145, 4);
    }

    /**
     * Notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
    }
}