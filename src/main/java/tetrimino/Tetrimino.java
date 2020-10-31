package tetrimino;

import setting.GAME;

import java.awt.*;

public abstract class Tetrimino {
    protected int rotate_state;
    protected Color color;
    protected Block[] blocks;
    public abstract void rotate();

    public void gravit() {
        for (Block b:blocks) {
            b.setY(b.getY()+ GAME.SIZE);
        }
    }

    public void goleft(Block[][] play_board) {

        for (Block b:blocks){
            if(b.getX() == GAME.MIN_X)
                return;

            if(b.getX()/GAME.SIZE > 0
                && play_board[(b.getX()/GAME.SIZE)-1][b.getY()/GAME.SIZE]!=null)
                return;

        }

        for (Block b:blocks)
            b.setX(b.getX()-GAME.SIZE);

    }

    public void goright(Block[][] play_board) {

        for (Block b:blocks) {
            if (b.getX() == GAME.MAX_X - GAME.SIZE)
                return;

            if(b.getX()/GAME.SIZE < GAME.COLS
                    && play_board[(b.getX()/GAME.SIZE)+1][b.getY()/GAME.SIZE]!=null)
                return;
        }

        for (Block b:blocks)
            b.setX(b.getX()+GAME.SIZE);

    }

    public Boolean isFelt(Block[][] board_blocks) {
        for (Block b:blocks) {
            if(b.getY()>GAME.MAX_Y-2*GAME.SIZE)
                return true;

            if(board_blocks[b.getX()/GAME.SIZE][b.getY()/GAME.SIZE + 1] != null)
                return true;
        }

        return false;
    }

    public Block[] getBlocks() {
        return blocks;
    }


}
