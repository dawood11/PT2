package com.profiletailor.game;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class PreviewToolGroup extends Table{
	//Contains a linked list of small tables which hold one dummy each
	PreviewToolGroup (Skin skin) {
		super(skin);
		setBackground("up");
		setBounds(5, 5, 350, 600);
	}
}
