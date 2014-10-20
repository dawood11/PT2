package com.profiletailor.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class PT2 extends Game {
	
	@Override
	public void create () {
		//new screen is created. PT2 must be sent to the screen.
		this.setScreen(new MainScreen(this));
		Assets.set();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
}
