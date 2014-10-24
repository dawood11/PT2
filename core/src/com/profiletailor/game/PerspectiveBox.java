package com.profiletailor.game;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/*
 * This box is in the view of the perspectives category
 * located in left half of view
 */
public class PerspectiveBox extends Table {
	
	TextButton [] perspectives;

	
	PerspectiveBox (Skin skin){
		super(skin);
		setBackground("up");
		setBounds(0, 0, ( Assets.viewW / 2 ), Assets.viewH);
		setBackground("up");
		createButtons();
		addButtons();


	}
	private void createButtons(){
		perspectives = new TextButton[7];
		int i = 0;
		for(Perspective p : PetrelFactory.perspectives){
			perspectives[i] = new TextButton(p.name, Assets.txbStyle1);
			perspectives[i].setBounds(0,getHeight()-((Assets.btnCatH-1)*i)-Assets.btnCatH,getWidth(),Assets.btnCatH);
			perspectives[i].addListener(new ClickListener(0){
				@Override
				public boolean handle(Event event) {
					
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
