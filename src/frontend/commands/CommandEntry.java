package frontend.commands;

import backend.commands.UserCommand;
import javafx.scene.control.Button;

/**
 * Buttons which represent user commands in the commands window. Clicking on
 * these buttons will run the commands that are contained in the entry
 * @author Matthew Tribby
 */
public class CommandEntry extends Button {
	private UserCommand userCommand;
	private String commandName;
	
	/**
	 * Constructor which creates a button based on the command
	 * @param command UserCommand
	 */
	public CommandEntry(UserCommand command){
		super(command.getKey());
		setOnMouseClicked(e -> callCommand());
		this.getStyleClass().add("table-entry");
		commandName = command.getKey();
		userCommand = command;
	}
	
	private void callCommand(){
		userCommand.execute();
	}
	
	/**
	 * Returns the String name of the entry
	 * @return title
	 */
	public String getName(){
		return commandName;
	}
	
	/**
	 * Updates the command visually on the commandEntry
	 * @param command new UserCommand to be updated
	 */
	public void updateCommand(UserCommand command){
		userCommand = command;
	}
}
