package com.profiletailor.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class PT2 extends Game {
	
	@Override
	public void create () {
		//new screen is created. PT2 must be sent to the screen.
		Assets.set();
		setScreen(new MainScreen(this));
		
	}
}
