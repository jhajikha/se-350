/*
 * Assignment: 1
 * Topic: JPaint
 * Author: Dan Walker
 */
package view.interfaces;

import java.awt.Graphics2D;
import java.util.List;
import model.interfaces.Region;

/**
 * Represents the collection of all the items the user has
 * drawn.
 */
public interface Picture {
  void add(Shape shape);
  void add(List<Shape> shapes);
  void remove(Shape shape);
  void draw(Graphics2D g);
  void select(Region region);
  List<Shape> getSelected();

}
