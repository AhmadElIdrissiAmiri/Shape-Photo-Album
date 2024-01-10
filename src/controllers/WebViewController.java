package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import model.Color;
import model.IPhotoAlbum;
import model.PhotoAlbumModel;
import views.WebPageView;


public class WebViewController implements IPhotoAlbumController {

  private WebPageView view;
  private IPhotoAlbum model;
  private String outPutFile;
  private File fileName;
  private final int DEFAULT_MAX =1000;
  private int xMax, yMax;

  public WebViewController(File fileName, String outPutFile, int xMax, int yMax) {
    if(xMax == 0 || yMax ==0){
      this.xMax = DEFAULT_MAX;
      this.yMax = DEFAULT_MAX;
    }else{
      this.xMax =xMax;
      this.yMax= yMax;
    }
    this.fileName = fileName;
    this.outPutFile = outPutFile;
    this.model = new PhotoAlbumModel();
  }

  @Override
  public void go(IPhotoAlbum photoAlbumModel) throws FileNotFoundException {
    if(this.fileName.equals("")|| this.fileName==null){
      throw new FileNotFoundException("There is no file");
    }
    Scanner scanner = new Scanner(this.fileName);
    String file = scanner.nextLine();
    String emptySpaces = " ";
    String[] splittable = file.split(emptySpaces);
    while (scanner.hasNextLine()) {
       if (splittable[0].equals("#") ){
         continue;
      } else if (splittable[0].equalsIgnoreCase("Shape")) {
        this.model.create(splittable[1], splittable[2],
            Integer.parseInt(splittable[3]), Integer.parseInt(splittable[4]),
            Integer.parseInt(splittable[5]), Integer.parseInt(splittable[6]),
            new Color(Integer.parseInt(splittable[7]), Integer.parseInt(splittable[8]),
                Integer.parseInt(splittable[9])));

      } else if (splittable[0].equalsIgnoreCase("snapShot")) {
         if(splittable.length>1){
           String[] descriptionArray = Arrays.copyOfRange(splittable,1,splittable.length);
           String description = String.join(" ", descriptionArray);
           this.model.snapshot(description);

         }else {
           this.model.snapshot("");
         }

      } else if (splittable[0].equalsIgnoreCase("remove")) {
        this.model.removeShapesFromAlbum(splittable[1]);


      } else if (splittable[0].equalsIgnoreCase("move")) {
        this.model.moveShape(splittable[1], Integer.parseInt(splittable[1]),
            Integer.parseInt(splittable[2]));

      } else if (splittable[0].equalsIgnoreCase("color")) {
        this.model.changeColor(splittable[1],
            new Color(Integer.parseInt(splittable[2]), Integer.parseInt(splittable[3]),
                Integer.parseInt(splittable[4])));

      } else if (splittable[0].equalsIgnoreCase("resize")) {
        this.model.changeDimensionsOfShape(splittable[1],
            Integer.parseInt(splittable[2]), Integer.parseInt(splittable[3]));
      }
    }
    this.view = new WebPageView(this.model.getSnapShotList(), this.outPutFile, this.xMax,
        this.yMax);

  }

}

