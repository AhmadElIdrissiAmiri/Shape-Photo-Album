package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

/**
 * The type Photo album model.
 */
public class PhotoAlbumModel implements IPhotoAlbum {

  private LinkedHashMap<String, IShape> shapesLinkedHashMap;
  private List<ISnapShot> snapShotList;
  private final double MIN_VALUE = 0.0;


  /**
   * Instantiates a new Photo album model.
   */
  public PhotoAlbumModel() {
    this.shapesLinkedHashMap = new LinkedHashMap<>();
    this.snapShotList = new ArrayList<>();
  }

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
  public void create(String name, String type, double widthOrRadius, double heightOrRadius,
      double coordinateX, double coordinateY, Color color) throws IllegalArgumentException {
    if (name.equals("") || name == null || type.equals("") || type == null ||
        widthOrRadius <= MIN_VALUE || heightOrRadius <= MIN_VALUE || color == null) {
      throw new IllegalArgumentException("Name and Type cannot be null or empty."
          + " You cannot have a negative height or width or radius");
    }
    if (type.equalsIgnoreCase("Rectangle")) {
      addShapesToAlbum(name,
          new Rectangle(name, type, widthOrRadius, heightOrRadius, coordinateX, coordinateY,
              color));
    } else if (type.equalsIgnoreCase("Oval")) {
      addShapesToAlbum(name,
          new Oval(name, type, widthOrRadius, heightOrRadius, coordinateX, coordinateY,
              color));
    }


  }

  /**
   * Add shapes to album by the name of the shape.
   *
   * @param nameOfShape the name of shape
   * @param shape       the shape
   */
  @Override
  public void addShapesToAlbum(String nameOfShape, IShape shape) throws IllegalArgumentException {
    if (nameOfShape == null || nameOfShape.equals("")) {
      throw new IllegalArgumentException("The Shape cannot be null or empty");
    } else {
      this.shapesLinkedHashMap.put(nameOfShape, shape);
    }
  }

  /**
   * Remove shapes from album by the name of the shape.
   *
   * @param nameOfShape the name of shape
   */
  @Override
  public void removeShapesFromAlbum(String nameOfShape) throws NoSuchElementException {
    if (!shapesLinkedHashMap.containsKey(nameOfShape)) {
      throw new NoSuchElementException("There is no such shape with the given ShapeIdentifier");
    } else {
      this.shapesLinkedHashMap.remove(nameOfShape);
    }

  }

  /**
   * Gets shape by the name.
   *
   * @param nameOfShape the name of shape
   * @return the shape
   */
  @Override
  public IShape getShape(String nameOfShape) throws IllegalArgumentException {
    if (!shapesLinkedHashMap.containsKey(nameOfShape)) {
      throw new NoSuchElementException("There is no such shape with the given shapeIdentifier");
    }
    return shapesLinkedHashMap.get(nameOfShape);
  }

  /**
   * Move shape to the new coordinates by the name of the shape.
   *
   * @param nameOfShape    the name of shape
   * @param newCoordinateX the new coordinate x
   * @param newCoordinateY the new coordinate y
   */
  @Override
  public void moveShape(String nameOfShape, double newCoordinateX, double newCoordinateY)
      throws IllegalArgumentException {
    if (!shapesLinkedHashMap.containsKey(nameOfShape)) {
      throw new IllegalArgumentException(
          "The PhotoAlbum does not contain this shape or The new coordinates cannot be negative");
    } else {
      for (IShape shapes : shapesLinkedHashMap.values()) {
        shapes.setCoordinateX(newCoordinateX);
        shapes.setCoordinateY(newCoordinateY);

      }
    }
  }

  /**
   * Change color by using the name of the shape and the new color.
   *
   * @param nameOfShape the name of shape
   * @param newColor    the new color
   */
  @Override
  public void changeColor(String nameOfShape, Color newColor) throws IllegalArgumentException {
    if (!shapesLinkedHashMap.containsKey(nameOfShape) || nameOfShape.equals("")
        || nameOfShape == null || newColor.equals("") || newColor == null) {
      throw new IllegalArgumentException(
          "The List does not contain this shape. This name of the shape is not valid!!. "
              + "Please enter a valid color name");
    } else {
      for (Entry<String, IShape> entry : shapesLinkedHashMap.entrySet()) {
        if (entry.getKey().equalsIgnoreCase(nameOfShape)) {
          {
            getShape(nameOfShape).setColor(newColor);

          }
        }
      }
    }
  }

