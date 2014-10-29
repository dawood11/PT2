package com.profiletailor.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class PreviewToolGroup extends Table{
	//Contains a linked list of small tables which hold one dummy each
	Label topLabel;
	Table buttonsTbl;
	

	PreviewToolGroup (Skin skin) {
		super(skin);
		setBackground("up");
		setBounds(Assets.viewW/2 , 0, Assets.viewW/2 , Assets.viewH);
		
		topLabel = new Label("My Ribbon", Assets.lblStyle1);
		topLabel.setBounds(0, Assets.viewH - Assets.lblH,  Assets.viewW/2,  Assets.lblH);
		
		buttonsTbl = new Table();
		buttonsTbl.setBounds(0, 0, Assets.viewW/2, Assets.viewH-Assets.lblH);
		buttonsTbl.setSkin(Assets.uiSkin);
		buttonsTbl.setBackground("up");
		
		addActor(topLabel);
		addActor(buttonsTbl);
		
	}
}
