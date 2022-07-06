import java.util.List;

/**
 * @author Gitali Naim
 */
public class MenuSelection {
    private String key;
    private String message;
    private List<LevelInformation> levelSet;

    /**
     * constructor of Menu selection.
     *
     * @param key - the key
     * @param message - the message
     * @param levelSet - the level set
     */
    public MenuSelection(String key, String message,
                         List<LevelInformation> levelSet) {
        this.key = key;
        this.message = message;
        this.levelSet = levelSet;
    }

    /**
     * Gets key.
     *
     * @return the key
     */
    public String getKey() {
        return this.key;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Gets level set.
     *
     * @return the level set
     */
    public List<LevelInformation> getLevelSet() {
        return this.levelSet;
    }
}