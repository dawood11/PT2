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
	
}
