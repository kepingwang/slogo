package frontend.preferences;

import frontend.views.TurtleScreenController;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import language.Language;

/**
 * The preference tab is an abstract class which extends Tab and is designed to
 * make it easy to create a Tab that can be easily filled with a specific set of
 * buttons. This class has two key purposes 1. to create a general tab class
 * which allows for easier authoring of tabs filled with buttons and 2. project
 * specific: it allows a coder to easily add more tabs to the preferences window
 * which can be open by pressing the preferences button in the turtle window. 
 * This allows for increased extensibility and flexibility
 * @author Matthew Tribby
 *
 */
public abstract class PreferenceTab extends Tab{
	private TurtleScreenController turtleScreenController;
	private VBox tabRoot;

	/**
	 * Constructor for class. Creates a tab and fills it with the buttons
	 * defined in the addButtons() method of the class which is called from
	 * the constructor. Also creates a resource bundle binded title with the
	 * key that is passed in
	 * @param controller The reference to the TurtleScreenController. This
	 * 					is necessary because the preference tab needs to be
	 * 					able to affect the turtle screen so therefore it
	 * 					needs the reference to the controller
	 * @param titleKey Key to bind the title to in the resource file
	 */
	public PreferenceTab(TurtleScreenController controller, String titleKey){
		super();
		turtleScreenController = controller;
	
		this.textProperty().bind(Language.createStringBinding(titleKey));
		tabRoot = new VBox(10);
		setContent(tabRoot);
		addButtons();
	}
	
	/**
	 * Adds buttons to the tab. Will be different for every implementation
	 * of PreferenceTab which is why this method is abstract
	 */
	public abstract void addButtons();
	
	/**
	 * Returns the root node. This is needed in the superclass so that the
	 * subclasses can use the functionality
	 * @return JavaFX root
	 */
	public VBox getRoot(){
		return tabRoot;
	}
	
	/**
	 * Returns reference to TurtleScreenController. This is also needed by
	 * the subclasses so that they can access the turtleScreenController
	 * instance which is set in the constructor of this class.
	 * @return TurtleScreenController object
	 */
	public TurtleScreenController getController(){
		return turtleScreenController;
	}
}
