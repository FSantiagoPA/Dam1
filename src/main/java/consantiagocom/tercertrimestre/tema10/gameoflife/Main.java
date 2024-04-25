package consantiagocom.tercertrimestre.tema10.gameoflife;

import javax.swing.*;

public class Main {
    public static void main(String []args){
        System.setProperty("sun.java2d.opengl", "true");
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Game of life");

        Game game = new Game(800, 800,10,10, 60);
        window.add(game);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        game.startThread();
    }
}
