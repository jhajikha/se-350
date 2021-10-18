/*
 * Assignment: 1
 * Topic: JPaint
 * Author: Dan Walker
 */
package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import model.interfaces.Shape;
import model.interfaces.UserChoices;
import model.interfaces.Picture;
import model.picture.Point;
import model.picture.ShapeImpl;
import view.gui.PaintCanvas;

/**
 * CreateShapeCommand is responsible for creating a given shape.
 * It can be stored and executed at any time because it contains all
 * of the information needed to create its assigned shape.
 */
public class CreateShapeCommand implements Command, Undoable {

  private Shape shape;
  private UserChoices userChoices;
  private PaintCanvas canvas;
  private Picture picture;
  private Point start;
  private Point end;

  public CreateShapeCommand(UserChoices userChoices, PaintCanvas canvas, Picture picture, Point start, Point end) {
    this.userChoices = userChoices;
    this.canvas = canvas;
    this.picture = picture;
    this.start = start;
    this.end = end;
    CommandHistory.add(this);
  }

  @Override
  public void undo() {
    picture.remove(shape);
  }

  @Override
  public void redo() {
    picture.add(shape);
  }

  @Override
  public void run() {
    shape = new ShapeImpl(start, end, userChoices.getActivePrimaryColor(), userChoices);
    picture.add(shape);
  }
}
