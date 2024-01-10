package model;


import java.util.Objects;

/**
 * The type Abstract 2 d shape.
 */
public abstract class Abstract2DShape implements IShape {

  private String name;
  private String type;
  private double widthOrRadius;
  private double heightOrRadius;
  private double coordinateX;
  private double coordinateY;
  private Color color;
  private final double MIN_VALUE = 0.0;


  /**
   * Constructor Abstract 2 d shape.
   *
   * @param name           the name
   * @param type           the type
   * @param widthOrRadius  the width or radius
   * @param heightOrRadius the height or radius
   * @param coordinateX    the coordinate x
   * @param coordinateY    the coordinate y
   * @param color          the color
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Abstract2DShape(String name, String type, double widthOrRadius, double heightOrRadius,
      double coordinateX, double coordinateY, Color color) throws IllegalArgumentException {
    if (name.equals("") || name == null || type.equals("") || type == null
        || widthOrRadius <= MIN_VALUE || heightOrRadius <= MIN_VALUE || color == null) {
      throw new IllegalArgumentException("Type cannot be null or empty."
          + " You cannot have a null shape or null corner dimensions");
    }
    this.name = name;
    this.type = type;
    this.widthOrRadius = widthOrRadius;
    this.heightOrRadius = heightOrRadius;
    this.coordinateX = coordinateX;
    this.coordinateY = coordinateY;
    this.color = color;
  }

  /**
   * get Name method
   *
   * @return string.
   */
  @Override
  public String getName() {
    return this.name;

  }

  /**
   * get Type method
   *
   * @return string.
   */
  @Override
  public String getType() {
    return this.type;
  }

  /**
   * get Width or Radius depending on the shape method
   *
   * @return double.
   */
  @Override
  public double getWidthOrRadius() {
    return this.widthOrRadius;
  }

  /**
   * get Height or Radius depending on the shape method
   *
   * @return double.
   */
  @Override
  public double getHeightOrRadius() {
    return this.heightOrRadius;
  }

  /**
   * get coordinate X  method
   *
   * @return double.
   */
  @Override
  public double getCoordinateX() {
    return this.coordinateX;
  }

  /**
   * get coordinate Y  method
   *
   * @return double.
   */
  @Override
  public double getCoordinateY() {
    return this.coordinateY;
  }

  /**
   * get color method
   *
   * @return Color.
   */
  @Override
  public Color getColor() {
    return this.color;
  }

  /**
   * set Width or Radius depending on the shape method.
   */
  @Override
  public void setWidthOrRadius(double newWithOrRadius) {
    this.widthOrRadius = newWithOrRadius;

  }

  /**
   * set Height or Radius depending on the shape method.
   */
  @Override
  public void setHeightOrRadius(double newHeightOrRadius) {
    this.heightOrRadius = newHeightOrRadius;
  }

  /**
   * set coordinate X method.
   */
  @Override
  public void setCoordinateX(double newCoordinateX) {
    this.coordinateX = newCoordinateX;
  }

  /**
   * set coordinate Y method.
   */
  @Override
  public void setCoordinateY(double newCoordinateY) {
    this.coordinateY = newCoordinateY;
  }

  /**
   * set color method.
   */
  @Override
  public void setColor(Color colorName) {
    this.color = colorName;

  }

  /**
   * equals method.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Abstract2DShape that = (Abstract2DShape) o;
    return Objects.equals(getName(), that.name) && Objects.equals(getType(), that.type)
        && Objects.equals(getWidthOrRadius(), that.widthOrRadius) && Objects.equals(
        getHeightOrRadius(),
        that.heightOrRadius) && Objects.equals(getCoordinateX(), that.coordinateX)
        && Objects.equals(getCoordinateY(), that.coordinateY)
        && Objects.equals(getColor(), that.color);
  }

  /**
   * hashCode method.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName(), getType(), getWidthOrRadius(), getHeightOrRadius(),
        getCoordinateX(), getCoordinateY(), getColor());
  }

  /**
   * toString method.
   *
   * @return String.
   */
  @Override
  public String toString() {
    return "Name: " + this.getName() + "\n" + "Type: " + this.getType() + "\n";

  }

}
