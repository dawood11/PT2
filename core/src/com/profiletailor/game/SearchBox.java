package com.profiletailor.game;


import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Payload;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Source;

/*
 * Contains searchfield and table with search results.
 * Dimensions and position is defined from static values in Assets, while children are relative to parent.
 */
public class SearchBox extends Table {
	Label lblTop; //header, if needed
	VerticalGroup tblResults; //displays search results
	TextField txfSearch; // input string for search
	TextFieldListener listener;
	Dummy[] dummies;

	
	SearchBox(){
		super();
		setClip(true); //clips children exceeding parents boundaries
		this.setBounds(0, Assets.btmLineH,  Assets.viewW/2,  Assets.viewH-Assets.btmLineH);
				
		create();
		show();			
		
	}
	private void create(){
		tblResults = new VerticalGroup(); //add skin?
		tblResults.setBounds(0, 0, getWidth(), getHeight() - (Assets.txfH + Assets.lblH));
		tblResults.align(Align.left);
		
		tblResults.space(Assets.padding);
		tblResults.pad(Assets.padding);				

		//Always stays at the top, but will not exceed parents boundaries
		lblTop = new Label("Search", Assets.lblStyle1 ); 
		lblTop.setBounds(0, getHeight()-Assets.lblH, Assets.viewW/2, Assets.lblH);

		
		txfSearch = new TextField("Search for items" , Assets.txfStyle1 );
		txfSearch.setSize(getWidth(), Assets.txfH);
		txfSearch.setPosition(0, getHeight() - (Assets.txfH + Assets.lblH));
		
		//TODO: seach only when enter is clicked
		txfSearch.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				
				//tblResults.clear();//empties tblResults
				String input = txfSearch.getText().toString().toLowerCase();
				if (!input.equals(" ")) {
					search(input);
				}
				return false;
			}
		});
		createDummies();
	}
	private void show(){
		addActor(txfSearch);
		addActor(tblResults);
		addActor(lblTop);
		displayAll();
	}
	
	private void search(String input){
		//System.out.println("SEARCHING: " + input);
	}
	public void displayAll(){
		for(Dummy d : dummies){
			if(d != null){
				tblResults.addActor(d);
				
				
			}
		}
		
	}
	private void createDummies(){
		dummies = new Dummy[16];
		dummies[0] = new Dummy("calc", Assets.dummySkin.getDrawable("calculator"));
		dummies[1] = new Dummy("database tool", Assets.dummySkin.getDrawable("database tool"));
		dummies[2] = new Dummy("edit well tops", Assets.dummySkin.getDrawable("edit well tops"));
		dummies[3] = new Dummy("folder", Assets.dummySkin.getDrawable("folder"));
		dummies[4] = new Dummy("insert two", Assets.dummySkin.getDrawable("insert two"));
		dummies[5] = new Dummy("insert", Assets.dummySkin.getDrawable("insert"));
		dummies[6] = new Dummy("managers", Assets.dummySkin.getDrawable("managers"));
		dummies[7] = new Dummy("new well tops folder", Assets.dummySkin.getDrawable("new well tops folder"));
		dummies[8] = new Dummy("object", Assets.dummySkin.getDrawable("object"));
		
		dummies[9] = new Dummy("searchbar", Assets.dummySkin.getDrawable("searchbar"));
		dummies[10] = new Dummy("sesmic interpetation", Assets.dummySkin.getDrawable("sesmic interpetation"));
		dummies[11] = new Dummy("studio", Assets.dummySkin.getDrawable("studio"));
		dummies[12] = new Dummy("synchronize", Assets.dummySkin.getDrawable("synchronize"));
		dummies[13] = new Dummy("tool palette", Assets.dummySkin.getDrawable("tool palette"));
		dummies[14] = new Dummy("visual filters", Assets.dummySkin.getDrawable("visual filters"));
		dummies[15] = new Dummy("window", Assets.dummySkin.getDrawable("window"));
	}
	/*
	 * The whole table acts as a drag-source
	 * dragstart:
	 * uses hit to determine which dummy to load
	 * dragstop:
	 * if a dummy is dropped outside target it is reentered into the table
	 */
	public void setSource(DragAndDrop dnd) {
		
		dnd.addSource(new Source(tblResults){
			
			@Override
			public Payload dragStart(InputEvent event, float x, float y,
					int pointer) {
				Dummy a = (Dummy)tblResults.hit(x, y, false);
				if(a != null){
					Payload p = new Payload();
					p.setDragActor(a);
					return p;
				}
				return null;

			}
			@Override
			public void dragStop(InputEvent event, float x, float y, int pointer, 
					DragAndDrop.Payload payload, DragAndDrop.Target target){
				if(target == null){
					Dummy returned = (Dummy)payload.getDragActor();
					tblResults.addActor(returned);
				}
			}
			
		});
		
	}
	public void resize(float width, float height){
		setSize(width, height);
		tblResults.setSize(width,  height - (Assets.txfH + Assets.lblH));
		lblTop.setPosition(0, getHeight()-Assets.lblH);
		txfSearch.setPosition(0, getHeight() - (Assets.txfH + Assets.lblH));
	}

	
}
