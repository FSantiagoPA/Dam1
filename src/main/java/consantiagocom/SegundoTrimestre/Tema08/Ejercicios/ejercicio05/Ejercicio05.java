package consantiagocom.SegundoTrimestre.Tema08.Ejercicios.ejercicio05;

import consantiagocom.SegundoTrimestre.Tema08.Ejercicios.libs.LibUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ejercicio05 {
    private final JLabel lbAttempts;
    private final JTextField tfNumber;
    private final GuessTheNumber game;
    public Ejercicio05() {
        final int MAX_ATTEMPTS = 5;
        final int MIN_NUMBER = 0;
        final int MAX_NUMBER = 100;
        final int WINDOW_WIDTH = 1024;
        final int WINDOW_HEIGHT = 768;
        final int BORDER_SIZE = 20;
        game = new GuessTheNumber(MIN_NUMBER, MAX_NUMBER, MAX_ATTEMPTS);

        JFrame frame = new JFrame("Adivina el número");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int x = (int)(dimension.getWidth() / 2f) - Math.round(WINDOW_WIDTH / 2f);
        int y = (int)(dimension.getHeight() / 2f) - Math.round(WINDOW_HEIGHT / 2f);

        frame.setBounds(x, y, WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        // panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        // panel.setLayout(new FlowLayout());
        frame.setContentPane(panel);
        lbAttempts = new JLabel();
        panel.add(lbAttempts);
        JLabel lbTitle = new JLabel("Adivina el número");
        lbTitle.setForeground(Color.BLACK);
        // lbTitle.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(lbTitle);

        tfNumber = new JTextField(7);
        tfNumber.setMaximumSize(tfNumber.getPreferredSize());
        panel.add(tfNumber);
        JButton button = new JButton("Adivina");
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfNumber.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Debe indicar un número");
                    return;
                }
                if (game.getCurrentAttempts() > 0) {
                    int number = Integer.parseInt(tfNumber.getText());
                    int option;
                    switch (game.attempt(number)) {
                        case LOWER:
                            JOptionPane.showMessageDialog(panel, "El número es más pequeño");
                            break;
                        case GREATER:
                            JOptionPane.showMessageDialog(panel, "El número es más grande");
                            break;
                        case YOU_WIN:
                            option = JOptionPane.showConfirmDialog(panel, "Has ganado!! ¿Quieres jugar otra partida");
                            if (option == 0) {
                                game.init();
                            }
                            break;
                        case YOU_LOSE:
                            option = JOptionPane.showConfirmDialog(panel, "Has perdido. El número era " + game.getCurrentNumber() + "\n¿Quieres jugar otra partida?");
                            if (option == 0) {
                                game.init();
                            }
                            break;
                    }
                } else {
                    int option = JOptionPane.showConfirmDialog(panel, "¿Quieres jugar otra partida?");
                    if (option == 0) {
                        game.init();
                    }
                }
                updateUI();
            }
        };
        button.addActionListener(actionListener);
        tfNumber.addActionListener(actionListener);

        panel.add(button);
        // frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.pack();
        LibUI.setMonitor(frame, 1);
        frame.setVisible(true);
        updateUI();
    }

    private void updateUI() {
        lbAttempts.setText("Intentos restantes: " + game.getCurrentAttempts());
        tfNumber.setText("");
        tfNumber.requestFocus();
    }

}
