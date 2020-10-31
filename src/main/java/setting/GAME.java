package setting;

import java.awt.*;

public final class GAME {
    public static final int SIZE = 45;

    public static final int COLS = 10;
    public static final int ROWS = 20;
    public static final int MAX_Y = ROWS*SIZE;
    public static final int MIN_X = 0;
    public static final int MAX_X = COLS*SIZE;
    public static final int MIDDLE = SIZE*(COLS/2);

    public static final int DELAY = 20;


    public static final int BORDER = 2;


    public static final Color MAIN_COLOR = new Color(100,100,100);
    public static final Color SECONDARY_COLOR = new Color(140,40,40);
    public static final Color SECONDARY_COLOR_BRIGHTER = new Color(160,47,47);


    public static final String SCORE_PATH = "src/main/resources/scores.txt";

    public static final Color ITETRIMINO_COLOR = new Color(123,1,173);
    public static final Color JTETRIMINO_COLOR = new Color(0,119,133);
    public static final Color LTETRIMINO_COLOR = new Color(12,21,112);
    public static final Color OTETRIMINO_COLOR = new Color(171,107,3);
    public static final Color STETRIMINO_COLOR = new Color(1,133,1);
    public static final Color TTETRIMINO_COLOR = new Color(173,53,8);
    public static final Color ZTETRIMINO_COLOR = new Color(173,25,36);



}
