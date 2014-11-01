package com.profiletailor.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Payload;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Source;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Target;

public class PreviewToolGroup extends Table{
	//Contains a linked list of small tables which hold one dummy each
	Label topLabel;
	Table buttonsTbl;
	

	PreviewToolGroup (Skin skin) {
		super(skin);
		setBackground("up");
		setBounds(Assets.viewW/2 , 0, Assets.viewW/2 , Assets.viewH);
		
		topLabel = new Label("My Toolgroup", Assets.lblStyle1);
		topLabel.setBounds(0, Assets.viewH - Assets.lblH,  Assets.viewW/2,  Assets.lblH);
		
		buttonsTbl = new Table();
		buttonsTbl.setBounds(0, 0, Assets.viewW/2, Assets.viewH-Assets.lblH);
		buttonsTbl.setSkin(Assets.uiSkin);
		buttonsTbl.setBackground("up");
		
		addActor(topLabel);
		addActor(buttonsTbl);
		
	}


	public void setTarget(DragAndDrop dnd) {
		dnd.addTarget(new Target(buttonsTbl){

			@Override
			public boolean drag(Source source, Payload payload, float x,
					float y, int pointer) {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public void drop(Source source, Payload payload, float x, float y,
					int pointer) {
				Dummy dropped = (Dummy)payload.getDragActor();
				dropped.setPosition(Assets.padding, buttonsTbl.getHeight() - dropped.getHeight() - Assets.padding);
				buttonsTbl.addActor(dropped);
				
			}
			
		});
		
	}
}
