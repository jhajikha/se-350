/*
 * Assignment: 2
 * Topic: JPaint
 * Author: Dan Walker
 */
package view.interfaces;

import java.awt.Graphics2D;

public interface DrawStrategy {
  void draw(Graphics2D graphics, Shape shape);
  void drawBorder(Graphics2D graphics, Shape shape);
  void drawSelected(Graphics2D graphics, Shape shape);
}
