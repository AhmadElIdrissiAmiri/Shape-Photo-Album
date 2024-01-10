package model;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * The Class Snapshot implements ISnapShot interface.
 */
public class Snapshot implements ISnapShot {

  private LocalDateTime snapShotID;

  private String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(
      Calendar.getInstance().getTime());

  private String description;
  private List<IShape> shapesList = new ArrayList<>();


  /**
   * Constructor of Snapshot.
   *
   * @param snapShotID  the snapshot id
   * @param timeStamp   the time stamp
   * @param description the description
   * @param shapesList  the shapes list
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Snapshot(LocalDateTime snapShotID, String timeStamp, String description,
      List<IShape> shapesList)
      throws IllegalArgumentException {
    if (snapShotID == null || timeStamp == null || timeStamp.equals("") || shapesList == null) {
      throw new IllegalArgumentException(
          "SnapShotID and timeStamp cannot be null or empty.");
    }

    this.snapShotID = snapShotID;
    this.timeStamp = timeStamp;
    this.description = description;
    this.shapesList = shapesList;

  }

  /**
   * Gets snap shot id.
   *
   * @return the snapshot id
   */
  @Override
  public LocalDateTime getSnapShotID() {
    return this.snapShotID;
  }

  /**
   * Gets snapshot time stamp.
   *
   * @return the snapshot time stamp
   */
  @Override
  public String getSnapShotTimeStamp() {
    return this.timeStamp;
  }

  /**
   * Gets snap shot description.
   *
   * @return the snapshot description
   */
  @Override
  public String getSnapShotDescription() {
    return this.description;
  }

  /**
   * Gets shape information.
   *
   * @return the shape information
   */
  @Override
  public String getShapeInformation() {
    StringBuilder shapeString = new StringBuilder();
    int shapesCounter = 1;
    for (IShape shape : this.shapesList) {
      if (!shape.toString().equals("")) {
        shapeString.append(shape).append("\n\n");
        shapesCounter++;
      } else {
        shapeString.equals("");
      }

    }
    return shapeString.toString();
  }

  /**
   * toString method.
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Snapshot ID: " + this.snapShotID + "\n"
        + "Timestamp: " + this.timeStamp + "\n"
        + "Description: " + this.description + "\n"
        + "Shape information:" + "\n"
        + this.getShapeInformation();
  }

  /**
   * getShapes as a list
   *
   * @return List</ IShape>
   */
  @Override
  public List<IShape> getShapes(){
    return this.shapesList;
  }
}
