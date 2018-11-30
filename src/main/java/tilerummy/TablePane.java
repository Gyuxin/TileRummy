package tilerummy;

<<<<<<< Updated upstream
import java.util.ArrayList;

import javafx.scene.layout.*;

@SuppressWarnings("restriction")
public class TablePane extends Pane {
	
	private float paneWidth;
	private float paneHeight;
	
	private float cardWidth;
	private float cardHeight;
	
	private Table table;
	private ArrayList<CardView[]> melds;
	
	public TablePane(Table t) {
		
		table = t;
		melds = new ArrayList<CardView[]>();
		paneWidth = 1200;
		paneHeight = 800;
		
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
				getChildren().add(meldView[j]);
				
			}
			
			currentX += m.getMeldSize()*cardWidth + 20;
			melds.add(meldView);
		}
		
	}
	
	public void update() {
		
		for(int i = 0; i < melds.size(); i++) {
			getChildren().removeAll(melds.get(i));
		}
		
		setUpTable();
		
	}
	
	public float getPaneHeight() {
		return paneHeight;
	}
	
	public float getPaneWidth() {
		return paneWidth;
	}

}
=======
 import java.util.ArrayList;

 import javafx.scene.layout.*;

 @SuppressWarnings("restriction")
 public class TablePane extends Pane {
 	
 	private float paneWidth;
 	private float paneHeight;
 	
 	private float cardWidth;
 	private float cardHeight;
 	
 	private Table table;
 	private ArrayList<CardView[]> melds;
 	
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
 				getChildren().add(meldView[j]);
 				
 			}
 			
 			currentX += m.getMeldSize()*cardWidth + 20;
 			melds.add(meldView);
 		}
 		
 	}
 	
 	public void update() {
 		
 		for(int i = 0; i < melds.size(); i++) {
 			getChildren().removeAll(melds.get(i));
 		}
 		
 		setUpTable();
 		
 	}
 	
 	public float getPaneHeight() {
 		return paneHeight;
 	}
 	
 	public float getPaneWidth() {
 		return paneWidth;
 	}

 }
>>>>>>> Stashed changes
