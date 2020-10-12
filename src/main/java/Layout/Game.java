package Layout;

import Game.Score;
import Settings.SETS;
import Settings.SETS_GAME;
import Game.Tetris;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends Basic implements ActionListener {
    private JButton back;
    private Score score;
    public Game(JFrame window, JPanel previous_menu) {
        super(window, previous_menu);

        score = new Score();

        first_panel.setPreferredSize(new Dimension(SETS.WINDOW_SIZE/4,SETS.WINDOW_SIZE));
        first_panel.setMaximumSize(new Dimension(SETS.WINDOW_SIZE/4,SETS.WINDOW_SIZE));

        second_panel.setPreferredSize(new Dimension(2*SETS.WINDOW_SIZE/4,SETS.WINDOW_SIZE));
        second_panel.setMaximumSize(new Dimension(2*SETS.WINDOW_SIZE/4,SETS.WINDOW_SIZE));

        thrid_panel.setPreferredSize(new Dimension(SETS.WINDOW_SIZE/4,SETS.WINDOW_SIZE));
        thrid_panel.setMaximumSize(new Dimension(SETS.WINDOW_SIZE/4,SETS.WINDOW_SIZE));

        /*-----------------------------
            first panel
        ------------------------------- */
        first_panel.setBackground(SETS.MAIN_COLOR);

        JPanel left_upper = new JPanel();
        left_upper.setPreferredSize(new Dimension(SETS.WINDOW_SIZE/4,2*SETS.WINDOW_SIZE/3));
        left_upper.setMaximumSize(new Dimension(SETS.WINDOW_SIZE/4,2*SETS.WINDOW_SIZE/3));
      //  left_upper.setBackground(Color.ORANGE);
        first_panel.add(left_upper);

        JPanel left_upper_center = new JPanel();
        left_upper_center.setPreferredSize(new Dimension(SETS.WINDOW_SIZE/5,2*SETS.WINDOW_SIZE/3));
        left_upper_center.setMaximumSize(new Dimension(SETS.WINDOW_SIZE/5,2*SETS.WINDOW_SIZE/3));
        left_upper_center.setLayout(new BoxLayout(left_upper_center,BoxLayout.LINE_AXIS));
        //left_upper_center.setBackground(Color.blue);
        left_upper.add(left_upper_center);

        JPanel left_upper_content = new JPanel();
        left_upper_content.setPreferredSize(new Dimension(SETS.WINDOW_SIZE/5,SETS.WINDOW_SIZE/3));
        left_upper_content.setMaximumSize(new Dimension(SETS.WINDOW_SIZE/5,SETS.WINDOW_SIZE/3));
        left_upper_content.setLayout(new BoxLayout(left_upper_content,BoxLayout.PAGE_AXIS));
       // left_upper_content.setBackground(Color.red);
        left_upper_center.add(left_upper_content);

        JLabel score_header = new JLabel("Score:");
        score_header.setFont(SETS.SECONDARY_FONT);
        left_upper_content.add(score_header);

        JLabel score_value = new JLabel("0");
        score_value.setFont(SETS.SECONDARY_FONT);
        left_upper_content.add(score_value);

        JLabel lines_header = new JLabel("Lines:");
        lines_header.setFont(SETS.SECONDARY_FONT);
        left_upper_content.add(lines_header);

        JLabel lines_value = new JLabel("0");
        lines_value.setFont(SETS.SECONDARY_FONT);
        left_upper_content.add(lines_value);

        JLabel speed_header = new JLabel("Speed:");
        speed_header.setFont(SETS.SECONDARY_FONT);
        left_upper_content.add(speed_header);

        JLabel speed_value = new JLabel("1");
        speed_value.setFont(SETS.SECONDARY_FONT);
        left_upper_content.add(speed_value);

        JPanel left_lower = new JPanel();
        left_lower.setPreferredSize(new Dimension(SETS.WINDOW_SIZE/4,SETS.WINDOW_SIZE/3));
        left_lower.setMaximumSize(new Dimension(SETS.WINDOW_SIZE/4,SETS.WINDOW_SIZE/3));
   //     left_lower.setBackground(Color.green);
        first_panel.add(left_lower);

        back = new JButton("Powr\u00F3t");
        back.addActionListener(this);
        back.setFocusable(false);
        back.setPreferredSize(new Dimension(SETS.WINDOW_SIZE/5,SETS.WINDOW_SIZE/5));
        back.setBackground(SETS.MAIN_COLOR);
        back.setFont(SETS.FONT);
        back.setForeground(SETS.SECONDARY_COLOR);
        left_lower.add(back);


        /*-----------------------------
            second panel
        ------------------------------- */

        second_panel.setBackground(SETS.MAIN_COLOR);

        JPanel play_field = new Tetris();
        play_field.setPreferredSize(new Dimension(SETS_GAME.COLS*SETS_GAME.SIZE,SETS.WINDOW_SIZE));
        play_field.setMaximumSize(new Dimension(SETS_GAME.COLS*SETS_GAME.SIZE,SETS.WINDOW_SIZE));
        second_panel.add(play_field);
        second_panel.setLayout(new BoxLayout(second_panel,BoxLayout.PAGE_AXIS));



        /*-----------------------------
            thrid panel
        ------------------------------- */


        JPanel right_center = new JPanel();
        right_center.setPreferredSize(new Dimension(SETS.WINDOW_SIZE/5,SETS.WINDOW_SIZE));
        right_center.setMaximumSize(new Dimension(SETS.WINDOW_SIZE/5,SETS.WINDOW_SIZE));
        right_center.setBackground(SETS.MAIN_COLOR);
        right_center.setLayout(new BoxLayout(right_center,BoxLayout.LINE_AXIS));
        thrid_panel.add(right_center);

        JPanel right_content = new JPanel();
        right_content.setPreferredSize(new Dimension(SETS.WINDOW_SIZE/5,200));
        right_content.setMaximumSize(new Dimension(SETS.WINDOW_SIZE/5,200));
        right_content.setBackground(SETS.SECONDARY_COLOR);
        right_center.add(right_content);

        JLabel temporary = new JLabel("nastepny blok");
        right_content.add(temporary);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        if(button == back){
            this.setVisible(false);
            previous_menu.setVisible(true);
        }
    }
}
