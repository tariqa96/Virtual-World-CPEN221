package ca.ubc.ece.cpen221.mp4.ai;

import java.util.Iterator;
import java.util.Set;

import ca.ubc.ece.cpen221.mp4.ArenaWorld;
import ca.ubc.ece.cpen221.mp4.Direction;
import ca.ubc.ece.cpen221.mp4.Location;
import ca.ubc.ece.cpen221.mp4.Util;
import ca.ubc.ece.cpen221.mp4.World;
import ca.ubc.ece.cpen221.mp4.commands.Command;
import ca.ubc.ece.cpen221.mp4.commands.EatCommand;
import ca.ubc.ece.cpen221.mp4.commands.MoveCommand;
import ca.ubc.ece.cpen221.mp4.commands.WaitCommand;
import ca.ubc.ece.cpen221.mp4.items.*;
import ca.ubc.ece.cpen221.mp4.items.animals.*;
import ca.ubc.ece.cpen221.mp4.items.vehicles.ArenaVehicle;

public class ArenaAnimalAI implements AI {
	
/**
 * This is a constructor where nothing is empty
 * @param energy
 */
	public ArenaAnimalAI(int energy) {
	}

/**
 * This method checks if a given location spot is open
 * @param world is the given world 
 * @param animal is used to check the surroundings of the 
 * 			given animal
 * @param location is used to check if the given Location 
 * 			is open
 * @return a boolean 'true'/'false' 
 */
	public boolean isLocationEmpty(ArenaWorld world, ArenaAnimal animal, Location location) {
	// If the location is not open, quickly return false
		if (!Util.isValidLocation(world, location)) {
			return false;
		}
		
		Set<Item> possibleMoves = world.searchSurroundings(animal);
		Iterator<Item> it = possibleMoves.iterator();
		
		while (it.hasNext()) {
			Item item = it.next();
			if (item.getLocation().equals(location)) {
				return false;
			}
		}
		return true;
	}

/**
 * This method gets the next action for ArenaAnimal Items
 */
	@Override
	public Command getNextAction(ArenaWorld world, ArenaAnimal animal) {
		Direction dir = Util.getRandomDirection();
		Location targetLocation = new Location(animal.getLocation(), dir);
		Set<Item> possibleEats = world.searchSurroundings(animal);
		Location current = animal.getLocation();
		Iterator<Item> it = possibleEats.iterator();
		
		while (it.hasNext()) {
			Item item = it.next();
			if ((item.getName().equals("Gnat") || item.getName().equals("Rabbit"))
					&& (current.getDistance(item.getLocation()) == 1)) {
				return new EatCommand(animal, item); // arena animals eat gnats
														// and rabbits
			}
		}
		if (Util.isValidLocation(world, targetLocation) && this.isLocationEmpty(world, animal, targetLocation)) {
			return new MoveCommand(animal, targetLocation);
		}
		return new WaitCommand();
	}

/**
 * This method is used for Vehicles and returns null
 * 	for Animal objects.
 */
	@Override
	public Command getNextAction2(ArenaWorld world, ArenaVehicle vehicle) {
		return null;
	}

	@Override
	public Command getNextAction(World world) {
		return null;
	}

}
