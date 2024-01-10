package modelView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import model.Color;
import model.IShape;
import model.Oval;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Oval test.
 */
public class OvalTest {

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
    this.shape1 = new Oval("O", "oval", 5.5,
        10.5, 1.0, 2.0, new Color(0.0, 0.0, 0.0));
    this.shape2 = new Oval("Beautiful Oval", "OVAL",
        1052.36, 0.52, -152.3,
        -1698.3, new Color(0.5, 0.6, 0.7));
    this.shape3 = new Oval("Awesome Oval", "Oval",
        85.6, 976.6,
        125.0, 500.6, new Color(0.7, 1.0, 1.0));
  }

  /**
   * Test Gets area.
   */
  @Test
  public void testGetArea() {
    assertEquals(181.42, this.shape1.getArea(), 0.01);
    assertEquals(1719.16, this.shape2.getArea(), 0.01);
    assertEquals(262627.59, this.shape3.getArea(), 0.01);
  }

  /**
   * Test Copy.
   */
  @Test
  public void testCopy() {
    assertTrue(this.shape1.equals(this.shape1.copy()));
    assertTrue(this.shape2.equals(this.shape2.copy()));
    assertFalse(this.shape2.equals(this.shape3.copy()));
    assertFalse(this.shape3.equals(this.shape1.copy()));
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    assertEquals("Name: O\n"
            + "Type: oval\n"
            + "Center: (1.0, 2.0), Width: 5.5, Height: 10.5, Color: (0.0,0.0,0.0)",
        this.shape1.toString());
    assertEquals("Name: Beautiful Oval\n"
            + "Type: OVAL\n"
            + "Center: (-152.3, -1698.3), Width: 1052.36, Height: 0.52, Color: (0.5,0.6,0.7)",
        this.shape2.toString());
    assertEquals("Name: Awesome Oval\n"
            + "Type: Oval\n"
            + "Center: (125.0, 500.6), Width: 85.6, Height: 976.6, Color: (0.7,1.0,1.0)",
        this.shape3.toString());


  }

  /**
   * Test exception 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testException1() {
    this.shape4 = new Oval("", "", -500,
        -600, 0.0, 0.0, new Color(5.5, 5.5, 5.5));

  }

  /**
   * Test exception 2.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testException2() {
    this.shape4 = new Oval(null, null,
        0.0, 0.0, -98, 98,
        new Color(0.0, 0.0, 52));
  }
}