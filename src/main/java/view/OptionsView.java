package view;

import helper.BButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static setting.VIEWS.MAIN_MENU_BG;

public class OptionsView extends BasicView implements ActionListener {

    private BButton music;
    private BButton sound;
    private BButton back ;

    private boolean music_status;
    private boolean sound_status;

    public OptionsView(JFrame window, JPanel previous_menu) {
        super(window, previous_menu);

        music_status = true;
        sound_status = true;

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

        back = new BButton("POWRÓT");
        back.setButton(new Dimension(200,100));
        first_panel.add(back);

        music.addActionListener(this);
        sound.addActionListener(this);
        back.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BButton button = (BButton)e.getSource();

        if(button == music){
            if(music_status){
                music.setText("Muzyka wyłączona");
            }else{
                music.setText("Muzyka włączona");
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
}
