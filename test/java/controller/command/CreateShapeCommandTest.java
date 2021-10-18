package controller.command;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import model.interfaces.UserChoices;
import model.persistence.UserChoicesImpl;
import model.picture.PictureImpl;
import model.picture.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreateShapeCommandTest {
  @Test
  @DisplayName("Running CreateShapeCommand should add an element to the picture")
  void verifyCommandAddsToPicture() {
    PictureImpl p = new PictureImpl();
    int startingSize = p.size();
    UserChoices u = new UserChoicesImpl(null);
    CreateShapeCommand c = new CreateShapeCommand(u, null, p, new Point(0,0), new Point(1,1));
    c.run();
    assertAll(
        () -> assertEquals(0, startingSize),
        () -> assertEquals(1, p.size())
    );
  }

  @Test
  @DisplayName("Executing undo should remove from the picture")
  void verifyUndoRemoves() {
    PictureImpl p = new PictureImpl();
    UserChoices u = new UserChoicesImpl(null);
    CreateShapeCommand c = new CreateShapeCommand(u, null, p, new Point(0,0), new Point(1,1));
    c.run();
    c.undo();
    assertEquals(0, p.size());
  }

  @Test
  @DisplayName("Executing redo should return the element to the Picture")
  void verifyRedoAddsBackIn() {
    PictureImpl p = new PictureImpl();
    UserChoices u = new UserChoicesImpl(null);
    CreateShapeCommand c = new CreateShapeCommand(u, null, p, new Point(0,0), new Point(1,1));
    c.run();
    c.undo();
    c.redo();
    assertEquals(1, p.size());
  }
}
