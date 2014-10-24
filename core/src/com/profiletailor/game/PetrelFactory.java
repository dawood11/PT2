package com.profiletailor.game;

import java.util.HashMap;

/*
 * Makes instances of classes PErspective and Ribbon tab and fills with required information
 * remember to call load from Assets or mainScreen or somewhere relevant
 */
public abstract class PetrelFactory {
	public static final String[] perspectiveNames = {"Seismic to Simulation", "Geology and Geophysics", "Advanced Geophysics", 
			"Reservoir and Production", "Drilling", "Shale", "My Perspective"};
	public static HashMap<String, Perspective> perspectives;
	
	//TODO: find out which tabs exists and give suitable names
	public static final String[] tabNames = {"File", "Home", "Stratigraphy", "Seismic Interpretation", 
		"Structural Modeling", "Property Modeling", "Reservoir Engineering", "Well Engineering", "Simulation", "MyTab"};
	public static HashMap<String, RibbonTab> tabs;
	
	public static void load(){
		createPerspectives();
		createRibbonTabs();
	}
	private static void createPerspectives(){
		perspectives = new HashMap<String, Perspective>();
		for(String name : perspectiveNames){
			perspectives.put(name, new Perspective(name));
		}
	}
	//sets the boolean array in each perspective that 
	//knows which tabs are in that perspective
	private static void setPerspectiveTabs(){
		Perspective per = perspectives.get("Seismic to Simulation");
		HashMap <String, RibbonTab> tabInPerspective = new HashMap <String, RibbonTab>();
		tabInPerspective.put("File", tabs.get("File"));
		tabInPerspective.put("Home", tabs.get("Home"));
		tabInPerspective.put("Stratigraphy", tabs.get("Stratigraphy"));
		tabInPerspective.put("Seismic Interpretation", tabs.get("Seismic Interpretation"));
		tabInPerspective.put("Structural Modeling", tabs.get("Structural Modeling"));
		tabInPerspective.put("Property Modeling", tabs.get("Property Modeling"));
		tabInPerspective.put("Reservoir Engineering", tabs.get("Reservoir Engineering"));
		tabInPerspective.put("Well Engineering", tabs.get("Well Engineering"));
		tabInPerspective.put("Simulation", tabs.get("Simulation"));
		tabInPerspective.put("MyTab", tabs.get("MyTab"));
		per.setTabs(tabInPerspective);
	}
	//
	private static void createRibbonTabs(){
		tabs = new HashMap <String, RibbonTab>();
		for(String name : tabNames){
			tabs.put(name, new RibbonTab(name));
		}
	}
}
