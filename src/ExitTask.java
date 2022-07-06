import biuoop.GUI;

/**
 * @author Gitali Naim
 */
public class ExitTask implements Task<Void> {
    private GUI gui;

    /**
     * constructor of ExitTask.
     *
     * @param gui a given gui
     */
    public ExitTask(GUI gui) {
        this.gui = gui;
    }

    /**
     * this function runs the task.
     *
     * @return null
     */
    public Void run() {
        this.gui.close();
        System.exit(0);
        return null;
    }
}