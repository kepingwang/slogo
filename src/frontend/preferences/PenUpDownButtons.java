package frontend.preferences;

import frontend.views.TurtleScreenController;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import utils.javafx.FX;

/**
 * HBox extension class which contains buttons which affect the pen and whether
 * it is up or down on the turtle screen. Extracted this buttons. Could be reused
 * in different points of the project if necessary.
 * @author Matthew Tribby
 */
public class PenUpDownButtons extends HBox {

	/**
	 * Constructor which creates the buttons. Passed in the turtleScreenController
	 * which allows the buttons to talk to that controller as that is necessary
	 * to affect whether the pen is up or down
	 * @param turtleScreenController
	 */
	public PenUpDownButtons(TurtleScreenController turtleScreenController){
		super();
		Button penUp = FX.button("PenUp", e -> turtleScreenController.allPensUp());
		Button penDown = FX.button("PenDown", e -> turtleScreenController.allPensDown());
		getChildren().addAll(penUp, penDown);
	}
	
}
