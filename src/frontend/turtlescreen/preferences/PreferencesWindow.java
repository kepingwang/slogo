package frontend.turtlescreen.preferences;


import java.util.ResourceBundle;
import frontend.turtlescreen.TurtleScreenController;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

/**
 * This is an extracted out window which contains the PreferenceTab instances
 * for this project. This class is essentially a shell for all the preference
 * choices and it holds all of those many preference choices in this window
 * which contains tabs. It is very much flexible because it can hold an unlimited
 * amount of tabs and therefore have unlimited functionality. 
 * @author Matthew Tribby
 */
public class PreferencesWindow {

public static final int WINDOW_WIDTH = 400;
public static final int WINDOW_HEIGHT = 200;
private TurtleScreenController turtleScreenController;
private TabPane tabPane;
public static final String RESOURCE_PACKAGE = "English";
private ResourceBundle resources = ResourceBundle.getBundle("resources.ui/" + RESOURCE_PACKAGE);
	
	/**
	 * Constructor: Initializes the window. 
	 * @param turtleScreenControl TurtleScreenController reference which is
	 * 							  necessary because the preferences window
	 * 							  needs to be able to affect turtle screen.
	 */
	public PreferencesWindow(TurtleScreenController turtleScreenControl){
		turtleScreenController = turtleScreenControl;
		
		tabPane = new TabPane();
		tabPane.getTabs().addAll(new EnvironmentPreferenceTab(turtleScreenControl), new TurtleTab(turtleScreenController));
		Stage stage = new Stage();
		Scene preferencesScene = new Scene(tabPane, WINDOW_WIDTH, WINDOW_HEIGHT);
		stage.setScene(preferencesScene);
		
		stage.setTitle(resources.getString("PreferencesTitle"));
		stage.show();
	}
	
	/**
	 * Adds an additional tab to the window
	 * @param tab Tab object
	 */
	public void addTab(Tab tab){
		tabPane.getTabs().add(tab);
	}
}


