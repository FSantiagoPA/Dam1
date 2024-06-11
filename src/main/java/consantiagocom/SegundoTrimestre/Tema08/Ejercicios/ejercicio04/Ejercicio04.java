package consantiagocom.SegundoTrimestre.Tema08.Ejercicios.ejercicio04;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Ejercicio04 {
    public Ejercicio04() {
        final int MIN_FONT_SIZE = 15;
        final int MAX_FONT_SIZE = 30;
        final String[] aficiones = new String[]{"Programación", "Robótica", "Astronomía", "Ciencia", "Guitarra clásica"};
        final String[] fuentes = new String[]{"Arial", "Courier", "Georgia", "Comic Sans"};
        final JLabel[] lbAficiones = new JLabel[aficiones.length];
        JFrame frame = new JFrame("Mis aficiones");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int width = 1024;
        int height = 768;
        int x = (int)(dimension.getWidth() / 2f) - Math.round(width / 2f);
        int y = (int)(dimension.getHeight() / 2f) - Math.round(height / 2f);

        frame.setBounds(x, y, width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.setContentPane(panel);
        JLabel titulo = new JLabel("Mis " + aficiones.length + " aficiones favoritas son: ");
        titulo.setForeground(Color.BLACK);
        titulo.setFont(new Font("Arial", Font.BOLD, MAX_FONT_SIZE));
        panel.add(titulo);
        Random random = new Random();
        for (int i = 0; i < aficiones.length; i++) {
            String fuente = fuentes[random.nextInt(fuentes.length)];
            Font font = new Font(fuente, Font.BOLD, random.nextInt(MAX_FONT_SIZE - MIN_FONT_SIZE + 1) + MIN_FONT_SIZE);
            lbAficiones[i] = new JLabel(aficiones[i]);
            lbAficiones[i].setFont(font);
            lbAficiones[i].setForeground(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            panel.add(lbAficiones[i]);
        }

        JButton button = new JButton("Cambiar colores");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // JOptionPane.showMessageDialog(panel, "Hola");
                for (int i = 0; i < lbAficiones.length; i++) {
                    lbAficiones[i].setForeground(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
                }
            }
        });
        panel.add(button);
        // frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}
