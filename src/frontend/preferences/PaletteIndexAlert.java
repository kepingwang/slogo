package frontend.preferences;

import javafx.scene.control.Alert;
import language.Language;

/**
 * Alert extension for Palette Indices. If the given index is outside of the
 * bounds it will return this alert which tells the user of this problem.
 * Uses string bindings to do the titles and alerts. 
 * @author Matthew Tribby
 */
public class PaletteIndexAlert extends Alert {

	public PaletteIndexAlert(AlertType alertType) {
		super(alertType);
		this.titleProperty().bind(Language.createStringBinding("PalIndexError"));
		this.contentTextProperty().bind(Language.createStringBinding("PalIndexErrorMessage"));
		this.showAndWait();
	}

}
