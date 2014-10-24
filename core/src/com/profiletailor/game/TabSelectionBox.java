package com.profiletailor.game;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class TabSelectionBox extends Table {
	TabSelectionBox(Skin skin){
		super(skin);
		this.setBounds(Assets.viewW/2, 0,  Assets.viewW/2,  Assets.viewH - Assets.prevwRibH);
		setBackground("up");
	}
}
