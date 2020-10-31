package helper;

import setting.VIEWS;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BJButton extends JButton implements MouseListener {
    public BJButton(String text) {
        super(text);

        setBackground(VIEWS.BUTTON_BG);
        setFont(VIEWS.PRIMARY_FONT);
    }

    public void setJButton(Dimension size, Border border){
        setPreferredSize(size);
        setMaximumSize(size);
        setBorder(border);
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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
