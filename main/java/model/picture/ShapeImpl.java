/*
 * Assignment: 1
 * Topic: JPaint
 * Author: Dan Walker
 */
package model.picture;

import java.awt.Graphics2D;
import model.ShapeColor;
import model.ShapeType;
import model.interfaces.Shape;
import model.interfaces.UserChoices;
import java.awt.Polygon;

/**
 * @see model.interfaces.Shape
 */
public class ShapeImpl implements Shape {

  private Point start;
  private Point end;
  private ShapeColor color;
  private UserChoices userchoices;
  private ShapeType shapetype;

  public ShapeImpl(Point start, Point end, ShapeColor color, UserChoices userchoices, ShapeType shapetype) {
    normalizePoints(start, end);
    this.color = color;
    this.userchoices = userchoices;
    this.shapetype = shapetype;
  }

  public Point getStart() {
    return start;
  }

  public Point getEnd() {
    return end;
  }

  public ShapeType getShapeType() {
    return shapetype;
  }

//  @Override
//  public void draw(Graphics2D graphics) {
//    graphics.setColor(color.value);
//
//    if (userchoices.getActiveShapeType() == ShapeType.RECTANGLE) {
//      Graphics2D graphicz = graphics;
//      drawRect(graphicz);
//    }
//    if (userchoices.getActiveShapeType() == ShapeType.ELLIPSE) {
//      Graphics2D graphicz = graphics;
//     drawElli(graphicz);
//    }
//
//  }


  public void drawRect(Graphics2D graphics) {
    graphics.setColor(color.value);
    graphics.fillRect(start.getX(), start.getY(), getWidth(), getHeight());
  }

  public void drawElli(Graphics2D graphics) {
    graphics.setColor(color.value);
    graphics.fillOval(start.getX(), start.getY(), getWidth(), getHeight());
  }

  public void drawTri(Graphics2D graphics) {
    graphics.setColor(color.value);

    //int [] xArr = {end.getX(),start.getX(), start.getX()};
    //int [] yArr = {start.getY(), start.getY(),end.getY()};

    Polygon polygon = new Polygon();
    polygon.reset();

    polygon.addPoint((start.getX() + end.getX()) / 2, start.getY());
    polygon.addPoint(end.getX(), end.getY());
    polygon.addPoint(start.getX(), end.getY());

    graphics.fillPolygon(polygon);

  }

  private int getWidth() {
    return end.getX() - start.getX();
  }

  private int getHeight() {
    return end.getY() - start.getY();
  }

  /**
   * The beginning and ending points are not necessarily the points needed when drawing.
   * This function figures out the better drawing points.
   * @param firstPoint location of the mouse when first clicked
   * @param endPoint location of mouse when finally released
   */
  private void normalizePoints(Point firstPoint, Point endPoint) {
    int newStartX;
    int newStartY;
    int newEndX;
    int newEndY;

    // Calculated new X values
    if (firstPoint.getX() > endPoint.getX()) {
      newStartX = endPoint.getX();
      newEndX = firstPoint.getX();
    } else {
      newStartX = firstPoint.getX();
      newEndX = endPoint.getX();
    }

    // Calculate new Y values
    if (firstPoint.getY() > endPoint.getY()) {
      newStartY = endPoint.getY();
      newEndY = firstPoint.getY();
    } else {
      newStartY = firstPoint.getY();
      newEndY = endPoint.getY();
    }

    start = new Point(newStartX, newStartY);
    end = new Point(newEndX, newEndY);
  }
}
