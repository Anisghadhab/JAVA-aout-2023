package com.anis.zookeeper;

public class Gorilla extends Mammals {
			
	// METHODS
	
	@Override
	public void displayEnergy() {
		System.out.println("Energy level: " + this.getEnergyLevel());
	}
	
	public void throwThings() {
		this.setEnergyLevel(this.getEnergyLevel() - 5);
		System.out.println("The gorilla has thrown something and his energy level has decreased by 5");
	}
	
	public void eatBananas() {
		this.setEnergyLevel(this.getEnergyLevel() + 10);
		System.out.println("The gorilla has eaten a banana and his energy level has increased by 10");
	}
	
	public void climbTree() {
		this.setEnergyLevel(this.getEnergyLevel() - 10);
		System.out.println("The gorilla has climbed a tree and his energy level has decreased by 10");
	}
	
	public void GorillaDemo() {
		this.throwThings();
		this.throwThings();
		this.throwThings();
		this.eatBananas();
		this.eatBananas();
		this.climbTree();
	}
}
