package controllers;

import java.io.FileNotFoundException;
import model.IPhotoAlbum;

/**
 * This is my interface Photo album controller.
 */
public interface IPhotoAlbumController {

  /**
   * This is my method go that takes in IPhotoAlbum as parameter. This method is the bridge between
   * the model and the view.
   *
   * @param photoAlbumModel the photo album model
   * @throws FileNotFoundException the file not found exception
   */
  void go(IPhotoAlbum photoAlbumModel) throws FileNotFoundException;


}
