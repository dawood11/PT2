package com.profiletailor.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class Dummy extends Image implements Drawable{
	private String navn;
	
	public Dummy(String navn, Drawable tex){
		super(tex);
		this.navn = navn;
		setSize(64f, 64f);
	}
	
	@Override
	public void draw(Batch batch, float x, float y, float width, float height) {
		
	}

	public Dummy copy(){
		Dummy d = new Dummy(navn, super.getDrawable());
		d.setSize(this.getWidth(), this.getHeight());
		return d;
	}
 
	@Override
	public float getLeftWidth() {
		return 0;
	}

	@Override
	public void setLeftWidth(float leftWidth) {
		
	}

	@Override
	public float getRightWidth() {
		return 0;
	}

	@Override
	public void setRightWidth(float rightWidth) {
		
	}

	@Override
	public float getTopHeight() {
		return 0;
	}

	@Override
	public void setTopHeight(float topHeight) {
		
	}

	@Override
	public float getBottomHeight() {
		return 0;
	}

	@Override
	public void setBottomHeight(float bottomHeight) {
		
	}

	@Override
	public float getMinWidth() {
		return 0;
	}

	@Override
	public void setMinWidth(float minWidth) {
		
	}

	@Override
	public float getMinHeight() {
		return 0;
	}

	@Override
	public void setMinHeight(float minHeight) {
		
	}

	public String getNavn() {
		return navn;
	}

}
