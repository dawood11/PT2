package com.profiletailor.game;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class BottomLine extends Table{
	MainScreen ms;
	TextButton apply, cancel, help, undo, redo, 
		_import, _export;
	ClickListener listener;
	
	BottomLine( Skin skin, MainScreen ms){
		super(skin);
		this.ms = ms;
		setPosition(Assets.padding, Assets.padding);
		setSize(Assets.btmLineW, Assets.btmLineH);
		
		this.setBackground("down");
		
		create();
		createListener();
		listenToButtons();
		show();
	}
	/*
	 * Create all buttons
	 */
	private void create(){
		float posX = getWidth() - Assets.btmButtonW1 - Assets.padding;
		apply = new TextButton("apply", Assets.txbStyle1);
		apply.setPosition( posX, Assets.padding);
		apply.setSize( Assets.btmButtonW1, Assets.btmButtonH);
		
		cancel = new TextButton("cancel", Assets.txbStyle1);
		cancel.setPosition(  posX -= Assets.btmButtonW1 + Assets.padding, Assets.padding);
		cancel.setSize(Assets.btmButtonW1, Assets.btmButtonH);
		
		posX -= 2*Assets.padding;
		
		help = new TextButton("help", Assets.txbStyle1);
		help.setPosition(posX -= Assets.padding + Assets.btmButtonW1, Assets.padding);
		help.setSize(Assets.btmButtonW1, Assets.btmButtonH);
		
		posX -= 2*Assets.padding;
		
		redo = new TextButton("redo", Assets.txbStyle1);
		redo.setPosition(posX -= Assets.padding + Assets.btmButtonW1, Assets.padding);
		redo.setSize(Assets.btmButtonW1, Assets.btmButtonH);
		
		undo = new TextButton("undo", Assets.txbStyle1);
		undo.setPosition(posX -= Assets.padding + Assets.btmButtonW1, Assets.padding);
		undo.setSize(Assets.btmButtonW1, Assets.btmButtonH);
		
	
		_import = new TextButton("import", Assets.txbStyle1);
		_import.setPosition(Assets.padding, Assets.padding);
		_import.setSize(Assets.btmButtonW1, Assets.btmButtonH);
		
		_export = new TextButton("export", Assets.txbStyle1);
		_export.setPosition(2*Assets.padding + Assets.btmButtonW1, Assets.padding);
		_export.setSize(Assets.btmButtonW1, Assets.btmButtonH);
		
		

	}
	/*
	 * Add actors that are shown
	 */
	private void show(){
		addActor(apply);
		addActor(cancel);
		addActor(help);
		addActor(undo);
		addActor(redo);
		addActor(_import);
		addActor(_export);
	}
	private void listenToButtons(){
		cancel.addListener(listener);
		apply.addListener(listener);
	}
	private void createListener() {
		listener = new ClickListener(0){
			@Override
			public boolean handle(Event event) {
				// TODO Auto-generated method stub
				if (apply.isPressed()){
					System.out.println("Apply is not implemented");			
					
					this.setTapCountInterval(100);
				}else if (cancel.isPressed()){
					System.out.println("Cancel is not implemented");					
					this.setTapCountInterval(100);
				}else if(help.isPressed()){
					System.out.println("Help is not implented");
					this.setTapCountInterval(100);
				}
				return false;
			}
		};
		
	}
}
