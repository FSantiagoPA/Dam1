package consantiagocom.SegundoTrimestre.Tema08.Ejercicios.ejercicio03;

import javax.swing.*;
import java.awt.*;

public class Ejercicio03 {
    public Ejercicio03() {
        JFrame frame = new JFrame("Hola Swing");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jLabel = new JLabel("Bienvenido al mundo de las interfaces gráficas");
        Container container = frame.getContentPane();
        container.setLayout(null);
        container.add(jLabel);
        jLabel.setBounds(20, 20, 500, 20);
        frame.setVisible(true);
        // frame.pack();
    }
}
