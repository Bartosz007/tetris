package view;

import helper.BButton;
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

    private final BButton game;
    private final BButton options;
    private final BButton scores;
    private final BButton exit;

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




        game = new BButton("START");
        game.setButton(VIEWS.BUTTON_SIZE);
        options = new BButton("OPCJE");
        options.setButton(VIEWS.BUTTON_SIZE);
        scores = new BButton("WYNIKI");
        scores.setButton(VIEWS.BUTTON_SIZE);
        exit = new BButton("WYJŚCIE");
        exit.setButton(VIEWS.BUTTON_SIZE);


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
