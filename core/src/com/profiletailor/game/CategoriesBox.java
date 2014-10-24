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
		
		final TextButton btnPerspectives = new TextButton("Perspectives", Assets.txbStyle1);
		btnPerspectives.setBounds(0,getHeight()-(Assets.btnCatH*2) +2 ,getWidth(),Assets.btnCatH);
		btnPerspectives.addListener(new ClickListener(0){
			@Override
			public boolean handle(Event event) {
				// TODO Auto-generated method stub
				if (btnPerspectives.isPressed()){
					ms.view.clear();
					ms.view.addActor(ms.perspectiveList);
					ms.view.addActor(ms.profile.getPerspective());
					this.setTapCountInterval(100);
				}
				//Does the shit that happens when pressed.
				return false;
			}
			
		});
		
		addActor (btnProfile);
		addActor (btnPerspectives);
	}
}
