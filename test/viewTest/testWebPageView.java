package viewTest;

import static org.junit.Assert.assertEquals;

import model.Color;
import model.Oval;
import model.PhotoAlbumModel;
import model.Rectangle;
import org.junit.Before;
import org.junit.Test;
import views.WebPageView;


/**
 * test Web Page View class
 */
public class testWebPageView {

  private WebPageView webView;
  private PhotoAlbumModel model;
  private Oval shape1;
  private Rectangle shape2;
  private Oval shape3;
  private Rectangle shape4;


  /**
   * Set Up method
   */
  @Before
  public void setUp() {
    this.model = new PhotoAlbumModel();
    this.shape1 = new Oval("O1", "oval", 35, 35,
        80, 95, new Color(149, 135, 201));
    this.model.addShapesToAlbum("O1", this.shape1);

    this.model.snapshot("This is my little beautiful shape");
    this.shape2 = new Rectangle("R1", "Rectangle",
        100, 150,
        100, 150, new Color(233, 33, 55));
    this.model.addShapesToAlbum("R1", this.shape2);
    this.shape3 = new Oval("O2", "oval", 100, 150,
        300, 300, new Color(185, 255, 200));
    this.model.addShapesToAlbum("O2", this.shape3);
    this.shape4 = new Rectangle("R2", "Rectangle",
        50, 50,
        500, 500, new Color(100, 150, 255));
    this.model.addShapesToAlbum("R2", this.shape4);

    this.model.snapshot("I will never forget you beautiful shapes. "
        + "You will be in my heart forever");

    this.webView = new WebPageView(model.getSnapShotList(),
        "ahmadHtmlFileForTesting.html", 800,
        800);
  }


  /**
   * Test web view.
   */
  @Test
  public void testWebView() {
    this.webView.simpleSVG();
    assertEquals("<!DOCTYPE html>\n"
        + "<html>\n"
        + "<head>\n"
        + "<style>\n"
        + "  .snapshot{\n"
        + "    border: 5px outset red;\n"
        + "   background-color: lightblue;\n"
        + "  }\n"
        + "</style>\n"
        + "</head>\n"
        + "<body>\n"
        + "<h1>A semester to remember.\n"
        + "Your magical PhotoAlbum is here</h1>\n"
        + "<div class=\"snapshot\"><h2>2022-12-10T20:54:49.180671700</h2>\n"
        + "<h2>Description: This is my little beautiful shape</h2>\n"
        + "    <svg width=\"800\" height=\"800\">\n"
        + "     <ellipse id=\"O1\"cx= \"80.0\"cy= \"95.0\"rx= \"35.0\"ry= \"35.0\""
        + "fill= \"rgb(149.0,135.0,201.0)\">\n"
        + "        </ellipse>\n"
        + "</svg>\n"
        + "</div>\n"
        + "</body>\n"
        + "</html><div class=\"snapshot\"><h2>2022-12-10T20:54:49.180671700</h2>\n"
        + "<h2>Description: This is my little beautiful shape</h2>\n"
        + "    <svg width=\"800\" height=\"800\">\n"
        + "     <ellipse id=\"O1\"cx= \"80.0\"cy= \"95.0\"rx= \"35.0"
        + "\"ry= \"35.0\"fill= \"rgb(149.0,135.0,201.0)\">\n"
        + "        </ellipse>\n"
        + "<div class=\"snapshot\"><h2>2022-12-10T20:54:49.259718400</h2>\n"
        + "<h2>Description: I will never forget you beautiful shapes. "
        + "You will be in my heart forever</h2>\n"
        + "    <svg width=\"800\" height=\"800\">\n"
        + "     <ellipse id=\"O1\"cx= \"80.0\"cy= \"95.0\"rx= \"35.0\"ry= \"35.0\""
        + "fill= \"rgb(149.0,135.0,201.0)\">\n"
        + "        </ellipse>\n"
        + "     <rect id=\"R1\"x= \"100.0\"y= \"150.0\""
        + "width= \"100.0\"height= \"150.0\"fill= \"rgb(233.0,33.0,55.0)\">\n"
        + "        </rect>\n"
        + "     <ellipse id=\"O2\"cx= \"300.0\"cy= \"300.0"
        + "\"rx= \"100.0\"ry= \"150.0\"fill= \"rgb(185.0,255.0,200.0)\">\n"
        + "        </ellipse>\n"
        + "     <rect id=\"R2\"x= \"500.0\"y= \"500.0\"width= "
        + "\"50.0\"height= \"50.0\"fill= \"rgb(100.0,150.0,255.0)\">\n"
        + "        </rect>\n"
        + "</svg>\n"
        + "</div>\n"
        + "</body>\n"
        + "</html></svg>\n"
        + "</div>\n"
        + "</body>\n"
        + "</html>", this.webView.getHtmlAsString());
  }

}

