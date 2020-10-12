package Layout;

import Settings.SETS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends Basic implements ActionListener {

    private final JButton start;
    private final JButton options;
    private final JButton scores;
    private final JButton exit;

    public Menu(JFrame window, JPanel previous_menu) {
        super(window, previous_menu);


        JPanel menu_container = new JPanel();
       // menu_container.setPreferredSize(new Dimension(SETS.SCREEN.width/4,SETS.SCREEN.height/2));
       // menu_container.setMaximumSize(new Dimension(SETS.SCREEN.width/4,SETS.SCREEN.height/2));
        menu_container.setBackground(Color.CYAN);
        menu_container.setLayout(new BoxLayout(menu_container,BoxLayout.PAGE_AXIS));

        second_panel.add(menu_container);
        second_panel.setLayout(new BoxLayout(second_panel,BoxLayout.LINE_AXIS));

        start = new JButton("Start");
        options = new JButton("Opcje");
        scores = new JButton("Wyniki");
        exit = new JButton("Wyjscie");
        start.setFont(SETS.FONT);
        options.setFont(SETS.FONT);
        scores.setFont(SETS.FONT);
        exit.setFont(SETS.FONT);

        menu_container.add(start);
        menu_container.add(options);
        menu_container.add(scores);
        menu_container.add(exit);

        start.addActionListener(this);
        options.addActionListener(this);
        scores.addActionListener(this);
        exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();

        if(button == start){
            setVisible(false);
            Game game = new Game(window,this);
            window.add(game);
        }else if(button == options){

        }else if(button == scores){

        }else{
            window.dispose();
        }

    }
}
