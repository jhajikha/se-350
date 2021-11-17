/*
 * Assignment: 1
 * Topic: JPaint
 * Author: Dan Walker
 */
package controller.command;

import controller.Clipboard;
import model.interfaces.Region;
import model.interfaces.UserChoices;
import model.picture.Point;
import view.interfaces.Picture;
import model.picture.RegionImpl;
import view.gui.PaintCanvas;
import controller.interfaces.Command;

/**
 * CommandController is responsible for creating new Commands based on
 * current user input.  The new Command is normally executed as well.
 */
public class CommandController {
  private final PaintCanvas canvas;
  private final UserChoices choices;
  private final Picture picture;
  private final Clipboard clipboard;

  public CommandController(PaintCanvas canvas, UserChoices choices, Picture picture, Clipboard clipboard) {
    this.choices = choices;
    this.canvas = canvas;
    this.picture = picture;
    this.clipboard = clipboard;
  }

  public void onDraw(Point start, Point end) {
    Region region = new RegionImpl(start, end);
    Command cmd = CommandFactory.makeCommand(choices,canvas,picture,region);
    cmd.run();

    canvas.repaint();
  }

  public void onUndo() {
    CommandHistory.undo();
    canvas.repaint();
  }
  public void onRedo() {
    CommandHistory.redo();
    canvas.repaint();
  }

  public void onCopy() {clipboard.copy();}

  public void onPaste() {
    clipboard.paste();
    canvas.repaint();
  }

  public void onDelete() {
    Command cmd = CommandFactory.makeDeleteCommand(picture);
    cmd.run();
    canvas.repaint();
  }
}

