package tilerummy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Screen;

@SuppressWarnings("restriction")
public class TablePaneTest extends Application {
	
	public void start(Stage primaryStage) throws InterruptedException {
		
		Deck d = new Deck();
		d.buildDeck();
		Table t = new Table();
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


		t.addMeld(m1);
		
		TablePane table = new TablePane(t);
		
		
		double x = Screen.getPrimary().getVisualBounds().getWidth();
		double y = Screen.getPrimary().getVisualBounds().getHeight();
		
		System.out.println(x);
		System.out.println(y);
		
		t.addMeld(m2);
		table.update();
		
		primaryStage.setTitle("Test");
		primaryStage.setResizable(true);
        primaryStage.setScene(new Scene(table, 1100,600));
        primaryStage.show();
		
		
	}
	
	public static void main(String[] args){
        launch(args);
    }

}
