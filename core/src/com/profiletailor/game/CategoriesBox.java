package com.profiletailor.game;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

	/*
	 * Table for menu with buttons for Ribbons, ToolGroups, Perspectives osv.
	 * Dimensions and position from static values in Assets, while children actors' values are relativte to parent 
	 */

public class CategoriesBox extends Table{
	private MainScreen ms;
	private ClickListener listener;
	TextButton btnProfile, btnTabs, btnTools, btnShort;

	
	CategoriesBox (Skin skin, final MainScreen ms){
		super(skin);
		this.ms = ms;
		setHeight(Assets.catH);
		setWidth(Assets.catW);
		setPosition(Assets.catX, Assets.catY); 
		setBackground("up");
		
		/*
		 * her har jeg delt koden opp i "kapittler"
		 */
		createButtons();
		createListener();
		addListenerToButtons();
		addButtonActors();
		


	}

	
	/*
	 * Konseptet er en listener for alle knappene, 
	 * her lages den med en if/else test for hvilken knapp som trykkes
	 * hver knapp kaller hver sin metode i view som clearer og legger til actors igjen
	 */
	private void createListener() {
		listener = new ClickListener(0){
			@Override
			public boolean handle(Event event) {
				// TODO Auto-generated method stub
				if (btnTabs.isPressed()){
					if(ms.view.current != ms.view.TABS){
						ms.view.setToTabsView();
					}
					
					
					this.setTapCountInterval(100);
				}
				else if (btnTools.isPressed()){
					if(ms.view.current != ms.view.TOOLS){
						ms.view.setToToolView();
					}
					
					
					this.setTapCountInterval(100);
				}else if (btnShort.isPressed()){
					if(ms.view.current != ms.view.SC){
						ms.view.setToSCView();
					}
					
					
					this.setTapCountInterval(100);
				}
					//else if (btnProfile.isPressed()){
//					if(ms.view.current != ms.view.PROFILE){
//						ms.view.setToProfilesView();;
//					}
//					this.setTapCountInterval(100);
//				}
				//Does the shit that happens when pressed.
				return false;
			}
		};
		
	}
	private void createButtons(){
		//btnProfile = new TextButton("Profile", Assets.txbStyle1);
		//btnProfile.setBounds(0,getHeight()-(Assets.btnCatH*1)+1,getWidth(),Assets.btnCatH);
		
		
		btnTabs = new TextButton("Tabs", Assets.txbStyle1);
		btnTabs.setBounds(0,getHeight()-(Assets.btnCatH*1) +1 ,getWidth(),Assets.btnCatH);
		
		
		btnTools = new TextButton("Tools", Assets.txbStyle1);
		btnTools.setBounds(0,getHeight()-(Assets.btnCatH*2)+1,getWidth(),Assets.btnCatH);
		
		
		btnShort = new TextButton("Shortcuts", Assets.txbStyle1);
		btnShort.setBounds(0,getHeight()-(Assets.btnCatH*3)+1,getWidth(),Assets.btnCatH);
		
	}
	public void addListenerToButtons(){
		//btnProfile.addListener(listener);
		btnTabs.addListener(listener);
		btnTools.addListener(listener);
		btnShort.addListener(listener);
	}
	public void addButtonActors(){
		//addActor (btnProfile);
		addActor (btnTabs);
		addActor (btnTools);
		addActor (btnShort);
	}
}
