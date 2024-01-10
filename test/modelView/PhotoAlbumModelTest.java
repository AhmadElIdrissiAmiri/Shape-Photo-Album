package modelView;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Predicate;
import model.Color;
import model.IPhotoAlbum;
import model.IShape;
import model.ISnapShot;
import model.Oval;
import model.PhotoAlbumModel;
import model.Rectangle;
import model.Snapshot;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Photo album model test.
 */
public class PhotoAlbumModelTest {

  private IShape shape1;
  private IShape shape2;
  private IShape shape3;
  private IShape shape4;
  private IShape shape5;

  private IPhotoAlbum photoAlbum1;
  private ISnapShot snapShot1;
  private ISnapShot snapShot2;
  private ISnapShot snapShot3;
  private String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(
      Calendar.getInstance().getTime());
  private LinkedHashMap<String, IShape> linkedHashMap;
  private List<ISnapShot> snapShotList;

  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    this.photoAlbum1 = new PhotoAlbumModel();
    this.linkedHashMap = new LinkedHashMap<>();
    this.snapShotList = new ArrayList<>();
    this.shape1 = new Rectangle("R", "rectangle", 50.0,
        100.0, 200.0, 200.0, new Color(1.0, 1.0, 1.0));
    this.shape2 = new Oval("O", "oval", 5.5,
        10.5, 1.0, 2.0, new Color(0.0, 0.0, 0.0));
    this.shape3 = new Rectangle("Beautiful Rectangle", "RECTANGLE",
        5000000.0, 80000.6666, 1500.6,
        85555.666, new Color(0.6, 1.0, 0.8));
    this.shape4 = new Oval("Beautiful Oval", "oval",
        500.0, 800.66, 158.6,
        85.66, new Color(0.7, 0.7, 0.7));
    this.shape5 = new Oval("Big Oval", "oval",
        508.0, 808.66, 165.6,
        845.66, new Color(0.8, 0.8, 0.0));

