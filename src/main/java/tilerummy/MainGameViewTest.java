package tilerummy;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class MainGameViewTest extends Application {

    public void start(Stage primaryStage){
    	
    	
    	Table aTable = new Table();	
    	ArrayList<Player> playerlist = new ArrayList<Player>();

        Player p1 = new Player();
        
        TablePane aTablePane = new TablePane(aTable);
        PlayerPane aPlayerPane = new PlayerPane(p1);
        InfoView aInfoPane = new InfoView();
        
        Deck d = new Deck();
        d.buildDeck();

        p1.drawATile(d.drawTile());
        p1.drawATile(d.drawTile());
        p1.drawATile(d.drawTile());
        p1.drawATile(d.drawTile());
        p1.drawATile(d.drawTile());
        p1.drawATile(d.drawTile());
        p1.drawATile(d.drawTile());
        p1.drawATile(d.drawTile());   
        p1.drawATile(d.drawTile());        
        p1.drawATile(d.drawTile());        
        p1.drawATile(d.drawTile());        
        p1.drawATile(d.drawTile());        
        p1.drawATile(d.drawTile());  
        
        Player p2 = new Player();
        
        Tile t1 = d.drawTile();
        Tile t2 = d.drawTile();
        
        p2.drawATile(t1);        
        p2.drawATile(t2);        
        
        
        for(int i = 0; i < p1.getNumberOfHandTile(); i++) {
        	p1.getMyHandTile().get(i).printTile();
        }
        

//        g.getPlayers().add(p1);
//        g.getPlayers().add(p2);
        
//        int s = g.getPlayers().size();
//        System.out.println(s);
        playerlist.add(p1);
        playerlist.add(p2);
        GameMain aGame = new GameMain(aTable, d, false, playerlist);
        
        MainGameView v = new MainGameView (aTablePane, aPlayerPane, aInfoPane, aGame);
       
		Meld m1 = new Meld();
		m1.addTileAtFirst(d.drawTile());
		m1.addTileAtFirst(d.drawTile());
		m1.addTileAtFirst(d.drawTile());
		
		Meld m2 = new Meld();
		m2.addTileAtFirst(d.drawTile());
		m2.addTileAtFirst(d.drawTile());
		m2.addTileAtFirst(d.drawTile());
		m2.addTileAtFirst(d.drawTile());
		m2.addTileAtFirst(d.drawTile());
		m2.addTileAtFirst(d.drawTile());
		m2.addTileAtFirst(d.drawTile());
		m2.addTileAtFirst(d.drawTile());
		m2.addTileAtFirst(d.drawTile());
		m2.addTileAtFirst(d.drawTile());
		m2.addTileAtFirst(d.drawTile());
		m2.addTileAtFirst(d.drawTile());
		m2.addTileAtFirst(d.drawTile());

		aTable.addMeld(m1);
		aTable.addMeld(m2);
		
		v.update();

        primaryStage.setTitle("Test");
        primaryStage.setResizable(true);
        primaryStage.setScene(new Scene(v, 1280,713));
        primaryStage.show();

    }

    public static void main(String[] args){
        launch(args);
    }

}

