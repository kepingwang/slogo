package frontend.turtlescreen.preferences;

import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * The PaletteEntry class defines the component that can be shown inside
 * a Palette class. A PaletteEntyr is an extension of VBox with its interior
 * components being its index which is displayed and whatever JavaFX node
 * is desired to be shown along with that index. The goal of this class then is 
 * for maximum flexibility as it allows the user to create a PaletteEntry with
 * any kind of JavaFX node (I have two examples in this project: ImageNodePalette
 * and ColorNodePalette)
 * @author Matthew Tribby
 */
public class PaletteEntry extends VBox {
	private int index;
	
	/**
	 * Constructor which initializes an entry with a given index and with the
	 * given node
	 * @param node JavaFX node to display
	 * @param index Index of the entry
	 */
	public PaletteEntry(Node node, int index){
		Text indexText = new Text(Integer.toString(index));
		getChildren().addAll(node, indexText);
		this.index = index;
	}
	
	/**
	 * Returns the index associated with this entry
	 * @return index
	 */
	public int getIndex(){
		return index;
	}
	
	/**
	 * Overriding of the base equals() method. Says that the entries are equal
	 * if their indices are equal. Useful for comparing entries and is used
	 * in the Palette class to check if an entry needs to be replaced.
	 */
	@Override
	public boolean equals(Object o) {
	        if (o == this) { return true; }
		if(o instanceof PaletteEntry){
			if(((PaletteEntry) o).index == this.index){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
	    int ans = 17;
	    ans *= 37 + index;
	    return ans;
	}
}
