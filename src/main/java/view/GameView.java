package view;

import game.Score;
import game.Tetris;
import helper.BJButton;
import setting.GAME;
import setting.GLOBAL;
import setting.VIEWS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameView extends BasicView implements ActionListener {
    private final BJButton back;
    private final Score score;
    public GameView(JFrame window, JPanel previous_menu) {
        super(window, previous_menu);

        score = new Score();

        setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));

        first_panel.setPreferredSize(new Dimension(225,900));
        first_panel.setMaximumSize(new Dimension(225,900));
        first_panel.setLayout(new BoxLayout(first_panel,BoxLayout.PAGE_AXIS));

        second_panel.setPreferredSize(new Dimension(450,900));
        second_panel.setMaximumSize(new Dimension(450,900));
        second_panel.setLayout(new BoxLayout(second_panel,BoxLayout.LINE_AXIS));

        thrid_panel.setPreferredSize(new Dimension(225,900));
        thrid_panel.setMaximumSize(new Dimension(225,900));
        thrid_panel.setLayout(new BoxLayout(thrid_panel,BoxLayout.PAGE_AXIS));

        second_panel.setBackground(Color.green);

        /**

        lewy panel

         **/
        JPanel left_upper = new JPanel();
        left_upper.setPreferredSize(new Dimension(225,800));
        left_upper.setMaximumSize(new Dimension(225,800));
        left_upper.setLayout(new BoxLayout(left_upper,BoxLayout.LINE_AXIS));
        first_panel.add(left_upper);

        JPanel left_lower = new JPanel();
        left_lower.setPreferredSize(new Dimension(200,100));
        left_lower.setMaximumSize(new Dimension(200,100));
        left_lower.setLayout(new BoxLayout(left_lower,BoxLayout.LINE_AXIS));
        first_panel.add(left_lower);


        JPanel score_container = new JPanel();
        score_container.setPreferredSize(new Dimension(225,200));
        score_container.setMaximumSize(new Dimension(225,200));
        score_container.setBackground(Color.pink);
        left_upper.add(score_container);

        score_container.add(score.buildScore());

        back = new BJButton("Powrot");
        back.setFocusable(false);
        back.setJButton(new Dimension(200,100), VIEWS.BUTTON_BORDER);
        back.addActionListener(this);
        left_lower.add(back);


         /**

        prawy panel

         **/

        JPanel right_center = new JPanel();
        right_center.setPreferredSize(new Dimension(200,900));
        right_center.setMaximumSize(new Dimension(200,900));
        right_center.setLayout(new BoxLayout(right_center,BoxLayout.LINE_AXIS));
        thrid_panel.add(right_center);

        JPanel next_tetrimino = new JPanel();
        next_tetrimino.setPreferredSize(new Dimension(200,200));
        next_tetrimino.setMaximumSize(new Dimension(200,200));
        next_tetrimino.setLayout(new BoxLayout(next_tetrimino,BoxLayout.PAGE_AXIS));
        right_center.add(next_tetrimino);



        /**
        środkowy panel

         **/
        JPanel tetris = new Tetris(window,this, score,next_tetrimino);
        tetris.setPreferredSize(new Dimension(GAME.COLS*GAME.SIZE,GLOBAL.BASIC_SIZE));
        tetris.setMaximumSize(new Dimension(GAME.COLS* GAME.SIZE,GLOBAL.BASIC_SIZE));
        second_panel.add(tetris);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        previous_menu.setVisible(true);
    }



}
