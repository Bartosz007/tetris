package Game;

import Settings.KEY;
import Settings.SETS_GAME;
import Tetriminos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.Timer;

public class Tetris extends JPanel {



    private final Block[][] blocks;
    private Tetrimino tetrimino;

    public Tetris() {
        final Timer timer;
        final int delay = 400;

        blocks = new Block[SETS_GAME.COLS][SETS_GAME.ROWS];

        tetrimino = nextTetrimino();


        addKeyListeners();

        timer = new Timer(delay, e -> {

            calculate();
            repaint();

        });
        timer.start();
    }


    private void calculate(){
        if(tetrimino.isFelt(blocks)){
            for (Block block:tetrimino.getBlocks()) {
               // blocks.add(block);

                blocks[block.getX()/SETS_GAME.SIZE][block.getY()/SETS_GAME.SIZE] = block;
                check_lines();
            }

            tetrimino = nextTetrimino();
        }

        tetrimino.gravit();

      /*  for (Block block:blocks) {
            block.setY(block.getY()+SETS_GAME.SIZE);
        }

       */

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g.create();

        paint_background(g2d);

        paint_blocks(g2d);

        paint_tetrimino(g2d);


        g2d.dispose();
    }

    private void paint_rect(Graphics2D g2d, int x, int y, Color color){

        g2d.setColor(SETS_GAME.BG);
        g2d.setStroke(new BasicStroke(SETS_GAME.BORDER));
        g2d.drawRect(x,y,SETS_GAME.SIZE,SETS_GAME.SIZE);

        g2d.setColor(color);
        g2d.fillRect(x+(SETS_GAME.BORDER/2),y+(SETS_GAME.BORDER/2),
                SETS_GAME.SIZE-SETS_GAME.BORDER,SETS_GAME.SIZE-SETS_GAME.BORDER);
    }

    private void paint_background(Graphics2D g2d){
        for(int i =0;i<SETS_GAME.COLS;i++){
            for(int j =0;j<SETS_GAME.ROWS;j++){
                paint_rect(g2d, i*SETS_GAME.SIZE,j*SETS_GAME.SIZE, SETS_GAME.FG);
            }
        }
    }

    private void paint_tetrimino(Graphics2D g2d){
        for (Block block:tetrimino.getBlocks()) {
            paint_rect(g2d, block.getX(),block.getY(),block.getColor());
        }

    }

    private void paint_blocks(Graphics2D g2d){
        for (Block[] b: blocks) {
            for(Block block:b){
               // System.out.println(block);
                if(block != null)
                    paint_rect(g2d,block.getX(),block.getY(),block.getColor());
            }
        }

      /*  for (Block block:blocks) {
            paint_rect(g2d,block.getX(),block.getY(),block.getColor());
        }*/
    }

    void addKeyListeners(){
        int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;

        getInputMap(IFW).put(KeyStroke.getKeyStroke("UP"), KEY.UP);
        getInputMap(IFW).put(KeyStroke.getKeyStroke("LEFT"), KEY.LEFT);
        getInputMap(IFW).put(KeyStroke.getKeyStroke("DOWN"), KEY.DOWN);
        getInputMap(IFW).put(KeyStroke.getKeyStroke("RIGHT"), KEY.RIGHT);

        getInputMap(IFW).put(KeyStroke.getKeyStroke("released UP"),KEY.RUP);
        getInputMap(IFW).put(KeyStroke.getKeyStroke("released LEFT"),KEY.RLEFT);
        getInputMap(IFW).put(KeyStroke.getKeyStroke("released DOWN"),KEY.RDOWN);
        getInputMap(IFW).put(KeyStroke.getKeyStroke("released RIGHT"),KEY.RRIGHT);

        getActionMap().put(KEY.UP, pressed(KEY.UP));
        getActionMap().put(KEY.LEFT, pressed(KEY.LEFT));
        getActionMap().put(KEY.DOWN, pressed(KEY.DOWN));
        getActionMap().put(KEY.RIGHT, pressed(KEY.RIGHT));
/*
        getActionMap().put(KEY.RUP, released(KEY.UP));
        getActionMap().put(KEY.RLEFT, released(KEY.LEFT));
        getActionMap().put(KEY.RDOWN, released(KEY.DOWN));
        getActionMap().put(KEY.RRIGHT, released(KEY.RIGHT));

 */

    }

    private Action pressed(int button) {
        return new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(button==KEY.LEFT){
                    tetrimino.goleft(blocks);
                }
                if(button==KEY.RIGHT){
                    tetrimino.goright(blocks);
                }
                if(button==KEY.UP){
                    tetrimino.rotate();
                }
                 /*
                if(button==KEY.LEFT){
                    active_block.setX(active_block.getX()-SETS_GAME.SIZE);
                    if(active_block.getX()<SETS_GAME.MIN_X)
                        active_block.setX(0);
                }
                if(button==KEY.RIGHT){
                    active_block.setX(active_block.getX()+SETS_GAME.SIZE);
                    if(active_block.getX()>SETS_GAME.MAX_X)
                        active_block.setX(SETS_GAME.MAX_X);
                }

                  if(button==KEY.UP){
                    System.out.println("rotacja");
                }
                if(button==KEY.DOWN){
                    System.out.println("szybszy spadek");
                }


                 */

            }
        };
    }

    private void check_lines() {
        int counter;
        for(int j =0;j<SETS_GAME.ROWS;j++){

            counter = 0;
            for(int i = 0;i<SETS_GAME.COLS;i++) // sprawdzanie zapełnienia linii
                if(blocks[i][j]!=null)
                    counter ++;



            if(counter == SETS_GAME.COLS){
                System.out.println("pelna linia: "+ j);//czyszczenie linii
                for(int k = 0;k<SETS_GAME.COLS;k++)
                    blocks[k][j]=null;


                for(int l =0;l<j;l++) { //grawitacja
                    for (int m = 0; m < SETS_GAME.COLS; m++) {
                        if(blocks[m][l]!=null)
                            blocks[m][l].setY(blocks[m][l].getY()+SETS_GAME.SIZE);

                    }
                }
                check_lines();
            }

        }

    }

    private Tetrimino nextTetrimino(){
        Random r = new Random();
        switch (r.nextInt(3)){
            case 0:
                return new Itetrimino();
            case 1:
                return new Otetrimino();
            case 2:
                return new Jtetrimino();
        }
        return new Otetrimino();
    }

/*
    private Action pressed(int button) {

        return new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(is_player_two_here){
                    if(button==KEY.UP){
                        player_two_moves[0] = true;
                    }
                    if(button==KEY.LEFT){
                        player_two_moves[1] = true;
                    }
                    if(button==KEY.DOWN){
                        player_two_moves[2] = true;
                    }
                    if(button==KEY.RIGHT){
                        player_two_moves[3] = true;
                    }
                    if(button==KEY.ENTER){
                        for(Bomb b: bombList){
                            if(player_two.getBlock_position().equals(b.getBlock_position())) { //jeśli w tym bloku jest już bomba to nie można postawić kolejnej
                                if(player_two.isMove_bomb() && !player_two.isBomb_in_hand()){
                                    player_two.setPicked_bomb(b);
                                    player_two.setBomb_in_hand(true);
                                }
                                return;
                            }
                        }
                        if( player_two.getBombs() > 0) {
                            player_two.setBombs(player_two.getBombs() - 1);
                            System.out.println(player_two.getBombs());
                            Bomb bomb = new Bomb(player_two.getBlock_position(), player_two.getBomb_power(), "red", "/red/dynamit.png", player_two);

                            bombList.add(bomb);
                        }
                    }
                }
            }
        };

    }
*/

}
