package backend.turtlecommands;

import java.util.List;

import backend.BackendController;
import backend.Variable;
import backend.parser.Input;
import backend.turtle.TurtleModel;

public class SetTowardsCommand extends TurtleCommand {

	public SetTowardsCommand(Input in, BackendController controller) {
		super(in, controller, 2);
	}

	/**
	 * sets the bearing of the turtle towards all coordinates specified by the
	 * arguments, one after the other
	 */
	@Override
	public double execute() {
		List<Variable> args = getArgs();
		List<TurtleModel> turtles = getTurtlePool().getActiveTurtles();
		for (int i = 0; i < args.size(); i += 2) {
			double towX = getArgs().get(i).getValue();
			double towY = getArgs().get(i + 1).getValue();
			for(TurtleModel t :turtles){
				getTurtlePool().setCurrentActiveTurtle(t.getTurtleIDNumber());
				t.setTowardsAction(towX, towY);
			}
		}
		return turtles.get(turtles.size() - 1).getAngleTurned();
	}

}
