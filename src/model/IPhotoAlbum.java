package model;


import java.util.Comparator;

import java.util.List;
import java.util.function.Predicate;

/**
 * The interface Photo album.
 */
public interface IPhotoAlbum {

  /**
   * Create shapes and add them to the linkedHashMap so when can have shapes on canvas.
   *
   * @param name           the name
   * @param type           the type
   * @param widthOrRadius  the width or radius
   * @param heightOrRadius the height or radius
   * @param coordinateX    the coordinate x
   * @param coordinateY    the coordinate y
   * @param color          the color
   */
  void create(String name, String type, double widthOrRadius, double heightOrRadius,
      double coordinateX, double coordinateY, Color color);

  /**
   * Add shapes to album by the name of the shape.
   *
   * @param nameOfShape the name of shape
   * @param shape       the shape
   */
  void addShapesToAlbum(String nameOfShape, IShape shape);

  /**
   * Remove shapes from album by the name of the shape.
   *
   * @param nameOfShape the name of shape
   */
  void removeShapesFromAlbum(String nameOfShape);

  /**
   * Gets shape by the name.
   *
   * @param nameOfShape the name of shape
   * @return the shape
   */
  IShape getShape(String nameOfShape);

  /**
   * Move shape to the new coordinates by the name of the shape.
   *
   * @param nameOfShape    the name of shape
   * @param newCoordinateX the new coordinate x
   * @param newCoordinateY the new coordinate y
   */
  void moveShape(String nameOfShape, double newCoordinateX, double newCoordinateY);

  /**
   * Change color by using the name of the shape and the new color.
   *
   * @param nameOfShape the name of shape
   * @param newColor    the new color
   */
  void changeColor(String nameOfShape, Color newColor);

  /**
   * Change dimensions of shape by using the name of the shape and the new dimensions .
   *
   * @param nameOfShape       the name of shape
   * @param newWidthOrRadius  the new width or radius
   * @param newHeightOrRadius the new height or radius
   */
  void changeDimensionsOfShape(String nameOfShape, double newWidthOrRadius,
      double newHeightOrRadius);

  /**
   * Add snapshots to the photoAlbum.
   *
   * @param snapchatDescription the snapchat description
   * @return the snapshot
   */
  Snapshot snapshot(String snapchatDescription);

  /**
   * Gets snapshot id.
   *
   * @return the snapshot i ds
   */
  String getSnapshotIDs();

  /**
   * Filter photo album, this method allows us to get a list of any kind of type of shapes we want.
   *
   * @param pq the pq
   * @return the photo album
   */
  IPhotoAlbum filter(Predicate<IShape> pq);

  /**
   * This method allows us to sort the shapes based on their area or anything we want by meanly
   * area.
   *
   * @param comp the comp
   */
  void sort(Comparator<IShape> comp);

  /**
   * Reset the photoAlbum to empty.
   */
  void reset();

  /**
   * Gets snapshot strings.
   *
   * @return the snapshot strings
   */
  StringBuilder getSnapshotStrings();

  /**
   * toString of the photoAlbum.
   *
   * @return String
   */
  String toString();

  /**
   * Get shapes strings.
   *
   * @return StringBuilder
   */
  StringBuilder getShapesStrings();
  List<ISnapShot> getSnapShotList();
}
