package com.profiletailor.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
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
	
	public static float txfHeight = 15;
	public static float lblHeight = 15;
	public static float btnCatHeight = 20;
	
	public static TextureAtlas uiAtlas;
	public static TextureAtlas dummyAtlas;
	public static Skin uiSkin;
	public static Skin dummySkin;
	public static TextButtonStyle txbStyle1;
	public static TextFieldStyle txfStyle1;
	public static LabelStyle lblStyle1;
	public static BitmapFont white, black, smallWhite, smallBlack;

	
	public static void set(){
		//initiate assets, import 9-packs, define skins, fonts and styles
		

		uiAtlas = new TextureAtlas("ui/pt2ui.pack");
		dummyAtlas = new TextureAtlas("dummys/dummys.pack");

		uiSkin = new Skin(uiAtlas); //Skin for everything that is not a searchable
		
		//Styles get their drawables from uiSkin;
		txbStyle1 = new TextButtonStyle();
		txbStyle1.down = uiSkin.getDrawable("txbDown");
		txbStyle1.up = uiSkin.getDrawable("txbUp");
		txbStyle1.pressedOffsetX = 1;
		txbStyle1.pressedOffsetY = -1;
		txbStyle1.font = smallWhite;
		
		
		txfStyle1 = new TextFieldStyle();
		txfStyle1.background = uiSkin.getDrawable("txfBg");
		txfStyle1.font = smallBlack;
		
	}
}
