package backend.commands;

import java.util.List;

import backend.BackendController;
import backend.Command;
import backend.Variable;
import backend.parser.Input;

/**
 * @author nikita This is the implementation of the MakeVariable command. An
 *         instance of this class gets created when the parser identifies that
 *         the user typed a MakeVariable command
 */
public class MakeVariableCommand extends Command {

	public MakeVariableCommand(Input in, BackendController controller) {
		super(in, controller, 2);
	}

	/**
	 * Assigns the name given in the first argument to the value given in the
	 * second argument. The variable table is updated accordingly
	 * 
	 * @return returns the value assigned to the variable
	 */
	@Override
	public double execute() {
		List<Variable> args = getArgs();
		Variable newVar = new Variable(args.get(0).getKey(), args.get(1).getValue());
		getBackendController().setVariable(newVar);
		return newVar.getValue();
	}
}
