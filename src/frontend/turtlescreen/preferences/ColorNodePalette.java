package frontend.turtlescreen.preferences;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * The goal of this class is to be a building block for building a palette
 * object. What this class does is instantiate a JavaFX rectangle to a certain
 * fill, thus representing a color in a fixed, set way, easy for the user
 * to see. Currently the class has a fixed rectangle size meaning each color
 * node has the same size but that could be changed in the future easily.
 * @author Matthew Tribby
 */
public class ColorNodePalette extends Rectangle {
	
	public static final double RECTANGLE_SIDE = 30;
	
	/**
	 * Constructor which creates the color node
	 * @param color Color to fill node with
	 */
	public ColorNodePalette(Color color){
		super(RECTANGLE_SIDE, RECTANGLE_SIDE);
		setFill(color);
	}
}
