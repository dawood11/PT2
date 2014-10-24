package com.profiletailor.game;

public class Perspective {
	public String name;
	private static boolean tabsCreated = false;
	
	Perspective(String name){
		this.name = name;
		
	}
	
	public void createTabs(){
		if(tabsCreated) return;
		String[] tabNames = {"a", "b", "c", "d"};
		RibbonTab[] tabs = new RibbonTab[tabNames.length];
		for(int i = 0; i < tabs.length; i++){
			tabs[i] = new RibbonTab(tabNames[i]);
		}
		tabsCreated = true;
	}
	
}
