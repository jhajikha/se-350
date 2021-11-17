package controller.command;

import controller.command.CommandHistory;
import controller.interfaces.Command;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import java.util.List;
import view.interfaces.Shape;
import view.interfaces.Picture;
import view.gui.PaintCanvas;

public class PasteShapesCommand implements Command, Undoable {
  private final Picture picture;
  private final List<Shape> clipBoardContents;
  private final PaintCanvas canvas;

  private List<Shape> pastedShapes = new ArrayList<>();
  private final int OFFSET = 10;

  public PasteShapesCommand(Picture picture, List<Shape> clipBoardContents, PaintCanvas canvas) {
    this.picture = picture;
    this.clipBoardContents = clipBoardContents;
    this.canvas = canvas;
    CommandHistory.add(this);
  }
  @Override
  public void run() {
    for (Shape shape : clipBoardContents) {
      shape.move(OFFSET, OFFSET);
      Shape newShape = shape.copy();
      picture.add(newShape);
      pastedShapes.add(newShape);
    }
  }

  @Override
  public void undo() {
    for (Shape shape: pastedShapes) {
      picture.remove(shape);
    }
  }

  @Override
  public void redo() {
    picture.add(pastedShapes);
  }
}
