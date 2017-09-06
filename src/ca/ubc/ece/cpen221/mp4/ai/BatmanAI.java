package ca.ubc.ece.cpen221.mp4.ai;

import ca.ubc.ece.cpen221.mp4.ArenaWorld;
import ca.ubc.ece.cpen221.mp4.Direction;
import ca.ubc.ece.cpen221.mp4.Location;
import ca.ubc.ece.cpen221.mp4.Util;
import ca.ubc.ece.cpen221.mp4.commands.Command;
import ca.ubc.ece.cpen221.mp4.commands.MoveCommand;
import ca.ubc.ece.cpen221.mp4.commands.WaitCommand;
import ca.ubc.ece.cpen221.mp4.items.animals.*;

public class BatmanAI extends AbstractAI {
/**
 * This is the empty constructor for 'BatmanAI'
 */
	public BatmanAI() {
	}

/**
 * The 'next-action' command decides the next intelligent action
 * 	for 'Batman' objects.
 */
	@Override
	public Command getNextAction(ArenaWorld world, ArenaAnimal animal) {
	
		Direction dir = Util.getRandomDirection();
		Location targetLocation = new Location(animal.getLocation(), dir);

		if (Util.isValidLocation(world, targetLocation) &&
			this.isLocationEmpty(world, animal, targetLocation)) {
			return new MoveCommand(animal, targetLocation);
		}
		return new WaitCommand();
	}			
}