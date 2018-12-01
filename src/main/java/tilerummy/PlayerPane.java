package tilerummy;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

import javafx.scene.control.Label;

public class PlayerPane extends Pane {

    private final static int MAXIN = 26;
    
    private Label name;

    private float paneWidth = 1200;
    private float paneHeight = 100;
    private float cardWidth = 55;
    private float cardHeight = 40;

    private int currentIndex;
    private ArrayList<Player> players;
    private Player player;

    private CardView[] inhandTiles;
    private ArrayList<CardView> selectedTiles = new ArrayList<CardView>();

    public PlayerPane(ArrayList<Player> p, int j){
     
     currentIndex = j;
     players = p;
     player = players.get(currentIndex);
;     name = new Label();
     name.relocate(0,0);
     name.setPrefSize(200, 50);
     
     this.setName();

        inhandTiles = new CardView[MAXIN];
        
        initialCardList();
        getChildren().add(name);
        
    }

    public void initialCardList(){

     player = players.get(currentIndex);
        for(int i = 0; i < player.getNumberOfHandTile(); i++){
         inhandTiles[i] = new CardView(player.getMyHandTile().get(i));
         inhandTiles[i].setTranslateX(cardWidth*i);
         inhandTiles[i].setTranslateY(paneHeight-cardHeight);

         inhandTiles[i].setPrefHeight(cardHeight);
         inhandTiles[i].setPrefWidth(cardWidth);
         getChildren().add(inhandTiles[i]);
  
        }
    }
    
    public int resetPlayer() {
        currentIndex++;
        
     if(currentIndex == players.size()) {
      currentIndex = 0;
     }
//     initialCardList();
      update();
      setName();
      return currentIndex;
    }
    
    public void update() { 
     player = players.get(currentIndex);
     getChildren().removeAll(inhandTiles);
     //System.out.println(inhandTiles.length);
     for(int i = 0; i < player.getNumberOfHandTile(); i++){
            inhandTiles[i] = new CardView(player.getMyHandTile().get(i));
            inhandTiles[i].setTranslateX(cardWidth*i);
            inhandTiles[i].setTranslateY(paneHeight-cardHeight);

            inhandTiles[i].setPrefHeight(cardHeight);
            inhandTiles[i].setPrefWidth(cardWidth);
            getChildren().add(inhandTiles[i]);
        }
     
    }
    
    public int getCurrentPlayer() {
     return currentIndex;
    }
    
    public float getPaneHeight() {
     return paneHeight;
    }
    
    public float getPaneWidth() {
     return paneWidth;
    }
    
    public void setName()
    {
     int i = currentIndex + 1;
     name.setText("Player"+i+"-"+player.getPlayerType());  
    }
    
    public CardView[] getInhandTile() {
     return inhandTiles;
    }
    
    public CardView getTile(int index) {
     return inhandTiles[index];
    }
    
    public ArrayList<CardView> getSelectedTiles(){
     return selectedTiles;
    }
    
    public void resetSelectedTiles() {
     selectedTiles = new ArrayList<CardView>();
    }

}