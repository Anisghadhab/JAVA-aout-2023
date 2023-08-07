package com.anis.zookeeper;

public class GiantBat extends Mammals {
	
	private int energyLevel;
	//CONSTRUCTOR
	public GiantBat() {
		this.energyLevel = 300;
	}
	
	// METHODS
	
	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	@Override
	public void displayEnergy() {
		System.err.println(this.getEnergyLevel());
	}
	
	public void fly() {
		System.out.println("Screeeeech!");
		this.setEnergyLevel(this.getEnergyLevel()-50);
		System.out.println(this.getEnergyLevel());
		
	}
	public void eatHumans() {
		System.out.println("Oh no, please, stay away!");
		this.setEnergyLevel(this.getEnergyLevel()+25);
		System.out.println(this.getEnergyLevel());

	}
	public void attackTown() {
		System.out.println("Piw piw piw!");
		this.setEnergyLevel(this.getEnergyLevel()-100);
		System.out.println(this.getEnergyLevel());


	}

}
