/*
 * Assignment: 2
 * Topic: JPaint
 * Author: Dan Walker
 */
package controller.command;

import controller.interfaces.Command;
import view.interfaces.Picture;
import model.interfaces.Region;

public class SelectShapesCommand implements Command {
  private Picture picture;
  private Region region;

  public SelectShapesCommand(Picture picture, Region region) {
    this.picture = picture;
    this.region = region;
  }
  @Override
  public void run() {
    picture.select(region);
  }
}
