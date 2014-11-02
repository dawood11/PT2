package com.profiletailor.game;


import java.util.LinkedList;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Payload;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Source;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Target;

public class PreviewTab extends Table {
	private Label nameLbl;
	private HorizontalGroup preview;
	LinkedList <Dummy> memory;
	
	
	PreviewTab(Skin skin){
		super(skin);
		setBounds(0, Assets.viewH - Assets.prevwRibH, Assets.viewW, Assets.prevwRibH);

		create();
		show();

	}
	private void create(){
		nameLbl = new Label("My Tab", Assets.lblStyle1);
		nameLbl.setBounds(0, getHeight() - Assets.lblH,  getWidth(),  Assets.lblH);
		
		preview = new HorizontalGroup();
		preview.setBounds(0, 0, getWidth(), getHeight()- Assets.lblH);
		preview.space(Assets.padding);
		preview.pad(Assets.padding);

		
		memory = new LinkedList<Dummy>();
	}
	private void show(){
		addActor(nameLbl);
		addActor(preview);
	}
	//called when preview is shown and loads all dummies in memory
	public void load(){
		for(Dummy d : memory){
			preview.addActor(d);
		}
	}


	public void setTarget(DragAndDrop dnd) {
		dnd.addTarget(new Target(preview){

			@Override
			public boolean drag(Source source, Payload payload, float x,
					float y, int pointer) {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public void drop(Source source, Payload payload, float x, float y,
					int pointer) {
				Dummy dropped = (Dummy)payload.getDragActor();
				dropped.setPosition(Assets.padding, preview.getHeight() - dropped.getHeight() - Assets.padding);
				//preview.addActor(dropped);
				preview.addActor(dropped);
				memory.add(dropped);
				//realign();
				
			}
			
		});

	}
	public void setSource(DragAndDrop dnd){
		dnd.addSource(new Source(preview){

			@Override
			public Payload dragStart(InputEvent event, float x, float y,
					int pointer) {
				Payload p = new Payload();
				Dummy hit = (Dummy)preview.hit(x, y, true);
				p.setDragActor(hit);
				memory.remove(hit);
				
				return p;
			}
			@Override
			public void dragStop(InputEvent event, float x, float y, int pointer, 
					DragAndDrop.Payload payload, DragAndDrop.Target target){
				if(target == null){
					preview.addActor((Dummy)payload.getDragActor());
					memory.add((Dummy)payload.getDragActor());
				}
			}
			
		});
	}
	


}
