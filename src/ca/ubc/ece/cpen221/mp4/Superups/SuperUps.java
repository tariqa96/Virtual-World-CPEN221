package ca.ubc.ece.cpen221.mp4.Superups;

import ca.ubc.ece.cpen221.mp4.Food;
import ca.ubc.ece.cpen221.mp4.items.Item;

public interface SuperUps extends Food,Item {

	
	/**
	 * for the corresponding animal, it will re-energize them to full health
	 * 
	 */
	
	
	int getSuperUp();
}
