package ca.ubc.ece.cpen221.mp4;

import javax.swing.SwingUtilities;

import ca.ubc.ece.cpen221.mp4.Superups.LoisLane;
import ca.ubc.ece.cpen221.mp4.Superups.PlayingCard;
import ca.ubc.ece.cpen221.mp4.Superups.WayneTower;
import ca.ubc.ece.cpen221.mp4.ai.*;
import ca.ubc.ece.cpen221.mp4.items.Gardener;
import ca.ubc.ece.cpen221.mp4.items.Grass;
import ca.ubc.ece.cpen221.mp4.items.animals.*;
import ca.ubc.ece.cpen221.mp4.items.vehicles.Batmobile;
import ca.ubc.ece.cpen221.mp4.items.vehicles.Lamborghini;
import ca.ubc.ece.cpen221.mp4.items.vehicles.PoliceCar;
import ca.ubc.ece.cpen221.mp4.staff.WorldImpl;
import ca.ubc.ece.cpen221.mp4.staff.WorldUI;

/**
 * The Main class initialize a world with some {@link Grass}, {@link Rabbit}s,
 * {@link Fox}es, {@link Gnat}s, {@link Gardener}, etc.
 *
 * You may modify or add Items/AcSupermans to the World.
 *
 */
public class Main {

	static final int X_DIM = 40;
	static final int Y_DIM = 40;
	static final int SPACES_PER_GRASS = 7;
	
	static final int INITIAL_GRASS = X_DIM * Y_DIM / SPACES_PER_GRASS;
	static final int INITIAL_GNATS = INITIAL_GRASS / 4;
	static final int INITIAL_RABBITS = INITIAL_GRASS / 4;
	static final int INITIAL_FOXES = INITIAL_GRASS / 32;
	
	static final int INITIAL_BATMAN = 20;
	static final int INITIAL_SUPERMAN = 20;
	static final int INITIAL_JOKER = 20;
	
	static final int INITIAL_BATMOBILE = 10;
	static final int INITIAL_POLICECARS = 10;
	static final int INITIAL_LAMBORGHINI = 10;
	
