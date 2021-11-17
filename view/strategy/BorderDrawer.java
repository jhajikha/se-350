package view.strategy;

import java.awt.Graphics2D;
import view.interfaces.DrawStrategy;
import view.interfaces.Shape;

/**
 * A decorator that implements the DrawStrategy by drawing
 * a border.
 */
public class BorderDrawer implements DrawStrategy {
  private final DrawStrategy mainDrawer;

  public BorderDrawer(DrawStrategy mainDrawer) {
    this.mainDrawer = mainDrawer;
  }

  @Override
  public void draw(Graphics2D graphics, Shape shape) {
    mainDrawer.draw(graphics, shape);
    mainDrawer.drawBorder(graphics, shape);
  }

  @Override
  public void drawBorder(Graphics2D graphics, Shape shape) {
    mainDrawer.drawBorder(graphics, shape);
  }

  @Override
  public void drawSelected(Graphics2D graphics, Shape shape) {
    mainDrawer.drawSelected(graphics, shape);
  }
}
