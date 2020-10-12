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
    private Timer timer;
    private int counter;
    public Tetris() {

        blocks = new Block[SETS_GAME.COLS][SETS_GAME.ROWS];

        tetrimino = nextTetrimino();

        addKeyListeners();
        counter = 0;
        timer = new Timer(SETS_GAME.DELAY, e -> {

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
            }
            check_lines();
           // tetrimino = new Ttetrimino();
            if(blocks[5][1]!=null || blocks[6][1]!=null) {
                System.out.println("Koniec gry");
                timer.stop();
            }

            tetrimino = nextTetrimino();


        }else{

            if(counter > SETS_GAME.FALL){
                tetrimino.gravit();
                counter = 0;
            }
        }
        counter ++;




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
        getInputMap(IFW).put(KeyStroke.getKeyStroke("SPACE"), KEY.SPACE);

        getActionMap().put(KEY.UP, pressed(KEY.UP));
        getActionMap().put(KEY.LEFT, pressed(KEY.LEFT));
        getActionMap().put(KEY.DOWN, pressed(KEY.DOWN));
        getActionMap().put(KEY.RIGHT, pressed(KEY.RIGHT));
        getActionMap().put(KEY.SPACE, pressed(KEY.SPACE));

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
                if(button==KEY.DOWN){
                    counter = counter + 50;
                }

                if(button==KEY.SPACE){
                    System.out.println("fd");
                    while (!tetrimino.isFelt(blocks)){
                        tetrimino.gravit();
                    }
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


                for(int l = j;l>0;l--) { //grawitacja
                    for (int m = 0; m < SETS_GAME.COLS; m++) {
                        blocks[m][l] = blocks[m][l-1];
                        if(blocks[m][l] != null)
                            blocks[m][l].setY(blocks[m][l].getY()+SETS_GAME.SIZE);
                      //  if(blocks[m][l] != null){
                        //    blocks[m][l].setY(blocks[m][l].getY()+SETS_GAME.SIZE);
                        //    blocks[m][l] = blocks[m][l-1];
                           // blocks[m][l] = null;
                      //  }


                    }
                }
                check_lines();
            }

        }

    }

    private Tetrimino nextTetrimino(){
        Random r = new Random();
        switch (r.nextInt(7)){
            case 0:
                return new Itetrimino();
            case 1:
                return new Jtetrimino();
            case 2:
                return new Ltetrimino();
            case 3:
                return new Stetrimino();
            case 4:
                return new Ttetrimino();
            case 5:
                return new Ztetrimino();
            case 6:
                return new Otetrimino();
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
