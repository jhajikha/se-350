/*
 * Assignment: 2
 * Topic: JPaint
 * Author: Dan Walker
 */
package view.strategy;

import java.awt.Graphics2D;
import java.awt.Polygon;
import model.interfaces.Region;

public class TriangleDrawer extends BasicDrawer {
  private final int NUM_SIDES = 3;

  @Override
  protected void drawShape(Graphics2D graphics, Region region) {
    int[] x = getXArray(region);
    int[] y = getYArray(region);

    Polygon p = new Polygon(x, y, NUM_SIDES);
    graphics.fillPolygon(p);
  }

  @Override
  protected void drawBorder(Graphics2D graphics, Region region) {
    int[] x = getXArray(region);
    int[] y = getYArray(region);

    Polygon p = new Polygon(x, y, NUM_SIDES);
    graphics.drawPolygon(p);
  }

  private int[] getYArray(Region region) {
    return new int[]{region.getY(), region.getY() + region.getHeight(), region.getY() + region.getHeight()};
  }

  private int[] getXArray(Region region) {
    return new int[]{region.getX() + region.getWidth() / 2, region.getX(), region.getX() + region.getWidth()};
  }
}