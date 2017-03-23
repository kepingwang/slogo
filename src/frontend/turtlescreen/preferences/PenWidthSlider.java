package frontend.turtlescreen.preferences;

import frontend.turtlescreen.TurtleScreenController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;

/**
 * Creates a slider which controls the pen's width
 * @author Matthew Tribby
 */
public class PenWidthSlider extends Slider {

	/**
	 * Constructor for this class. The TurtleScreenController reference is
	 * passed in to allow for the pen attribute being changed in the actual
	 * screen
	 * @param turtleScreenController
	 */
	public PenWidthSlider(TurtleScreenController turtleScreenController){
		super();
		setMin(0);
		setMax(30);
		setValue(turtleScreenController.getPenWidth());
		setShowTickLabels(true);
		setShowTickMarks(true);
		setMajorTickUnit(10);
		setMinorTickCount(5);
		setBlockIncrement(1);
		
		valueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				turtleScreenController.setPenThickness(newValue.doubleValue());
			}
		});
	}
}
