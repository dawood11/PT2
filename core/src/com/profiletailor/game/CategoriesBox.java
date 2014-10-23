package com.profiletailor.game;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

	/*
	 * Table for menu with buttons for Ribbons, ToolGroups, Perspectives osv.
	 * Gimensions and position from static values in Assets, while children actors' values are relativte to parent 
	 */
public class CategoriesBox extends Table{

	CategoriesBox (Skin skin){
		super(skin);
		setHeight(Assets.catH);
		setWidth(Assets.catW);
		setPosition(Assets.catX, Assets.catY); 
		setBackground("up");

		TextButton btnProfile = new TextButton("Profile", Assets.txbStyle1);
		btnProfile.setBounds(0,getHeight()-(Assets.btnCatH*1)+1,getWidth(),Assets.btnCatH);
		
		TextButton btnPerspectives = new TextButton("Perspectives", Assets.txbStyle1);
		btnPerspectives.setBounds(0,getHeight()-(Assets.btnCatH*2) +2 ,getWidth(),Assets.btnCatH);
		btnPerspectives.addListener(new EventListener(){
			@Override
			public boolean handle(Event event) {
				// TODO Auto-generated method stub
				//Does the shit that happens when pressed.
				return false;
			}
			
		});
		
		addActor (btnProfile);
		addActor (btnPerspectives);
	}
}
