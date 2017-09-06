package ca.ubc.ece.cpen221.mp4.ai;

import java.util.Iterator;
import java.util.Set;

import ca.ubc.ece.cpen221.mp4.ArenaWorld;
import ca.ubc.ece.cpen221.mp4.Direction;
import ca.ubc.ece.cpen221.mp4.Location;
import ca.ubc.ece.cpen221.mp4.Util;
import ca.ubc.ece.cpen221.mp4.commands.BreedCommand;
import ca.ubc.ece.cpen221.mp4.commands.Command;
import ca.ubc.ece.cpen221.mp4.commands.EatCommand;
import ca.ubc.ece.cpen221.mp4.commands.MoveCommand;
import ca.ubc.ece.cpen221.mp4.commands.WaitCommand;
import ca.ubc.ece.cpen221.mp4.items.Item;
import ca.ubc.ece.cpen221.mp4.items.animals.*;

public class FoxAI extends AbstractAI {
/**
 * This is the constructor for the foxAI
 */
	public FoxAI() {
	}

/**
 * The 'next-action' command decides the next intelligent action
 * 	for 'Fox' objects.
 */
	@Override
	public Command getNextAction(ArenaWorld world, ArenaAnimal animal) {
		
		Direction dir = Util.getRandomDirection();

		Location targetLocation = new Location(animal.getLocation(), dir);
		Set<Item> possibleEats = world.searchSurroundings(animal);
		Location current  = animal.getLocation();
		Iterator<Item> it = possibleEats.iterator();
		
		while(it.hasNext()) {
		// Declare the item to check as 'item'
			Item item = it.next();
			
			if(animal.getEnergy() >= 100) {
				return new WaitCommand();
			}
			
		// If the closest item is a Gnat or Rabbit, eat it
			if ( item.getName().equals("Rabbit")
					&& (current.getDistance(item.getLocation()) == 1)) {
				return new EatCommand(animal, item);
			}			
			
		// If the Fox has them in this view, we should move towards it
			if( item.getName().equals("Rabbit")
					&& (current.getDistance(item.getLocation()) != 1)) {
				
				dir = Util.getDirectionTowards(animal.getLocation(), item.getLocation());
				targetLocation = new Location(animal.getLocation(), dir);
				
				if(Util.isValidLocation(world, targetLocation) &&
					this.isLocationEmpty(world, animal, targetLocation)) {
					return new MoveCommand(animal, targetLocation );
				}
			}
			
		// If the closest item nearby is another Fox, breed.
			if((item.getName().equals("Fox")) 
				&& (animal.getEnergy() >= animal.getMinimumBreedingEnergy()) ){
				
				if (Util.isValidLocation(world, targetLocation) &&
					this.isLocationEmpty(world, animal, targetLocation)) {
					
					return new BreedCommand(animal, targetLocation);
				}
			}
		}
		
	// If a given location is empty, move into it.
		if (Util.isValidLocation(world, targetLocation) &&
				this.isLocationEmpty(world, animal, targetLocation)) {
			return new MoveCommand(animal, targetLocation);
		}
		return new WaitCommand();
	}
}