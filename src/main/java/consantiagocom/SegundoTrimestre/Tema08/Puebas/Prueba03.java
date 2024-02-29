package consantiagocom.SegundoTrimestre.Tema08.Puebas;

import javax.swing.*;
import java.awt.*;

public class Prueba03 {
    public static void main(String[] args) {
        JFrame window = new JFrame("Hola mundo");
        Toolkit herramienta = Toolkit.getDefaultToolkit();
        Dimension dimension =Toolkit.getDefaultToolkit().getScreenSize();
        int width = 400;
        int height = 400;
        int x,y;
        x = (int)(dimension.width/2f) - Math.round(width/2f);
        y = (int)(dimension.height/2f) - Math.round(height/2f);

        JLabel label = new JLabel("Hola gui");
        label.setBounds(20,20,100,50);
        JPanel panel = new JPanel();
        panel.add(label);
        panel.setLayout(null);
        window.setContentPane(panel);

       window.setBounds(x,y,width,height);
       window.setVisible(true);
    }
}
