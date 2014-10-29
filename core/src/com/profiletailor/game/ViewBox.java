package com.profiletailor.game;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/*
 * Contains everything except CategoriesBox, for easy cleaning and redrawing.
 * 
 */
public class ViewBox extends Table{
	public final int TOOLS = 0, TABS = 1, SC = 2, PROFILE = 3;
	public SearchBox searchbox;
	public PreviewToolGroup previewTG;
	public int current;
	
	public ViewBox(Skin skin) {
		super(skin);
		setHeight(Assets.viewH);
		setWidth(Assets.viewW);
		setX(Assets.viewX);
		setY(Assets.viewY);
		setBackground("up");
		
		previewTG = new PreviewToolGroup(Assets.uiSkin);
		searchbox = new SearchBox();
	}
	
	/*
	 * Det er forskjellige metoder i view for hvert view
	 * alle clearer, setter current-variablen og adder actors
	 */
	public void setToToolView() {
		clear();
		current = TOOLS;
		addActor(previewTG);
		addActor(searchbox);		
	}

	public void setToSCView() {
		clear();
		current = TOOLS;
		// TODO: add Actor ShortCut Picker
		
		
	}

	public void setToTabsView() {
		clear();
		current = TABS;
		/*
		 * TODO: add actors for tabs view
		 */
		
	}
	
}
