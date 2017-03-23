package frontend.preferences;

import frontend.views.TurtleScreenController;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import utils.javafx.FX;

/**
 * Buttons which show or hide the turtles on the screen
 * @author Matthew Tribby
 */
public class TurtleVisibleButtons extends HBox{
	
	/**
	 * Constructor
	 * @param turtleScreenController TurtleScreenController which is needed
	 * 								 to affect the turtles
	 */
	public TurtleVisibleButtons(TurtleScreenController turtleScreenController){
		super();
		Button hide = FX.button("HideTurtle", e -> turtleScreenController.hideAllTurtles());
		Button show = FX.button("ShowTurtle", e -> turtleScreenController.showAllTurtles());
		getChildren().addAll(hide, show);
	}

}
