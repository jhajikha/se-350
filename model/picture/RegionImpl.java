/*
 * Assignment: 2
 * Topic: JPaint
 * Author: Dan Walker
 */
package model.picture;

import model.interfaces.Region;

/**
 * Manages the rectangular regions need for a number of operation:
 * - normalizing points
 * - hit detection
 * - shape dimensions
 */
public class RegionImpl implements Region {
  private Point start;
  private Point end;
  private Point originalStart;
  private Point originalEnd;


  public RegionImpl(Point start, Point end) {
    originalStart = start;
    originalEnd = end;
    Point[] newPoints = normalizePoints(start, end);
    this.start = newPoints[0];
    this.end = newPoints[1];
  }

  public Point start() {return start; }

  public Point end() {return end; }

  public int getWidth() {
    return end.getX() - start.getX();
  }

  public int getHeight() {
    return end.getY() - start.getY();
  }

  @Override
  public int getDeltaX() {
    return originalEnd.getX() - originalStart.getX();
  }

  @Override
  public int getDeltaY() {
    return originalEnd.getY() - originalStart.getY();
  }

  public int getX() {return start.getX(); }

  @Override
  public int getY() {
    return start.getY();
  }

  public int right() {return end.getX();}

  public int left() {return start.getX();}

  public int top() {return start.getY();}

  public int bottom() {return end.getY();}

  public boolean overlaps(Region other) {
    if (overlapsSideToSide(other) && overlapsTopToBottom(other)) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void move(int x, int y) {
    start = new Point(start.getX() + x, start.getY() + y);
    end = new Point(end.getX() + x, end.getY() + y);
  }

  @Override
  public Region reshape(int startDiff, int endDiff) {
    Point newStart = new Point(start.getX() + startDiff, start.getY() + startDiff);
    Point newEnd = new Point(end.getX() + endDiff, end.getY() + endDiff);
    return new RegionImpl(newStart, newEnd);
  }

  public Region reshapex(int startDiff, int endDiff) {
    int oldHeight = getHeight();
    int oldWidth = getWidth();
    int newHeight = oldHeight + (Math.abs(startDiff) * 2);
    double dNewWidth = Math.ceil((newHeight * oldWidth) / (double) oldHeight);
    int newWidth = (int) Math.ceil(dNewWidth);
    int xendDiff = ((newWidth - oldWidth) / 2) + 1;
    Point newStart = new Point(start.getX() + startDiff, start.getY() + startDiff);
    Point newEnd = new Point(newStart.getX() + newWidth, newStart.getY() + newHeight);
    return new RegionImpl(newStart, newEnd);
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) return false;
    if (other instanceof Region) {
      Region otherRegion = (Region) other;
      if (start.equals(otherRegion.start()) && end.equals(otherRegion.end())) return true;
      else return  false;
    } else return false;
  }

  public String toString() {
    return "Region(" + start + " : " + end + ")";
  }

  @Override
  public Region copy() {
    return new RegionImpl(start.copy(), end.copy());
  }

  private boolean overlapsSideToSide(Region other) {
    return (this.right() > other.left() && this.right() < other.right()) ||
        (other.right() > this.left() && other.right() < this.right());
  }

  private boolean overlapsTopToBottom(Region other) {
    return (this.bottom() > other.top() && this.bottom() < other.bottom()) ||
        (other.bottom() > this.top() && other.bottom() < this.bottom());
  }

  /**
   * The beginning and ending points are not necessarily the points needed when drawing.
   * This function figures out the better drawing points.
   * @param firstPoint location of the mouse when first clicked
   * @param endPoint location of mouse when finally released
   * @return array containing recalculated start and end points from a drawing perspective
   */
  private Point[] normalizePoints(Point firstPoint, Point endPoint) {
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

    return new Point[] {new Point(newStartX, newStartY), new Point(newEndX, newEndY)};
  }
}

