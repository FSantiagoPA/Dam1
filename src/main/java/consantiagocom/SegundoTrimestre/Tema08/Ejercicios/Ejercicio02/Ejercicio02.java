package consantiagocom.SegundoTrimestre.Tema08.Ejercicios.Ejercicio02;

import javax.swing.*;

public class Ejercicio02 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hola Swing");
        frame.setSize(800,600);
        JLabel label = new JLabel("Bienvenido al mundo de las interfaces gráficas");
        frame.getContentPane().add(label);
        frame.setVisible(true);
    }
}
