package model;

/**
 * The interface Shape.
 */
public interface IShape {

  /**
   * Gets name.
   *
   * @return the name
   */
  String getName();

  /**
   * Gets type.
   *
   * @return the type
   */
  String getType();

  /**
   * Gets width or radius.
   *
   * @return the width or radius
   */
  double getWidthOrRadius();

  /**
   * Gets height or radius.
   *
   * @return the height or radius
   */
  double getHeightOrRadius();

  /**
   * Gets coordinate x.
   *
   * @return the coordinate x
   */
  double getCoordinateX();

  /**
   * Gets coordinate y.
   *
   * @return the coordinate y
   */
  double getCoordinateY();

  /**
   * Gets color.
   *
   * @return the color
   */
  Color getColor();

  /**
   * Sets width or radius.
   *
   * @param newWithOrRadius the new with or radius
   */
  void setWidthOrRadius(double newWithOrRadius);

  /**
   * Sets height or radius.
   *
   * @param newHeightOrRadius the new height or radius
   */
  void setHeightOrRadius(double newHeightOrRadius);

  /**
   * Sets coordinate x.
   *
   * @param newCoordinateX the new coordinate x
   */
  void setCoordinateX(double newCoordinateX);

  /**
   * Sets coordinate y.
   *
   * @param newCoordinateY the new coordinate y
   */
  void setCoordinateY(double newCoordinateY);


  /**
   * Sets color.
   *
   * @param newColor the new color
   */
  void setColor(Color newColor);

  /**
   * Gets area.
   *
   * @return the area
   */
  double getArea();

  /**
   * Copy shape.
   *
   * @return the shape
   */
  IShape copy();

  /**
   * toString method.
   *
   * @return String.
   */
  String toString();


}
