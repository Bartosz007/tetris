package game;


import helper.PaintMethods;
import setting.GAME;
import setting.KEY;
import tetrimino.*;
import view.EndGameView;
import view.GameView;
import view.MenuView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;


public class Tetris extends JPanel {

    private final Block[][] blocks;
    private Tetrimino tetrimino;
   // private NextTetrimino next_tetrimino;
    private Timer timer;
    private int counter;
    private Score score;
    private JPanel next_jpanel;
    private int speed;
    private int points;
    private PaintMethods paintMethods;
    private NextTetrimino nextTetrimino;
    private GameView gameView;
    private JFrame window;
    public Tetris(JFrame window, GameView gameView, Score score, JPanel next_jpanel) {
        this.score = score;
        this.next_jpanel = next_jpanel;
        this.gameView = gameView;
        this.window = window;

        this.paintMethods = new PaintMethods();
        this.speed = score.getSpeed().getValue();
        this.points = score.getScore().getValue();

        blocks = new Block[GAME.COLS][GAME.ROWS];

        tetrimino = newTetrimino();
        nextTetrimino = new NextTetrimino(newTetrimino());

        next_jpanel.add(nextTetrimino);
        System.out.println("wydrukowano2");
       // next_tetrimino = new NextTetrimino(nextTetrimino());

        addKeyListeners();

        counter = GAME.DELAY;

        timer = new Timer(GAME.DELAY, e -> {

            calculate();
            repaint();

        });
        timer.start();
    }

    //TODO: poprawić pierwszy skok
    private void calculate(){

        if(counter < 0){
            if(tetrimino.isFelt(blocks)){

                for (Block block:tetrimino.getBlocks()) {

                    blocks[block.getX()/GAME.SIZE][block.getY()/GAME.SIZE] = block;
                }

                check_lines();

                //TODO: poprawić to, te nule i koniec gry
                if(blocks[5][1]!=null || blocks[6][1]!=null) { // sprawdzenie czy te bloki nie są zajęte

                    timer.stop();
                    //tu ustawić chwilę opóźnienia

                    gameView.setVisible(false);
                    window.add(new EndGameView(window,null, score.getScore().getValue()));

                }

                tetrimino = nextTetrimino.getTetrimino();
                nextTetrimino.setTetrimino(newTetrimino());

            }else{

                tetrimino.gravit();
                counter = GAME.DELAY - 2*this.speed + 2;
            }

        }

        counter --;



    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g.create();

        //rysowanie tła
        paintMethods.paint_background(g2d);

        //rysowanie bloków
        paintMethods.paint_blocks(g2d,blocks);

        //rysowanie tetrimino
        paintMethods.paint_tetrimino(g2d,tetrimino);

        //odświeżenie grafiki
        g2d.dispose();
    }

    private void check_lines() {
        int counter;
        for(int j =0;j<GAME.ROWS;j++){

            counter = 0;
            for(int i = 0;i<GAME.COLS;i++)
                if(blocks[i][j]!=null)
                    counter ++;



            if(counter == GAME.COLS){
                for(int k = 0;k<GAME.COLS;k++)
                    blocks[k][j]=null;

                score.getScore().addValue(Score.LINE*this.speed);
                score.getLines().addValue(1);
                //TODO: poprawić kolizje podczas obrotów
                if(this.speed != score.calculateSpeed()){ //TODO: przerobić opad na czas rzeczywisty
                    score.getSpeed().addValue(1);
                    this.speed++;
                }


                for(int l = j;l>0;l--) { //grawitacja
                    for (int m = 0; m < GAME.COLS; m++) {
                        blocks[m][l] = blocks[m][l-1];
                        if(blocks[m][l] != null)
                            blocks[m][l].setY(blocks[m][l].getY()+GAME.SIZE);

                    }
                }
                check_lines();

            }
        }
    }

    private Tetrimino newTetrimino(){
        int rand = new Random().nextInt(7);

        switch (rand){
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
            default:
                return new Otetrimino();
        }
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
                    //TODO: poprawić to ->
                    counter = counter - 20;
                    score.getScore().addValue(Score.DOWN_BUTTON*speed);
                    //   score.setScore_value(score.getScore_value()+SETS_GAME.SCORE_DOWN_BUTTON*score.getLevel_value());
                    //   score.setScore(score.getScore_value());
                }

                if(button==KEY.SPACE){
                    int count = 0;
                    while (!tetrimino.isFelt(blocks)){
                        tetrimino.gravit();
                        count++;
                    }
                    score.getScore().addValue(Score.SPACE*count*speed);

                    //   score.setScore_value(score.getScore_value()+SETS_GAME.SCORE_SPACE*score.getLevel_value());
                    //  score.setScore(score.getScore_value());
                }

            }
        };
    }


}
