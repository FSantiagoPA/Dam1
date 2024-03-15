package consantiagocom.SegundoTrimestre.Tema08.Ejercicios.Ejercicio05;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    private JFrame frame;
    private JLabel attemptsLabel;
    private JTextField guessField;
    private JButton guessButton;
    private AdivinarNumero juego;

    public UI() {
        juego = new AdivinarNumero();
        setupUI();
    }

    private void setupUI() {
        frame = new JFrame("Adivina el numero!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 768);
        frame.setLayout(null);

        attemptsLabel = new JLabel("Attempts remaining: " + juego.numIntentos);
        attemptsLabel.setBounds(10, 10, 250, 25);
        frame.add(attemptsLabel);

        guessField = new JTextField();
        guessField.setBounds(10, 40, 250, 25);
        frame.add(guessField);

        guessButton = new JButton("Make a guess!");
        guessButton.setBounds(10, 70, 250, 25);
        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int guess = Integer.parseInt(guessField.getText().trim());
                int result = juego.intentoAdivinar(guess);
                switch (result) {
                    case -1:
                        showMessage("Sorry, you lose. The number was: " + juego.numAdivinar);
                        if (promptNewGame()) {
                            juego.reinicar();
                            updateAttempts();
                        } else {
                            System.exit(0);
                        }
                        break;
                    case 1:
                        updateAttempts();
                        break;
                    case 0:
                        showMessage("Congratulations, you win!");
                        if (promptNewGame()) {
                            juego.reinicar();
                            updateAttempts();
                        } else {
                            System.exit(0);
                        }
                }
            }
        });
        frame.add(guessButton);

        frame.setVisible(true);
    }

    private void updateAttempts() {
        attemptsLabel.setText("Intentos restantes: " + juego.numIntentos);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    private boolean promptNewGame() {
        int response = JOptionPane.showConfirmDialog(frame, "¿Te gustaría volver a jugar?", "Nuevo juego",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return response == JOptionPane.YES_OPTION;
    }
}
