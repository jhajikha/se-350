/*
 * Assignment: 1
 * Topic: JPaint
 * Author: Dan Walker
 */
package controller.command;

import controller.ShapeBuilder;
import controller.interfaces.Command;
import controller.interfaces.Undoable;
import java.awt.Color;
import model.ShapeShadingType;
import model.interfaces.Region;
import view.interfaces.Shape;
import model.interfaces.UserChoices;
import view.interfaces.Picture;
import model.picture.Point;
import view.picture.ShapeImpl;
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
  private Region region;

  public CreateShapeCommand(UserChoices userChoices, PaintCanvas canvas, Picture picture, Region region) {
    this.userChoices = userChoices;
    this.canvas = canvas;
    this.picture = picture;
    this.region = region;
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
    ShapeBuilder builder = new ShapeBuilder();
    Color fillColor = userChoices.getActivePrimaryColor().value;
    Color borderColor = userChoices.getActiveSecondaryColor().value;
    ShapeShadingType shadingType = userChoices.getActiveShapeShadingType();
    builder
        .setFillColor(fillColor)
        .setBorderColor(borderColor)
        .setShading(shadingType)
        .setRegion(region)
        .setType(userChoices.getActiveShapeType());

    shape = builder.build();
    picture.add(shape);
  }
}
