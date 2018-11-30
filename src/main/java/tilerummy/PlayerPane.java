package tilerummy;

import javafx.scene.layout.Pane;
import javafx.scene.control.Label;

@SuppressWarnings("restriction")
public class PlayerPane extends Pane {

    private final static int MAXIN = 26;
    
    private Label name;

    private float paneWidth = 1200;
    private float paneHeight = 100;
    private float cardWidth = 55;
    private float cardHeight = 40;

    private Player player;

    private CardView[] inhandTiles;

    public PlayerPane(Player aPlayer){
    	
    	name = new Label("Name");
    	name.relocate(0,0);
    	name.setPrefSize(100, 50);

        player = aPlayer;

        inhandTiles = new CardView[MAXIN];
        
        initialCardList();
        
    }

    public void initialCardList(){

        for(int i = 0; i < player.getNumberOfHandTile(); i++){
        	inhandTiles[i] = new CardView(player.getMyHandTile().get(i));
        	inhandTiles[i].setTranslateX(cardWidth*i);
        	inhandTiles[i].setTranslateY(paneHeight-cardHeight);

        	inhandTiles[i].setPrefHeight(cardHeight);
       		inhandTiles[i].setPrefWidth(cardWidth);
       		getChildren().add(inhandTiles[i]);
  
        }
        
        System.out.println(inhandTiles.length);
        
        getChildren().add(name);

    }
    
    public void resetPlayer(Player p) {
    	player = p;
    	update();
    }
    
    public void update() {
    	
    	getChildren().removeAll(inhandTiles);
    	System.out.println(inhandTiles.length);
    	for(int i = 0; i < player.getNumberOfHandTile(); i++){
            inhandTiles[i] = new CardView(player.getMyHandTile().get(i));
            inhandTiles[i].setTranslateX(cardWidth*i);
            inhandTiles[i].setTranslateY(paneHeight-cardHeight);

            inhandTiles[i].setPrefHeight(cardHeight);
            inhandTiles[i].setPrefWidth(cardWidth);
            getChildren().add(inhandTiles[i]);
        }
    	
    }
    
    public float getPaneHeight() {
    	return paneHeight;
    }
    
    public float getPaneWidth() {
    	return paneWidth;
    }

}
