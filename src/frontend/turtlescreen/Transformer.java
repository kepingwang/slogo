package frontend.turtlescreen;


import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

/**
 * This super-class is designed to provide a framework for handling the turtle
 * screen's coordinates. Its goal is to take the SLogo-based coordinates where
 * (0,0) is the center of the screen and where positive y is upwards and where
 * positive x is to the right and translate them to readable coordinates for
 * JavaFX where 0,0 is in the top left. Because there are multiple possible
 * implementations of handling turtle coordinates i.e. infinite bounds,
 * bounded, and toroidal 
 * @author Matthew Tribby
 */
public abstract class Transformer {
	private double xOff;
	private double yOff;
	private double xBounds;
	private double yBounds;
	
	/**
	 * Constructor: will be same constructor for all implementations. 
	 * Initializes a Transformer object
	 * @param xOffset: The initial x offset to the center of the screen,
	 * 					basically the center x coordinate on a screen where
	 * 					(0,0) is the top left. Equal to half screen's width
	 * @param yOffset  The initial y offset to the center of the screen,
	 * 					basically the center y coordinate on a screen where
	 * 					(0,0) is the top left. Equal to half screen's height
	 */
	public Transformer(double xOffset, double yOffset){
		xOff = xOffset;
		yOff = yOffset;
		xBounds = 2*xOff;
		yBounds = 2*yOff;
	}
	
	/**
	 * Translates a point from a grid where (0,0) is in the center of the screen,
	 * where center is defined by the x and y offsets that are held by the object,
	 * to a point in a grid where (0,0) is in the top left and thus readable by
	 * a JavaFX canvas. 
	 * @param x x-coordinate that needs to be translated
	 * @param y y-coordinate that needs to be translated
	 * @return A Point which contains the translated location
	 */
	public Point2D translateLoc(double x, double y){
		return new Point2D(xOff + x, yOff - y);
	}

	/**
	 * Inputting the translated location, this will return the turtle location.
	 * There will be different implementations for different types of transformers.
	 * Example, if there is an implementation where the turtle wraps around the 
	 * screen, this method would mod the turtle's traveling and return the
	 * final location of the turtle for the command.
	 * @param location Translated unmodified final location of turtle
	 * @return Final location of turtle, adjusted for Transformer type
	 */
	public abstract Point2D getTurtleLoc(Point2D location);
	
	/**
	 * Draws the line that follow the turtle when the pen is down in SLogo.
	 * There will be different implementations for different types of transformers.
	 * For example, if the turtle wraps around in an implementation, the lines
	 * will also need to wrap around the screen and continue to the turtle's
	 * final location.
	 * @param start Starting location for the line
	 * @param end Unmodified ending location for the line (not adjusted for any
	 * 			  certain implementation just a straight line)
	 * @param gc Graphics context used to draw the lines
	 */
	public abstract void drawLines(Point2D start, Point2D end, GraphicsContext gc);
	
	/**
	 * Returns the slope of the current line which could be useful for certain
	 * implementations and finding final turtle location and drawing lines.
	 * @param first First point on the line
	 * @param second Second point on the line
	 * @return numerical value of slope
	 */
	public double getSlope(Point2D first, Point2D second){
		return (second.getY()-first.getY())/(second.getX()-first.getX());
	}
	
	/**
	 * Changes the x-bound for the transformer
	 * @param x new x-bound
	 */
	public void setXBound(double x){
		xBounds = x;
	}
	
	/**
	 * Changes the y-bound for the transformer
	 * @param y new x-bound
	 */
	public void setYBound(double y){
		yBounds = y;
	}
	
	/**
	 * Useful for implementations of transformer to get x-bounds 
	 * @return current x-bounds of screen
	 */
	public double getXBounds(){
		return xBounds;
	}
	
	/**
	 * Useful for implementations of transformer to get y-bounds
	 * @return current y-bounds of screen
	 */
	public double getYBounds(){
		return yBounds;
	}
	
	
}
