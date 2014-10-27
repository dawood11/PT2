package com.profiletailor.game;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class PerspectiveSetting extends Table{

	public PerspectiveSetting(Skin uiSkin) {
		super(uiSkin);
		setBackground("up");
		setBounds(( Assets.viewW / 2 )-1, 0, ( Assets.viewW / 2 )+1, Assets.viewH);
		setBackground("up");
	}
	
	public void loadPerspective(String perspectiveName){
		/*
		 * Called from buttons in perspectiveBox
		 * Calls method in factory to return perspective with same name
		 * Clears old content and adds the new content to itself
		 */
	}
	
}
