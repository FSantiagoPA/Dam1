package consantiagocom.SegundoTrimestre.Tema08.Puebas;

import javax.swing.*;
import java.awt.*;

public class Prueba05 {
    public static void main(String[] args) {
        JFrame window = new JFrame("Hola mundo");
        Toolkit herramienta = Toolkit.getDefaultToolkit();
        Dimension dimension =Toolkit.getDefaultToolkit().getScreenSize();
        int width = 400;
        int height = 400;
        int x,y;
        x = (int)(dimension.width/2f) - Math.round(width/2f);
        y = (int)(dimension.height/2f) - Math.round(height/2f);

        JLabel label = new JLabel("Hola gui Hola gui Hola gui ");
        JLabel label2 = new JLabel("Hola gui Hola gui Hola gui ");
        JPanel panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel,BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);
        panel.add(label);
        panel.add(label2);
        window.setContentPane(panel);

       window.setBounds(x,y,width,height);
       window.setVisible(true);
    }
}
