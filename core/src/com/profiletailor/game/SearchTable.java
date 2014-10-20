package com.profiletailor.game;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

/*
 * Contains searchfield and table with search results.
 * Dimensions and position is defined from static values in Assets, while children are relative to parent.
 */
public class SearchTable extends Table {
	Label lblTop; //header, if needed
	Table tblResults; //displays search results
	TextField txfSearch; // input string for search
	
	SearchTable(){
		super();
		setClip(true); //clips children exceeding parents boundaries
		
		//Create and define actors
		tblResults = new Table(Assets.uiSkin);
		lblTop = new Label("Search", Assets.lblStyle1);
		txfSearch = new TextField("Search for items" , Assets.txfStyle1);

		//Always stays at the top, but will not exceed parents boundaries
		lblTop.setSize(getWidth(), Assets.lblHeight);
		lblTop.setPosition(0, getHeight() - lblTop.getHeight());
		
		//Always stays under lblTop
		txfSearch.setSize(getWidth(), Assets.txfHeight);
		txfSearch.setPosition(0, getHeight() - (txfSearch.getHeight() + lblTop.getHeight()));
		txfSearch.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				tblResults.clear();//empties tblResults
				String input = txfSearch.getText().toString().toLowerCase();
				if (!input.equals(" ")) {
					search(input);
				}
				return false;
			}
		});
		
		//Always stays right beneath lblTop and txfSearch
		tblResults.setSize(getWidth(), getHeight() - (txfSearch.getHeight() + lblTop.getHeight()));
		tblResults.setPosition(0, 0);
		
	}
	
	private void search(String input){
		/*
		 * Called when input is registered in txfSearch
		 * must:
		 * - ignore letter casing
		 * - ignore other input than essential keyboard-presses
		 * - clears previous results
		 * - loop through all searchable items and display them in tblResults
		 */
	}
	
}
