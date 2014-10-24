package com.profiletailor.game;

public class Perspective {
	public String name;
	//holder booleans som forteller for hver tab om den er med i perspektivet eller ikke
	//skal settes fra PetrelFactory
	private boolean [] hasTab;
	
	Perspective(String name){
		this.name = name;
		hasTab = new boolean[PetrelFactory.tabNames.length];
		
	}
	

	
}
