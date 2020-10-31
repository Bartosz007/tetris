package view;

import helper.BJButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static setting.VIEWS.MAIN_MENU_BG;

public class OptionsView extends BasicView implements ActionListener {

    private BJButton music;
    private BJButton sound;
    private BJButton back ;

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


        music = new BJButton("Muzyka wlaczona");
        music.setJButton(new Dimension(200,100),null);
        buttons_containter.add(music);

        sound = new BJButton("Dzwieki wlaczone");
        sound.setJButton(new Dimension(200,100),null);
        buttons_containter.add(sound);

        back = new BJButton("Powrot");
        back.setJButton(new Dimension(200,100),null);
        first_panel.add(back);

        music.addActionListener(this);
        sound.addActionListener(this);
        back.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BJButton button = (BJButton)e.getSource();

        if(button == music){
            if(music_status){
                music.setText("Muzyka wylaczona");
            }else{
                music.setText("Muzyka wlaczona");
            }
            music_status=!music_status;
        }else if (button == sound){
            if(sound_status){
                sound.setText("Dzwiek wylaczony");
            }else{
                sound.setText("Dzwiek wlaczony");
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
