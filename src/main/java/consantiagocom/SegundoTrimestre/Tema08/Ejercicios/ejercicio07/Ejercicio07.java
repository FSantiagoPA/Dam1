package consantiagocom.SegundoTrimestre.Tema08.Ejercicios.ejercicio07;

import consantiagocom.SegundoTrimestre.Tema08.Ejercicios.libs.LibUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio07 {
    private final RockPaperScissors game;
    private final JLabel lbPlayer;
    private final JLabel lbCPU;

    public Ejercicio07() {
        final int ROUNDS_TO_WIN = 5;
        final int WINDOW_WIDTH = 800;
        final int WINDOW_HEIGHT = 600;
        final int BORDER_SIZE = 20;

        game = new RockPaperScissors(ROUNDS_TO_WIN);

        JFrame frame = new JFrame("Piedra, Papel o Tijera");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int x = (int)(dimension.getWidth() / 2f) - Math.round(WINDOW_WIDTH / 2f);
        int y = (int)(dimension.getHeight() / 2f) - Math.round(WINDOW_HEIGHT / 2f);

        frame.setBounds(x, y, WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        // panel.setBorder(new EmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
        // panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setLayout(null);
        frame.setContentPane(panel);

        JLabel lbTitle = new JLabel("Piedra, Papel o Tijeras");
        lbTitle.setBounds(220, 20, WINDOW_WIDTH, 34);
        lbTitle.setForeground(Color.BLACK);
        lbTitle.setFont(new Font("Arial", Font.BOLD, 34));
        panel.add(lbTitle);

        JLabel lbPlayerTitle = new JLabel("PLAYER");
        lbPlayerTitle.setBounds(80, 150, WINDOW_WIDTH, 40);
        lbPlayerTitle.setForeground(Color.BLUE);
        lbPlayerTitle.setFont(new Font("Arial", Font.BOLD, 40));
        panel.add(lbPlayerTitle);

        lbPlayer = new JLabel("0");
        lbPlayer.setBounds(130, 220, WINDOW_WIDTH, 80);
        lbPlayer.setForeground(Color.BLUE);
        lbPlayer.setFont(new Font("Arial", Font.BOLD, 80));
        panel.add(lbPlayer);

        JLabel lbVersus = new JLabel("VS");
        lbVersus.setBounds(350, 180, WINDOW_WIDTH, 80);
        lbVersus.setForeground(Color.BLACK);
        lbVersus.setFont(new Font("Arial", Font.BOLD, 80));
        panel.add(lbVersus);

        JLabel lbCPUTitle = new JLabel("CPU");
        lbCPUTitle.setBounds(590, 150, WINDOW_WIDTH, 40);
        lbCPUTitle.setForeground(Color.RED);
        lbCPUTitle.setFont(new Font("Arial", Font.BOLD, 40));
        panel.add(lbCPUTitle);

        lbCPU = new JLabel("0");
        lbCPU.setBounds(610, 220, WINDOW_WIDTH, 80);
        lbCPU.setForeground(Color.RED);
        lbCPU.setFont(new Font("Arial", Font.BOLD, 80));
        panel.add(lbCPU);

        JButton buttonRock = new JButton("Piedra");
        buttonRock.setBounds(80, 400, 150, 60);
        buttonRock.setName(RockPaperScissors.GameValue.ROCK.toString());

        JButton buttonPaper = new JButton("Papel");
        buttonPaper.setBounds(320, 400, 150, 60);
        buttonPaper.setName(RockPaperScissors.GameValue.PAPER.toString());

        JButton buttonScissors = new JButton("Tijeras");
        buttonScissors.setBounds(550, 400, 150, 60);
        buttonScissors.setName(RockPaperScissors.GameValue.SCISSORS.toString());

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    JButton button = (JButton) e.getSource();
                    RockPaperScissors.GameValue gameValue = RockPaperScissors.GameValue.fromString(button.getName());
                    RockPaperScissors.GameResult result = game.attempt(gameValue);
                    RockPaperScissors.GameValue cpuValue = game.getValue();
                    updateUI();
                    switch (result) {
                        case NONE:
                            JOptionPane.showMessageDialog(panel, "Empate");
                            break;
                        case PLAYER_WINS:
                            JOptionPane.showMessageDialog(panel, "Has ganado!\n La CPU eligió " + cpuValue);
                            break;
                        case CPU_WINS:
                            JOptionPane.showMessageDialog(panel, "Has perdido!\n La CPU eligió " + cpuValue);
                            break;
                    }
                    if (game.isFinished()) {
                        String text;
                        if (game.getPlayerWins() > game.getCPUWins()) {
                            text = "*** HAS GANADO LA PARTIDA ***";
                        } else {
                            text = "*** LA CPU HA GANADO LA PARTIDA ***";
                        }
                        int option = JOptionPane.showConfirmDialog(panel, text + "\n¿Quieres jugar otra partida?");
                        if (option == 0) {
                            game.newGame();
                            updateUI();
                        }
                    } else {
                        game.nextRound();
                    }
                }
            }
        };
        buttonRock.addActionListener(actionListener);
        buttonPaper.addActionListener(actionListener);
        buttonScissors.addActionListener(actionListener);

        panel.add(buttonRock);
        panel.add(buttonPaper);
        panel.add(buttonScissors);

        // frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        // frame.pack();
        LibUI.setMonitor(frame, 1);
        frame.setVisible(true);
        updateUI();
    }

    private void updateUI() {
        lbPlayer.setText(String.valueOf(game.getPlayerWins()));
        lbCPU.setText(String.valueOf(game.getCPUWins()));
    }

}
