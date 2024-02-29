package consantiagocom.SegundoTrimestre.Tema08.Ejercicios;

import javax.swing.*;
import java.awt.*;

public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");

        int width = 400;
        int height = 400;
        int x,y;

        Toolkit tool = Toolkit.getDefaultToolkit();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        x = (int)(dimension.getWidth()/2f) - Math.round(width/2f);
        y = (int)(dimension.getHeight()/2f) - Math.round(height/2f);

        String[] symbol = new String[]
                {"%" , "CE" , "C" , "x",
                "1/x" , "x^2" , "sdr" , "/",
                "7" , "8" , "9" , "*",
                "4" , "5" , "6" , "-",
                "1" , "2" , "3" , "+",
                "+/-" , "0" , "." , "="};

        JPanel panel = new JPanel();
        GridLayout gridLayout = new GridLayout(6,4);
        panel.setLayout(gridLayout);
        for (String symbols : symbol) {
            JButton button = new JButton(symbols);
            button.setBackground(Color.darkGray);
            button.setForeground(Color.white);
            panel.add(button);
        }
        frame.setContentPane(panel);
        frame.setBounds(x,y,width,height);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
