package Layout;

import Settings.SETS;

import javax.swing.*;
import java.awt.*;

public abstract class Basic extends JPanel { //screen przykładowy z domyślnymi wartosciami wszystkiego
    protected JButton back;
    protected JFrame window;
    protected JPanel previous_menu;

    protected JPanel main_menu,first_panel,second_panel,thrid_panel;

    public Basic(JFrame window, JPanel previous_menu) {

        this.window = window;
        this.previous_menu = previous_menu;


        main_menu = new JPanel();
        main_menu.setPreferredSize(new Dimension(SETS.WINDOW_SIZE,SETS.WINDOW_SIZE));
        main_menu.setMaximumSize(new Dimension(SETS.WINDOW_SIZE,SETS.WINDOW_SIZE));
        main_menu.setLayout(new BoxLayout(main_menu,BoxLayout.LINE_AXIS));
        add(main_menu);

        first_panel = new JPanel();
        first_panel.setBackground(SETS.MAIN_COLOR);
        first_panel.setLayout(new BoxLayout(first_panel,BoxLayout.PAGE_AXIS));
        main_menu.add(first_panel);

        second_panel = new JPanel();
        second_panel.setBackground(SETS.SECONDARY_COLOR);
        second_panel.setLayout(new BoxLayout(second_panel,BoxLayout.PAGE_AXIS));
        main_menu.add(second_panel);

        thrid_panel = new JPanel();
        thrid_panel.setLayout(new BoxLayout(thrid_panel,BoxLayout.PAGE_AXIS));
        thrid_panel.setBackground(SETS.MAIN_COLOR);
        main_menu.add(thrid_panel);

        /*
        //przycisk cofania się
        back = new JButton("Cofnij");
        back.setFont( new Font("Dialog", Font.BOLD, 24));
        thrid_panel.add(back);

         */
    }
}
