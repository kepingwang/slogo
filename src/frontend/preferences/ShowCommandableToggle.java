package frontend.preferences;

import frontend.views.TurtleScreenController;
import javafx.scene.control.CheckBox;
import language.Language;

/**
 * Extracted out toggle for JavaFX component. This toggle is a check box that
 * decides whether or not to show if the turtle is selected/commandable (in this
 * project that is shown by a black circle on the turtle if it is selected). 
 * @author Matthew Tribby
 */
public class ShowCommandableToggle extends CheckBox {

	/**
	 * Creates checkbox
	 * @param controller TurtleScreenController reference
	 */
	public ShowCommandableToggle(TurtleScreenController controller){
		super();
		this.textProperty().bind(Language.createStringBinding("ShowCommandable"));
		this.setSelected(true);
		this.setOnAction(e -> controller.updateShowCommandable(this.isSelected()));
	}
}
