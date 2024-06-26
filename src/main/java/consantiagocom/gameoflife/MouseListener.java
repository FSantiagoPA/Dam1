package consantiagocom.gameoflife;

import java.awt.event.MouseEvent;

public class MouseListener implements java.awt.event.MouseListener{

    // Declare the variables that will store the mouse position
    int x;
    int y;
    Mode mode;
    boolean paused = false;

    // Constructor sets the initial position of the mouse to -1 (outside the grid)
    public MouseListener() {
        x = -1;
        y = -1;
        mode = Mode.NONE;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    // When the mouse is pressed, the position is stored
    @Override
    public void mousePressed(MouseEvent e) {
        // If the left mouse button is pressed, the mode is set to INSERT
        if (e.getButton() == MouseEvent.BUTTON1) {
            this.mode = Mode.INSERT;

            // If the right mouse button is pressed, the mode is set to DELETE
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            this.mode = Mode.DELETE;

            // If the middle mouse button is pressed, the game is paused or unpaused
        } else if (e.getButton() == MouseEvent.BUTTON2){
            this.paused = !this.paused;
        }
        x = e.getX();
        y = e.getY();
    }

    // When the mouse is released, the position is set to -1 (outside the grid)
    @Override
    public void mouseReleased(MouseEvent e) {
        x = -1;
        y = -1;
        // If the left or right mouse button is released, the mode is set to NONE
        if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3){
            this.mode = Mode.NONE;
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}