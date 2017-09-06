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
import ca.ubc.ece.cpen221.mp4.items.animals.ArenaAnimal;
import ca.ubc.ece.cpen221.mp4.items.animals.Fox;
import ca.ubc.ece.cpen221.mp4.items.animals.Rabbit;

/**
 * Your Rabbit AI.
 */
public class RabbitAI extends AbstractAI {

	private int closest = 10; // max number; greater than rabbit's view range
	private int temp;
	private boolean foxFound;
	

		public RabbitAI() {

		}

		@Override
		public Command getNextAction(ArenaWorld world, ArenaAnimal animal) {
			
			Direction dir = Util.getRandomDirection();

			//Direction WEST = WEST;
			Location targetLocation = new Location(animal.getLocation(), dir);
			Set<Item> possibleEats = world.searchSurroundings(animal);
			Location current  = animal.getLocation();
			Iterator<Item> it = possibleEats.iterator();
			
			while(it.hasNext()){
				Item item = it.next();
				
				/*if(item.getName().equals("grass") && animal.getEnergy() <= 30 && 
				current.getDistance(item.getLocation()) <= animal.getViewRange()){
				
					dir = Util.getDirectionTowards(animal.getLocation(), item.getLocation());
					targetLocation = new Location(animal.getLocation(), dir);
					
					if(Util.isValidLocation(world, targetLocation) &&
						this.isLocationEmpty(world, animal, targetLocation)) {
						return new MoveCommand(animal, targetLocation );
						}
				}
				if (item.getName().equals("grass")
						&& (current.getDistance(item.getLocation()) == 1)) {
					return new EatCommand(animal, item);
				}
*/
				//if the closest item is an earthquake or tornado, RUN! (or move)
				if((item.getName().equals("Fox"))&& (current.getDistance(item.getLocation()) <= animal.getViewRange()))
					dir = Util.getDirectionTowards(animal.getLocation(), item.getLocation());
					dir = oppositeDir(dir); // gets the direction opposite to the item. 
					 targetLocation = new Location(animal.getLocation(), dir);
					 
					// moves away from the animal.
					if(Util.isValidLocation(world, targetLocation) &&
							this.isLocationEmpty(world, animal, targetLocation)) {
						return new MoveCommand(animal, targetLocation );
					}

					
				// if the closest item is Gnat or a Rabbit, EAT!
			
				
				//if the rabbit sees them in his view, he should move towards them.
				
				if(item.getName().equals("grass")
						&& (current.getDistance(item.getLocation()) <= animal.getViewRange())) {
					
					dir = Util.getDirectionTowards(animal.getLocation(), item.getLocation());
					targetLocation = new Location(animal.getLocation(), dir);
					
					if(Util.isValidLocation(world, targetLocation) &&
						this.isLocationEmpty(world, animal, targetLocation)) {
						return new MoveCommand(animal, targetLocation );
						}
				}
				
				
				
			// if the item closest is a fox, BREED!
				if((item.getName().equals("Rabbit")) && (animal.getEnergy() >= animal.getMinimumBreedingEnergy()) ){
					if (Util.isValidLocation(world, targetLocation) &&
						this.isLocationEmpty(world, animal, targetLocation)) {
						return new BreedCommand(animal, targetLocation);
				}
				}
			}
			
			//else if the location is empty, move there. 
			if (Util.isValidLocation(world, targetLocation) &&
					this.isLocationEmpty(world, animal, targetLocation)) {
				return new MoveCommand(animal, targetLocation);
			}
			
			return new WaitCommand();
		}

	

		}
