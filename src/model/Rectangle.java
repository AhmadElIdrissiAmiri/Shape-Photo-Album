package model;

/**
 * The type Rectangle.
 */
public class Rectangle extends Abstract2DShape {

  /**
   * Constructor of Rectangle.
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
  public Rectangle(String name, String type, double widthOrRadius, double heightOrRadius,
      double coordinateX, double coordinateY, Color color) throws IllegalArgumentException {
    super(name, type, widthOrRadius, heightOrRadius, coordinateX, coordinateY, color);
  }

  /**
   * get Area of the shape rectangle.
   *
   * @return double.
   */
  @Override
  public double getArea() {
    return this.getWidthOrRadius() * this.getHeightOrRadius();

  }

  /**
   * make a copy of the shape.
   *
   * @return IShape.
   */
  @Override
  public IShape copy() {

    return new Rectangle(this.getName(), this.getType(), this.getWidthOrRadius(),
        this.getHeightOrRadius(), this.getCoordinateX(), this.getCoordinateY(), this.getColor());

  }

  /**
   * toString method.
   *
   * @return String.
   */
  @Override
  public String toString() {
    return super.toString()
        + "Min corner: (" + this.getCoordinateX() + ", " + this.getCoordinateY() + "), "
        + "Width: " + this.getWidthOrRadius() + ", " + "Height: " + this.getHeightOrRadius() + ", "
        + "Color: " + this.getColor();
  }
}
