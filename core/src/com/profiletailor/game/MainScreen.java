package com.profiletailor.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

/*
 * Mainscreen is responsible for creating and distributing actors to stage.
 * Dimensions and position is defined by static values in Assets. Stage copies this.
 */
public class MainScreen implements Screen{
	public Stage stage;
	final public Game game;
	public CategoriesBox catTable;
	public ViewBox view;

	public PreviewToolGroup previewTG;
	public PerspectiveSetting perspectiveSetting;
	
	public MainScreen (Game g){
		//Gdx.app.log(TITLE, "ctor");

		PetrelFactory.load();
		game = g;
		stage = new Stage();
		//create all tables
		previewTG = new PreviewToolGroup(Assets.uiSkin);
		perspectiveSetting = new PerspectiveSetting(Assets.uiSkin);
		
		view = new ViewBox(Assets.uiSkin);

		catTable = new CategoriesBox(Assets.uiSkin, this);
		//catTable.setBackground(Assets.uiSkin.getDrawable("up"));	
		//view.addActor(new PerspectiveBox(Assets.uiSkin));
		//view.addActor(new TabSelectionBox(Assets.uiSkin) );
		

		//catTable.setBackground(Assets.uiSkin.getDrawable("up"));		

	}
	
	//Render is looping after show() is called.
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		//Gdx.app.log(TITLE, "render");
		
		Gdx.gl.glClearColor(1f, 1f, 1f, 1.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//Distributes action to actors, actors children, and actors children's children.
		stage.act(delta); //delta = time since last time drawn
		stage.draw(); //redraws
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	//Called once when screen is activated and creates. All data within the screen is created here. 
	@Override
	public void show() {
		//All input går gjennom stage
		Gdx.input.setInputProcessor(stage);
		
		//Add actors to table
		stage.addActor(catTable);
		stage.addActor(view);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
}
