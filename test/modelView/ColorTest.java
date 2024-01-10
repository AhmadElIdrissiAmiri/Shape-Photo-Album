package modelView;

import static org.junit.Assert.assertEquals;

import model.Color;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Color test.
 */
public class ColorTest {

  /**
   * The Color 1.
   */
  private Color color1;
  /**
   * The Color 2.
   */
  private Color color2;
  /**
   * The Color 3.
   */
  private Color color3;

  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    this.color1 = new Color(0.1, 0.1, 0.1);
    this.color2 = new Color(0.0, 0.0, 1.0);

  }

  /**
   * test Gets r.
   */
  @Test
  public void testGetR() {
    assertEquals(0.1, this.color1.getR(), 0.01);
    assertEquals(0.0, this.color2.getR(), 0.01);
  }

  /**
   * test Gets g.
   */
  @Test
  public void getG() {
    assertEquals(0.1, this.color1.getG(), 0.01);
    assertEquals(0.0, this.color2.getG(), 0.01);
  }

  /**
   * test Gets b.
   */
  @Test
  public void testGetB() {
    assertEquals(0.1, this.color1.getB(), 0.01);
    assertEquals(1.0, this.color2.getB(), 0.01);
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    assertEquals("(0.1,0.1,0.1)", this.color1.toString());
    assertEquals("(0.0,0.0,1.0)", this.color2.toString());
  }

  /**
   * Test exception 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testException1() {
    this.color3 = new Color(-5000, 9000, -93620);

  }

  /**
   * Test exception 2.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testException2() {
    this.color3 = new Color(11111, 1111, 5555);

  }

  /**
   * Test exception 3.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testException3() {
    this.color3 = new Color(1.01, 1.01, 1.02);

  }
}