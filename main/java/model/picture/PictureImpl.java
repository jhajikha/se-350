/*
 * Assignment: 1
 * Topic: JPaint
 * Author: Dan Walker
 */
package model.picture;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import model.ShapeType;
import model.interfaces.Picture;
import model.interfaces.Shape;

/**
 * @see model.interfaces.Picture
 */
public class PictureImpl implements Picture {

  private final List<Shape> elements = new ArrayList<>();

  @Override
  public void add(Shape shape) {
    elements.add(shape);
  }

  @Override
  public void remove(Shape shape) {
    elements.remove(shape);
  }

  @Override
  public void draw(Graphics2D graphic) {
    for (Shape shape : elements) {
     if (shape.getShapeType() == ShapeType.RECTANGLE) shape.drawRect(graphic);
     if (shape.getShapeType() == ShapeType.ELLIPSE) shape.drawElli(graphic);
     if (shape.getShapeType() == ShapeType.TRIANGLE) shape.drawTri(graphic);
    }
  }

  public int size() {
    return elements.size();
  }
}
