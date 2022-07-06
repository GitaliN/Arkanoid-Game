/**
 * @param <T> the type parameter
 * @author Gitali Naim
 * <p>
 * The interface Menu.
 */
public interface Menu<T> extends Animation {

    /**
     * Add selection.
     *
     * @param key       - the key
     * @param message   - the message
     * @param returnVal - the return val
     */
    void addSelection(String key, String message, T returnVal);

    /**
     * Add sub menu.
     *
     * @param key     - the key
     * @param message - the message
     * @param subMenu - the sub menu
     */
    void addSubMenu(String key, String message, Menu<T> subMenu);

    /**
     * Reset.
     */
    void reset();

    /**
     * Gets status.
     *
     * @return the status
     */
    T getStatus();
}