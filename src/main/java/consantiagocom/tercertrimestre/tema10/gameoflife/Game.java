package consantiagocom.tercertrimestre.tema10.gameoflife;

import javax.swing.*;

import java.awt.*;

import static javax.swing.text.StyleConstants.setBackground;

public class Game extends JPanel implements Runnable {
    private static final long NANOS_IN_SECOND = 1_000_000_000;
    private int width;
    private int height;
    private Thread gameThread;
    private double targetFps;
    private int cellWidth;
    private int cellHeight;
    private int numCols;
    private int numRows;

    public Game(int width, int height,int nunCols,int numRows, double targetFps) {
        this.width = width;
        this.height = height;
        this.targetFps = targetFps;
        this.cellWidth = width/nunCols;
        this.cellHeight = height/numRows;
        this.numRows = numRows;
        this.numCols = nunCols;
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        setFocusable(true);
    }

    public void startThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        final double NANOS_BETWEEN_UPDATES = NANOS_IN_SECOND / targetFps;
        long currentFrame, lastFrame;
        boolean exit = false;
        double deltaTime;
        lastFrame = System.nanoTime();

        while (!exit) {
            currentFrame = System.nanoTime();
            while (currentFrame - lastFrame > NANOS_BETWEEN_UPDATES) {
                deltaTime = (double)(currentFrame - lastFrame) / NANOS_IN_SECOND;
                //processInput();
                repaint();
                update(deltaTime);
                lastFrame = currentFrame;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        drawGrid(g2);

    }

    public void update(double deltaTime) {
    }

    private void drawGrid(Graphics2D g){
        g.setColor(Color.BLACK);
        for(int x = 0; x < numCols; x++){
            g.drawLine(x*cellWidth, 0,x * cellWidth,height);
        }
        for ( int y = 0; y < numRows;y++){
            g.drawLine(0,y * cellHeight, width,y * cellHeight);
        }
    }


}
