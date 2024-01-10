package model;


import java.time.LocalDateTime;
import java.util.List;


/**
 * The interface Snap shot.
 */
public interface ISnapShot {

  /**
   * Gets snap shot id.
   *
   * @return the snapshot id
   */
  LocalDateTime getSnapShotID();

  /**
   * Gets snapshot time stamp.
   *
   * @return the snapshot time stamp
   */
  String getSnapShotTimeStamp();

  /**
   * Gets snap shot description.
   *
   * @return the snapshot description
   */
  String getSnapShotDescription();

  /**
   * Gets shape information.
   *
   * @return the shape information
   */
  String getShapeInformation();

  /**
   * toString method.
   *
   * @return String
   */
  String toString();

  /**
   * getShapes as a list
   *
   * @return List</ IShape> shapes
   */
  List<IShape> getShapes();

}
