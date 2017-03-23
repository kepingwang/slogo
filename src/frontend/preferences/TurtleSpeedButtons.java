package frontend.preferences;

import frontend.views.TurtleScreenController;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import utils.javafx.FX;

/**
 * Buttons which change the turtle speeds based on pressing said buttons
 * @author Matthew Tribby
 */
public class TurtleSpeedButtons extends HBox {
	
	/**
	 * Constructor
	 * @param turtleScreenController reference to TurtleScreenController, 
	 * 								 necessary to change the speed
	 */
	public TurtleSpeedButtons(TurtleScreenController turtleScreenController){
		super();
		Button slow = FX.button("SlowDown", e -> turtleScreenController.slowDown());
		Button speed = FX.button("SpeedUp", e -> turtleScreenController.speedUp());
		getChildren().addAll(slow, speed);
	}
}
