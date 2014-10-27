package com.profiletailor.game;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
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

	
	CategoriesBox (Skin skin, final MainScreen ms){
		super(skin);
		this.ms = ms;
		setHeight(Assets.catH);
		setWidth(Assets.catW);
		setPosition(Assets.catX, Assets.catY); 
		setBackground("up");

		final TextButton btnProfile = new TextButton("Profile", Assets.txbStyle1);
		btnProfile.setBounds(0,getHeight()-(Assets.btnCatH*1)+1,getWidth(),Assets.btnCatH);
		
		final TextButton btnTabs = new TextButton("Tabs", Assets.txbStyle1);
		btnTabs.setBounds(0,getHeight()-(Assets.btnCatH*2) +1 ,getWidth(),Assets.btnCatH);
		btnTabs.addListener(new ClickListener(0){
			@Override
			public boolean handle(Event event) {
				// TODO Auto-generated method stub
				if (btnTabs.isPressed()){
					ms.view.clear();
					ms.view.addActor(ms.perspectiveSetting);
					this.setTapCountInterval(100);
				}
				//Does the shit that happens when pressed.
				return false;
			}
			
		});
		final TextButton btnTools = new TextButton("Tools", Assets.txbStyle1);
		btnTools.setBounds(0,getHeight()-(Assets.btnCatH*3)+1,getWidth(),Assets.btnCatH);
		
		final TextButton btnShort = new TextButton("Shortcuts", Assets.txbStyle1);
		btnShort.setBounds(0,getHeight()-(Assets.btnCatH*4)+1,getWidth(),Assets.btnCatH);
		
		addActor (btnProfile);
		addActor (btnTabs);
		addActor (btnTools);
		addActor (btnShort);
	}
}
