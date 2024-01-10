package modelView;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


import model.Color;
import model.IShape;
import model.Oval;
import model.Rectangle;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Abstract shape test.
 */
public class AbstractShapeTest {

  /**
   * The Shape 1.
   */
  private IShape shape1;
  /**
   * The Shape 2.
   */
  private IShape shape2;
  /**
   * The Shape 3.
   */
  private IShape shape3;
  /**
   * The Shape 4.
   */
  private IShape shape4;


  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    this.shape1 = new Rectangle("R", "rectangle", 50.0,
        100.0, 200.0, 200.0, new Color(1.0, 1.0, 1.0));
    this.shape2 = new Oval("O", "oval", 5.5,
        10.5, 1.0, 2.0, new Color(0.0, 0.0, 0.0));
    this.shape3 = new Rectangle("Beautiful Rectangle", "RECTANGLE",
        5000000.0, 8000000000.666666, 150000.6,
        855555555.6666, new Color(0.6, 1.0, 0.8));


  }

  /**
   * Test get name.
   */
  @Test
  public void testGetName() {
    assertEquals("R", this.shape1.getName());
    assertEquals("O", this.shape2.getName());
    assertEquals("Beautiful Rectangle", this.shape3.getName());

  }


  /**
   * Test get type.
   */
  @Test
  public void testGetType() {
    assertEquals("rectangle", this.shape1.getType());
    assertEquals("oval", this.shape2.getType());
    assertEquals("RECTANGLE", this.shape3.getType());

  }

  /**
   * Test get width or radius.
   */
  @Test
  public void testGetWidthOrRadius() {
    assertEquals(50.0, this.shape1.getWidthOrRadius(), 0.01);
    assertEquals(5.5, this.shape2.getWidthOrRadius(), 0.01);
    assertEquals(5000000.0, this.shape3.getWidthOrRadius(), 0.01);

  }

  /**
   * Test get height or radius.
   */
  @Test
  public void testGetHeightOrRadius() {
    assertEquals(100.0, this.shape1.getHeightOrRadius(), 0.01);
    assertEquals(10.5, this.shape2.getHeightOrRadius(), 0.01);
    assertEquals(8000000000.666666, this.shape3.getHeightOrRadius(), 0.01);

  }

  /**
   * Test get coordinate x.
   */
  @Test
  public void testGetCoordinateX() {
    assertEquals(200.0, this.shape1.getCoordinateX(), 0.01);
    assertEquals(1.0, this.shape2.getCoordinateX(), 0.01);
    assertEquals(150000.6, this.shape3.getCoordinateX(), 0.01);


  }

  /**
   * Test get coordinate y.
   */
  @Test
  public void testGetCoordinateY() {
    assertEquals(200.0, this.shape1.getCoordinateY(), 0.01);
    assertEquals(2.0, this.shape2.getCoordinateY(), 0.01);
    assertEquals(855555555.6666, this.shape3.getCoordinateY(), 0.01);

  }

  /**
   * Test get color.
   */
  @Test
  public void testGetColor() {
    assertEquals("(1.0,1.0,1.0)", this.shape1.getColor().toString());
    assertEquals("(0.0,0.0,0.0)", this.shape2.getColor().toString());
    assertEquals("(0.6,1.0,0.8)", this.shape3.getColor().toString());

  }

  /**
   * Test set width or radius x.
   */
  @Test
  public void testSetWidthOrRadiusX() {
    this.shape1.setWidthOrRadius(55);
    assertEquals(55, this.shape1.getWidthOrRadius(), 0.01);
    this.shape2.setWidthOrRadius(200);
    assertEquals(200, this.shape2.getWidthOrRadius(), 0.01);
    this.shape3.setWidthOrRadius(100);
    assertEquals(100, this.shape3.getWidthOrRadius(), 0.01);


  }

  /**
   * Test set height or radius.
   */
  @Test
  public void testSetHeightOrRadius() {
    this.shape1.setHeightOrRadius(80);
    assertEquals(80, this.shape1.getHeightOrRadius(), 0.01);
    this.shape2.setHeightOrRadius(8000);
    assertEquals(8000, this.shape2.getHeightOrRadius(), 0.01);
    this.shape3.setHeightOrRadius(900);
    assertEquals(900, this.shape3.getHeightOrRadius(), 0.01);


  }

  /**
   * Test set coordinate x.
   */
  @Test
  public void testSetCoordinateX() {
    this.shape1.setCoordinateX(-600);
    assertEquals(-600, this.shape1.getCoordinateX(), 0.01);
    this.shape2.setCoordinateX(900000);
    assertEquals(900000, this.shape2.getCoordinateX(), 0.01);
    this.shape3.setCoordinateX(8500);
    assertEquals(8500, this.shape3.getCoordinateX(), 0.01);


  }

  /**
   * Test set coordinate y.
   */
  @Test
  public void testSetCoordinateY() {
    this.shape1.setCoordinateY(78500.666);
    assertEquals(78500.666, this.shape1.getCoordinateY(), 0.01);
    this.shape2.setCoordinateY(120.63);
    assertEquals(120.63, this.shape2.getCoordinateY(), 0.01);
    this.shape3.setCoordinateY(-960.065);
    assertEquals(-960.065, this.shape3.getCoordinateY(), 0.01);


  }

  /**
   * Test set color.
   */
  @Test
  public void testSetColor() {
    this.shape1.setColor(new Color(0.5, 0.5, 0.4));
    assertEquals("(0.5,0.5,0.4)", this.shape1.getColor().toString());
    this.shape2.setColor(new Color(0.1, 0.2, 0.3));
    assertEquals("(0.1,0.2,0.3)", this.shape2.getColor().toString());
    this.shape3.setColor(new Color(1.0, 0.9, 0.0));
    assertEquals("(1.0,0.9,0.0)", this.shape3.getColor().toString());


  }


  /**
   * Test equals.
   */
  @Test
  public void testEquals() {
    assertTrue(this.shape1.equals(this.shape1.copy()));
    assertTrue(this.shape2.equals(this.shape2.copy()));
    assertTrue(this.shape3.equals(this.shape3.copy()));
    assertFalse(this.shape1.equals(this.shape2));
    assertFalse(this.shape2.equals(this.shape3));
    assertFalse(this.shape1.equals(this.shape3));

  }

  /**
   * Test hash code.
   */
  @Test
  public void testHashCode() {
    assertEquals(2.13858607E9, this.shape1.hashCode(), 0.01);
    assertEquals(-1.422335823E9, this.shape2.hashCode(), 0.01);
    assertEquals(6.16231639E8, this.shape3.hashCode(), 0.01);
  }


  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    assertEquals("Name: R\n"
            + "Type: rectangle\n"
            + "Min corner: (200.0, 200.0), Width: 50.0, Height: 100.0, Color: (1.0,1.0,1.0)",
        this.shape1.toString());
    assertEquals("Name: O\n"
            + "Type: oval\n"
            + "Center: (1.0, 2.0), Width: 5.5, Height: 10.5, Color: (0.0,0.0,0.0)",
        this.shape2.toString());
    assertEquals("Name: Beautiful Rectangle\n"
        + "Type: RECTANGLE\n"
        + "Min corner: (150000.6, 8.555555556666E8), Width: 5000000.0, "
        + "Height: 8.000000000666666E9, Color: (0.6,1.0,0.8)", this.shape3.toString());

  }

  /**
   * Test exception 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testException1() {
    this.shape4 = new Rectangle("", "", 0, 0,
        0, 0, new Color(-966, -966, 966));
  }

  /**
   * Test exception 2.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testException2() {
    this.shape4 = new Oval(null, null, -966, -60000,
        0, 0, new Color(-9, -9668888, 96600000));
  }

}
