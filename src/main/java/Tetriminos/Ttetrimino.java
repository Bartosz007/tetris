package Tetriminos;

import Settings.SETS_GAME;

import java.awt.*;

public class Ttetrimino extends Tetrimino{

    public Ttetrimino() {
        color = new Color(15,85,0);
        rotate_state = 0;
        blocks = new Block[4];
        blocks[0] = new Block(SETS_GAME.MIDDLE-SETS_GAME.SIZE,SETS_GAME.SIZE,color);
        blocks[1] = new Block(SETS_GAME.MIDDLE,SETS_GAME.SIZE,color);
        blocks[2] = new Block(SETS_GAME.MIDDLE+SETS_GAME.SIZE,SETS_GAME.SIZE,color);
        blocks[3] = new Block(SETS_GAME.MIDDLE,0,color);
    }

    @Override
    public void rotate() {
        switch (rotate_state){
            case 0:
                if (blocks[1].getY() > SETS_GAME.MAX_Y-SETS_GAME.SIZE*2)
                    break;

                blocks[0].setY(blocks[0].getY()-SETS_GAME.SIZE);
                blocks[0].setX(blocks[0].getX()+SETS_GAME.SIZE);

                blocks[2].setY(blocks[2].getY()+SETS_GAME.SIZE);
                blocks[2].setX(blocks[2].getX()-SETS_GAME.SIZE);

                blocks[3].setY(blocks[3].getY()+SETS_GAME.SIZE);
                blocks[3].setX(blocks[3].getX()+SETS_GAME.SIZE);


                rotate_state = 1;
                break;

            case 1:
                if(blocks[1].getX() == SETS_GAME.MIN_X)
                    break;

                blocks[0].setY(blocks[0].getY()+SETS_GAME.SIZE);
                blocks[0].setX(blocks[0].getX()+SETS_GAME.SIZE);

                blocks[2].setY(blocks[2].getY()-SETS_GAME.SIZE);
                blocks[2].setX(blocks[2].getX()-SETS_GAME.SIZE);

                blocks[3].setY(blocks[3].getY()+SETS_GAME.SIZE);
                blocks[3].setX(blocks[3].getX()-SETS_GAME.SIZE);

                rotate_state = 2;
                break;
            case 2:

                blocks[0].setY(blocks[0].getY()+SETS_GAME.SIZE);
                blocks[0].setX(blocks[0].getX()-SETS_GAME.SIZE);

                blocks[2].setY(blocks[2].getY()-SETS_GAME.SIZE);
                blocks[2].setX(blocks[2].getX()+SETS_GAME.SIZE);

                blocks[3].setY(blocks[3].getY()-SETS_GAME.SIZE);
                blocks[3].setX(blocks[3].getX()-SETS_GAME.SIZE);

                rotate_state = 3;
                break;
            case 3:

                if(blocks[1].getX() > SETS_GAME.MAX_X-2*SETS_GAME.SIZE)
                    break;

                blocks[0].setY(blocks[0].getY()-SETS_GAME.SIZE);
                blocks[0].setX(blocks[0].getX()-SETS_GAME.SIZE);

                blocks[2].setY(blocks[2].getY()+SETS_GAME.SIZE);
                blocks[2].setX(blocks[2].getX()+SETS_GAME.SIZE);

                blocks[3].setY(blocks[3].getY()-SETS_GAME.SIZE);
                blocks[3].setX(blocks[3].getX()+SETS_GAME.SIZE);

                rotate_state = 0;
                break;
        }
    }

}
