package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import model.interfaces.Region;
import view.interfaces.Picture;
import view.interfaces.Shape;

import java.util.ArrayList;
import java.util.List;

public class DeleteShapesCommand implements Command, Undoable {

  private final Picture picture;
  private List<Shape> deletedShapes;

  public DeleteShapesCommand(Picture picture) {

    this.picture = picture;
    this.deletedShapes= new ArrayList<Shape>();

    CommandHistory.add(this);
  }
  @Override
  public void run() {

    List<Shape> picSelected=  picture.getSelected();
    for (Shape shape : picSelected){
      deletedShapes.add(shape);
    }
    for (Shape shape : deletedShapes) {
      picture.remove(shape);
    }
  }

  @Override
  public void undo() {
    picture.add(deletedShapes);
  }

  @Override
  public void redo() {
    for (Shape shape : deletedShapes) {
      picture.remove(shape);
    }
  }

}