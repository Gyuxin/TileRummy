package tilerummy;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.layout.*;

public class MainGameView extends Pane {

	private PlayerPane playerPane;
	private TablePane tablePane;
	private InfoView infoPane;
	private Button exit; 
	private Button skip;
	
	private int numPlayers;
	
	private float paneWidth = 1280;
	private float paneHeight = 713;
	
	public MainGameView(TablePane aTablePane, PlayerPane aPlayerPane, InfoView aInfoPane) {
		
		playerPane = aPlayerPane;
		playerPane.relocate(10, 600);
		playerPane.setPrefSize(playerPane.getPrefWidth(), playerPane.getPrefHeight());
		
		tablePane = aTablePane;
		tablePane.relocate(10, 10);
		tablePane.setPrefSize(tablePane.getPrefWidth(), tablePane.getPrefHeight());
		
		infoPane = aInfoPane;
		infoPane.relocate(1000, 0);
		infoPane.setPrefSize(30, 50);
		
		exit = new Button();
		exit.setText("QUIT GAME");
		exit.relocate(1000, 600);
		exit.setPrefSize(120, 20);
		
		skip = new Button();
		skip.setText("SKIP GAME");
		skip.relocate(1000, 630);
		skip.setPrefSize(120, 20);
		
		
		getChildren().add(playerPane);
		getChildren().add(tablePane);
		getChildren().add(infoPane);
		getChildren().add(exit);
		getChildren().add(skip);
	}
	
	public void update() {
		
		playerPane.update();
		tablePane.update();
		
	}
	public Button getExitButton()
	{
		return exit;
	}
	
}