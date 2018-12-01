package tilerummy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InfoViewTest extends Application {
    public void start(Stage primaryStage) {
        

        InfoView myPanel = new InfoView( );
        primaryStage.setTitle("InfoView Test");
        primaryStage.setResizable(true);
        primaryStage.setScene(new Scene(myPanel, 200, 210)); 
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
