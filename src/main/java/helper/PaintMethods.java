package helper;

import setting.GAME;
import setting.GLOBAL;
import tetrimino.Block;
import tetrimino.Tetrimino;

import java.awt.*;

public class PaintMethods {

    public void paint_rect(Graphics2D g2d, int x, int y, Color color){

        g2d.setColor(GLOBAL.SECONDARY_COLOR);
        g2d.setStroke(new BasicStroke(GAME.BORDER));
        g2d.drawRect(x,y,GAME.SIZE,GAME.SIZE);

        g2d.setColor(color);
        g2d.fillRect(x+(GAME.BORDER/2),y+(GAME.BORDER/2),
                GAME.SIZE-GAME.BORDER,GAME.SIZE-GAME.BORDER);
    }

    public void paint_background(Graphics2D g2d){
        for(int i =0;i<GAME.COLS;i++){
            for(int j =0;j<GAME.ROWS;j++){
                paint_rect(g2d, i*GAME.SIZE,j*GAME.SIZE, GLOBAL.MAIN_COLOR);
            }
        }
    }

    public void paint_tetrimino(Graphics2D g2d, Tetrimino tetrimino){
        for (Block block:tetrimino.getBlocks()) {
            paint_rect(g2d, block.getX(),block.getY(),block.getColor());
        }
    }

    public void paint_blocks(Graphics2D g2d, Block[][] blocks){
        for (Block[] b: blocks) {
            for(Block block:b){
                // System.out.println(block);
                //TODO: poprawić to (Optional zamiast != null)
                if(block != null)
                    paint_rect(g2d,block.getX(),block.getY(),block.getColor());
            }
        }

    }
}
