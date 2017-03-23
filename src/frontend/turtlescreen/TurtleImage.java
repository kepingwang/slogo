package frontend.turtlescreen;

import frontend.frontend.FrontEndController;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

/**
 * The goal of this class is to be the visual representation of a turtle
 * for a JavaFX component. This class encapsulates both the actual turtle
 * image and if the turtle is selectable or not.
 * @author Matthew Tribby
 *
 */
public class TurtleImage {
	public static final int TURTLE_HEIGHT = 30;
	public static final int TURTLE_WIDTH = 30;
	private ImageView turtleImage;
	private Circle currentCircle;
	private boolean commandable = true;
	private boolean currentOn = true;
	public static final int CURRENT_CIRCLE_RADIUS = 4;
	private FrontEndController frontEnd;
	private Transformer locTransformer;
	private int id;
	public static final String INITIAL_TURTLE_IMAGE = "turtle.png";
	
	/**
	 * Constructor for TurtleImage. Creates a turtle based on an idNumber,
	 * important for handling multiple turtles, a Transformer, changes
	 * depending on the type of turtle screen, starting x of the turtle,
	 * starting y of the turtle, and a reference to the FrontEndController
	 * which is important for talking to the back-end when a turtleImage
	 * is selected.
	 * @param idNumber ID of turtle
	 * @param locationTransformer Transformer object which governs turtle movement
	 * @param startingX 
	 * @param startingY
	 * @param frontEnd 
	 */
	public TurtleImage(int idNumber, Transformer locationTransformer, double startingX, double startingY, FrontEndController frontEnd){
		setInitialImage();
		turtleImage.setFitWidth(TURTLE_WIDTH);
		turtleImage.setFitHeight(TURTLE_HEIGHT);
		currentCircle = new Circle(4);
		locTransformer = locationTransformer;
		moveTo(startingX, startingY);
		this.frontEnd = frontEnd;
		id = idNumber;	
		turtleImage.setOnMouseClicked(e -> {toggleCommandable();});
	}
	
	/**
	 * Constructor which initializes a turtle at (0,0) on a SLogo grid, where
	 * (0,0) is center in the screen. Gives turtle a certain ID number, a
	 * Transformer object which governs its movements and reference to its
	 * FrontEndController which helps link it to the back-end.
	 * @param idNumber ID of turtle
	 * @param locationTransformer Transformer object which governs turtle movement
	 * @param frontEnd
	 */
	public TurtleImage(int idNumber, Transformer locationTransformer, FrontEndController frontEnd){
		this(idNumber, locationTransformer, 0.0, 0.0, frontEnd);
	}
	
	private void setInitialImage(){
		//Images gotten from open clipart site: https://openclipart.org/detail/1024/turtle
		Image turtle = new Image(getClass().getClassLoader().getResourceAsStream(INITIAL_TURTLE_IMAGE));
		turtleImage = new ImageView(turtle);
	}
	
	/**
	 * Sets the image of the TurtleImage to a new image
	 * @param newImage
	 */
	public void setImage(Image newImage){
		turtleImage.setImage(newImage);
	}
	
	/**
	 * Sets the current angle of the turtle in degrees
	 * @param angle Angle in degrees
	 */
	public void setAngle(double angle){
		turtleImage.setRotate(angle);
	}

	/**
	 * Returns a JavaFXNode object which is the visual representation of the
	 * turtle. The actual implementation of the turtle is encapsulated.
	 * @return JavaFX node of the turtle
	 */
	public Node getImage() {
		return turtleImage;
	}
	
	/**
	 * Moves the turtle to a new specific location which is on the SLogo
	 * grid where (0,0) is the center 
	 * @param x new x coordinate to move to
	 * @param y new y coordinate to move to
	 */
	public void moveTo(double x, double y){
		
		Point2D location = locTransformer.translateLoc(x, y);
		location = locTransformer.getTurtleLoc(location);
		turtleImage.setX(location.getX() - TURTLE_WIDTH/2);
		turtleImage.setY(location.getY() - TURTLE_HEIGHT/2);
		currentCircle.setCenterX(location.getX());
		currentCircle.setCenterY(location.getY());
	
	}
	
	/**
	 * Shows the turtle's visual representation on the JavaFX component
	 */
	public void show(){
		turtleImage.setVisible(true);
		currentCircle.setVisible(commandable && currentOn);
	}
	
	/**
	 * Hides the turtle's visual representation on the JavaFX component
	 */
	public void hide(){
		turtleImage.setVisible(false);
		turtleImage.setVisible(false);
	}

	/**
	 * Returns the JavaFX node which is the selected circle for the turtle
	 * (selected circle: show if turtle is currently selected by user)
	 * @return JavaFX node which represents selection of turtle
	 */
	public Node getCircle() {
		return currentCircle;
	}

	private void toggleCommandable(){
		commandable = !commandable;
		updateCircle();
		frontEnd.toggleTurtle(id);
	}
	
	/**
	 * Updates whether the turtle is selected/commandable. When a turtle is
	 * commandable it means that a user command will affect it
	 */
	public void updateCommandable(){
		commandable = true;
		updateCircle();
	}
	
	/**
	 * Updates whether or not to show whether a turtle is selected/commandable
	 * visually for the user
	 * @param show If true, show selected representation, if false do not
	 */
	public void updateShowCommandable(boolean show) {
		currentOn = show;
		updateCircle();
	}
	
	private void updateCircle(){
		currentCircle.setVisible(commandable && currentOn);
	}
	
}
