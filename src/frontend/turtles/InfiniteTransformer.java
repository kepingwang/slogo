package frontend.turtles;


import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

/**
 * This class is a concrete implementation of the Transformer superclass.
 * As a transformer, it is responsible for changing points from the SLogo grid
 * coordinates (where 0,0 is the center of the screen) and in this implementation
 * it handles those conditions when the display is set to be infinite meaning
 * that if the turtle goes off the screen, it will continue to proceed that way,
 * there is no sort of wrapping or bounds
 * @author Matthew Tribby
 */
public class InfiniteTransformer extends Transformer{

	public InfiniteTransformer(double xOffset, double yOffset){
		super(xOffset, yOffset);
	}
	
	public Point2D getTurtleLoc(Point2D location) {
		return location;
	}
	
	public void drawLines(Point2D start, Point2D end, GraphicsContext gc){	
		 gc.strokeLine(start.getX(), start.getY(), end.getX(), end.getY());
	}	
}
