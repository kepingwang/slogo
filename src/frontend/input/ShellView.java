package frontend.input;

import frontend.input.shell.Shell;
import javafx.scene.control.ScrollPane;

public class ShellView extends ScrollPane implements InputView {

	
	private Shell shell;
	private ShellController controller;
	
	public ShellView() {
		shell = new Shell();
		this.setContent(shell);
		controller = new ShellController(this);
	}
	
	public Shell getShell() {
		return shell;
	}
	
	@Override
	public ShellController getController() {
		return controller;
	}

}
