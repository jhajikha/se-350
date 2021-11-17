/*
 * Assignment: 2
 * Topic: JPaint
 * Author: Dan Walker
 */
package controller;

import view.interfaces.DrawStrategy;
import view.strategy.BasicDrawer;
import view.strategy.BorderDrawer;
import view.strategy.EllipseDrawer;
import view.strategy.EmptyShapeDrawer;
import view.strategy.RectangleDrawer;
import view.strategy.TriangleDrawer;
import java.awt.Color;
import model.picture.Point;
import model.ShapeType;
import model.ShapeShadingType;
import model.interfaces.Region;
import view.interfaces.Shape;
import view.picture.ShapeImpl;

public class ShapeBuilder {
  private Color color;
  private Color borderColor;

  private Point start;
  private Point end;
  private ShapeType type;
  private ShapeShadingType shading;
  private Region region;

  public ShapeBuilder setFillColor(Color color) {
    this.color = color;
    return this;
  }

  public ShapeBuilder setBorderColor(Color color) {
    this.borderColor = color;
    return this;
  }

  public ShapeBuilder setRegion(Region region) {
    this.region = region;
    return  this;
  }

  public ShapeBuilder setType(ShapeType type) {
    this.type = type;
    return this;
  }

  public ShapeBuilder setShading(ShapeShadingType shading) {
    this.shading = shading;
    return this;
  }

  public Shape build() {
    Shape newShape = null;
    DrawStrategy drawStrategy = null;

    switch (type) {
      case ELLIPSE:
        drawStrategy = new EllipseDrawer();
        break;
      case RECTANGLE:
        drawStrategy = new RectangleDrawer();
        break;
      case TRIANGLE:
        drawStrategy = new TriangleDrawer();
        break;
      default:
        throw new IllegalArgumentException("Unknown ShapeType");
    }

    if (shading != ShapeShadingType.FILLED_IN) {
      if (shading == ShapeShadingType.OUTLINE) {
        drawStrategy = new EmptyShapeDrawer((BasicDrawer) drawStrategy);
      }
      drawStrategy = new BorderDrawer(drawStrategy);
    }

    newShape = new ShapeImpl(region, color, borderColor, drawStrategy, shading);
    return newShape;
  }
}
