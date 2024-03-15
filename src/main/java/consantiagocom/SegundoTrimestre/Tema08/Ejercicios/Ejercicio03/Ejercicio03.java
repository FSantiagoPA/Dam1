package consantiagocom.SegundoTrimestre.Tema08.Ejercicios.Ejercicio03;

import javax.swing.*;
import java.awt.*;

public class Ejercicio03 {
    public static void main(String[] args) {
        int width = 800;
        int height = 600;
        JFrame frame = new JFrame("Hola Swing");
        Container container = frame.getContentPane();
        container.setLayout(null);
        JLabel label = new JLabel("Bienvenido al mundo de las interfaces gráficas");
        container.add(label);
        label.setBounds(20,20,width,20);
        frame.setSize(width,height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
