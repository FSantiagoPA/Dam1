package consantiagocom.SegundoTrimestre.Tema08.Puebas;

import javax.swing.*;
import java.awt.*;

public class Prueba02 {
    public static void main(String[] args) {
        JFrame window = new JFrame("Hola mundo");
        Toolkit herramienta = Toolkit.getDefaultToolkit();
        Dimension dimension =Toolkit.getDefaultToolkit().getScreenSize();
        int width = 400;
        int height = 400;
        int x,y;
        x = (int)(dimension.width/2f) - Math.round(width/2f);
        y = (int)(dimension.height/2f) - Math.round(height/2f);
       window.setBounds(x,y,width,height);
       window.setVisible(true);
    }
}
