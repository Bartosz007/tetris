package view;

import builder.TableBuilder;
import helper.BButton;
import helper.JSONOperations;
import org.json.simple.JSONObject;
import setting.GAME;
import setting.GLOBAL;
import setting.VIEWS;

import javax.imageio.ImageIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import static setting.VIEWS.MAIN_MENU_BG;

public class EndGameView extends BasicView implements ActionListener {

    private int score;
    private String name;
    private JTextField player_value;
    private JSONOperations jsonOperations;
    private BButton next;

    public EndGameView(JFrame window, JPanel previous_menu, int score) {
        super(window, previous_menu);

        this.score = score;

        this.jsonOperations = new JSONOperations(GAME.SCORE_PATH);

        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

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



        JPanel table_container = new JPanel();
        table_container.setPreferredSize((new Dimension(360,80)));
        table_container.setMaximumSize(new Dimension(360,80));
        table_container.setLayout(new BoxLayout(table_container,BoxLayout.LINE_AXIS));
        second_panel.add(table_container);

        table_container.setBackground(GLOBAL.SECONDARY_COLOR);

        /**
         * kolumna number
         */

        JPanel number_col = new JPanel();
        number_col.setPreferredSize((new Dimension(80,40)));
        number_col.setMaximumSize(new Dimension(80,40));
        table_container.add(number_col);

        JLabel first_value = new JLabel();
        first_value.setFont(VIEWS.PRIMARY_FONT);
        first_value.setForeground(GLOBAL.MAIN_COLOR);
        number_col.add(first_value);

        ArrayList<TableBuilder> tableBuilders = jsonOperations.readFile();

        for (int i = 0; i < tableBuilders.size(); i++) {
            if(tableBuilders.get(i).getScore() < this.score){
                first_value.setText(i+1+".");
                break;
            }
        }


        /**
         * kolumna score
         */

        JPanel score_col = new JPanel();
        score_col.setPreferredSize((new Dimension(170,40)));
        score_col.setMaximumSize(new Dimension(170,40));
        table_container.add(score_col);

        JLabel score_value = new JLabel(this.score+"");
        score_value.setFont(VIEWS.PRIMARY_FONT);
        score_value.setForeground(GLOBAL.MAIN_COLOR);
        score_col.add(score_value);

        /**
         * kolumna player
         */

        JPanel player_col = new JPanel();
        player_col.setPreferredSize((new Dimension(200,40)));
        player_col.setMaximumSize(new Dimension(200,40));
        table_container.add(player_col);

        player_value = new JTextField();
        player_value.setFont(VIEWS.PRIMARY_FONT);
        player_value.setForeground(GLOBAL.MAIN_COLOR);
        player_value.setPreferredSize((new Dimension(100,30)));
        player_value.setMaximumSize(new Dimension(100,30));
        player_value.setHorizontalAlignment(SwingConstants.CENTER);
        player_value.setFocusable(true);
        player_value.setBackground(GLOBAL.SECONDARY_COLOR);
        player_value.setBorder(BorderFactory.createLineBorder(null,0));
        player_col.add(player_value);

        /**
         *
         * kolumna next
         */

        JPanel next_col = new JPanel();
        next_col.setPreferredSize((new Dimension(80,80)));
        next_col.setMaximumSize(new Dimension(80,80));
        next_col.setLayout(new BoxLayout(next_col,BoxLayout.LINE_AXIS));
        table_container.add(next_col);

        next = new BButton("DALEJ");
        next.setPreferredSize((new Dimension(80,80)));
        next.setMaximumSize(new Dimension(80,80));
        next_col.add(next);

        number_col.setOpaque(false);
        score_col.setOpaque(false);
        player_col.setOpaque(false);
        next_col.setOpaque(false);


        next.addActionListener(this);
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
        this.name = player_value.getText();

        if(name.equals(""))
            name = "NN";
        JSONOperations jsonOperations = new JSONOperations(GAME.SCORE_PATH);
        jsonOperations.saveToFile(new TableBuilder(score, name));

        this.setVisible(false);
        window.add(new MenuView(window));

    }
}
