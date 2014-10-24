package com.profiletailor.game;

import java.util.HashMap;

public class Perspective {
	public String name;
	public  HashMap<String, RibbonTab> tabs;
	
	Perspective(String name){
		this.name = name;
		
	}
	public void setTabs(HashMap<String, RibbonTab> tabInPerspective) {
		this.tabs = tabInPerspective;
		
	}
	
	

	
}
