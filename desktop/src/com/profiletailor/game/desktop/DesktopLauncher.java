package com.profiletailor.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.profiletailor.game.Assets;
import com.profiletailor.game.PT2;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = (int) Assets.screenH;
		config.width = (int) Assets.screenW;
		new LwjglApplication(new PT2(), config);
	}
}
