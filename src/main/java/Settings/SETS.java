package Settings;

import java.awt.*;

public class SETS {
    public static int WIDTH = 1000;
    public static int HEIGHT = 1000;
    public static Color MAIN_COLOR = new Color(100,100,100);
    //public static Color SECONDARY_COLOR = new Color(140,40,40);
    public static Color SECONDARY_COLOR = Color.white;

    public static int TEXT_SIZE = 20;
    public static Font FONT = new Font("Dialog", Font.BOLD, TEXT_SIZE);
    public static Font SECONDARY_FONT = new Font("Arial", Font.BOLD, 15);
    public static Dimension SCREEN = Toolkit.getDefaultToolkit().getScreenSize();
    public static int WINDOW_SIZE = SETS_GAME.SIZE * SETS_GAME.ROWS+50 ;

}
