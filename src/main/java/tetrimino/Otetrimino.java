package tetrimino;


import setting.GAME;

import java.awt.*;

public class Otetrimino extends Tetrimino{

    public Otetrimino() {
        //TODO ustawić kolory tetrimino jako stałe
        color = new Color(244,140,5);
        rotate_state = 0;
        blocks = new Block[4];
        blocks[0] = new Block(GAME.MIDDLE-GAME.SIZE,0,color);
        blocks[1] = new Block(GAME.MIDDLE-GAME.SIZE,GAME.SIZE,color);
        blocks[2] = new Block(GAME.MIDDLE,0,color);
        blocks[3] = new Block(GAME.MIDDLE,GAME.SIZE,color);
    }

    @Override
    public void rotate() {

    }
}
