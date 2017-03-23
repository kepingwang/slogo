package frontend.turtlescreen.preferences;

import java.io.File;
import java.util.ResourceBundle;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * This class essentially is a file chooser which is used to exclusively
 * allow the user to pick image files. This is a stand alone JavaFX component
 * that can be utilized in a variety of situations
 * @author Matthew Tribby
 *
 */
public class ImageSelector{
	FileChooser fileChooser;
	File imageFile;
	public static final String RESOURCE_PACKAGE = "English";
	private ResourceBundle resources = ResourceBundle.getBundle("resources.ui/" + RESOURCE_PACKAGE);
	
	/**
	 * Creates an ImageSelector with the title of an image selector being chosen
	 * by passing the String key to a resource file. Forces the user to use
	 * resource files to ensure better coding conventions
	 * @param titleKey String key for resource file
	 */
	public ImageSelector(String titleKey){
		//Code inspired from the link
		//https://docs.oracle.com/javase/8/javafx/api/javafx/stage/FileChooser.html
		fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter(resources.getString("ImageFiles"), "*.png", "*.jpg", "*.gif"));
		imageFile = fileChooser.showOpenDialog(new Stage());
	}
	
	/**
	 * Sets the initial directory for the filechooser
	 * @param path
	 */
	public void setInitialDirectory(String path){
		fileChooser.setInitialDirectory(new File(path));
	}
	
	/**
	 * Returns the current file that the user has selected
	 * @return chosen File, returns null if no file
	 */
	public File getFile(){
		return imageFile;
	}
}
