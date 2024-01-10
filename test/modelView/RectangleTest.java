package modelView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import model.Color;
import model.IShape;
import model.Rectangle;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Rectangle test.
 */
public class RectangleTest {

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
    this.shape2 = new Rectangle("YYYYYYYYYYYYYYYYYYYYYYYYYYY",
        "RECTANGLE", 696, 648,
        -8251, 9642, new Color(0.0, 0.0, 0.0));
    this.shape3 = new Rectangle("Yes Rectangle",
        "rectangle", 50.0, 50.0,
        200.0, 300.0, new Color(0.0, 0.0, 0.0));
  }

  /**
   * Test Gets area.
   */
  @Test
  public void testGetArea() {
    assertEquals(5000.0, this.shape1.getArea(), 0.01);
    assertEquals(451008.0, this.shape2.getArea(), 0.01);
    assertEquals(2500.0, this.shape3.getArea(), 0.01);
  }

  /**
   * Test Copy.
   */
  @Test
  public void testCopy() {
    assertTrue(this.shape1.equals(this.shape1.copy()));
    assertTrue(this.shape2.equals(this.shape2.copy()));
    assertTrue(this.shape3.equals(this.shape3.copy()));
    assertFalse(this.shape1.equals(this.shape2.copy()));
    assertFalse(this.shape2.equals(this.shape1.copy()));
    assertFalse(this.shape3.equals(this.shape1.copy()));
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
    assertEquals("Name: YYYYYYYYYYYYYYYYYYYYYYYYYYY\n"
            + "Type: RECTANGLE\n"
            + "Min corner: (-8251.0, 9642.0), Width: 696.0, Height: 648.0, Color: (0.0,0.0,0.0)",
        this.shape2.toString());
    assertEquals("Name: Yes Rectangle\n"
            + "Type: rectangle\n"
            + "Min corner: (200.0, 300.0), Width: 50.0, Height: 50.0, Color: (0.0,0.0,0.0)",
        this.shape3.toString());
  }

  /**
   * Test exception 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testException1() {
    this.shape4 = new Rectangle("", "", -500,
        -600, 0.0, 0.0, new Color(5.5, 5.5, 5.5));

  }

  /**
   * Test exception 2.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testException2() {
    this.shape4 = new Rectangle(null, null,
        0.0, 0.0, -98, 98,
        new Color(0.0, 0.0, 52));
  }
}