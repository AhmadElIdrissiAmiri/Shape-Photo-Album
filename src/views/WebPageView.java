package views;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import model.IShape;
import model.ISnapShot;

/**
 * This is my class Web page view.
 */
public class WebPageView {

  private List<ISnapShot> snapShotList;
  private int xMax;
  private int yMax;
  private String outPutFile;
  private StringBuilder headerStringBuilder = new StringBuilder();
  private StringBuilder bodyShapesStringBuilder = new StringBuilder();
  private StringBuilder footStringBuilder = new StringBuilder();
  private String htmlAsString;

  /**
   * Instantiates a new Web page view.
   *
   * @param snapShotList the snap shot list
   * @param outPutFile   the out put file
   * @param xMax         the x max
   * @param yMax         the y max
   */
  public WebPageView(List<ISnapShot> snapShotList, String outPutFile, int xMax, int yMax) {
    this.snapShotList = snapShotList;
    this.outPutFile = outPutFile;
    this.xMax = xMax;
    this.yMax = yMax;
    this.htmlAsString = this.headerStringBuilder.append(this.bodyShapesStringBuilder).
        append(this.footStringBuilder).toString();


  }

  /**
   * Simple svg.This is just a simple method to gather all my stringBuilders
   */
  public void simpleSVG() {

    this.headerStringBuilder.append("<!DOCTYPE html>\n"
        + "<html>\n"
        + "<head>"
        + "\n<style>\n  .snapshot{\n    border: 5px outset red;\n   background-color: "
        + "lightblue;\n  }"
        + "\n</style>"
        + "\n</head>"
        + "\n<body>"
        + "\n<h1>A semester to remember.\nYour magical PhotoAlbum is here</h1>\n");
    for (ISnapShot snapShot : this.snapShotList) {
      List<IShape> shapesList = snapShot.getShapes();
      this.bodyShapesStringBuilder.append("<div class=\"snapshot\">" + "<h2>")
          .append(snapShot.getSnapShotID())
          .append("</h2>\n")
          .append("<h2>Description: ")
          .append(snapShot.getSnapShotDescription())
          .append("</h2>\n")
          .append("    <svg width=\"" + this.xMax + "\" height=\"" + this.yMax + "\">\n");
      for (IShape shapes : shapesList) {
        if (shapes.getType().equalsIgnoreCase("rectangle")) {
          this.bodyShapesStringBuilder.append("     <rect id=\"").append(shapes.getName()).append
              ("\"").append("x= \"").append(
              shapes.getCoordinateX()).append("\"").append("y= \"").append(
              shapes.getCoordinateY()).append("\"").append("width= \"").append(
              shapes.getWidthOrRadius()).append("\"").append("height= \"").append(
              shapes.getHeightOrRadius()).append("\"").append("fill= \"rgb").append(
              shapes.getColor()).append("\"").append(">\n").append("        </rect>\n");

        } else {
          this.bodyShapesStringBuilder.append("     <ellipse id=\"").append(shapes.getName()).append
              ("\"").append("cx= \"").append(
              shapes.getCoordinateX()).append("\"").append("cy= \"").append(
              shapes.getCoordinateY()).append("\"").append("rx= \"").append(
              shapes.getWidthOrRadius()).append("\"").append("ry= \"").append(
              shapes.getHeightOrRadius()).append("\"").append("fill= \"rgb").append(
              shapes.getColor()).append("\"").append(">\n").append("        </ellipse>\n");
        }
      }

      this.footStringBuilder.append("</svg>\n</div>\n</body>\n</html>");

      try {
        BufferedWriter f_writer
            = new BufferedWriter(new FileWriter(this.outPutFile));
        f_writer.write(this.headerStringBuilder.toString());
        f_writer.append(this.bodyShapesStringBuilder.toString())
            .append(this.footStringBuilder.toString());

        f_writer.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      this.htmlAsString = this.headerStringBuilder.
          append(this.bodyShapesStringBuilder).append(this.footStringBuilder).toString();
    }
  }

  /**
   * Gets html as string.
   *
   * @return the html as string
   */
  public String getHtmlAsString() {
    return this.htmlAsString;
  }
}







