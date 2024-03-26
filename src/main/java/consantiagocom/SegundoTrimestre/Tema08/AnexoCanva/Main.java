package consantiagocom.SegundoTrimestre.Tema08.AnexoCanva;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Game Of Life");

        Game game = new Game(1280,960,60);
        frame.add(game);
        frame.pack();
        frame.setVisible(true);
        game.start();
    }
}
