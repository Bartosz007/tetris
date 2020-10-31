package view;

import builder.TableBuilder;
import helper.BBasicScrollBarUI;
import helper.BButton;
import helper.JSONOperations;
import setting.GAME;
import setting.GLOBAL;
import setting.VIEWS;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import static setting.VIEWS.MAIN_MENU_BG;


public class ScoresView extends BasicView implements ActionListener, MouseListener {

    private BButton back;
    public ScoresView(JFrame window, JPanel previous_menu) {
        super(window, previous_menu);

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


        JPanel table = new JPanel();
        table.setLayout(new BoxLayout(table, BoxLayout.PAGE_AXIS));
        table.setOpaque(false);

        //JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize((new Dimension(400,800)));
        scrollPane.setMaximumSize(new Dimension(400,800));
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.GREEN,0));

        JScrollBar jScrollBar = new JScrollBar();
        jScrollBar.setBackground(GLOBAL.SECONDARY_COLOR);
        jScrollBar.setUI(new BBasicScrollBarUI());

        scrollPane.setVerticalScrollBar(jScrollBar);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        second_panel.add(scrollPane);


        back = new BButton("POWRÓT");
        back.setButton(new Dimension(200,100));
        back.setForeground(GLOBAL.MAIN_COLOR);
        back.addMouseListener(this);
        first_panel.add(back);

        back.addActionListener(this);

        JSONOperations jsonOperations = new JSONOperations(GAME.SCORE_PATH);
        ArrayList<TableBuilder> tableBuilders = jsonOperations.readFile();
        for (int i = 0; i < tableBuilders.size(); i++) {
            drawLine(table, i+1, tableBuilders.get(i));
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        previous_menu.setVisible(true);
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

    void drawLine(JPanel panel, int i, TableBuilder tableBuilder){
        JPanel row = new JPanel();
        row.setPreferredSize((new Dimension(360,60)));
        row.setMaximumSize(new Dimension(360,60));
        row.setLayout(new BoxLayout(row,BoxLayout.LINE_AXIS));
        row.setBackground(GLOBAL.SECONDARY_COLOR);
        row.addMouseListener(this);
        panel.add(row);

        //table_container.setBackground(GLOBAL.SECONDARY_COLOR);

        JPanel number_col = new JPanel();
        number_col.setPreferredSize((new Dimension(80,40)));
        number_col.setMaximumSize(new Dimension(80,40));
        number_col.setBackground(GLOBAL.SECONDARY_COLOR);

        number_col.setOpaque(false);
        row.add(number_col);

        JLabel first_value = new JLabel(i+".");
        first_value.setFont(VIEWS.SECONDARY_FONT);
        first_value.setForeground(GLOBAL.MAIN_COLOR);
        number_col.add(first_value);


        //

        JPanel score_col = new JPanel();
        score_col.setPreferredSize((new Dimension(170,40)));
        score_col.setMaximumSize(new Dimension(170,40));
        score_col.setOpaque(false);
        row.add(score_col);

        JLabel score_value = new JLabel(tableBuilder.getScore()+"");
        score_value.setFont(VIEWS.SECONDARY_FONT);
        score_value.setForeground(GLOBAL.MAIN_COLOR);

        score_col.add(score_value);

        //

        JPanel player_col = new JPanel();
        player_col.setPreferredSize((new Dimension(200,40)));
        player_col.setMaximumSize(new Dimension(200,40));
        player_col.setOpaque(false);
        row.add(player_col);

        JLabel player_value = new JLabel(tableBuilder.getName()+"");
        player_value.setFont(VIEWS.SECONDARY_FONT);
        player_value.setForeground(GLOBAL.MAIN_COLOR);

        player_col.add(player_value);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Component component =(Component)e.getSource();
        component.setBackground(GAME.SECONDARY_COLOR_BRIGHTER);

    }

    @Override
    public void mouseExited(MouseEvent e) {
        Component component =(Component)e.getSource();
        component.setBackground(GAME.SECONDARY_COLOR);
    }

}
