package com.oop.animal;

public class Gorilla extends Mammal {
	
	public void throwSomething() {
		int throwSomething = super.getEnergy() - 5;
		super.setEnergy(throwSomething);
		System.out.println("The gorilla has thrown something.");
	}
	
	public void eatBananas() {
		int eatBanana = super.getEnergy() + 10;
		super.setEnergy(eatBanana);
		System.out.println("The gorilla has been satisfied for eating banana.");
	}
	
	public void climb() {
		int climbTree = super.getEnergy() - 10;
		super.setEnergy(climbTree);
		System.out.println("The gorilla has climbed a tree.");
	}
}
