
package model;

/**
 * The type Color.
 */
public class Color implements IColor {

  private double r;
  private double g;
  private double b;
  private final double MAX_VALUE = 255.0;
  private final double MIN_VALUE = 0.0;

  /**
   * Color constructor.
   *
   * @param r the r
   * @param g the g
   * @param b the b
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Color(double r, double g, double b) throws IllegalArgumentException {
    if (r < MIN_VALUE || g < MIN_VALUE || b < MIN_VALUE || r > MAX_VALUE || g > MAX_VALUE
        || b > MAX_VALUE) {
      throw new IllegalArgumentException("The range for the RGB is between 0 and 255. "
          + "Please Enter a valid RGB");
    }
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * get R  method from RGB.
   *
   * @return double.
   */
  public double getR() {
    return this.r;
  }

  /**
   * get G  method from RGB.
   *
   * @return double.
   */
  public double getG() {
    return this.g;
  }

  /**
   * get B  method from RGB.
   *
   * @return double.
   */
  public double getB() {
    return this.b;
  }

  /**
   * toString method.
   *
   * @return String.
   */

  @Override
  public String toString() {
    return "(" + this.getR() + "," + this.getG() + "," + this.getB() + ")";
  }

}