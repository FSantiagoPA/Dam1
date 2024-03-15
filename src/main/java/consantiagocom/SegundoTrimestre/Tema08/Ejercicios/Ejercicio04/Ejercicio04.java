package consantiagocom.SegundoTrimestre.Tema08.Ejercicios.Ejercicio04;

import javax.swing.*;
import java.awt.*;

public class Ejercicio04 {
    public static void main(String[] args) {
        int width = 1024;
        int height = 768;
        JFrame frame = new JFrame("Ejercicio04");
        Container container = frame.getContentPane();
        container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
        JLabel futbol = new JLabel("Entrenar futbol");
        JLabel leer = new JLabel("Leer");
        JLabel videojuegos = new JLabel("Jugar videoJuegos");
        JLabel verSeries= new JLabel("Ver series");
        JLabel cocinar= new JLabel("Cocinar");
        container.add(futbol);
        container.add(leer);
        container.add(videojuegos);
        container.add(verSeries);
        container.add(cocinar);
        frame.setSize(width,height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
