package consantiagocom.SegundoTrimestre.Tema08.Ejercicios.ejercicio02;

import javax.swing.*;
import java.awt.*;

public class Ejercicio02 {
    public Ejercicio02() {
        JFrame frame = new JFrame("Hola Swing");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jLabel = new JLabel("Bienvenido al mundo de las interfaces gráficas");
        Container container = frame.getContentPane();
        container.add(jLabel);
        frame.setVisible(true);
        frame.pack();
    }
}
