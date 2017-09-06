package ca.ubc.ece.cpen221.mp4.commands;

import ca.ubc.ece.cpen221.mp4.World;
import ca.ubc.ece.cpen221.mp4.items.Item;
import ca.ubc.ece.cpen221.mp4.items.NonLivingItem;

public class DestroyCommand implements Command {

	private final NonLivingItem item;
	private final Item vehicle;
	
	
	public DestroyCommand(NonLivingItem item, Item currentItem){
		this.item = item;
		this.vehicle = currentItem;
	}
	

	public DestroyCommand( Item currentItem, NonLivingItem item){
		this.item = item;
		this.vehicle = currentItem;
	}
	
	@Override
	public void execute(World world) throws InvalidCommandException {
//		if (item.getStrength() <= vehicle.getStrength())
//			throw new InvalidCommandException("Invalid EatCommand: Food possesses too much strength");
//		if (vehicle.getLocation().getDistance(item.getLocation()) != 1)
//			throw new InvalidCommandException("Invalid EatCommand: Food is not adjacent");

		item.eat(vehicle);
		vehicle.loseEnergy(Integer.MAX_VALUE);
		
	}

	
	
	
	
}
