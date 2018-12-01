package tilerummy;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.util.Duration;

@SuppressWarnings("restriction")
public class InfoView extends Pane{
 
 Pane innerPane = new Pane();
 private int y_TimeLable;
 TextField counter = new TextField(); 
 TextArea console = new TextArea();
 private ArrayList<Player> players;
 private ArrayList<TextField> textFieldList = new ArrayList<TextField>();
 
 public InfoView(int numberOfPlayer, ArrayList<Player> players)
 {
   y_TimeLable = numberOfPlayer*35+30;
   this.players = players;
   initialView(numberOfPlayer);
   update();
 }
 
 public void update()
 {
	 for(int i=0; i<players.size();i++)
	 {
		 String num = String.valueOf(players.get(i).getNumberOfHandTile());
		 textFieldList.get(i).setText(num);
	 }
 }
 
 public void setCounterField(Integer timeLeft) {
   counter.setText(timeLeft.toString());
 }
 
 public void addToConsole(String s) {
  console.appendText(s);
 }
 
 public void initialView(int numberOfPlayer) { 
   for(int i=0; i<numberOfPlayer; i++) {
     Player temp = players.get(i);
     Label tempLable = new Label("player"+(i+1)+"\n"+temp.getPlayerType()); 
     tempLable.relocate(10, 30+35*i); 
     tempLable.setPrefSize(160, 30);
     tempLable.setFont(new Font(11));
     innerPane.getChildren().add(tempLable);
   }
   
   Label restTimeLable = new Label("rest of time:"); 
   restTimeLable.relocate(10, y_TimeLable);
   restTimeLable.setPrefSize(160, 30);
   innerPane.getChildren().add(restTimeLable);
   
   for(int i=0; i<numberOfPlayer; i++) {
     TextField tempText = new TextField(); 
     textFieldList.add(tempText);
     tempText.relocate(200, 30+35*i); 
     tempText.setPrefSize(50, 30);
     innerPane.getChildren().add(tempText);
   }
   
   counter.relocate(200, y_TimeLable); 
   counter.setPrefSize(50, 30);
   innerPane.getChildren().add(counter);
   
   console.relocate(10, y_TimeLable+45); 
   console.setPrefSize(240, 375);
   console.setPrefRowCount(200); 
   innerPane.getChildren().add(console);
   this.addToConsole("\n\nWELCOME!\n\n");
   Label titleLabel = new Label(); // Title to be placed onto border 
   titleLabel.setText("Info: "); // Incoming constructor parameter 
   titleLabel.setStyle("-fx-background-color: white; \n" +
   "-fx-translate-y: 5; \n" +
   "-fx-translate-x: 10;"); 
   getChildren().addAll(innerPane, titleLabel);
 }
}