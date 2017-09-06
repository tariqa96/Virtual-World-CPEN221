package ca.ubc.ece.cpen221.mp4.Superups;
import javax.swing.ImageIcon;


import ca.ubc.ece.cpen221.mp4.Location;
import ca.ubc.ece.cpen221.mp4.Util;
import ca.ubc.ece.cpen221.mp4.items.Item;

public class LoisLane implements Item {
	private static final int ENERGY = 250;
	private static final int STRENGTH = 5;
	private static final ImageIcon LoisLaneImage = Util.loadImage("loislane2.gif");
	private Location location;
	private Boolean isDead;
	
	public LoisLane(Location location){
		this.location = location;
		this.isDead = false;

	}

		@Override
		public ImageIcon getImage() {
			return LoisLaneImage;
		}

		@Override
		public String getName() {
			return "LoisLane";
		}

		@Override
		public Location getLocation() {
			return location;
		}

		@Override
		public int getPlantCalories() {
			return ENERGY;
		}

		@Override
		public int getMeatCalories() {
			return 0;
		}

		@Override
		public void loseEnergy(int energy) {
			// Dies if loses energy.
			isDead = true;
		}

		@Override
		public boolean isDead() {
			return isDead;
		}

		@Override
		public int getStrength() {
			return STRENGTH;
		}

		
	}