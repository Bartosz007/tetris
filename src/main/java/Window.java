import view.EndGameView;
import view.GameView;
import view.MenuView;

import javax.swing.*;

public class Window extends JFrame {
    public Window() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
      //  setPreferredSize(GLOBAL.WINDOW_SIZE);
        // setExtendedState(JFrame.MAXIMIZED_BOTH); //maksymalizacja okna, zmienić rozmiar
      //  setSize(SETS.WINDOW_SIZE,SETS.WINDOW_SIZE);
       // setSize(GLOBAL.WINDOW_SIZE);
        setTitle("TETRIS");
     // getContentPane().setPreferredSize(GLOBAL.WINDOW_SIZE);

        add(new MenuView(this));
      //  add(new GameView(this,null));
      //  add(new EndGameView(this,null,8888));
        pack();
        //TODO: usunąć białą ramkę

       // add(new Game(this,null));
    }
}
