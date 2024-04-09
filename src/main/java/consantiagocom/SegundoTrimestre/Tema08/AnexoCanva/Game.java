package consantiagocom.SegundoTrimestre.Tema08.AnexoCanva;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;


public class Game extends JPanel implements Runnable{
    private final int width;
    private final int height;
    private  final float fpsLimit;
    private Thread thread;
    private boolean finished;
    private final Ball ball;
    public Game (int width, int height , float fpsLimit){
        this.width = width;
        this.height = height;
        this.fpsLimit = fpsLimit;
        this.finished = false;
        setDoubleBuffered(true);
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
        setFocusable(true);

        ball = new Ball(10,10,30,10,Color.white,width,height);

    }
    public void start() {
        thread = new  Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        final double NANOS_BETWEEN_UPDATES = 1_000_000_000 / fpsLimit;
        long currentFrame;
        long lastFrame =  currentFrame = System.nanoTime();

        System.out.println("Iniciando hilo ...");
        while (!finished){
            currentFrame = System.nanoTime();
            if (currentFrame - lastFrame > NANOS_BETWEEN_UPDATES) { //cual de estos elementos se deberia poner fuera y por que ya que es peligroso.
                processInput();
                update();
                draw();
                lastFrame = currentFrame;
            }
        }
    }

    private void draw() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        ball.draw(g2);
    }

    private void update() {
        ball.update();
    }

    private void processInput() {
        //TODO: proccesInput
    }
}
