package frontend.turtlescreen.preferences;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.*;
import utils.language.Language;

/**
 * The goal of this class is to create a JavaFX component that acts as a color
 * selector meaning that a user can utilize it to pick a color which is then
 * associated with some preference or component. Meant to be a flexible JavaFX
 * component that is reusable.
 * @author Matthew Tribby
 */
public class ColorSelector extends HBox {
	private ColorPicker colorPicker;
	public static final int MAX_WIDTH = 40;
	public static final int MAX_HEIGHT = 40;
	private Font font = new Font(12);

	/**
	 * Instantiates a Color Selector. 
	 * @param paint Color to set initial value of color selector to (not utilized
	 * 					in current version of this class)
	 * @param titleKey Key of the String in the resource file to be bound with.
	 * 				   Current constraint of this class is that the string has
	 * 				   to be bound to a resource file, there can be no final
	 * 				   String title. This is not a bad constraint though because
	 * 				   it forces good coding conventions
	 */
	public ColorSelector (Paint paint, String titleKey){
		colorPicker = new ColorPicker();
		colorPicker.setMaxWidth(MAX_WIDTH);
		colorPicker.setMaxHeight(MAX_HEIGHT);
		colorPicker.setValue(Color.BLACK);
		Label pickerTitle = new Label();
		pickerTitle.textProperty().bind(Language.createStringBinding(titleKey));
		pickerTitle.setFont(font);
		getChildren().addAll(pickerTitle, colorPicker);
	}
	
	/**
	 * Returns the ColorPicker component of this larger component. The trade-off
	 * of not encapsulating this ColorPicker is that the user to connect functionality
	 * on click to the ColorPicker object. So although not encapsulated, this
	 * method is important for extending functionality of this class.
	 * @return ColorPicker object
	 */
	public ColorPicker getColorPicker(){
		return colorPicker;
	}
	
	/**
	 * Sets font used by this class's title.
	 * @param font
	 */
	public void setFont(Font font){
		this.font = font;
	}
}
