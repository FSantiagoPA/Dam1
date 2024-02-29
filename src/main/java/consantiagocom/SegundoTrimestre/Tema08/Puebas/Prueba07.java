package consantiagocom.SegundoTrimestre.Tema08.Puebas;

import javax.swing.*;
import java.awt.*;

public class Prueba07 {
    public static void main(String[] args) {
        JFrame window = new JFrame("Hola mundo");
        Toolkit herramienta = Toolkit.getDefaultToolkit();
        Dimension dimension =Toolkit.getDefaultToolkit().getScreenSize();
        int width = 400;
        int height = 400;
        int x,y;
        x = (int)(dimension.width/2f) - Math.round(width/2f);
        y = (int)(dimension.height/2f) - Math.round(height/2f);


        JPanel panel = new JPanel();
        GridLayout gridLayout = new GridLayout(5,5);
        panel.setLayout(gridLayout);
        for (int i = 1; i <=5*5 ; i++) {
            JButton button = new JButton("boton"+i);
            panel.add(button);
        }

        int opcion = JOptionPane.showConfirmDialog(window, "¿Seguro que desea salir?");
        System.out.println(opcion);

    }
}
