package Tetriminos;

import Settings.SETS_GAME;

import java.awt.*;

public class Otetrimino extends Tetrimino{

    public Otetrimino() {
        color = new Color(244,140,5);
        rotate_state = 0;
        blocks = new Block[4];
        blocks[0] = new Block(SETS_GAME.MIDDLE,-SETS_GAME.SIZE,color);
        blocks[1] = new Block(SETS_GAME.MIDDLE,-2*SETS_GAME.SIZE,color);
        blocks[2] = new Block(SETS_GAME.MIDDLE+SETS_GAME.SIZE,-SETS_GAME.SIZE,color);
        blocks[3] = new Block(SETS_GAME.MIDDLE+SETS_GAME.SIZE,-2*SETS_GAME.SIZE,color);
    }

    @Override
    public void rotate() {

    }
}
