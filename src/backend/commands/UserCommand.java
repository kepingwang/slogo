package backend.commands;

import java.util.ArrayList;
import java.util.List;

import backend.BackendController;
import backend.Command;
import backend.UserCommandInterface;
import backend.Variable;
import backend.parser.Expression;
import backend.parser.Input;

/**
 * @author nikita This class is the implementation of user defined commands. An
 *         instance of this class will be created when a
 *         MakeUserDefinedCommand's execute() method is executed. This class
 *         keeps all of the commands that this command owns and the names of the
 *         variables that are used, and the name of this command. There are
 *         methods
 */
public class UserCommand extends Command implements UserCommandInterface {
	private String name;
	private List<Variable> argNames;
	private Expression commands;

	public UserCommand(String name, BackendController controller, Input in, List<Variable> argNames,
			Expression commands) {
		super(in, controller, argNames.size());
		this.name = name;
		this.argNames = argNames;
		this.commands = commands;
	}

	/**
	 * execute this user defined command
	 * 
	 * @return the return value of the last executed command.
	 */
	@Override
	public double execute() {
		List<Double> old = new ArrayList<Double>();
		for (int i = 0; i < argNames.size(); i++) {
			String varName = argNames.get(i).getKey();
			double newVal = getChildren().get(i).evaluate().getValue();
			old.add(newVal);
			getBackendController().setVariable(new Variable(varName, newVal));
		}
		double ret = commands.evaluate().getValue();
		for (int i = 0; i < old.size(); i++) {
			String varName = argNames.get(i).getKey();
			double newVal = old.get(i);
			getBackendController().getParser().getVariableTable().removeVariable(new Variable(varName, newVal));
		}
		return ret;
	}

	@Override
	public String getKey() {
		return name;
	}

	public List<Variable> getArgNames() {
		return argNames;
	}

	public Expression getCommands() {
		return commands;
	}

}
