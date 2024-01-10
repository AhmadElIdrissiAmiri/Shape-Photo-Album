package modelView;

import static org.junit.Assert.assertEquals;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Color;
import model.IShape;
import model.ISnapShot;
import model.Oval;
import model.Rectangle;
import model.Snapshot;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Snapshot test.
 */
public class SnapshotTest {

  private IShape shape1;
  private IShape shape2;
  private IShape shape3;
  private IShape shape4;
  private IShape shape5;
  private ISnapShot snapShot1;
  private ISnapShot snapShot2;
  private ISnapShot snapShot3;
  private LocalDateTime timeNow = LocalDateTime.now();
  private String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(
      Calendar.getInstance().getTime());
  private List<IShape> list1 = new ArrayList<>();
  private List<IShape> list2 = new ArrayList<>();
  private List<IShape> list3 = new ArrayList<>();


  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    this.shape1 = new Rectangle("R", "Rectangle", 50.0,
        12.0, 500.0, 500.0, new Color(1.0, 0.0, 0.0));
    this.shape2 = new Oval("O", "Oval", 50.0,
        15, 600, 4000, new Color(0.0, 0.0, 0.0));
    this.shape3 = new Rectangle("Yes Rectangle",
        "rectangle", 50.0, 50.0,
        200.0, 300.0, new Color(0.0, 0.0, 0.0));
    this.shape4 = new Oval("Awesome Oval", "Oval",
        85.6, 976.6,
        125.0, 500.6, new Color(0.7, 1.0, 1.0));
    this.shape5 = new Oval("OVAL", "Oval",
        78, 98.25,
        175.0, 425.6, new Color(0.8, 1.0, 1.0));
    this.list1.add(this.shape1);
    this.list1.add(this.shape2);
    this.list1.add(this.shape3);
    this.list1.add(this.shape4);
    this.list2.add(this.shape1);
    this.list2.add(this.shape2);
    this.list2.add(this.shape3);
    this.list2.add(this.shape4);
    this.list2.add(this.shape5);
    this.snapShot1 = new Snapshot(this.timeNow, this.timeStamp,
        "This is my snapshot", this.list1);
    this.snapShot2 = new Snapshot(this.timeNow, this.timeStamp,
        "This is my favorite shape ever", this.list2);
    this.snapShot3 = new Snapshot(this.timeNow, this.timeStamp,
        "Hello From the other side Shape", this.list3);
  }

  /**
   * Test Gets snapshot id.
   */
  @Test
  public void testGetSnapShotID() {
    assertEquals("2022-11-29T15:19:04.988948800", this.snapShot1.getSnapShotID());
    assertEquals("2022-11-29T15:22:05.988948810", this.snapShot2.getSnapShotID());
    assertEquals("2022-11-29T16:13:09.609411200", this.snapShot3.getSnapShotID());
  }

  /**
   * Test Gets snapshot time stamp.
   */
  @Test
  public void testGetSnapShotTimeStamp() {
    assertEquals("29-11-2022 15:34:08", this.snapShot1.getSnapShotTimeStamp());
    assertEquals("29-11-2022 15:45:10", this.snapShot2.getSnapShotTimeStamp());
    assertEquals("29-11-2022 16:15:08", this.snapShot3.getSnapShotTimeStamp());

  }

  /**
   * Test Gets snapshot description.
   */
  @Test
  public void testGetSnapShotDescription() {
    assertEquals("This is my snapshot", this.snapShot1.getSnapShotDescription());
    assertEquals("This is my favorite shape ever", this.snapShot2.getSnapShotDescription());
    assertEquals("Hello From the other side Shape", this.snapShot3.getSnapShotDescription());
  }

  /**
   * Gets shape information.
   */
  @Test
  public void testGetShapeInformation() {
    assertEquals("Name: R\n"
            + "Type: Rectangle\n"
            + "Min corner: (500.0, 500.0), Width: 50.0, Height: 12.0, Color: (1.0,0.0,0.0)\n"
            + "\n"
            + "Name: O\n"
            + "Type: Oval\n"
            + "Center: (600.0, 4000.0), Width: 50.0, Height: 15.0, Color: (0.0,0.0,0.0)\n"
            + "\n"
            + "Name: Yes Rectangle\n"
            + "Type: rectangle\n"
            + "Min corner: (200.0, 300.0), Width: 50.0, Height: 50.0, Color: (0.0,0.0,0.0)\n"
            + "\n"
            + "Name: Awesome Oval\n"
            + "Type: Oval\n"
            + "Center: (125.0, 500.6), Width: 85.6, Height: 976.6, Color: (0.7,1.0,1.0)" + "\n\n",
        this.snapShot1.getShapeInformation());
    assertEquals("Name: R\n"
            + "Type: Rectangle\n"
            + "Min corner: (500.0, 500.0), Width: 50.0, Height: 12.0, Color: (1.0,0.0,0.0)\n"
            + "\n"
            + "Name: O\n"
            + "Type: Oval\n"
            + "Center: (600.0, 4000.0), Width: 50.0, Height: 15.0, Color: (0.0,0.0,0.0)\n"
            + "\n"
            + "Name: Yes Rectangle\n"
            + "Type: rectangle\n"
            + "Min corner: (200.0, 300.0), Width: 50.0, Height: 50.0, Color: (0.0,0.0,0.0)\n"
            + "\n"
            + "Name: Awesome Oval\n"
            + "Type: Oval\n"
            + "Center: (125.0, 500.6), Width: 85.6, Height: 976.6, Color: (0.7,1.0,1.0)\n"
            + "\n"
            + "Name: OVAL\n"
            + "Type: Oval\n"
            + "Center: (175.0, 425.6), Width: 78.0, Height: 98.25, Color: (0.8,1.0,1.0)\n\n",
        this.snapShot2.getShapeInformation());
    assertEquals("", this.snapShot3.getShapeInformation());
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    assertEquals("Snapshot ID: 2022-11-29T15:40:54.964951100\n"
            + "Timestamp: 29-11-2022 15:40:55\n"
            + "Description: This is my snapshot\n"
            + "Shape information:\n"
            + "Name: R\n"
            + "Type: Rectangle\n"
            + "Min corner: (500.0, 500.0), Width: 50.0, Height: 12.0, Color: (1.0,0.0,0.0)\n"
            + "\n"
            + "Name: O\n"
            + "Type: Oval\n"
            + "Center: (600.0, 4000.0), Width: 50.0, Height: 15.0, Color: (0.0,0.0,0.0)\n"
            + "\n"
            + "Name: Yes Rectangle\n"
            + "Type: rectangle\n"
            + "Min corner: (200.0, 300.0), Width: 50.0, Height: 50.0, Color: (0.0,0.0,0.0)\n"
            + "\n"
            + "Name: Awesome Oval\n"
            + "Type: Oval\n"
            + "Center: (125.0, 500.6), Width: 85.6, Height: 976.6, Color: (0.7,1.0,1.0)\n\n",
        this.snapShot1.toString());
    assertEquals("Snapshot ID: 2022-11-29T16:16:29.687645200\n"
            + "Timestamp: 29-11-2022 16:16:29\n"
            + "Description: This is my favorite shape ever\n"
            + "Shape information:\n"
            + "Name: R\n"
            + "Type: Rectangle\n"
            + "Min corner: (500.0, 500.0), Width: 50.0, Height: 12.0, Color: (1.0,0.0,0.0)\n"
            + "\n"
            + "Name: O\n"
            + "Type: Oval\n"
            + "Center: (600.0, 4000.0), Width: 50.0, Height: 15.0, Color: (0.0,0.0,0.0)\n"
            + "\n"
            + "Name: Yes Rectangle\n"
            + "Type: rectangle\n"
            + "Min corner: (200.0, 300.0), Width: 50.0, Height: 50.0, Color: (0.0,0.0,0.0)\n"
            + "\n"
            + "Name: Awesome Oval\n"
            + "Type: Oval\n"
            + "Center: (125.0, 500.6), Width: 85.6, Height: 976.6, Color: (0.7,1.0,1.0)\n"
            + "\n"
            + "Name: OVAL\n"
            + "Type: Oval\n"
            + "Center: (175.0, 425.6), Width: 78.0, Height: 98.25, Color: (0.8,1.0,1.0)\n\n",
        this.snapShot2.toString());
    assertEquals("Snapshot ID: 2022-11-29T16:17:22.146186\n"
        + "Timestamp: 29-11-2022 16:17:22\n"
        + "Description: Hello From the other side Shape\n"
        + "Shape information:", this.snapShot3.toString());
  }

  /**
   * Test exception 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testException1() {
    this.snapShot3 = new Snapshot(LocalDateTime.now(), "", "My snapshot",
        this.list1);

  }

  /**
   * Test exception 2.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testException2() {
    this.snapShot3 = new Snapshot(LocalDateTime.now(), null, "", null);

  }

  /**
   * Test exception 3.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testException3() {
    this.snapShot3 = new Snapshot(LocalDateTime.now(), null, "Based shape ever",
        this.list1);

  }
}