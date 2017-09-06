package ca.ubc.ece.cpen221.mp4.ai;

import java.util.Iterator;
import java.util.Set;

import ca.ubc.ece.cpen221.mp4.ArenaWorld;
import ca.ubc.ece.cpen221.mp4.Direction;
import ca.ubc.ece.cpen221.mp4.Location;
import ca.ubc.ece.cpen221.mp4.Util;
import ca.ubc.ece.cpen221.mp4.World;
import ca.ubc.ece.cpen221.mp4.commands.Command;
import ca.ubc.ece.cpen221.mp4.commands.MoveCommand;
import ca.ubc.ece.cpen221.mp4.commands.WaitCommand;
import ca.ubc.ece.cpen221.mp4.items.Item;
import ca.ubc.ece.cpen221.mp4.items.animals.ArenaAnimal;
import ca.ubc.ece.cpen221.mp4.items.vehicles.ArenaVehicle;
import ca.ubc.ece.cpen221.mp4.items.vehicles.AbstractArenaVehicle;

public class VehicleAI extends AbstractAI {

	/*public VehicleAI(){
		
	}
	

	@Override
	public Command getNextAction(World world ) {
		
		Direction dir = Util.getRandomDirection();
		Location targetLocation = new Location(this.getLocation(), dir);
		Set<Item> possibleDestroy = world.searchSurroundings(items);
		Location current = this.getLocation();
		Iterator<Item> it = possibleDestroy.iterator();
		
		while(it.hasNext()){
			Item item = it.next();
			if(item.getStrength() > this.getStrength()){
				dir = Util.getDirectionTowards(this.getLocation(), item.getLocation());
				dir = oppositeDir(dir); // gets the direction opposite to the item. 
				targetLocation = new Location(this.getLocation(), dir);
				
				// moves away from the animal.
				if(Util.isValidLocation(world, targetLocation) &&
						this.isLocationEmpty(world, vehicle, targetLocation) && this.getSpeed() < ) {
					return new MoveCommand(vehicle, targetLocation );
				}
			}
		
			
			
			// if the item is weaker and is in range, vehicle should destroy it
			

			if(item.getStrength()  < vehicle.getStrength()){
				
			}
		
			//if the item is weaker but isnt in touching range, it should chase after it,
			
			// should destroy kill anything with weaker 
		
		
		}
		
		
		
		
		return new WaitCommand();
	}

	
	
	
	@Override
	public Command getNextAction(ArenaWorld world, ArenaAnimal animal) {
		//used for animals	
		return null;
	}*/
}
