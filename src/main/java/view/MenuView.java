package view;

import helper.gui.BButton;
import helper.file.JSONOperations;
import helper.sound.SoundPlayer;
import helper.sound.SoundSettings;
import setting.GLOBAL;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static setting.GLOBAL.MAIN_MENU_BG;

public class MenuView extends BasicView implements ActionListener {

    private final BButton game;
    private final BButton options;
    private final BButton scores;
    private final SoundPlayer soundPlayer;
    private SoundSettings soundSettings;

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
        game.setButton(GLOBAL.BUTTON_SIZE);
        options = new BButton("OPCJE");
        options.setButton(GLOBAL.BUTTON_SIZE);
        scores = new BButton("WYNIKI");
        scores.setButton(GLOBAL.BUTTON_SIZE);
        BButton exit = new BButton("WYJŚCIE");
        exit.setButton(GLOBAL.BUTTON_SIZE);


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

        loadSoundSettings();


        soundPlayer = new SoundPlayer(getClass().getResourceAsStream("/sounds/tetris.wav"));
        if(soundSettings.isMusicOn()){
            soundPlayer.playContinoulsly();
        }


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

        if(soundSettings.isSoundOn()){
            SoundPlayer soundPlayer2 = new SoundPlayer(getClass().getResourceAsStream("/sounds/button.wav"));
            soundPlayer2.playOnce();
        }


        if(button == game){

            setVisible(false);
            GameView new_game = new GameView(window,this,soundPlayer);

            window.add(new_game);

        }else if(button == options){

            setVisible(false);
            OptionsView new_options = new OptionsView(window,this, soundPlayer);
            window.add(new_options);

        }else if(button == scores){

            setVisible(false);
            ScoresView new_scores = new ScoresView(window,this);
            window.add(new_scores);

        }else{
            soundPlayer.stop();
            window.dispose();
        }

    }

    public void loadSoundSettings(){
        JSONOperations jsonOperations = new JSONOperations(GLOBAL.SOUND_SETTINGS_PATH);
        System.out.println(jsonOperations);
        soundSettings = new SoundSettings(jsonOperations);
    }

    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
        loadSoundSettings();
    }
}
