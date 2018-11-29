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
		
		tablePane = new TablePane(main.getTable());
		playerPane = new PlayerPane(main.getPlayers().get(0));
		
	}
	
	public void update(ArrayList<Player> player) {
		
		
		
	}
	
}
