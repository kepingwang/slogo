package backend.parser;

import backend.BackendController;
import backend.Variable;
import backend.VariableException;
import backend.commands.MakeUserInstructionCommand;
import backend.commands.MakeVariableCommand;

/**
 * @author nikita This class is the implementation of the Variable expression.
 *         An instance of this class gets created by the parser when it
 *         identifies that a variable was typed by the user.
 */
public class VariableExpression extends Expression {

	public VariableExpression(Input info, BackendController controller) {
		super(info, controller, 0);

	}

	/**
	 * Get the value of the variable from the variable table if it is defined,
	 * else assume that the written variable is participating in the definition
	 * of a new variable (MakeVariableCommand) or the definition of a new
	 * command (MakeUserInstructionCommand).
	 * 
	 * @return the variable that was retrieved from the variable table or the
	 *         variable with the variable name and 0 value to be created
	 */
	@Override
	public Variable evaluate() {
		try {
			return getBackendController().getParser().getVariableTable().getVariable(getString().substring(1));
		} catch (VariableException e) {
			if (getParent() instanceof MakeVariableCommand
					|| getParent().getParent() instanceof MakeUserInstructionCommand) {
				Variable var = new Variable(getString().substring(1), 0);
				getBackendController().getParser().getVariableTable().setVariable(var);
				return var;
			} else {
				getBackendController().getParser().complain(e);
				return null;
			}
		}
	}
}
