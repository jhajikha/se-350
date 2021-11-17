/*
 * Assignment: 1
 * Topic: JPaint
 * Author: Dan Walker
 */
package view.picture;

import java.awt.Color;
import java.awt.Graphics2D;
//import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.Region;
import view.interfaces.Shape;
import view.interfaces.DrawStrategy;

/**
 * @see Shape
 */
public class ShapeImpl implements Shape {

  private final Color primaryColor;
  private final Color secondaryColor;
  private final Region region;
  private  DrawStrategy drawStrategy = null;
  private ShapeShadingType shadingType;

  public ShapeImpl(Region region, Color primaryColor, Color secondaryColor, DrawStrategy drawStrategy, ShapeShadingType shadingType) {
    this.region = region;
    this.primaryColor = primaryColor;
    this.secondaryColor = secondaryColor;
    this.drawStrategy = drawStrategy;
    this.shadingType = shadingType;
  }
  public ShapeImpl(Region region, Color color) {
    this.region = region;
    this.primaryColor = color;
    this.secondaryColor = color;
  }

  public Color getPrimaryColor() { return primaryColor; }

  @Override
  public Color getSecondaryColor() {
    return secondaryColor;
  }

  @Override
  public ShapeShadingType getShadingType() {
    return shadingType;
  }

  public Region region() {return region; }

  @Override
  public void draw(Graphics2D graphics) {
    drawStrategy.draw(graphics, this);
  }

  @Override
  public void drawSelected(Graphics2D graphics) {
    drawStrategy.drawSelected(graphics, this);
  }

  public void move(int x, int y) {
    region.move(x, y);
  }

  public Shape copy() {
    return new ShapeImpl(region.copy(), primaryColor, secondaryColor, drawStrategy, shadingType);
  }

}
