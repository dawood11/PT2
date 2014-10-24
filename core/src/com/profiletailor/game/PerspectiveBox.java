package com.profiletailor.game;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/*
 * This box is in the view of the perspectives category
 * located in left half of view
 */
public class PerspectiveBox extends Table {
	
	TextButton [] perspectives;

	
	PerspectiveBox (Skin skin){
		super(skin);
		this.setBounds(0,  0,  Assets.viewW/2,  Assets.viewH);
		setBackground("up");
		createButtons();
		addButtons();


	}
	private void createButtons(){
		perspectives = new TextButton[7];
		int i = 0;
		for(Perspective p : PetrelFactory.perspectives){
			perspectives[i] = new TextButton(p.name, Assets.txbStyle1);
			perspectives[i].setBounds(0,getHeight()-(Assets.btnCatH*i)+i,getWidth(),Assets.btnCatH);
			perspectives[i].addListener(new EventListener(){
				@Override
				public boolean handle(Event event) {
					// TODO Auto-generated method stub
					//Does the shit that happens when pressed.
					return false;
				}
				
			});
			i++;
		}
	}
	private void addButtons(){
		for(TextButton tb : perspectives){
			if(tb != null){
				addActor(tb);
			}
		}
	}
}
