package model.picture;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShapeImplTest {
  @Test
  @DisplayName("A drag from upper left to lower right should leave start point unchanged")
  void testUpperLeftToLowerRight() {
    Point start = new Point(1,1);
    Point end = new Point(2, 2);
    ShapeImpl s = new ShapeImpl(start, end, null);
    assertEquals(start, s.getStart());
  }

  @Test
  @DisplayName("A drag from lower right to upper left should swap end for start")
  void testLowerRightToUpperLeft() {
    Point start = new Point(1,1);
    Point end = new Point(0, 0);
    ShapeImpl s = new ShapeImpl(start, end, null);
    assertEquals(end, s.getStart());
  }

  @Test
  @DisplayName("A drag from upper right to lower left should swap end for start")
  void testUpperRightToLowerLeft() {
    Point start = new Point(1,1);
    Point end = new Point(0, 2);
    ShapeImpl s = new ShapeImpl(start, end, null);
    assertEquals(new Point(0, 1), s.getStart());
  }

  @Test
  @DisplayName("A drag from upper right to lower left should swap end for start")
  void testLowerLeftToUpperRight() {
    Point start = new Point(1,1);
    Point end = new Point(2, 0);
    ShapeImpl s = new ShapeImpl(start, end, null);
    assertEquals(new Point(1, 0), s.getStart());
  }
}
