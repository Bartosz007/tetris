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

public class OptionsView extends BasicView implements ActionListener {

    private final BButton music;
    private final BButton sound;
    private final SoundPlayer soundPlayer;

    private boolean music_status;
    private boolean sound_status;

    public OptionsView(JFrame window, JPanel previous_menu, SoundPlayer soundPlayer) {
        super(window, previous_menu);

        this.soundPlayer = soundPlayer;

        setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));

        first_panel.setPreferredSize((new Dimension(250,900)));
        first_panel.setMaximumSize(new Dimension(250,900));
        first_panel.setOpaque(false);

        second_panel.setPreferredSize((new Dimension(400,900)));
        second_panel.setMaximumSize(new Dimension(400,900));
        second_panel.setLayout(new BoxLayout(second_panel,BoxLayout.LINE_AXIS));
        second_panel.setOpaque(false);

        thrid_panel.setPreferredSize((new Dimension(250,900)));
        thrid_panel.setMaximumSize(new Dimension(250,900));
        thrid_panel.setOpaque(false);

        JPanel buttons_containter = new JPanel();
        buttons_containter.setPreferredSize((new Dimension(400,100)));
        buttons_containter.setMaximumSize(new Dimension(400,100));
        buttons_containter.setLayout(new BoxLayout(buttons_containter,BoxLayout.LINE_AXIS));
        second_panel.add(buttons_containter);


        music = new BButton("Muzyka włączona");
        music.setButton(new Dimension(200,100));
        buttons_containter.add(music);

        sound = new BButton("Dzwięki włączone");
        sound.setButton(new Dimension(200,100));
        buttons_containter.add(sound);

        BButton back = new BButton("POWRÓT");
        back.setButton(new Dimension(200,100));
        first_panel.add(back);

        music.addActionListener(this);
        sound.addActionListener(this);
        back.addActionListener(this);

        loadOptions();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BButton button = (BButton)e.getSource();

        if(sound_status){
            SoundPlayer soundPlayer2 = new SoundPlayer(getClass().getResourceAsStream("/sounds/button.wav"));
            soundPlayer2.playOnce();
        }


        if(button == music){
            if(music_status){
                music.setText("Muzyka wyłączona");
                soundPlayer.stop();
            }else{
                music.setText("Muzyka włączona");
                soundPlayer.playContinoulsly();
            }
            music_status=!music_status;
        }else if (button == sound){
            if(sound_status){
                sound.setText("Dźwięk wyłączony");
            }else{
                sound.setText("Dźwięk włączony");
            }
            sound_status=!sound_status;
        }
        else{
            JSONOperations jsonOperations = new JSONOperations(GLOBAL.SOUND_SETTINGS_PATH);
            jsonOperations.saveSoundSettings(sound_status,music_status);

            this.setVisible(false);
            previous_menu.setVisible(true);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        super.paintComponent(g);
        BufferedImage background = null;
        try {
            background =  ImageIO.read(getClass().getResource(MAIN_MENU_BG));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(background,0,0,900,900,this);

    }

    private void loadOptions(){
        JSONOperations jsonOperations = new JSONOperations(GLOBAL.SOUND_SETTINGS_PATH);
        SoundSettings soundSettings = new SoundSettings(jsonOperations);

        music_status = soundSettings.isMusicOn();
        sound_status = soundSettings.isSoundOn();

        if(music_status){
            music.setText("Muzyka włączona");
        }else{
            music.setText("Muzyka wyłączona");

        }

        if(sound_status){
            sound.setText("Dźwięk włączony");
        }else{
            sound.setText("Dźwięk wyłączony");
        }


    }
}
