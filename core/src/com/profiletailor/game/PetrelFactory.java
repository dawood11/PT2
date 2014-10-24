package com.profiletailor.game;

/*
 * Makes instances of classes PErspective and Ribbon tab and fills with required information
 * remember to call load from Assets or mainScreen or somewhere relevant
 */
public abstract class PetrelFactory {
	public static final String[] perspectiveNames = {"Seismic to Simulation", "Geology and Geophysics", "Advanced Geophysics", 
			"Reservoir and Production", "Drilling", "Shale", "My Perspective"};
	public static Perspective[] perspectives;
	
	//TODO: find out which tabs exists and give suitable names
	public static final String[] tabNames = {"a", "b", "c"};
	public static RibbonTab[] tabs;
	
	public static void load(){
		createPerspectives();
		createRibbonTabs();
	}
	private static void createPerspectives(){
		perspectives = new Perspective[perspectiveNames.length];
		for(int i = 0; i < perspectiveNames.length; i++){
			perspectives[i] = new Perspective(perspectiveNames[i]);
		}
	}
	//sets the boolean array in each perspective that 
	//knows which tabs are in that perspective
	private static void setPerspectiveTabs(){
		
	}
	//
	private static void createRibbonTabs(){
		tabs = new RibbonTab[tabNames.length];
		for(int i = 0; i < tabNames.length; i++){
			tabs[i] = new RibbonTab(tabNames[i]);
		}
	}
}
