package Tetriminos;

import Settings.SETS;
import Settings.SETS_GAME;

import java.awt.*;

public abstract class Tetrimino {
    protected int rotate_state;
    protected Color color;
    protected Block[] blocks;
    public abstract void rotate();


    public void gravit() {
        for (Block b:blocks) {
            b.setY(b.getY()+ SETS_GAME.SIZE);
        }
    }

    public void goleft(Block[][] play_board) {

        for (Block b:blocks){
            if(b.getX() == SETS_GAME.MIN_X)
                return;

            if(b.getX()/SETS_GAME.SIZE > 0
                && play_board[(b.getX()/SETS_GAME.SIZE)-1][b.getY()/SETS_GAME.SIZE]!=null)
                return;

        }

        for (Block b:blocks)
            b.setX(b.getX()-SETS_GAME.SIZE);

    }

    public void goright(Block[][] play_board) {

        for (Block b:blocks) {
            if (b.getX() == SETS_GAME.MAX_X - SETS_GAME.SIZE)
                return;

            if(b.getX()/SETS_GAME.SIZE < SETS_GAME.COLS
                    && play_board[(b.getX()/SETS_GAME.SIZE)+1][b.getY()/SETS_GAME.SIZE]!=null)
                return;
        }

        for (Block b:blocks)
            b.setX(b.getX()+SETS_GAME.SIZE);

    }

    public Boolean isFelt(Block[][] board_blocks) {
        for (Block b:blocks) {
            if(b.getY()>SETS_GAME.MAX_Y-2*SETS_GAME.SIZE)
                return true;

            if(board_blocks[b.getX()/SETS_GAME.SIZE][b.getY()/SETS_GAME.SIZE + 1] != null)
                return true;
        }

        return false;
    }

    public Block[] getBlocks() {
        return blocks;
    }

}
