package tilerummy;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


@SuppressWarnings("restriction")
public class testCounter extends Application {
 
 Label lb;
 Stage windows;
 private final Integer starttime=15;
 private Integer seconds= starttime;
 
 @Override
 public void start(Stage primaryStage) {
	  windows= primaryStage;
	  Group root= new Group();
	  lb= new Label();
	  lb.setText("Countdown: 15");
	  lb.setFont(Font.font(30));
	  lb.setTextFill(Color.RED);
	  
	   doTime();
	  
	  HBox layout= new HBox(5);
	  layout.getChildren().add(lb);
	  root.getChildren().add(layout);
	  Scene scene= new Scene(root, 300,70, Color.BLACK);
	  windows.setScene(scene);
	  windows.show();
  
 }
 
 private void doTime() {
	  final Timeline time= new Timeline();
	  KeyFrame frame= new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
		    
		    seconds--;
		    lb.setText("Countdown: "+seconds.toString());
		    if(seconds<=0){
		     time.stop();
		    }   
		   }
	  });
	  
	  time.setCycleCount(Timeline.INDEFINITE);
	  time.getKeyFrames().add(frame);
	  if(time!=null){
	   time.stop();
	  }
	  time.play();
 }

 public static void main(String[] args) {
  launch(args);
 }
}
