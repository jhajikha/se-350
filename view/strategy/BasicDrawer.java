package view.strategy;

import view.interfaces.DrawStrategy;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import model.ShapeShadingType;
import model.interfaces.Region;
import view.interfaces.Shape;

/**
 * Implements the graphics calls that are not specific to a kind
 * of shape. See decendent classes for more information.
 */
public abstract class BasicDrawer implements DrawStrategy {
  final static float dash[] = { 10.0f };
  final static BasicStroke dashed = new BasicStroke(3.0f,
      BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);

  protected abstract void drawShape(Graphics2D graphics, Region region);

  protected abstract void drawBorder(Graphics2D graphics, Region region);

  public void drawBorder(Graphics2D graphics, Shape shape) {
    graphics.setColor(getBorderColor(shape));
    graphics.setStroke(new BasicStroke(3));
    Region region = shape.region();
    drawBorder(graphics, region);
  }

  @Override
  public void draw(Graphics2D graphics, Shape shape) {
    graphics.setColor(shape.getPrimaryColor());
    Region region = shape.region();
    drawShape(graphics, region);
  }

  public void drawSelected(Graphics2D graphics, Shape shape) {
    graphics.setColor(Color.GRAY);
    graphics.setStroke(dashed);
    Region region = shape.region();
    Region selectRegion = region.reshape(-3, 3);
    drawBorder(graphics, selectRegion);
  }

  public Color getBorderColor(Shape shape) {
    return shape.getShadingType() == ShapeShadingType.OUTLINE_AND_FILLED_IN ? shape.getSecondaryColor() : shape.getPrimaryColor();
  }
}
