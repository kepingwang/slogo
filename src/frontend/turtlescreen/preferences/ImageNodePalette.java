package frontend.turtlescreen.preferences;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class is designed to create an image node to be used to show in the
 * Palette class. An image node essentially is a ImageView of a fixed size
 * that displays the image for the user in a standardized way. Note that in
 * the current implementation of SLogo this class is not utilized
 * @author Matthew Tribby
 */
public class ImageNodePalette extends ImageView{

	public static final double IMAGE_SIDE_LENGTH = 30;
	
	/**
	 * Constructor: creates ImageView in a standardized way for Palette
	 * @param imageFile File which contains image
	 */
	public ImageNodePalette(File imageFile){
		super();
		Image image = new Image(imageFile.toURI().toString());
		this.setImage(image);
		this.setFitWidth(IMAGE_SIDE_LENGTH);
		this.setFitHeight(IMAGE_SIDE_LENGTH);
	}
}