  /**
   * Change dimensions of shape by using the name of the shape and the new dimensions .
   *
   * @param nameOfShape       the name of shape
   * @param newWidthOrRadius  the new width or radius
   * @param newHeightOrRadius the new height or radius
   */
  @Override
  public void changeDimensionsOfShape(String nameOfShape, double newWidthOrRadius,
      double newHeightOrRadius) throws IllegalArgumentException {
    if (!shapesLinkedHashMap.containsKey(nameOfShape)) {
      throw new IllegalArgumentException(
          "The PhotoAlbum does not contain this shape or The new dimensions cannot be negative");
    } else {
      for (IShape shapes : shapesLinkedHashMap.values()) {
        shapes.setWidthOrRadius(newWidthOrRadius);
        shapes.setHeightOrRadius(newHeightOrRadius);

      }
    }
  }

  /**
   * Add snapshots to the photoAlbum.
   *
   * @param snapchatDescription the snapchat description
   * @return the snapshot
   */
  @Override
  public Snapshot snapshot(String snapchatDescription) {
    LocalDateTime timeNow = LocalDateTime.now();
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    Snapshot snapshot = new Snapshot(timeNow, timeNow.format(timeFormatter), snapchatDescription,
        this.shapesLinkedHashMap.values().stream().toList());
    this.snapShotList.add(snapshot);
    return snapshot;
  }

  /**
   * Gets snapshot id.
   *
   * @return the snapshot i ds
   */
  @Override
  public String getSnapshotIDs() {
    List<String> IDsOfSnapShot = new ArrayList<>();
    for (ISnapShot each : this.snapShotList) {
      IDsOfSnapShot.add("" + each.getSnapShotID().toString());
    }
    return "List of snapshots before reset: " + IDsOfSnapShot;

  }

  /**
   * Filter photo album, this method allows us to get a list of any kind of type of shapes we want.
   *
   * @param pq the pq
   * @return the photo album
   */
  @Override
  public IPhotoAlbum filter(Predicate<IShape> pq) {
    if (pq == null) {
      throw new IllegalArgumentException("pq cannot be null");
    }
    IPhotoAlbum q = new PhotoAlbumModel();
    List<String> newPhotoAlbum = new ArrayList<>(this.shapesLinkedHashMap.keySet());
    for (String each : newPhotoAlbum) {
      if (pq.test(this.shapesLinkedHashMap.get(each))) {
        q.addShapesToAlbum(each, this.shapesLinkedHashMap.get(each).copy());
      }

    }
    return q;
  }

  /**
   * This method allows us to sort the shapes based on their area or anything we want by meanly
   * area.
   *
   * @param comp the comp
   */
  @Override
  public void sort(Comparator<IShape> comp) throws IllegalArgumentException {

    if (comp == null) {
      throw new IllegalArgumentException("Comparator cannot be null");
    }
    LinkedHashMap<String, IShape> sortedShapesLinkedHashMap = new LinkedHashMap<>();
    this.shapesLinkedHashMap.entrySet().stream()
        .sorted((shape1, shape2) -> comp.compare(shape1.getValue(), shape2.getValue()))
        .forEachOrdered(entry -> sortedShapesLinkedHashMap.put(
            entry.getKey(), entry.getValue()));
    shapesLinkedHashMap = sortedShapesLinkedHashMap;
  }

  /**
   * Reset the photoAlbum to empty.
   */
  @Override
  public void reset() {
    this.shapesLinkedHashMap = new LinkedHashMap<>();
    this.snapShotList = new ArrayList<>();

  }

  /**
   * Gets snapshot strings.
   *
   * @return the snapshot strings
   */
  @Override
  public StringBuilder getSnapshotStrings() {
    StringBuilder snapIDs = new StringBuilder();
    for (ISnapShot snap : this.snapShotList) {
      snapIDs.append(snap.toString());
    }
    return snapIDs;
  }

  /**
   * Get shapes strings.
   *
   * @return StringBuilder
   */
  @Override
  public StringBuilder getShapesStrings() {
    StringBuilder shapes = new StringBuilder();
    for (IShape shape : this.shapesLinkedHashMap.values()) {
      shapes.append(shape.toString()).append("\n");
    }
    return shapes;
  }

  /**
   * toString of the photoAlbum.
   *
   * @return String
   */
  @Override
  public String toString() {
    StringBuilder photoAlbumString = new StringBuilder();
    int shapesCounter = 1;
    for (IShape shape : shapesLinkedHashMap.values()) {
      photoAlbumString.append("Printing Snapshots\n").append(getSnapshotStrings()).append("\n");
      break;

    }
    return photoAlbumString.toString();
  }

  @Override
  public List<ISnapShot> getSnapShotList(){
    List<ISnapShot> snapIDs = new ArrayList<>();
    for (ISnapShot snap : this.snapShotList) {
      snapIDs.add(snap);
    }
    return snapIDs;
  }


}
