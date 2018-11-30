package tilerummy;

import java.util.ArrayList;
import javafx.scene.layout.*;

public class MainGameView extends Pane {

	private PlayerPane playerPane;
	private TablePane tablePane;
	
	private int numPlayers;
	
	private float paneWidth = 1280;
	private float paneHeight = 713;
	
	public MainGameView(GameMain main) {
		
		//tablePane = new TablePane(main.getTable());
		playerPane = new PlayerPane(main.getPlayers().get(0));
		playerPane.relocate(0, 600);
		playerPane.setPrefSize(playerPane.getPrefWidth(), playerPane.getPrefHeight());
		
		tablePane = new TablePane(main.getTable());
		tablePane.relocate(0, 0);
		tablePane.setPrefSize(tablePane.getPrefWidth(), tablePane.getPrefHeight());
		
		getChildren().add(playerPane);
		getChildren().add(tablePane);
	}
	
	public void update() {
		
		playerPane.update();
		tablePane.update();
		
	}
	
}
