package tilerummy;

import javafx.application.Application;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.*;


public class TileRummyApp extends Application {
	private int numberOfTotalPlayer;
	private static ArrayList<Player> players = new ArrayList<Player>();
	private boolean gameContinue = true;
	private static Table gameTable = new Table();
	private static Deck gameDeck = new Deck();
	private TablePane gameTablePane;
	private PlayerPane gamePlayerPane;
	private static Player firstPlayingPlayer;
	private static TileRummyApp game;
	private MainGameView gameView;
	private InfoView gameInfoPane;
	

    public void start(Stage primaryStage){
    	gameTable = new Table();
    	gameTablePane = new TablePane(gameTable);
    	gamePlayerPane = new PlayerPane(firstPlayingPlayer);
    	gameInfoPane = new InfoView();
    	gameView = new MainGameView(gameTablePane, gamePlayerPane, gameInfoPane);
    	gameView.getExitButton().setOnAction(new EventHandler<ActionEvent>() {
    		 public void handle(ActionEvent actionEvent) { handleExitButtonPress(); }
    		 });
    	
    	primaryStage.setTitle("TILE RUMMT");
    	primaryStage.setResizable(true);
    	primaryStage.setScene(new Scene(gameView, 1280,713));
    	primaryStage.show();
    	
    
    	if(!gameContinue)
    	{
    		System.exit(0);
    	}
    }
    public void handleExitButtonPress()
    {
    	JOptionPane.showConfirmDialog(null, "YOU QUIT THE GAME");
    	gameContinue = false;
    }
    
    public void totalNumberOfPlayer(Scanner sc) {
    	String number = JOptionPane.showInputDialog("How many players do we have in this game? (1-4)");
		this.numberOfTotalPlayer = Integer.parseInt(number);
	}
    
    
    
	public int initAI(Scanner sc, ObservableValue ov) {
		String AIn = JOptionPane.showInputDialog("\n\nHOW MANY AI PLAYER(0-4) ??? \n\n ");
		int numberOfAI = Integer.parseInt(AIn);
		if(numberOfAI>0) {
			for(int i=0; i<numberOfAI; i++) {
				int temp = Integer.parseInt(JOptionPane.showInputDialog("\n\nASSIGN STRATEGY 1-3 TO COMPUTER:" + (i+1) + "\n\n"));
				if(temp==1) {
					players.add(new Computer1(ov,sc));
				} else if(temp==2) {
					players.add(new Computer2(ov,sc));
				} else if(temp==3) {
					Computer3 c = new Computer3(ov,sc);
	           		players.add(c);
	           		ov.addObserver(c);					//problem here with observer. what if we have more than one computer3?
				}
			}
		}
		return numberOfAI;
	}
	
	
	public int decideWhoPlayFirst(Deck d) {
		int result = -1;
		int maxNum = -1;
		
		int count = 0;
		
		for(int i=0;i<4;i++) {
			int temp = generateRandonTile(d);
			System.out.println(temp);
			if(temp==maxNum) {			// 和前玩家一样大。再抽一次
				i--;
			}
			if(temp>maxNum) {
				maxNum = temp;
				result = i;
			}
		}
		
		JOptionPane.showConfirmDialog(null, "\n\nPlayer"+(result+1)+"\nGet Largest Tile: "+maxNum + "So Player"+(result+1)+" plays first!\n\n");
		return result;
	}
	
	public int generateRandonTile(Deck d) {
		while(true) {
			int temp = d.getARandomTile().getNumber();
			if(temp!=0) {		// 不是鬼
				return temp;
			}
			System.out.println("抽到鬼啦");
		}
	}
	
	
	public void initPlayersHandTile(Scanner sc, Deck d) {
		for(int i=0;i<players.size();i++) {
			players.get(i).initialHandTile(sc, d);
			players.get(i).sort();
		}
	}

	
	
    public static void main(String[] args){ 
    	ObservableValue ov = new ObservableValue(0);
    	Scanner sc = new Scanner(System.in);
    	game = new TileRummyApp();
        gameDeck = new Deck();
        gameDeck.buildDeck();
        firstPlayingPlayer = new Player();
    	//welcome dialog
    	JOptionPane.showMessageDialog(null,"Welcome to TILE RUMMY");
    	//initial the number of player
    	game.totalNumberOfPlayer(sc);
    	//initial AI player
    	game.initAI(sc,ov);
    	//system decide who start first
//    	game.decideWhoPlayFirst(gameDeck);
    	firstPlayingPlayer = players.get(game.decideWhoPlayFirst(gameDeck));
       //initial players' hand tiles
    	game.initPlayersHandTile(sc, gameDeck);
        launch(args);
    }

}

