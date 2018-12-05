package tilerummy;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.layout.*;

public class MainGameView extends Pane {

	private PlayerPane playerPane;
	private TablePane tablePane;
	private InfoView infoPane;
	private Button exit; 
	private Button skip;
	private Button deal;
	private Button AIGo;
	private Button end;
	private Button reset;
	private Button add;
	
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
		
		AIGo = new Button();
		AIGo.setText("AI GO");
		AIGo.relocate(1130, 600);
		AIGo.setPrefSize(120, 20);
		
		deal = new Button();
		deal.setText("DEAL CARD");
		deal.relocate(1130, 630);
		deal.setPrefSize(120, 20);
		
		end = new Button();
		end.setText("END TURN");
		end.relocate(1000, 600);
		end.setPrefSize(120, 20);
		
		skip = new Button();
		skip.setText("SKIP TURN");
		skip.relocate(1000, 630);
		skip.setPrefSize(120, 20);
		
		exit = new Button();
		exit.setText("QUIT GAME");
		exit.relocate(1000, 660);
		exit.setPrefSize(120, 20);
		
		reset = new Button();
		reset.setText("CLEAR");
		reset.relocate(1130, 660);
		reset.setPrefSize(120, 20);
		
		add = new Button();
		add.setText("ADD TILE");
		add.relocate(1130, 570);
		add.setPrefSize(120, 20);
		

		
		
		
		
		
		
		
		
		getChildren().add(playerPane);
		getChildren().add(tablePane);
		getChildren().add(infoPane);
		getChildren().add(exit);
		getChildren().add(skip);
		getChildren().add(deal);
		getChildren().add(AIGo);
		getChildren().add(end);
		getChildren().add(reset);
		getChildren().add(add);
	}
	
	public void update() {
		
		playerPane.update();
		tablePane.update();
		infoPane.update();
		
	}
	public Button getExitButton()
	{
		return exit;
	}
	public Button getSkipButton()
	{
		return skip;
	}
	
	public Button getDealButton() {
		return deal;
	}
	
	public PlayerPane getPlayerPane()
	{
		return playerPane;
	}
	
	public Pane getTablePane() {
		return tablePane;
	}
	public Button getAIGoButton()
	{
		return AIGo;
	}
	public Button getEndButton()
	{
		return end;
	}

	public ButtonBase getResetButton() {
		return reset;
	}
	public Button getAddButton() {
		return add;
	}
}