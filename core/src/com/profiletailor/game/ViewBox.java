package com.profiletailor.game;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;

/*
 * Contains everything except CategoriesBox, for easy cleaning and redrawing.
 * 
 */
public class ViewBox extends Table{
	//keeps status of view
	public final int TOOLS = 0, TABS = 1, SC = 2;
	public int current;
	public DragAndDrop dnd;
	
	//actors
	public TabSelectionBox tabSelectionBox;
	public PreviewTab previewTab;
	public SearchBox searchbox;
	public PreviewToolGroup previewTG;
	
	public ViewBox(Skin skin) {
		super(skin);
		setHeight(Assets.viewH);
		setWidth(Assets.viewW);
		setX(Assets.viewX);
		setY(Assets.viewY);
		setBackground("up");
		dnd = new DragAndDrop();
		dnd.setTouchOffset(-Assets.dummyW/2,  Assets.dummyH/2);
		dnd.setDragActorPosition(-Assets.dummyW/2,  Assets.dummyH/2);
		
		previewTG = new PreviewToolGroup(Assets.uiSkin);
		searchbox = new SearchBox();
		tabSelectionBox = new TabSelectionBox(Assets.uiSkin);
		previewTab = new PreviewTab(Assets.uiSkin);
		
		//default to tabs?
		setToTabsView();
		
		
	}
	
	/*
	 * Det er forskjellige metoder i view for hvert view
	 * alle clearer, setter current-variablen og adder actors
	 */
	public void setToToolView() {
		
		current = TOOLS;
		searchbox.resize(Assets.viewW/2, Assets.viewH- Assets.btmLineH); //searchbox might have to be resized
		searchbox.displayAll(); //shows all dummies, searchfunction is disabled
		searchbox.setSource(dnd); //sets Searchtable as drag and drop source		
		previewTG.setTarget(dnd); //sets toolgroup as dragAndDrop target
		previewTG.setSource(dnd);
		previewTG.load();
		
		//removes old actors and adds new 
		clear();
		addActor(previewTG);
		addActor(searchbox);		
		
	}

	public void setToSCView() {
		clear();
		current = SC;

		// TODO: add Shortcuts actors
		
		
	}

	public void setToTabsView() {
		clear();
		current = TABS;
		searchbox.resize(Assets.viewW/2, Assets.viewH - Assets.prevwRibH - Assets.btmLineH);
		searchbox.displayAll();
		searchbox.setSource(dnd);
		
		previewTab.setTarget(dnd);
		previewTab.setSource(dnd);
		previewTab.load();
		
		addActor(tabSelectionBox);
		addActor(searchbox);
		addActor(previewTab);

		
		
		
	}
}
