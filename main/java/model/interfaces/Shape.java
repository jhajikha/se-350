package model.interfaces;

import java.awt.Graphics2D;
import model.ShapeType;

/**
 * Represents an individual shape drawn by the user.
 */
public interface Shape {
  void drawRect(Graphics2D graphics);
  void drawElli(Graphics2D graphics);
  void drawTri(Graphics2D  graphics);
  ShapeType getShapeType();
}
