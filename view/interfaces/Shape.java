/*
 * Assignment: 1
 * Topic: JPaint
 * Author: Dan Walker
 */
package view.interfaces;

import java.awt.Color;
import java.awt.Graphics2D;
import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.Region;

/**
 * Represents an individual shape drawn by the user.
 */
public interface Shape {
  void draw(Graphics2D graphics);
  void drawSelected(Graphics2D graphics);
  Color getPrimaryColor();
  Color getSecondaryColor();
  ShapeShadingType getShadingType();
  Region region();
  void move(int deltaX, int deltaY);
  Shape copy();
}
