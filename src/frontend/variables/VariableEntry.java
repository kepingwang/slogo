package frontend.variables;

import backend.Variable;
import javafx.scene.control.Button;

/**
 * This class represents the visual representation of a variable on the front-end
 * of the project. This extension of a button can be clicked to edit the value
 * of the variable and that change is subsequently reflected in the back-end 
 * @author Matthew Tribby
 */
public class VariableEntry extends Button{
	private String variableName;
	private Variable variable;
	public static final String NAME_VALUE_SPACE = "			";

	/**
	 * Constructor, makes an instance with the variable passed in
	 * @param variable
	 */
	public VariableEntry(Variable variable){
		super(variable.getKey() + NAME_VALUE_SPACE + variable.getValue());
		
		this.variable = variable;
		variableName = variable.getKey();
		setOnMouseClicked(e -> changeValue());
		this.getStyleClass().add("table-entry");
	}
	
	private void changeValue(){
		new VariableEditor(this);
	}
	
	/**
	 * Returns name/key of the given VariableEntry
	 * @return String name
	 */
	public String getName(){
		return variableName;
	}
	
	/**
	 * Changes the value of the visual representation. This is useful as the
	 * value can change in the back-end and then can be updated in the front-end
	 * @param value String representation of number. If not a number, a null pointer
	 * exception will be thrown.
	 */
	public void changeValue(String value){
		changeValue(Double.parseDouble(value));
	}
	
	/**
	 * Same as previous method but with double parameter
	 * @param value
	 */
	public void changeValue(double value){
		setText(variableName + NAME_VALUE_SPACE + value);
		variable.update(value);
	}
	
	/**
	 * Returns variable instance associated with entry
	 * @return variable object
	 */
	public Variable getVariable(){
		return variable;
	}
	
	/**
	 * Compares two variable entries. Two variable entries are deemed equal
	 * if they have the same variableName. This is utilized in the replacement
	 * decisions for variables
	 */
	@Override
	public boolean equals(Object o) {
		if(o instanceof VariableEntry){
			VariableEntry comparison = (VariableEntry) o;
		
			if(comparison.variableName.equals(this.variableName)){
				return true;
			}
		}
		return false;
		
	}

}
