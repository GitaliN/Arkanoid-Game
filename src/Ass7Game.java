import java.util.ArrayList;
import java.util.List;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * @author Gitali Naim
 */
public class Ass7Game {

    /**
     * This is the main function of the program.
     *
     * @param args - arguments of the program
     */
    public static void main(String[] args) {

        //initialize the game
        GUI gui = new GUI("Arkanoid", 800, 600);
        AnimationRunner animationRunner = new AnimationRunner(gui, 60, new Sleeper());
        List<LevelInformation> levelsEasy = new ArrayList<LevelInformation>();
        List<LevelInformation> levelsHard = new ArrayList<LevelInformation>();

        //easy levels
        levelsEasy.add(new DirectHit());
        levelsEasy.add(new WideEasy());
        levelsEasy.add(new DigitalWorld());

        //hard levels
        levelsHard.add(new Colorful());
        levelsHard.add(new PinkView());
        levelsHard.add(new WinterBlue());

        //create the sub menu
        Menu<Task<Void>> levelsMenu = new MenuAnimation<Task<Void>>(
                "Level Sets", gui.getKeyboardSensor(), animationRunner);
        try {
            List<MenuSelection> levelsSets = new ArrayList<MenuSelection>();
            levelsSets.add(new MenuSelection("e", "Easy", levelsEasy));
            levelsSets.add(new MenuSelection("h", "Hard", levelsHard));

            for (MenuSelection selection : levelsSets) {
                levelsMenu.addSelection(selection.getKey(), selection.getMessage(), new StartGameTask(
                        gui, animationRunner, selection.getLevelSet()));
            }
        } catch (Exception e) {
            System.out.println("error");
            System.exit(0);
        }

        //create the menu
        Menu<Task<Void>> menu = new MenuAnimation<Task<Void>>("Arkanoid", gui.getKeyboardSensor(), animationRunner);
        menu.addSubMenu("s", "Start game", levelsMenu);
        menu.addSelection("e", "Exit", new ExitTask(gui));
        while (true) {
            animationRunner.run(menu);
            Task<Void> task = menu.getStatus();
            task.run();
            menu.reset();
        }
    }
}