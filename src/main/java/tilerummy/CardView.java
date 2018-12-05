package tilerummy;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class CardView extends Button{
	
	private Tile tile;
	private boolean selected = false;
	
    public CardView(Tile t)
    {
    	tile = t;
        String colour = t.getColor();
        int number = t.getNumber();
        String numberInString = String.valueOf(number);
        this.setText(numberInString);
        if(colour.equals("R"))
        {
            this.setStyle("-fx-font: 22 arial; -fx-base: rgb(214,21,21); -fx-text-fill: rgb(255,255,255);");

        }
        else if(colour.equals("B"))
        {
            this.setStyle("-fx-font: 22 arial; -fx-base: rgb(0,0,0); -fx-text-fill: rgb(255,255,255);");
        }
        else if(colour.equals("G"))
        {
            this.setStyle("-fx-font: 22 arial; -fx-base: rgb(57,209,43); -fx-text-fill: rgb(255,255,255);");
        }
        else if(colour.equals("O"))
        {
            this.setStyle("-fx-font: 22 arial; -fx-base: rgb(244,111,9); -fx-text-fill: rgb(255,255,255);");
        }
        this.setPrefSize(50, 40);

        this.setOnAction(new EventHandler<ActionEvent>() {
   		 	public void handle(ActionEvent actionEvent) { 
   		 		handleButtonPress(); }
   		 });
        
    }
    
    public boolean getSelected() {
    	return selected;
    }
    
    public void handleButtonPress() {   	
    	selected = true;
    	tile.printTile();
    }
    
    public Tile getTile() {
    	return tile;
    }

}