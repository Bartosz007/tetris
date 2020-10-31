package view;

import helper.BJButton;
import setting.VIEWS;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static setting.VIEWS.MAIN_MENU_BG;

public class MenuView extends BasicView implements ActionListener {

    private final BJButton game;
    private final BJButton options;
    private final BJButton scores;
    private final BJButton exit;

    public MenuView(JFrame window) {
        super(window,null);

        setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));


        first_panel.setPreferredSize((new Dimension(270,900)));
        first_panel.setMaximumSize(new Dimension(270,900));
        first_panel.setOpaque(false);

        second_panel.setPreferredSize((new Dimension(360,900)));
        second_panel.setMaximumSize(new Dimension(360,900));
        second_panel.setLayout(new BoxLayout(second_panel,BoxLayout.LINE_AXIS));
        second_panel.setOpaque(false);

        thrid_panel.setPreferredSize((new Dimension(270,900)));
        thrid_panel.setMaximumSize(new Dimension(270,900));
        thrid_panel.setOpaque(false);

        JPanel menu = new JPanel();
        menu.setPreferredSize((new Dimension(360,400)));
        menu.setMaximumSize(new Dimension(360,400));
        menu.setLayout(new BoxLayout(menu,BoxLayout.PAGE_AXIS));
        menu.setOpaque(false);
        second_panel.add(menu);

        game = new BJButton("START");
        game.setJButton(VIEWS.BUTTON_SIZE,VIEWS.BUTTON_BORDER);
        options = new BJButton("OPCJE");
        options.setJButton(VIEWS.BUTTON_SIZE,VIEWS.BUTTON_BORDER);
        scores = new BJButton("WYNIKI");
        scores.setJButton(VIEWS.BUTTON_SIZE,VIEWS.BUTTON_BORDER);
        exit = new BJButton("WYJSCIE");
        exit.setJButton(VIEWS.BUTTON_SIZE,VIEWS.BUTTON_BORDER);


        menu.add(Box.createVerticalStrut(15));
        menu.add(game);
        menu.add(Box.createVerticalStrut(30));
        menu.add(options);
        menu.add(Box.createVerticalStrut(30));
        menu.add(scores);
        menu.add(Box.createVerticalStrut(30));
        menu.add(exit);

        game.addActionListener(this);
        options.addActionListener(this);
        scores.addActionListener(this);
        exit.addActionListener(this);

        game.setFocusable(false);
        options.setFocusable(false);
        scores.setFocusable(false);
        exit.setFocusable(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage background = null;
        try {
            background =  ImageIO.read(getClass().getResource(MAIN_MENU_BG));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(background,0,0,900,900,this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();

        if(button == game){

            setVisible(false);
            GameView new_game = new GameView(window,this);
            window.add(new_game);

        }else if(button == options){

            setVisible(false);
            OptionsView new_options = new OptionsView(window,this);
            window.add(new_options);

        }else if(button == scores){

            setVisible(false);
            ScoresView new_scores = new ScoresView(window,this);
            window.add(new_scores);

        }else{
            window.dispose();
        }

    }
}
