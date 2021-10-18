/*
 * Assignment: 1
 * Topic: JPaint
 * Author: Jeffrey Sharpe, Dan Walker
 */
package view.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import model.interfaces.Picture;

/**
 * PaintCanvas is responsible for responding to the graphics system when it
 * is time to update the display.  This is a boundary class so very little code
 * should be added here.
 */
public class PaintCanvas extends JComponent {

    private final Picture picture;

    public PaintCanvas(Picture picture) {
        this.picture = picture;
    }

    @Override
    /**
     * This is an event handler.  If this function gets called, its time to
     * draw the entire picture.
     * It you want to force a paint event, call aPaintCanvas.repaint()
     */
    public void paintComponent(Graphics g) {
        Graphics2D graphics2d = (Graphics2D) g;
        picture.draw(graphics2d);
    }
}
