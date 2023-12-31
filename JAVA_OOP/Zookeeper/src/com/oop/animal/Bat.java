package com.oop.animal;

public class Bat extends Mammal {
	
	public Bat() {
		super.setEnergy(300);
	}
	public void fly() {
		int flyEnergy = super.getEnergy() - 50;
		super.setEnergy(flyEnergy);
		System.out.println("The bat has flew.");
	}
	
	public void eatHumans() {
		int eatHumanEnergy = super.getEnergy() + 25;
		super.setEnergy(eatHumanEnergy);
		System.out.println("The bat has been satisfied for eating.");
	}
	
	public void attackTown() {
		int attackTownEnergy = super.getEnergy() - 100;
		super.setEnergy(attackTownEnergy);
		System.out.println("The bat has attacked a town.");
	}
}