	static final int INITIAL_LOISLANE = 15;
	static final int INITIAL_WAYNETOWER = 15;
	static final int INITIAL_PLAYINGCARD = 15;
	
/**
 *  This is our 'Main' method that creates our World
 * @param args
 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Main().createAndShowWorld();
			}
		});
	}

/**
 * This method creates our Game Board
 */
	public void createAndShowWorld() {
		World world = new WorldImpl(X_DIM, Y_DIM);
		initialize(world);
		new WorldUI(world).show();
	}

/**
 * This method initializes all our Items into our Game Board
 * @param world is the variable where all Items are added into
 */
	public void initialize(World world) {
	/* What is this ..?
		world.addActor(new Gardener());*/
	// Non-Living Items
		addGrass(world);
		addGnats(world);
	// Living Animals
		addRabbits(world);
		addFoxes(world);
	// Custom Animals
		addBatman(world);
		addSuperman(world);
		addJoker(world);
	// Custom Vehicles
		addBatmobile(world);
		addPoliceCar(world);
		addLamborghini(world);
	// Custom Items
		addLoisLane(world);
		addWayneTower(world);
		addPlayingCard(world);
	}

/**
 * This method adds 'Grass' objects into the Arena
 * @param world is where the Items are added into
 */
	private void addGrass(World world) {
		for (int i = 0; i < INITIAL_GRASS; i++) {
			Location loc = Util.getRandomEmptyLocation(world);
			world.addItem(new Grass(loc));
		}
	}
	
/**
 * This method adds 'Gnat' objects into the Arena
 * @param world is where the Items are added into
 */
	private void addGnats(World world) {
		for (int i = 0; i < INITIAL_GNATS; i++) {
			Location loc = Util.getRandomEmptyLocation(world);
			Gnat gnat = new Gnat(loc);
			world.addItem(gnat);
			world.addActor(gnat);
		}
	}

/**
 * This method adds 'Rabbit' objects into the Arena
 * @param world is where the Items are added into
 */
	private void addRabbits(World world) {
		RabbitAI rabbitAI = new RabbitAI();
		for (int i = 0; i < INITIAL_RABBITS; i++) {
			Location loc = Util.getRandomEmptyLocation(world);
			Rabbit rabbit = new Rabbit(rabbitAI, loc);
			world.addItem(rabbit);
			world.addActor(rabbit);
		}
	}
	
/**
 * This method adds 'Fox' objects into the Arena
 * @param world is where the Items are added into
 */
	private void addFoxes(World world) {
		FoxAI foxAI = new FoxAI();
		for (int i = 0; i < INITIAL_FOXES; i++) {
			Location loc = Util.getRandomEmptyLocation(world);
			Fox fox = new Fox(foxAI, loc);
			world.addItem(fox);
			world.addActor(fox);
		}
	}
	
/**
 * This method adds 'Batman' objects into the Arena
 * @param world is where the Items are added into
 */
	private void addBatman(World world) {
		BatmanAI BatmanAI = new BatmanAI();
		for(int i = 0; i < INITIAL_BATMAN; i++){
			Location loc = Util.getRandomEmptyLocation(world);
			Batman Batman = new Batman(BatmanAI, loc);
			world.addItem(Batman);
			world.addActor(Batman);
		}
	}

/**
 * This method adds 'Superman' objects into the Arena
 * @param world is where the Items are added into
 */
	private void addSuperman(World world) {
	// This is the AI for Superman objects
		SupermanAI SupermanAI = new SupermanAI();
		for(int i = 0; i < INITIAL_SUPERMAN; i++){
			Location loc = Util.getRandomEmptyLocation(world);
			Superman superman = new Superman(SupermanAI, loc);
			world.addItem(superman);
			world.addActor(superman);
		}
	}
	
/**
 * This method adds 'Joker' objects into the Arena
 * @param world is where the Items are added into
 */
	private void addJoker(World world) {
		JokerAI jokerAI = new JokerAI();
		for(int i = 0; i < INITIAL_JOKER; i++){
			Location loc = Util.getRandomEmptyLocation(world);
			Joker joker = new Joker(jokerAI, loc);
			world.addItem(joker);
			world.addActor(joker);
		}
	}

/**
 * This method adds 'Batmobile' objects into the Arena
 * @param world is where the Items are added into
 */
	private void addBatmobile(World world){
		for(int i = 0; i < INITIAL_BATMOBILE; i++){
			Location loc = Util.getRandomEmptyLocation(world);
			Batmobile batmobile = new Batmobile(loc);
			world.addItem(batmobile);
			world.addActor(batmobile);
		}
	}

/**
 * This method adds 'PoliceCar' objects into the Arena
 * @param world is where the Items are added into
 */
	private void addPoliceCar(World world) {
		for(int i = 0; i < INITIAL_POLICECARS; i++){
			Location loc = Util.getRandomEmptyLocation(world);
			PoliceCar policeCar = new PoliceCar(loc);
			world.addItem(policeCar);
			world.addActor(policeCar);
		}
	}
	
/**
 * This method adds 'Lamborghini' objects into the Arena
 * @param world is where the Items are added into
 */
	private void addLamborghini(World world) {
		for(int i = 0; i < INITIAL_LAMBORGHINI; i++){
			Location loc = Util.getRandomEmptyLocation(world);
			Lamborghini lamborghini = new Lamborghini(loc);
			world.addItem(lamborghini);
			world.addActor(lamborghini);
		}
	}

/**
 * This method adds 'LoisLane' objects into the Arena
 * @param world is where the Items are added into
 */
	private void addLoisLane(World world) {
		for(int i = 0; i < INITIAL_LOISLANE; i++){
			Location loc = Util.getRandomEmptyLocation(world);
			LoisLane loisLane = new LoisLane(loc);
			world.addItem(loisLane);
			world.addItem(loisLane);
		}
	}

/**
 * This method adds 'WayneTower' objects into the Arena
 * @param world is where the Items are added into
 */
	private void addWayneTower(World world) {
		for(int i = 0; i < INITIAL_WAYNETOWER; i++){
			Location loc = Util.getRandomEmptyLocation(world);
			WayneTower wayneTower = new WayneTower(loc);
			world.addItem(wayneTower);
			world.addItem(wayneTower);
		}
	}

/**
 * This method adds 'PlayingCard' objects into the Arena
 * @param world is where the Items are added into
 */
	private void addPlayingCard(World world) {
		for(int i = 0; i < INITIAL_PLAYINGCARD; i++){
			Location loc = Util.getRandomEmptyLocation(world);
			PlayingCard playingCard = new PlayingCard(loc);
			world.addItem(playingCard);
			world.addItem(playingCard);
		}
	}

}