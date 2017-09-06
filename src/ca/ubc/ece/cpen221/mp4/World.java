package ca.ubc.ece.cpen221.mp4;

import java.util.Set;

import ca.ubc.ece.cpen221.mp4.items.Item;
import ca.ubc.ece.cpen221.mp4.items.vehicles.ArenaVehicle;

/**
 * The virtual world simulation. Holds all of the {@link Item}s in this
 * simulation and contains methods which insert and retrieve these Items.
 */
public interface World extends ArenaWorld {

	/**
	 * Adds an {@link Actor} to this world. This actor will then be called to
	 * take action every N steps where N is given by its cooldown period.
	 *
	 * @see Actor#getCoolDownPeriod()
	 *
	 * @param actor
	 *            the Actor to be added to this world
	 */
	void addActor(Actor actor);

	/**
	 * Add an {@link Item} to this world.
	 *
	 * @param item
	 *            the Item to be added to this world
	 */
	void addItem(Item item);

	/**
	 * Returns the collection of {@link Item}s in this World. The
	 * <code>Iterable</code> interface enables this collection to be used in a
	 * "for each" loop:
	 *
	 * <pre>
	 *   e.g. <code> for(Item item : world.getItems()) {...}
	 * </pre>
	 *
	 * @return a collection of all Items in this World
	 */
	Iterable<Item> getItems();
	
	/**
	 * Returns items within the view range of <code>animal</code>, which is
	 * defined by {@link ArenaVehicle #getViewRange()}.
	 *
	 * @see World#searchSurroundings(Location, int)
	 *
	 * @param vehicle
	 *            the ArenaAnimal whose location is used
	 * @return a set of items visible to <code>vehicle</code>
	 */
	Set<Item> searchSurroundings(ArenaVehicle vehicle);
	
	/**
	 * Retrieves the set of {@link Item}s surrounding a location within a range
	 * in this World.
	 *
	 * @param loc
	 *            the location around which items are retrieved
	 * @param range
	 *            the maximum distance an item can be from the location
	 * @return the set of items found
	 */
	Set<Item> searchSurroundings(Location loc, int range);

	/**
	 * Performs a single step in the simulation.
	 */
	void step();

}
