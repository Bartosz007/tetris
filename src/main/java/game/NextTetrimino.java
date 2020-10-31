package game;

import helper.PaintMethods;
import setting.GLOBAL;
import setting.VIEWS;
import tetrimino.Block;
import tetrimino.Otetrimino;
import tetrimino.Tetrimino;

import javax.swing.*;
import java.awt.*;

public class NextTetrimino extends JPanel {

    private Tetrimino tetrimino;
    private PaintMethods paintMethods;
    public NextTetrimino(Tetrimino tetrimino) {
        this.tetrimino = tetrimino;
        this.paintMethods = new PaintMethods();
        setBackground(GLOBAL.SECONDARY_COLOR);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g.create();
        g2d.setColor(GLOBAL.MAIN_COLOR);
        g2d.drawString("NASTEPNY: ",65,20);

        for (Block b :tetrimino.getBlocks() ) {
            paintMethods.paint_rect(g2d,b.getX()-150,b.getY()+40,b.getColor());
        }

        g2d.dispose();
    }

    public void setTetrimino(Tetrimino tetrimino) {
        this.tetrimino = tetrimino;
        repaint();
    }

    public Tetrimino getTetrimino() {
        return tetrimino;
    }
}
