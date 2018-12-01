package tilerummy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CardViewTest extends Application {
    public void start(Stage primaryStage) {
        

        Pane myPanel = new Pane( );
        Tile t1 = new Tile("G", 9);
        Tile t2 = new Tile("B", 9);
        Tile t3 = new Tile("O", 9);
        Tile t4 = new Tile("R", 9);
        CardView c1 = new CardView(t1);
        CardView c2 = new CardView(t2);
        CardView c3 = new CardView(t3);
        CardView c4 = new CardView(t4);
        c1.relocate(10, 10);
        c2.relocate(50, 10);
        c3.relocate(90, 10);
        c4.relocate(130, 10);
        myPanel.getChildren().addAll(c1,c2,c3,c4);
        primaryStage.setTitle("CardView Test");
        primaryStage.setResizable(true);
        primaryStage.setScene(new Scene(myPanel, 300, 300)); 
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
