package com.anis.zookeeper;

public abstract class Mammals {
	private int energyLevel;
	
	// DEFAULT CONSTRUCTOR
	
	public Mammals() {
		this.energyLevel = 100;
	}
	
	// METHODS
	
	public abstract void displayEnergy();
	
	// GETTERS & SETTERS
	
	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
}
