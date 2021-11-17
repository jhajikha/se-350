/*
 * Assignment: 1
 * Topic: JPaint
 * Author: Dan Walker
 */
package model.picture;

/**
 * Represents the coordinates of a user's mouse event
 */
public class Point {
  private int x;
  private int y;

  public int getX() {
    return x;
  }

  public void setX(int x) { this.x = x; }

  public void setY(int y) {this.y = y; }

  public int getY() {
    return y;
  }

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Point copy() {
    return new Point(x, y);
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) {return false; }
    if (other instanceof Point) {
      Point p = (Point) other;
      return this.x == p.x && this.y == p.y;
    }
    return false;
  }

  @Override
  public String toString() {
    return "Point(" + x + "," + y + ")";
  }
}
