package com.profiletailor.game;


import java.util.LinkedList;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Payload;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Source;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Target;

public class PreviewToolGroup extends Table{
	
	private Label topLabel;
	private Table buttonsTbl;
	private HorizontalGroup [] tbl;
	private int[] tblCnt;
	private LinkedList <Dummy> memory;
	private final int FULL = 6;
	

	PreviewToolGroup (Skin skin) {
		super(skin);
		setBackground("up");
		setBounds(Assets.viewW/2 , Assets.btmLineH, Assets.viewW/2 , Assets.viewH - Assets.btmLineH);
		create();
		setupTable();
		show();		
		
	}
	private void create(){
		topLabel = new Label("My Toolgroup", Assets.lblStyle1);
		topLabel.setBounds(0, getHeight() - Assets.lblH,  getWidth(),  Assets.lblH);
		
		buttonsTbl = new Table();
		buttonsTbl.setBounds(0, 0, getWidth(), getHeight()-Assets.lblH);
		buttonsTbl.setSkin(Assets.uiSkin);
		buttonsTbl.setBackground("up");
		
		tbl = new HorizontalGroup[10];
		tblCnt = new int[tbl.length];
		
		memory = new LinkedList <Dummy>();
			

	}
	private void show(){
		addActor(topLabel);
		addActor(buttonsTbl);
	}
	private void setupTable(){
		int i = 0;
		for(float h = buttonsTbl.getHeight()-(Assets.dummyH + Assets.padding); h > 0; h-= Assets.dummyH + Assets.padding){
			tbl[i] = new HorizontalGroup();
			tbl[i].setBounds(Assets.padding, h, getWidth() - 2*Assets.padding, Assets.dummyH);
			tbl[i].space(Assets.padding);
			buttonsTbl.addActor(tbl[i]);
			i++;
		}
	}
	//called when reentering view
	public void load(){
		tblCnt = new int[tbl.length];
		for(Dummy d : memory){
			this.addDummyToTable(d);
		}
	}

	public void setTarget(DragAndDrop dnd) {
		dnd.addTarget(new Target(buttonsTbl){

			@Override
			public boolean drag(Source source, Payload payload, float x,
					float y, int pointer) {
				
				return true;
			}

			@Override
			public void drop(Source source, Payload payload, float x, float y,
					int pointer) {
				Dummy dropped = (Dummy)payload.getDragActor();
				addDummyToTable(dropped);	
				memory.add(dropped);
			}
			
		});
		
	}
	public void setSource(DragAndDrop dnd){
		dnd.addSource(new Source(this){

			@Override
			public Payload dragStart(InputEvent event, float x, float y,
					int pointer) {
				Payload p = new Payload();
				Actor hit = buttonsTbl.hit(x,  y,  true);
				
				if(hit instanceof Dummy){
					p.setDragActor((Dummy)hit);
					tblCnt[((Dummy) hit).row]--;
					memory.remove(hit);
					return p;					
				}
				return null;

			}
			@Override
			public void dragStop(InputEvent event, float x, float y, int pointer, 
					DragAndDrop.Payload payload, DragAndDrop.Target target){
				if(target == null){
					Dummy dum = (Dummy)payload.getDragActor();
					addDummyToTable(dum);
					memory.add(dum);
					
				}
				
			}
			
			
		});
	}
	private void addDummyToTable(Dummy d){
		for(int i = 0; i < tbl.length; i++){
			if (tbl[i] != null && tblCnt[i] < FULL){
				tbl[i].addActor(d);
				
				d.row = i;
				tblCnt[i]++;
				break;
			}
		}
	}
}
