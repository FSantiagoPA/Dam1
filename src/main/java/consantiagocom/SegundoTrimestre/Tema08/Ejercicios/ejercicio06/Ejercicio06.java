package consantiagocom.SegundoTrimestre.Tema08.Ejercicios.ejercicio06;

import consantiagocom.SegundoTrimestre.Tema08.Ejercicios.libs.LibUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio06 {
    private final JTextField tfHeight;
    private final JTextField tfWeight;

    public Ejercicio06() {
        final int WINDOW_WIDTH = 1024;
        final int WINDOW_HEIGHT = 768;
        final int BORDER_SIZE = 20;

        JFrame frame = new JFrame("Calculadora de IMC");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int x = (int)(dimension.getWidth() / 2f) - Math.round(WINDOW_WIDTH / 2f);
        int y = (int)(dimension.getHeight() / 2f) - Math.round(WINDOW_HEIGHT / 2f);

        frame.setBounds(x, y, WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.setContentPane(panel);

        JLabel lbHeight = new JLabel("Indica tu estatura en cm");
        lbHeight.setForeground(Color.BLACK);
        // lbTitle.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(lbHeight);

        tfHeight = new JTextField(7);
        tfHeight.setMaximumSize(tfHeight.getPreferredSize());
        panel.add(tfHeight);

        JLabel lbWeight = new JLabel("Indica tu peso en kg");
        lbWeight.setForeground(Color.BLACK);
        // lbTitle.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(lbWeight);

        tfWeight = new JTextField(7);
        tfWeight.setMaximumSize(tfWeight.getPreferredSize());
        panel.add(tfWeight);


        JButton button = new JButton("Calcular IMC");
        ActionListener actionListenerButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfHeight.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Debes indicar tu altura");
                    return;
                }
                if (tfWeight.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Debes indicar tu peso");
                    return;
                }
                calculateBMI(panel);
            }
        };
        ActionListener actionListenerTextField = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfHeight.getText().isEmpty()) {
                    tfHeight.requestFocus();
                    return;
                }
                if (tfWeight.getText().isEmpty()) {
                    tfWeight.requestFocus();
                    return;
                }
                calculateBMI(panel);
            }
        };
        button.addActionListener(actionListenerButton);
        tfHeight.addActionListener(actionListenerTextField);
        tfWeight.addActionListener(actionListenerTextField);

        panel.add(button);
        // frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.pack();
        LibUI.setMonitor(frame, 1);
        frame.setVisible(true);
        updateUI();
    }

    private void calculateBMI(JPanel panel) {
        String text = BMICalculator.getBMIString(Integer.parseInt(tfHeight.getText()), Integer.parseInt(tfWeight.getText()));
        JOptionPane.showMessageDialog(panel, text);
        updateUI();
    }

    private void updateUI() {
        tfHeight.setText("");
        tfWeight.setText("");
        tfHeight.requestFocus();
    }
}
