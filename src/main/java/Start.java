import Layout.Game;
import Settings.SETS;

import javax.swing.*;

public class Start extends JFrame {
    public Start() {
        super("Hello world");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
       // setExtendedState(JFrame.MAXIMIZED_BOTH); //maksymalizacja okna, zmienić rozmiar
        setSize(SETS.WINDOW_SIZE,SETS.WINDOW_SIZE);
        setTitle("Tetris");

        //add(new Menu(this,null));
        add(new Game(this,null));
    }
}
