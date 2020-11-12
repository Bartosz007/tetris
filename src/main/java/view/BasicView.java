package view;

import setting.GLOBAL;

import javax.swing.*;

public abstract class BasicView extends JPanel { //screen przykładowy z domyślnymi wartosciami wszystkiego

    protected JFrame window;
    protected JPanel previous_menu;

    protected JPanel first_panel,second_panel,thrid_panel;

    public BasicView(JFrame window, JPanel previous_menu) {
        this.window = window;
        this.previous_menu = previous_menu;

        setPreferredSize(GLOBAL.WINDOW_SIZE);
        setMaximumSize(GLOBAL.WINDOW_SIZE);


        first_panel = new JPanel();
        add(first_panel);

        second_panel = new JPanel();
        add(second_panel);

        thrid_panel = new JPanel();
        add(thrid_panel);
    }
}
