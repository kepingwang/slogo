package frontend.turtlescreen.preferences;

import java.util.List;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * The Palette class is designed to show the user a group of PaletteEntry objects
 * which are numbered images/colors/etc. This class is the overall shell for
 * an unlimited number of PaletteEntry objects, ensuring maximum flexibility
 * and extensibility because it will hold an PaletteEntry object.
 * @author Matthew Tribby
 */
public class Palette {
	public static final double PALETTE_WIDTH = 250;
	public static final double PALETTE_HEIGHT = 75;
	private HBox root;
	private Stage paletteStage;

	/**
	 * Constructor: crates a Palette given a list of initial PaletteEntry
	 * objects to display
	 * @param entries List of PaletteEntry objects
	 */
	public Palette(List<PaletteEntry> entries){
		paletteStage = new Stage();
		root = new HBox();
		root.maxWidth(PALETTE_WIDTH);
		Scene pal = new Scene(root, PALETTE_WIDTH, PALETTE_HEIGHT);
		paletteStage.setScene(pal);
		
		for(PaletteEntry entry : entries){
			root.getChildren().add(entry);
		}
	}

	/**
	 * Shows the Palette
	 */
	public void show(){
		paletteStage.show();
	}
	
	/**
	 * Hides the Palette
	 */
	public void hide(){
		paletteStage.hide();
	}
	
	/**
	 * Adds to the Palette an entry. If there is already another entry at the
	 * given index, then the old entry will be replaced and if not, the new entry
	 * will be placed at the end of the palette.
	 * @param entry
	 */
	public void add(PaletteEntry entry){
		root.getChildren().remove(entry);
		if(entry.getIndex() <= root.getChildren().size()){
			root.getChildren().add(entry.getIndex(), entry);
		}
		else{
			root.getChildren().add(entry);
		}
	}
}
