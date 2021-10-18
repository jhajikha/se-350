package model.interfaces;

import java.awt.Graphics2D;

/**
 * Represents the collection of all the items the user has
 * drawn.
 */
public interface Picture {
  void add(Shape shape);
  void remove(Shape shape);
  void draw(Graphics2D g);

}
