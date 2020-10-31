package game;

import builder.ScoreBuilder;

import javax.swing.*;

public class Score {
    private ScoreBuilder score;
    private ScoreBuilder lines;
    private ScoreBuilder speed;

    public static int DOWN_BUTTON = 1;
    public static int SPACE = 2;
    public static int LINE = 100;

    public Score() {

        score = new ScoreBuilder("WYNIK:",0);
        lines = new ScoreBuilder("LINIE:",0);
        speed = new ScoreBuilder("SZYBKOSC:",1);

    }

    public JPanel buildScore(){
        JPanel jp = new JPanel();

        jp.setLayout(new BoxLayout(jp,BoxLayout.PAGE_AXIS));
        jp.add(score.buildPanel());
        jp.add(Box.createVerticalStrut(20));

        jp.add(lines.buildPanel());
        jp.add(Box.createVerticalStrut(20));

        jp.add(speed.buildPanel());

        return jp;
    }

    public ScoreBuilder getScore() {
        return score;
    }

    public ScoreBuilder getLines() {
        return lines;
    }


    public ScoreBuilder getSpeed() {
        return speed;
    }

    public int calculateSpeed(){
        int lines =  this.lines.getValue();

        if(lines <10)
            return 1;
        else if (lines > 9 && lines<20)
            return 2;
        else if(lines > 19 && lines<30)
            return 3;
        else if(lines > 29 && lines<40)
            return 4;
        else if(lines > 39 && lines<50)
            return 5;
        else if(lines > 69 && lines<90)
            return 6;
        else if(lines > 89 && lines<110)
            return 7;
        else if(lines > 109 && lines<149)
            return 8;
        else if(lines > 149)
            return 9;

        return 1;
    }
}
