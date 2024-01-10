package main;

import controllers.GraphicalViewController;
import controllers.WebViewController;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import model.PhotoAlbumModel;


/**
 * This is my Photo album main class.
 */
public class PhotoAlbumMain {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   * @throws IOException the io exception
   */
  public static void main(String[] args) throws IOException {
    String outputFile = "";
    String typeOfView = "";
    File commandFile = null;
    int xMax = 1000;
    int yMax = 1000;

    for (int i = 0; i < args.length; i++) {
      if (args[i].equalsIgnoreCase("-in")) {
        commandFile = new File(args[Arrays.asList(args).indexOf("-in") + 2]);
      } else if (args[i].equalsIgnoreCase("-view") ||
          args[i].equalsIgnoreCase("-v")) {
        typeOfView = args[Arrays.asList(args).indexOf(i) + 2];
      }
      if (typeOfView.equalsIgnoreCase("graphical") ||
          typeOfView.equalsIgnoreCase("web")) {
        for (i = 0; i < args.length; i++) {
          if (args[i].equalsIgnoreCase("-out")) {
            outputFile = args[Arrays.asList(args).indexOf("-out") + 2];
            xMax = Integer.parseInt(args[Arrays.asList(args).indexOf(i) + 4]);
            yMax = Integer.parseInt(args[Arrays.asList(args).indexOf(i) + 6]);
            try {
              new GraphicalViewController(commandFile, xMax, yMax).go(new PhotoAlbumModel());

            } catch (IOException e) {
              e.printStackTrace();
            }
          } else {
            try {
              new WebViewController(commandFile, outputFile, xMax, yMax).go(new PhotoAlbumModel());
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        }
      }
    }
  }

}











