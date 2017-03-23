package frontend.preferences;


import frontend.views.TurtleScreenController;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import language.Language;

/**
 * This is a concrete implementation of the PreferenceTab abstract class.
 * This class creates a tab which allows the user to edit attributes in the
 * environment including but not limited to the pen color, pen width, and
 * background color. This is a useful concrete JavaFX component for this SLogo
 * project
 * @author Matthew Tribby
 *
 */
public class EnvironmentPreferenceTab extends PreferenceTab {
	
	/**
	 * Creates a Preference Tab object which has a reference to a TurtleScreenController
	 * and has a title which has a String key of EnviroPrefs which is bound
	 * to a resource file
	 * @param controller TurtleScreenController reference that this tab will be
	 * 					 linked to and then affect.
	 */
	public EnvironmentPreferenceTab(TurtleScreenController controller){
		super(controller, "EnviroPrefs");
	}

	/**
	 * Implementation of abstract method. Adds buttons to tab
	 */
	public void addButtons() {
		ColorSelector penColor = new ColorSelector(getController().getPenColor(), "PenColor");
		penColor.getColorPicker().setOnAction(e -> getController().setPenColor(penColor.getColorPicker().getValue()));
		
		HBox penWidth = new HBox();
		Label penThick = new Label();
		penThick.textProperty().bind(Language.createStringBinding("PenThick"));
		penWidth.getChildren().addAll(penThick, new PenWidthSlider(getController()));
	
		ColorSelector backColor = new ColorSelector(Color.WHITE, "BackColor");
		backColor.getColorPicker().setOnAction(e -> getController().setBackground(backColor.getColorPicker().getValue()));
		
		getRoot().getChildren().addAll(penColor, penWidth, new PenUpDownButtons(getController()), backColor);
	}
}
