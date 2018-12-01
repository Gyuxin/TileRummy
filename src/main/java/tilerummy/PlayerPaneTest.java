package tilerummy;

 import javafx.application.Application;
 import javafx.scene.Scene;
 import javafx.stage.Stage;

 @SuppressWarnings("restriction")
 public class PlayerPaneTest extends Application {

     public void start(Stage primaryStage){

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
         
         PlayerPane p = new PlayerPane(player);
         
         p.resetPlayer(p2);
         

         primaryStage.setTitle("Test");
         primaryStage.setResizable(true);
         primaryStage.setScene(new Scene(p, 1000,210));
         primaryStage.show();

     }

     public static void main(String[] args){
         launch(args);
     }

 }