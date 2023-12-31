package com.oop.zoo;
import com.oop.animal.Gorilla;
import com.oop.animal.Bat;
public class MammalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gorilla gorilla1 = new Gorilla();
		System.out.println("--------------The Gorilla--------------");
		gorilla1.displayEnergy();
		gorilla1.throwSomething();
		gorilla1.throwSomething();
		gorilla1.throwSomething();
		gorilla1.displayEnergy();
		gorilla1.eatBananas();
		gorilla1.eatBananas();
		gorilla1.displayEnergy();
		gorilla1.climb();
		gorilla1.displayEnergy();
		
		Bat bat1 = new Bat();
		System.out.println("--------------The Bat--------------");
		bat1.displayEnergy();
		bat1.attackTown();
		bat1.attackTown();
		bat1.attackTown();
		bat1.displayEnergy();
		bat1.eatHumans();
		bat1.eatHumans();
		bat1.displayEnergy();
		bat1.fly();
		bat1.fly();
		bat1.displayEnergy();
	}

}
