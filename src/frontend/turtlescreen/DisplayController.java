package frontend.turtlescreen;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import frontend.turtlescreen.preferences.ColorNodePalette;
import frontend.turtlescreen.preferences.ImageNodePalette;
import frontend.turtlescreen.preferences.Palette;
import frontend.turtlescreen.preferences.PaletteEntry;
import frontend.turtlescreen.preferences.PaletteIndexAlert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import utils.javafx.FX;
/**
 * The goal of this controller is to handle aesthetic changes to the turtle 
 * screen. It was created to eliminate some of the bulk from the FrontEndController
 * @author matt, nikita, keping
 * */
public class DisplayController {
	private Map<Integer, Color> colors;
	private Map<Integer, File> turtleImages;

	private TurtleScreenController turtleScreenController;
	private Palette colorPalette;
	private Palette imagePalette;

	private static final int INIT_PEN_SIZE = 1;
	private static final int INIT_SHAPE_INDEX = 0;
	private static final int INIT_BACKGROUND_INDEX = 5;
	private static final int INIT_PEN_COLOR_INDEX = 0;
	private int penSize = INIT_PEN_SIZE; 
	private int shapeIndex = INIT_SHAPE_INDEX;
	private int backgroundIndex = INIT_BACKGROUND_INDEX;
	private int penColorIndex = INIT_PEN_COLOR_INDEX;
	

	/**
	 * Constructor, which just sets up initial variables to default values
	 * @param controller
	 */
	public DisplayController(TurtleScreenController controller){
		initialize();
		turtleScreenController = controller;
		syncConfig();
	}
	
	/**
	 * Constructor which also takes in a config to allow for the loading in 
	 * of a saved configuration
	 * @param controller
	 * @param config Saved Configuration
	 */
	public DisplayController(TurtleScreenController controller, DisplayConfig config) {
		initialize();
		turtleScreenController = controller;
		penSize = config.getPenSize();
		shapeIndex = config.getShapeIndex();
		backgroundIndex = config.getBackgroundIndex();
		penColorIndex = config.getPenColorIndex();
		syncConfig();
	}
	private void initialize() {
		// From Keping: I've changed here to not use double brace initialization
		// The syntax is unusual, and will perhaps cause trouble.
		// http://stackoverflow.com/questions/1958636/what-is-double-brace-initialization-in-java
		
		//default values
		colors = new HashMap<Integer, Color>();
		colors.put(0, Color.BLACK);
		colors.put(1, Color.BLUE);
		colors.put(2, Color.GREEN);
		colors.put(3, Color.ORANGE);
		colors.put(4, Color.RED);
		colors.put(5, Color.WHITE);
		colors.put(6, Color.YELLOW);	
		
		//default values
		turtleImages = new HashMap<Integer, File>();
		turtleImages.put(0, new File("turtle.png"));
		turtleImages.put(1, new File("turtle2.png"));
		
		ArrayList<PaletteEntry> entries = new ArrayList<PaletteEntry>();
		for(Integer index : colors.keySet()){
			entries.add(new PaletteEntry(new ColorNodePalette(colors.get(index)), index));
		}
		colorPalette = new Palette(entries);
		
		ArrayList<PaletteEntry> imageEntries = new ArrayList<PaletteEntry>();
		for(Integer index : turtleImages.keySet()){
			imageEntries.add(new PaletteEntry(new ImageNodePalette(turtleImages.get(index)), index));
		}
		imagePalette = new Palette(imageEntries);
	}
	private void syncConfig() {
		setPenSize(penSize);
		setShape(shapeIndex);
		setBackground(backgroundIndex);
		setPenColor(penColorIndex);
	}
	
	
	/**
	 * Display the Color Palette
	 */
	public void showColorPalette(){
		colorPalette.show();
	}
	
	/**
	 * Change the pen width
	 * @param width
	 */
	public void setPenSize(int width){
		penSize = width;
		turtleScreenController.setPenThickness(width);
	}
	
	/**
	 * Calls the palette to set a certain index to a certain color based
	 * on a given RGB value
	 * @param params 4 element array. params[0] = index. params[1] = r. 
	 * 			   					  params[2] = g. params[3] = b
	 */
	public void setPalette(int[] params){
		if(params[1] < 0 || params[1] > 255 || params[2] < 0 || params[2] > 255 || params[3] < 0 || params[3] > 255){
			FX.alertError("BadRGB", "BadRGBMessage", "");
		}
		else{
			Color newColor = Color.rgb(params[1], params[2], params[3]);
			colorPalette.add(new PaletteEntry(new ColorNodePalette(newColor), params[0]));
			colors.put(params[0], newColor);
		}
	}
	
	/**
	 * Sets the Image of the turtle (currently not utilized)
	 * @param index Index of the turtle shape to use
	 */
	public void setShape(int index){
		if(turtleImages.get(index) == null){
			new PaletteIndexAlert(AlertType.ERROR);
		}
		else{
			turtleScreenController.setTurtleImage(turtleImages.get(index));
			shapeIndex = index;
		}
	}
	
	/**
	 * Sets the background color of the turtle screen based on the color
	 * which is related to the index in the color palette
	 * @param index index for color palette
	 */
	public void setBackground(int index){
		if(colors.get(index) == null){
			new PaletteIndexAlert(AlertType.ERROR);
		}
		else{
			turtleScreenController.setBackground(colors.get(index));
			backgroundIndex = index;
		}
	}
	
	/**
	 * Changes pen color, setting it to the value related to indexing
	 * into the color palette based on the given index
	 * @param index index on color palette
	 */
	public void setPenColor(int index){
		if(colors.get(index) == null){
			new PaletteIndexAlert(AlertType.ERROR);
		}
		else{
			turtleScreenController.setPenColor(colors.get(index));
			penColorIndex = index;
		}
	}
	
	/**
	 * Returns index tied to current pen color on color palette
	 * @return index of color
	 */
	public int getPenColor(){
		return penColorIndex;
	}
	
	/**
	 * Returns index tied to current shape on image palette
	 * @return index of shape
	 */
	public int getShape(){
		return shapeIndex;
	}
	
	/**
	 * Returns the current configuration. Utilize for saving the current states
	 * @return DisplayConfig which holds the state for DisplayController
	 */
	public DisplayConfig getConfig() {
		return new DisplayConfig(penSize, shapeIndex, backgroundIndex, penColorIndex);
	}
}
