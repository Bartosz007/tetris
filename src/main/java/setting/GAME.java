package setting;

import java.awt.*;

public class GAME {
    public static final int SIZE = 45;

    public static final int COLS = 10;
    public static final int ROWS = 20;
    public static final int MAX_Y = ROWS*SIZE;
    public static final int MIN_X = 0;
    public static final int MAX_X = COLS*SIZE;
    public static final int MIDDLE = SIZE*(COLS/2);

    public static int DELAY = 20;


    public static int BORDER = 2;


    public static Color MAIN_COLOR = new Color(100,100,100);
    public static Color SECONDARY_COLOR = new Color(140,40,40);
    public static Color SECONDARY_COLOR_BRIGHTER = new Color(160,47,47);


    public static String SCORE_PATH = "src/main/resources/scores.txt";


}
