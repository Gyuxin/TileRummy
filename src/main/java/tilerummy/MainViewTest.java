package tilerummy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class MainViewTest extends Application {

    public void start(Stage primaryStage){
    	
    	GameMain g = new GameMain();

        Player player = new Player();
        Deck d = new Deck();
        d.buildDeck();

        player.drawATile(d.drawTile());
        player.drawATile(d.drawTile());
        player.drawATile(d.drawTile());
        player.drawATile(d.drawTile());
        player.drawATile(d.drawTile());
        player.drawATile(d.drawTile());
        player.drawATile(d.drawTile());
        player.drawATile(d.drawTile());   
        player.drawATile(d.drawTile());        
        player.drawATile(d.drawTile());        
        player.drawATile(d.drawTile());        
        player.drawATile(d.drawTile());        
        player.drawATile(d.drawTile());  
        
        Player p2 = new Player();
        
        Tile t1 = d.drawTile();
        Tile t2 = d.drawTile();
        
        p2.drawATile(t1);        
        p2.drawATile(t2);        
        
        for(int i = 0; i < player.getNumberOfHandTile(); i++) {
        	player.getMyHandTile().get(i).printTile();
        }
        

        g.getPlayers().add(player);
        g.getPlayers().add(p2);
        
        int s = g.getPlayers().size();
        System.out.println(s);
        
        MainGameView v = new MainGameView(g);
       
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

		g.getTable().addMeld(m1);
		g.getTable().addMeld(m2);
		
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
