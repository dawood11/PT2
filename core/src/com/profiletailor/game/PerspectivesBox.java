package com.profiletailor.game;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class PerspectivesBox extends Table{
	
	PerspectivesBox (Skin skin) {
		super(skin);
		setBackground("up");
		setBounds(Assets.padding, Assets.padding, ( Assets.viewW / 2 ) - (Assets.padding*3), Assets.viewH-(Assets.padding*2));
	}
		
}
