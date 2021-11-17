/*
 * Assignment: 2
 * Topic: JPaint
 * Author: Dan Walker
 */
package controller.command;

import controller.interfaces.Command;
import java.util.List;
import model.MouseMode;
import view.interfaces.Picture;
import model.interfaces.Region;
import model.interfaces.UserChoices;
import view.gui.PaintCanvas;
import view.interfaces.Shape;

public class CommandFactory {
  public static Command makeCommand(UserChoices userChoices, PaintCanvas canvas, Picture picture, Region region) {
    Command cmd;
    MouseMode mode = userChoices.getActiveMouseMode();
    switch (mode) {
      case DRAW:
        cmd = new CreateShapeCommand(userChoices, canvas, picture, region);
        break;
      case SELECT:
        cmd = new SelectShapesCommand(picture, region);
        break;
      case MOVE:
        cmd = new MoveShapesCommand(picture, region);
        break;
      default:
        throw new IllegalArgumentException("Unknown mouse mode");
    }
    return cmd;
  }

  public static Command makePasteCommand(Picture picture, List<Shape> contents, PaintCanvas canvas) {
    return new PasteShapesCommand(picture, contents, canvas);
  }

  public static Command makeDeleteCommand(Picture picture) {
    return new DeleteShapesCommand(picture);
  }

}
