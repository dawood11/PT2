package com.profiletailor.game;


import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
/*
 * This is where the user picks which tabs are visible in My Perspective
 * TODO: trenger ny CheckBoxStyle
 * TODO: fix scrollpane
 */
public class TabSelectionBox extends Table {
	CheckBox [] boxes;
	VerticalGroup boxGroup;
	ScrollPane pane;
	
	
	TabSelectionBox(Skin skin){
		super(skin);
		this.setBounds(Assets.viewW/2, Assets.btmLineH,  Assets.viewW/2,  Assets.viewH - Assets.prevwRibH-Assets.btmLineH);
		setBackground("up");
		create();
		show();
	}
	private void create(){
		boxGroup = new VerticalGroup();
		boxGroup.setPosition(Assets.padding, Assets.padding);
		boxGroup.setHeight(getHeight() - 2*Assets.padding);
		boxGroup.setWidth(Assets.boxW + Assets.padding);
		boxGroup.align(Align.left);
		boxGroup.space(Assets.padding);

		
		
		boxes =  new CheckBox[11];
		boxes[0] = new CheckBox("File", Assets.checkBoxStyle);
		boxes[0].addListener(new ChangeListener(){
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Assets.DEBUG = !Assets.DEBUG;
				
			}			
		});
		boxes[1] = new CheckBox("Home", Assets.checkBoxStyle);
		boxes[2] = new CheckBox("My Tab", Assets.checkBoxStyle);
		boxes[3] = new CheckBox("Stratigraphy", Assets.checkBoxStyle);
		boxes[4] = new CheckBox("Seismic Interpretation", Assets.checkBoxStyle);
		boxes[5] = new CheckBox("Structural Modelling", Assets.checkBoxStyle);
		boxes[6] = new CheckBox("Property modelling", Assets.checkBoxStyle);
		boxes[7] = new CheckBox("Fracture Modelling", Assets.checkBoxStyle);
		boxes[8] = new CheckBox("Reservoir Engineering", Assets.checkBoxStyle);
		boxes[9] = new CheckBox("Well Enigneering", Assets.checkBoxStyle);
		boxes[10] = new CheckBox("Simulation", Assets.checkBoxStyle);
		
		//Temporary Skin! How to adjust the size of the scrollbar?
		pane = new ScrollPane(this, new ScrollPaneStyle(Assets.uiSkin.getDrawable("up"), 
				Assets.uiSkin.getDrawable("down"), 
				Assets.uiSkin.getDrawable("up"),
				Assets.uiSkin.getDrawable("down"), 
				Assets.uiSkin.getDrawable("up")));
	    pane.setFillParent(true);
	    pane.setFadeScrollBars(false);
	    pane.setWidget(boxGroup);
	   
	    
		
	}
	private void show(){
		//addActor(boxGroup);
		 addActor(pane);
		for(CheckBox cb : boxes){
			if(cb != null){
				boxGroup.addActor(cb);
			}
		}

	}
}
