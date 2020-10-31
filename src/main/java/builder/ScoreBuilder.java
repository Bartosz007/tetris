package builder;

import setting.GLOBAL;
import setting.VIEWS;

import javax.swing.*;
import java.awt.*;

public class ScoreBuilder{
    private JLabel jlheader;
    private JLabel jlvalue;
    private int value;

    public ScoreBuilder(String header, int value) {
        this.jlheader = new JLabel(header);
        this.jlvalue = new JLabel(value+"");
        this.value = value;

        this.jlheader.setFont(VIEWS.SECONDARY_FONT);
        this.jlvalue.setFont(VIEWS.SECONDARY_FONT);

        this.jlheader.setForeground(GLOBAL.MAIN_COLOR);
        this.jlvalue.setForeground(GLOBAL.MAIN_COLOR);

    }

    public int getValue() {
        return value;
    }

    public void addValue(int val) {
        this.value = this.value + val;
        this.jlvalue.setText(this.value+"");
    }

    public JPanel buildPanel(){
        JPanel jpmain = new JPanel();
        jpmain.setLayout(new BoxLayout(jpmain,BoxLayout.PAGE_AXIS));

        JPanel jpheader = new JPanel();
        jpheader.setLayout(new BoxLayout(jpheader,BoxLayout.LINE_AXIS));
        jpheader.add(jlheader);


        JPanel jpvalue = new JPanel();
        jpvalue.setLayout(new BoxLayout(jpvalue,BoxLayout.LINE_AXIS));
        jpvalue.add(jlvalue);


        jpmain.add(jpheader);
        jpmain.add(jpvalue);

        jpheader.setOpaque(false);
        jpvalue.setOpaque(false);
        jpmain.setOpaque(false);

        return jpmain;
    }
}