    this.linkedHashMap.put("R", this.shape1);
    this.linkedHashMap.put("O", this.shape1);
    this.linkedHashMap.put("Beautiful Rectangle", this.shape1);
    this.linkedHashMap.put("Beautiful Oval", this.shape1);
    this.snapShot1 = new Snapshot(LocalDateTime.now(), this.timeStamp,
        "This is my first snapshot",
        this.linkedHashMap.values().stream().toList());
    this.snapShot2 = new Snapshot(LocalDateTime.now(), this.timeStamp,
        "This is my second snapshot",
        this.linkedHashMap.values().stream().toList());
    this.linkedHashMap.put("Big Oval", this.shape5);
    this.snapShot3 = new Snapshot(LocalDateTime.now(), this.timeStamp,
        "This is my third snapshot",
        this.linkedHashMap.values().stream().toList());


  }


  /**
   * Test create.
   */
  @Test
  public void testCreate() {
    this.photoAlbum1.create("R", "rectangle", 50.0,
        100.0, 200.0, 200.0, new Color(1.0, 1.0, 1.0));
    this.photoAlbum1.create("O", "oval", 5.5,
        10.5, 1.0, 2.0, new Color(0.0, 0.0, 0.0));
    this.photoAlbum1.create("Beautiful Rectangle", "RECTANGLE",
        5000000.0, 80000.6666, 1500.6,
        85555.666, new Color(0.6, 1.0, 0.8));
    this.photoAlbum1.create("Beautiful Oval", "oval",
        500.0, 800.66, 158.6,
        85.66, new Color(0.7, 0.7, 0.7));
    this.photoAlbum1.create("Big Oval", "oval",
        508.0, 808.66, 165.6,
        845.66, new Color(0.8, 0.8, 0.0));
  }

  /**
   * Test add shapes to album.
   */
  @Test
  public void testAddShapesToAlbum() {
    this.photoAlbum1.addShapesToAlbum("R", this.shape1);
    this.photoAlbum1.addShapesToAlbum("O", this.shape2);
    this.photoAlbum1.addShapesToAlbum("Beautiful Rectangle", this.shape3);
    this.photoAlbum1.addShapesToAlbum("Beautiful Oval", this.shape4);
    this.photoAlbum1.addShapesToAlbum("Big Oval", this.shape5);
  }


  /**
   * Test remove shapes from album.
   */
  @Test
  public void testRemoveShapesFromAlbum() {
    this.photoAlbum1.addShapesToAlbum("R", this.shape1);
    this.photoAlbum1.addShapesToAlbum("O", this.shape2);
    this.photoAlbum1.addShapesToAlbum("Beautiful Rectangle", this.shape3);
    this.photoAlbum1.removeShapesFromAlbum("R");
    this.photoAlbum1.removeShapesFromAlbum("O");
    this.photoAlbum1.removeShapesFromAlbum("Beautiful Rectangle");
  }

  /**
   * Test get shape.
   */
  @Test
  public void testGetShape() {
    this.photoAlbum1.addShapesToAlbum("R", this.shape1);
    this.photoAlbum1.addShapesToAlbum("O", this.shape2);
    this.photoAlbum1.addShapesToAlbum("Beautiful Rectangle", this.shape3);
    assertEquals("Name: R\n"
            + "Type: rectangle\n"
            + "Min corner: (200.0, 200.0), Width: 50.0, Height: 100.0, Color: (1.0,1.0,1.0)",
        this.photoAlbum1.getShape("R").toString());
    assertEquals("Name: O\n"
            + "Type: oval\n"
            + "Center: (1.0, 2.0), Width: 5.5, Height: 10.5, Color: (0.0,0.0,0.0)",
        this.photoAlbum1.getShape("O").toString());
    assertEquals("Name: Beautiful Rectangle\n"
            + "Type: RECTANGLE\n"
            + "Min corner: (1500.6, 85555.666), Width: 5000000.0, Height: 80000.6666, "
            + "Color: (0.6,1.0,0.8)",
        this.photoAlbum1.getShape("Beautiful Rectangle").toString());
  }

  /**
   * Test move shape.
   */
  @Test
  public void testMoveShape() {
    this.photoAlbum1.addShapesToAlbum("R", this.shape1);
    this.photoAlbum1.addShapesToAlbum("O", this.shape2);
    this.photoAlbum1.addShapesToAlbum("Beautiful Rectangle", this.shape3);
    this.photoAlbum1.moveShape("R", 50.55, 60.55);
    assertEquals("Name: R\n"
            + "Type: rectangle\n"
            + "Min corner: (50.55, 60.55), Width: 50.0, Height: 100.0, Color: (1.0,1.0,1.0)",
        this.photoAlbum1.getShape("R").toString());
    this.photoAlbum1.moveShape("O", 85.5, -85);
    assertEquals("Name: O\n"
            + "Type: oval\n"
            + "Center: (85.5, -85.0), Width: 5.5, Height: 10.5, Color: (0.0,0.0,0.0)",
        this.photoAlbum1.getShape("O").toString());
    this.photoAlbum1.moveShape("Beautiful Rectangle",
        -625, -500);
    assertEquals("Name: Beautiful Rectangle\n"
            + "Type: RECTANGLE\n"
            + "Min corner: (-625.0, -500.0), Width: 5000000.0, Height: 80000.6666, "
            + "Color: (0.6,1.0,0.8)",
        this.photoAlbum1.getShape("Beautiful Rectangle").toString());
  }

  /**
   * Test change dimensions of shape.
   */
  @Test
  public void testChangeDimensionsOfShape() {
    this.photoAlbum1.addShapesToAlbum("R", this.shape1);
    this.photoAlbum1.addShapesToAlbum("O", this.shape2);
    this.photoAlbum1.addShapesToAlbum("Beautiful Rectangle", this.shape3);
    this.photoAlbum1.changeDimensionsOfShape("R",
        78.9, 85);
    assertEquals("Name: R\n"
            + "Type: rectangle\n"
            + "Min corner: (200.0, 200.0), Width: 78.9, Height: 85.0, Color: (1.0,1.0,1.0)",
        this.photoAlbum1.getShape("R").toString());
    this.photoAlbum1.changeDimensionsOfShape("O",
        52.8, 85.6);
    assertEquals("Name: O\n"
            + "Type: oval\n"
            + "Center: (1.0, 2.0), Width: 52.8, Height: 85.6, Color: (0.0,0.0,0.0)",
        this.photoAlbum1.getShape("O").toString());
    this.photoAlbum1.changeDimensionsOfShape("Beautiful Rectangle",
        12.5, 8.5);
    assertEquals("Name: Beautiful Rectangle\n"
            + "Type: RECTANGLE\n"
            + "Min corner: (1500.6, 85555.666), Width: 12.5, Height: 8.5, Color: (0.6,1.0,0.8)",
        this.photoAlbum1.getShape("Beautiful Rectangle").toString());
  }

  /**
   * Test change color.
   */
  @Test
  public void testChangeColor() {
    this.photoAlbum1.addShapesToAlbum("R", this.shape1);
    this.photoAlbum1.addShapesToAlbum("O", this.shape2);
    this.photoAlbum1.addShapesToAlbum("Beautiful Rectangle", this.shape3);
    this.photoAlbum1.changeColor("R", new Color(1.0, 1.0, 0.5));
    assertEquals("Name: R\n"
            + "Type: rectangle\n"
            + "Min corner: (200.0, 200.0), Width: 50.0, Height: 100.0, Color: (1.0,1.0,0.5)",
        this.photoAlbum1.getShape("R").toString());
    this.photoAlbum1.changeColor("O", new Color(0.8, 0.5, 0.0));
    assertEquals("Name: O\n"
            + "Type: oval\n"
            + "Center: (1.0, 2.0), Width: 5.5, Height: 10.5, Color: (0.8,0.5,0.0)",
        this.photoAlbum1.getShape("O").toString());
    this.photoAlbum1.changeColor("Beautiful Rectangle",
        new Color(0.0, 0.1, 0.8));
    assertEquals("Name: Beautiful Rectangle\n"
            + "Type: RECTANGLE\n"
            + "Min corner: (1500.6, 85555.666), Width: 5000000.0, "
            + "Height: 80000.6666, Color: (0.0,0.1,0.8)",
        this.photoAlbum1.getShape("Beautiful Rectangle").toString());
  }

  /**
   * Test get snapshot i ds.
   */
  @Test
  public void testGetSnapshotIDs() {
    this.photoAlbum1.addShapesToAlbum("R", this.shape1);
    this.photoAlbum1.addShapesToAlbum("O", this.shape2);
    this.photoAlbum1.addShapesToAlbum("Beautiful Rectangle", this.shape3);
    this.photoAlbum1.snapshot("This is my first snapshot");
    this.photoAlbum1.snapshot("This is my second snapshot");
    this.photoAlbum1.snapshot("This is my third snapshot");
    assertEquals("List of snapshots before reset: [2022-11-29T22:18:37.557255100, "
            + "2022-11-29T22:18:37.563274400, 2022-11-29T22:18:37.563274400]",
        this.photoAlbum1.getSnapshotIDs());

  }

  /**
   * Test filter.
   */
  @Test
  public void testFilter() {
    this.photoAlbum1.addShapesToAlbum("R", this.shape1);
    this.photoAlbum1.addShapesToAlbum("O", this.shape2);
    this.photoAlbum1.addShapesToAlbum("Beautiful Rectangle", this.shape3);
    this.photoAlbum1.addShapesToAlbum("Beautiful Oval", this.shape4);
    this.photoAlbum1.addShapesToAlbum("Big Oval", this.shape5);
    this.photoAlbum1.snapshot("");

    Predicate<IShape> pq = shape -> shape.getType().equalsIgnoreCase("rectangle");
    IPhotoAlbum testingFilter = photoAlbum1.filter(pq);

    assertEquals("Name: R\n"
            + "Type: rectangle\n"
            + "Min corner: (200.0, 200.0), Width: 50.0, Height: 100.0, Color: (1.0,1.0,1.0)",
        testingFilter.getShape("R").toString());
    assertEquals("Name: Beautiful Rectangle\n"
            + "Type: RECTANGLE\n"
            + "Min corner: (1500.6, 85555.666), Width: 5000000.0, Height: 80000.6666, "
            + "Color: (0.6,1.0,0.8)",
        testingFilter.getShape("Beautiful Rectangle").toString());
    assertEquals("Name: R\n"
            + "Type: rectangle\n"
            + "Min corner: (200.0, 200.0), Width: 50.0, Height: 100.0, Color: (1.0,1.0,1.0)\n"
            + "Name: Beautiful Rectangle\n"
            + "Type: RECTANGLE\n"
            + "Min corner: (1500.6, 85555.666), Width: 5000000.0, "
            + "Height: 80000.6666, Color: (0.6,1.0,0.8)\n",
        testingFilter.getShapesStrings().toString());
    Predicate<IShape> pq2 = shape -> shape.getType().equalsIgnoreCase("oval");
    IPhotoAlbum testingFilter1 = photoAlbum1.filter(pq2);
    assertEquals("Name: O\n"
            + "Type: oval\n"
            + "Center: (1.0, 2.0), Width: 5.5, Height: 10.5, Color: (0.0,0.0,0.0)\n"
            + "Name: Beautiful Oval\n"
            + "Type: oval\n"
            + "Center: (158.6, 85.66), Width: 500.0, Height: 800.66, Color: (0.7,0.7,0.7)\n"
            + "Name: Big Oval\n"
            + "Type: oval\n"
            + "Center: (165.6, 845.66), Width: 508.0, Height: 808.66, Color: (0.8,0.8,0.0)\n",
        testingFilter1.getShapesStrings().toString());

  }

  /**
   * Test sort.
   */
  @Test
  public void testSort() {
    this.photoAlbum1.addShapesToAlbum("R", this.shape1);
    this.photoAlbum1.addShapesToAlbum("O", this.shape2);
    this.photoAlbum1.addShapesToAlbum("Beautiful Rectangle", this.shape3);
    this.photoAlbum1.addShapesToAlbum("Beautiful Oval", this.shape4);
    this.photoAlbum1.addShapesToAlbum("Big Oval", this.shape5);
    this.photoAlbum1.snapshot("This is my first snapshot");
    this.photoAlbum1.snapshot("This is my second snapshot");
    this.photoAlbum1.snapshot("This is my third snapshot");

    Comparator<IShape> sortingBasedOnArea = (shape1, shape2) ->
        Double.compare(shape1.getArea(), shape2.getArea());
    this.photoAlbum1.sort(sortingBasedOnArea);
    assertEquals("Name: O\n"
        + "Type: oval\n"
        + "Center: (1.0, 2.0), Width: 5.5, Height: 10.5, Color: (0.0,0.0,0.0)\n"
        + "Name: R\n"
        + "Type: rectangle\n"
        + "Min corner: (200.0, 200.0), Width: 50.0, Height: 100.0, Color: (1.0,1.0,1.0)\n"
        + "Name: Beautiful Oval\n"
        + "Type: oval\n"
        + "Center: (158.6, 85.66), Width: 500.0, Height: 800.66, Color: (0.7,0.7,0.7)\n"
        + "Name: Big Oval\n"
        + "Type: oval\n"
        + "Center: (165.6, 845.66), Width: 508.0, Height: 808.66, Color: (0.8,0.8,0.0)\n"
        + "Name: Beautiful Rectangle\n"
        + "Type: RECTANGLE\n"
        + "Min corner: (1500.6, 85555.666), Width: 5000000.0, Height: "
        + "80000.6666, Color: (0.6,1.0,0.8)\n", this.photoAlbum1.getShapesStrings().toString());

  }

  /**
   * Test snapshot.
   */
  @Test
  public void testSnapshot() {
    this.photoAlbum1.addShapesToAlbum("R", this.shape1);
    this.photoAlbum1.addShapesToAlbum("O", this.shape2);
    this.photoAlbum1.addShapesToAlbum("Beautiful Rectangle", this.shape3);
    this.photoAlbum1.snapshot("This is my first snapshot");
    this.photoAlbum1.snapshot("This is my second snapshot");
    this.photoAlbum1.snapshot("This is my third snapshot");
    assertEquals("Printing Snapshots\n"
        + "Snapshot ID: 2022-11-29T22:12:38.368553200\n"
        + "Timestamp: 29-11-2022 22:12:38\n"
        + "Description: This is my first snapshot\n"
        + "Shape information:\n"
        + "Name: R\n"
        + "Type: rectangle\n"
        + "Min corner: (200.0, 200.0), Width: 50.0, Height: 100.0, Color: (1.0,1.0,1.0)\n"
        + "\n"
        + "Name: O\n"
        + "Type: oval\n"
        + "Center: (1.0, 2.0), Width: 5.5, Height: 10.5, Color: (0.0,0.0,0.0)\n"
        + "\n"
        + "Name: Beautiful Rectangle\n"
        + "Type: RECTANGLE\n"
        + "Min corner: (1500.6, 85555.666), Width: 5000000.0, Height: 80000.6666, "
        + "Color: (0.6,1.0,0.8)\n"
        + "\n"
        + "Snapshot ID: 2022-11-29T22:12:38.374575400\n"
        + "Timestamp: 29-11-2022 22:12:38\n"
        + "Description: This is my second snapshot\n"
        + "Shape information:\n"
        + "Name: R\n"
        + "Type: rectangle\n"
        + "Min corner: (200.0, 200.0), Width: 50.0, Height: 100.0, Color: (1.0,1.0,1.0)\n"
        + "\n"
        + "Name: O\n"
        + "Type: oval\n"
        + "Center: (1.0, 2.0), Width: 5.5, Height: 10.5, Color: (0.0,0.0,0.0)\n"
        + "\n"
        + "Name: Beautiful Rectangle\n"
        + "Type: RECTANGLE\n"
        + "Min corner: (1500.6, 85555.666), Width: 5000000.0, Height: "
        + "80000.6666, Color: (0.6,1.0,0.8)\n"
        + "\n"
        + "Snapshot ID: 2022-11-29T22:12:38.374575400\n"
        + "Timestamp: 29-11-2022 22:12:38\n"
        + "Description: This is my third snapshot\n"
        + "Shape information:\n"
        + "Name: R\n"
        + "Type: rectangle\n"
        + "Min corner: (200.0, 200.0), Width: 50.0, Height: 100.0, Color: (1.0,1.0,1.0)\n"
        + "\n"
        + "Name: O\n"
        + "Type: oval\n"
        + "Center: (1.0, 2.0), Width: 5.5, Height: 10.5, Color: (0.0,0.0,0.0)\n"
        + "\n"
        + "Name: Beautiful Rectangle\n"
        + "Type: RECTANGLE\n"
        + "Min corner: (1500.6, 85555.666), Width: 5000000.0, Height: 80000.6666, Color: "
        + "(0.6,1.0,0.8)\n"
        + "\n"
        + "\n", this.photoAlbum1.toString());


  }

  /**
   * Test reset.
   */
  @Test
  public void testReset() {
    this.photoAlbum1.reset();
    assertEquals("", this.photoAlbum1.toString());
  }


  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    this.photoAlbum1.addShapesToAlbum("R", this.shape1);
    this.photoAlbum1.addShapesToAlbum("O", this.shape2);
    this.photoAlbum1.addShapesToAlbum("Beautiful Rectangle", this.shape3);
    this.photoAlbum1.snapshot("This is my first snapshot");
    this.photoAlbum1.snapshot("This is my second snapshot");
    this.photoAlbum1.snapshot("This is my third snapshot");
    assertEquals("Printing Snapshots\n"
        + "Snapshot ID: 2022-11-29T22:11:36.105248\n"
        + "Timestamp: 29-11-2022 22:11:36\n"
        + "Description: This is my first snapshot\n"
        + "Shape information:\n"
        + "Name: R\n"
        + "Type: rectangle\n"
        + "Min corner: (200.0, 200.0), Width: 50.0, Height: 100.0, Color: (1.0,1.0,1.0)\n"
        + "\n"
        + "Name: O\n"
        + "Type: oval\n"
        + "Center: (1.0, 2.0), Width: 5.5, Height: 10.5, Color: (0.0,0.0,0.0)\n"
        + "\n"
        + "Name: Beautiful Rectangle\n"
        + "Type: RECTANGLE\n"
        + "Min corner: (1500.6, 85555.666), Width: 5000000.0, "
        + "Height: 80000.6666, Color: (0.6,1.0,0.8)\n"
        + "\n"
        + "Snapshot ID: 2022-11-29T22:11:36.109247\n"
        + "Timestamp: 29-11-2022 22:11:36\n"
        + "Description: This is my second snapshot\n"
        + "Shape information:\n"
        + "Name: R\n"
        + "Type: rectangle\n"
        + "Min corner: (200.0, 200.0), Width: 50.0, Height: 100.0, Color: (1.0,1.0,1.0)\n"
        + "\n"
        + "Name: O\n"
        + "Type: oval\n"
        + "Center: (1.0, 2.0), Width: 5.5, Height: 10.5, Color: (0.0,0.0,0.0)\n"
        + "\n"
        + "Name: Beautiful Rectangle\n"
        + "Type: RECTANGLE\n"
        + "Min corner: (1500.6, 85555.666), Width: 5000000.0, "
        + "Height: 80000.6666, Color: (0.6,1.0,0.8)\n"
        + "\n"
        + "Snapshot ID: 2022-11-29T22:11:36.110257500\n"
        + "Timestamp: 29-11-2022 22:11:36\n"
        + "Description: This is my third snapshot\n"
        + "Shape information:\n"
        + "Name: R\n"
        + "Type: rectangle\n"
        + "Min corner: (200.0, 200.0), Width: 50.0, Height: 100.0, Color: (1.0,1.0,1.0)\n"
        + "\n"
        + "Name: O\n"
        + "Type: oval\n"
        + "Center: (1.0, 2.0), Width: 5.5, Height: 10.5, Color: (0.0,0.0,0.0)\n"
        + "\n"
        + "Name: Beautiful Rectangle\n"
        + "Type: RECTANGLE\n"
        + "Min corner: (1500.6, 85555.666), Width: 5000000.0, "
        + "Height: 80000.6666, Color: (0.6,1.0,0.8)\n"
        + "\n"
        + "\n", this.photoAlbum1.toString());


  }

  /**
   * Test exception 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testException1() {

  }

  /**
   * Test exception 2.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testException2() {
    this.photoAlbum1.snapshot("");

  }

  /**
   * Test exception 3.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testException3() {
    this.photoAlbum1.addShapesToAlbum("", null);

  }

  /**
   * Test exception 4.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testException4() {

  }
}