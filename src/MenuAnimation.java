import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author Gitali Naim
 *
 * @param <T> the type parameter
 */
public class MenuAnimation<T> implements Menu<T> {
    private String menuTitle;
    private List<String> keys;
    private List<String> messages;
    private List<T> options;
    private List<Menu<T>> subMenus;
    private List<Boolean> isOption;
    private T status;
    private boolean close;
    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;

    /**
     * constructor of menu animation.
     *
     * @param menuTitle       - the menuTitle
     * @param keyboardSensor  - the keyboardSensor
     * @param animationRunner - the animationRunner
     */
    public MenuAnimation(String menuTitle, KeyboardSensor keyboardSensor,
                         AnimationRunner animationRunner) {
        this.menuTitle = menuTitle;
        this.keys = new ArrayList<String>();
        this.messages = new ArrayList<String>();
        this.options = new ArrayList<T>();
        this.subMenus = new ArrayList<Menu<T>>();
        this.isOption = new ArrayList<Boolean>();
        this.close = false;
        this.keyboardSensor = keyboardSensor;
        this.animationRunner = animationRunner;
    }

    /**
     * This function draws the current state of the animation object on the screen.
     *
     * @param d the DrawSurface
     */
    @Override
    public void doOneFrame(DrawSurface d) {

        //the open screen
        d.setColor(new Color(240, 214, 245));
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(new Color(203, 48, 232));
        d.drawText(260, d.getHeight() / 2 - 90, this.menuTitle, 70);
        d.fillRectangle(80, d.getHeight() / 2 - 70, d.getWidth() - 160, 3);
        for (int i = 0; i < this.keys.size(); i++) {
            d.drawText(260, 200 + 40 * (i + 2), "("
                    + this.keys.get(i) + ") " + this.messages.get(i), 30);
        }
        for (int i = 0; i < this.keys.size(); i++) {
            if (this.keyboardSensor.isPressed(this.keys.get(i))) {
                if (this.isOption.get(i)) {
                    this.status = this.options.get(i);
                    this.close = true;
                } else {
                    this.animationRunner.run(this.subMenus.get(i));
                    this.status = this.subMenus.get(i).getStatus();
                    this.subMenus.get(i).reset();
                    this.close = true;
                    break;
                }
            }
        }
    }

    /**
     * This function tells if the animation should stop.
     *
     * @return true if the animation should stop, false otherwise
     */
    @Override
    public boolean shouldStop() {
        return this.close;
    }

    /**
     * Add selection.
     *
     * @param key       - the key
     * @param message   - the message
     * @param returnVal - the return val
     */
    @Override
    public void addSelection(String key, String message, T returnVal) {
        this.keys.add(key);
        this.messages.add(message);
        this.options.add(returnVal);
        this.subMenus.add(null);
        this.isOption.add(true);
    }

    /**
     * Add sub menu.
     *
     * @param key     - the key
     * @param message - the message
     * @param subMenu - the sub menu
     */
    @Override
    public void addSubMenu(String key, String message, Menu<T> subMenu) {
        this.keys.add(key);
        this.messages.add(message);
        this.subMenus.add(subMenu);
        this.options.add(null);
        this.isOption.add(false);
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    @Override
    public T getStatus() {
        return this.status;
    }

    /**
     * Reset.
     */
    @Override
    public void reset() {
        this.status = null;
        this.close = false;
    }
}