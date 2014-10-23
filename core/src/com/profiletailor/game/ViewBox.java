package com.profiletailor.game;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/*
 * Contains everything except CategoriesBox, for easy cleaning and redrawing.
 * 
 */
public class ViewBox extends Table{
	
	public ViewBox(Skin skin) {
		super(skin);
		setHeight(Assets.viewH);
		setWidth(Assets.viewW);
		setX(Assets.viewX);
		setY(Assets.viewY);
		setBackground("up");
	}
	/*
	 * AddActor and Clear is called outside this class to change "views" :P
	 * It's possible that we could use a method for each view, just for simplicity? 
	 */
	
}
