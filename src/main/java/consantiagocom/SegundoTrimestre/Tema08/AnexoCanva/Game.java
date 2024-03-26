package consantiagocom.SegundoTrimestre.Tema08.AnexoCanva;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;

public class Game extends JPanel implements Runnable{
    private final int width;
    private final int height;
    private  final float fpsLimit;
    private Thread thread;
    private boolean finished;
    public Game (int width, int height , float fpsLimit, boolean finished){
        this.width = width;
        this.height = height;
        this.fpsLimit = fpsLimit;
        this.finished = finished;
        setDoubleBuffered(true);
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
        setFocusable(true);


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

        System.out.println("Iniciando hilo");
        while (!finished){
            currentFrame = System.nanoTime();
            if (currentFrame - lastFrame > NANOS_BETWEEN_UPDATES) { //cual de estos elementos se deberia poner fuera y por que yaque es peligroso.
                processInput();
                update();
                draw();
                lastFrame = currentFrame;
            }
        }
    }

    private void draw() {
        //TODO: draw
    }

    private void update() {
        //TODO: update
        //personaje.x = personaje.x = velocidad;
    }

    private void processInput() {
        //TODO: proccesInput
    }
}
