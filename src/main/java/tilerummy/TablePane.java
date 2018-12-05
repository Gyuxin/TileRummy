package tilerummy;

 import java.util.ArrayList;

import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;

 public class TablePane extends Pane {
 	
 	private float paneWidth;
 	private float paneHeight;
 	
 	private float cardWidth;
 	private float cardHeight;
 	
 	private Table table;
 	private ArrayList<CardView[]> melds;
 		
 	DropShadow shadow = new DropShadow();
 	
 	public TablePane(Table t) {
 		
 		table = t;
 		melds = new ArrayList<CardView[]>();
 		paneWidth = 1000;
 		paneHeight = 600;
 		
 		cardWidth = 60;
         cardHeight = 50;
         
         setUpTable();

 	}
 	
 	public void setUpTable() {
 		
 		int currentX = 0;
 		int currentY = 0;
 		
 		for(int i = 0; i < table.getSize(); i++) {
 			
 			Meld m = table.getMeld(i);
 			CardView[] meldView = new CardView[m.getMeldSize()];
 			
 			//Need a function to check if the width exceeds the max width
 			//换行function
 			
 			if((currentX + cardWidth*(m.getMeldSize())) > paneWidth) {
 				currentX = 0;
 				currentY += cardHeight+20;
 			}
 			
 			for(int j = 0; j < m.getMeldSize(); j++) {
 				
 				meldView[j] = new CardView(m.get(j));
 				meldView[j].setTranslateX(currentX+cardWidth*j);
 				meldView[j].setTranslateY(currentY);
 				
 				meldView[j].setPrefWidth(cardWidth);
 				meldView[j].setPrefHeight(cardHeight);
 				
 				if(m.getJustPlayed()) {
 					meldView[j].setEffect(shadow);
 				}
 				
 				getChildren().add(meldView[j]);
 				
 			}
 			
 			currentX += m.getMeldSize()*cardWidth + 20;
 			melds.add(meldView);
 		}
 		table.setMeldsPlayedFalse();
 	}
 	
 	public void update() {

 		for(int i = 0; i < melds.size(); i++) {
 			getChildren().removeAll(melds.get(i));
 		}	
 		melds = new ArrayList<CardView[]>();
 		setUpTable();

 		
 	}
 	
 	public float getPaneHeight() {
 		return paneHeight;
 	}
 	
 	public float getPaneWidth() {
 		return paneWidth;
 	}
 	
 	public ArrayList<CardView[]> getTable(){
 		return melds;
 	}

 }
