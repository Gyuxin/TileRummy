package tilerummy;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class InfoView extends Pane{
	public InfoView()
	{
		Pane innerPane = new Pane();
		Label label1 = new Label("player1's tiles:"); 
		label1.relocate(10, 30); 
		label1.setPrefSize(120, 30);
		Label label2 = new Label("player2's tiles:"); 
		label2.relocate(10, 65); 
		label2.setPrefSize(120, 30);
		Label label3 = new Label("player3's tiles:"); 
		label3.relocate(10, 100);
		label3.setPrefSize(120, 30);
		Label label4 = new Label("player4's  tiles:"); 
		label4.relocate(10, 135);
		label4.setPrefSize(120, 30);
		Label label5 = new Label("rest of time:"); 
		label5.relocate(10, 170);
		label5.setPrefSize(120, 30);
		
	
		
		
		
		TextField computer1 = new TextField(); 
		computer1.relocate(130, 30); 
		computer1.setPrefSize(50, 30);
		TextField computer2 = new TextField(); 
		computer2.relocate(130, 65); 
		computer2.setPrefSize(50, 30);
		TextField computer3 = new TextField(); 
		computer3.relocate(130, 100); 
		computer3.setPrefSize(50, 30);
		TextField player = new TextField(); 
		player.relocate(130, 135); 
		player.setPrefSize(50, 30);
		
		TextField counter = new TextField(); 
		counter.relocate(130, 170); 
		counter.setPrefSize(50, 30);
		
	
		
		
		
		
		innerPane.getChildren().addAll(label1, label2, label3,label4,label5, computer1, computer2, computer3, player,counter);
		
		Label titleLabel = new Label(); // Title to be placed onto border 
		titleLabel.setText("Info: "); // Incoming constructor parameter 
		titleLabel.setStyle("-fx-background-color: white; \n" +
		"-fx-translate-y: 5; \n" +
		"-fx-translate-x: 10;"); 
		getChildren().addAll(innerPane, titleLabel);
		
		
		

		
	
		
	}
	
	
	
	
   

	

}
