package Game;

import Layout.Basic;
import Settings.SETS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends Basic implements ActionListener {
    private JButton back;

    public Game(JFrame window, JPanel previous_menu) {
        super(window, previous_menu);

        first_panel.setPreferredSize(new Dimension(SETS.SCREEN.width/4,SETS.SCREEN.height));
        second_panel.setPreferredSize(new Dimension(2*SETS.SCREEN.width/4,SETS.SCREEN.height));
        thrid_panel.setPreferredSize(new Dimension(SETS.SCREEN.width/4,SETS.SCREEN.height));

        second_panel.setLayout(new BoxLayout(second_panel,BoxLayout.PAGE_AXIS));

        JPanel play_field = new Tetris();
        play_field.setPreferredSize(new Dimension(SETS.SCREEN.width/4,SETS.SCREEN.height));
        play_field.setMaximumSize(new Dimension(SETS.SCREEN.width/4,SETS.SCREEN.height));
      //  play_field.setBackground(Color.cyan);
        second_panel.add(play_field);
        back = new JButton("Powrot");
        back.addActionListener(this);
        first_panel.add(back);

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
