/*
 * Assignment: 2
 * Topic: JPaint
 * Author: Dan Walker
 */
package model.interfaces;

import model.picture.Point;

/**
 * Manages the rectangular regions need for a number of operation:
 * - normalizing points
 * - hit detection
 * - shape dimensions
 */
public interface Region {
  int getX();
  int getY();
  int getWidth();
  int getHeight();
  int getDeltaX();
  int getDeltaY();
  int top();
  int bottom();
  int left();
  int right();
  boolean overlaps(Region r);
  void move(int x, int y);
  Region reshape(int start, int end);
  Region copy();
  Point start();
  Point end();
}
