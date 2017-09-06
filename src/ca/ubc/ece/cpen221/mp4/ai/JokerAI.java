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
import ca.ubc.ece.cpen221.mp4.items.animals.Joker;

/**
 * Your Rabbit AI.
 */
public class JokerAI extends AbstractAI {
	
		public JokerAI() {

		}

		@Override
		public Command getNextAction(ArenaWorld world, ArenaAnimal animal) {
			
			Direction dir = Util.getRandomDirection();

			Location targetLocation = new Location(animal.getLocation(), dir);
			Set<Item> possibleEats = world.searchSurroundings(animal);
			Location current  = animal.getLocation();
			Iterator<Item> it = possibleEats.iterator();
			
			while(it.hasNext()){
				Item item = it.next();
				
				//if the closest item is an Batman or tornado, RUN! (or move)
				if((item.getName().equals("Batman"))&& (current.getDistance(item.getLocation()) <= animal.getViewRange())){
					dir = Util.getDirectionTowards(animal.getLocation(), item.getLocation());
					dir = oppositeDir(dir); // gets the direction opposite to the item. 
					 targetLocation = new Location(animal.getLocation(), dir);
					 //moves away from the animal
					if(Util.isValidLocation(world, targetLocation) &&
							this.isLocationEmpty(world, animal, targetLocation)) {
						return new MoveCommand(animal, targetLocation );
					}
				}

				// if the closest item is Gnat or a Rabbit, EAT!
				if ((item.getName().equals("Fox") || item.getName().equals("PlayingCard")) 
						&& (current.getDistance(item.getLocation()) == 1)) {
					return new EatCommand(animal, item);
				}
				
				//if the joker sees them in his view, he should move towards them.
				
				if((item.getName().equals("Fox")) || item.getName().equals("PlayingCard")
						&& (current.getDistance(item.getLocation()) <= animal.getViewRange())) {
					
					dir = Util.getDirectionTowards(animal.getLocation(), item.getLocation());
					targetLocation = new Location(animal.getLocation(), dir);
					
					if(Util.isValidLocation(world, targetLocation) &&
						this.isLocationEmpty(world, animal, targetLocation)) {
						return new MoveCommand(animal, targetLocation );
						}
				}
				
				
				
			// if the item closest is a fox, BREED!
				if((item.getName().equals("Joker")) && (animal.getEnergy() >= animal.getMinimumBreedingEnergy()) ){
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
