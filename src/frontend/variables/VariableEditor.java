package frontend.variables;

import java.util.Optional;
import java.util.ResourceBundle;

import javafx.scene.control.TextInputDialog;

/**
 * Class which allows the user to edit a variable
 * @author Matthew Tribby
 */
public class VariableEditor {
	VariableEntry entry;
	
	public static final String RESOURCE_PACKAGE = "English";
	private ResourceBundle resources = ResourceBundle.getBundle("resources.ui/" + RESOURCE_PACKAGE);
	
	/**
	 * Constructor which pops up a window which allows the user to edit a specific
	 * variable
	 * @param varEntry Variable entry to be changed
	 */
	public VariableEditor(VariableEntry varEntry){
		//http://code.makery.ch/blog/javafx-dialogs-official/
		entry = varEntry;
		TextInputDialog valueInput = new TextInputDialog();
		valueInput.setContentText(resources.getString("VarEditContext") + entry.getName());
		valueInput.setTitle(resources.getString("ValueEditor") + entry.getName());
		Optional<String> result = valueInput.showAndWait();
		result.ifPresent(e -> handleResult(result.get()));
	}
	
	private void handleResult(String number){
		//Regular Expressions from http://stackoverflow.com/questions/14206768/how-to-check-if-a-string-is-numeric
		Boolean match = number.matches("[-+]?\\d*\\.?\\d+");  
		if(match){
			entry.changeValue(number);
		}
	}
}
