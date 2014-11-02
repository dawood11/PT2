package com.profiletailor.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox.CheckBoxStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;

	/*
	 * Contains static values for:
	 * - dimensions for first-level actors on stage
	 * - screen-dimensions
	 * - labelstyles
	 * - fonts
	 * - textfieldstyles
	 * - atlas
	 * - tablestyles
	 */

abstract public class Assets {
	public static boolean DEBUG = false;
	public static float screenH = 640, screenW = 1080, padding = 5;
	
	public static float catX = 0 + padding,
			catY = 0 + padding,
			catH = screenH * .95f ,
			catW = screenW / 7.0f; //..or something like that.
	
	public static final float viewX = 0 + catW + catX + padding,
			viewY = 0 + padding ,
			viewH = catH,
			viewW = screenW - catW - (padding * 3);
	
	public static float txfH = 15;
	public static float lblH = 15;
	public static float btnCatH = 35;

	
	
	public static TextureAtlas uiAtlas;
	public static TextureAtlas dummyAtlas;
	public static Skin uiSkin;
	public static Skin dummySkin;
	public static TextButtonStyle txbStyle1;
	public static TextFieldStyle txfStyle1;
	public static LabelStyle lblStyle1;
	public static BitmapFont white, black, smallWhite, smallBlack;
	public static CheckBoxStyle checkBoxStyle;
	


	public static Texture checked, unchecked;

	public static float dummyH = 64f;
	public static float dummyW = 64f;

	public static float prevwRibH =  dummyH + padding*2 + lblH;
	public static float btmButtonW1 = 50,
			btmButtonW2 = 25,
			btmButtonH = 35, 
			btmLineH = btmButtonH + 2*padding,
			btmLineW = screenW - 2*padding;
	
	public static float boxW = 30, boxH = 30;
		
	public static void set(){
		//initiate assets, import 9-packs, define skins, fonts and styles
		

		uiAtlas = new TextureAtlas("pt2ui.pack");
		dummyAtlas = new TextureAtlas("dummy.pack");

		uiSkin = new Skin(uiAtlas); //Skin for everything that is not a searchable
		dummySkin = new Skin(dummyAtlas);
		

		
		smallWhite = new BitmapFont(Gdx.files.internal("white.fnt"), false);
		smallBlack = new BitmapFont(Gdx.files.internal("black.fnt"), false);
		
		
		//temporary check box styles
		checkBoxStyle = new CheckBoxStyle(uiSkin.getDrawable("down"), 
				uiSkin.getDrawable("up"), smallBlack, Color.BLACK);
		
		

		
		//Styles get their drawables from uiSkin;
		txbStyle1 = new TextButtonStyle();
		txbStyle1.down = uiSkin.getDrawable("down");
		txbStyle1.up = uiSkin.getDrawable("up");
		txbStyle1.pressedOffsetX = 1;
		txbStyle1.pressedOffsetY = -1;
		txbStyle1.font = smallBlack;
		txbStyle1.font.setScale(0.5f);
		
		
		txfStyle1 = new TextFieldStyle();
		txfStyle1.background = uiSkin.getDrawable("up");
		txfStyle1.font = smallBlack;
		txfStyle1.fontColor = Color.GRAY;
		
		lblStyle1 = new LabelStyle();
		lblStyle1.font = smallBlack;
		lblStyle1.background = uiSkin.getDrawable("down");
		
		
	}
}
