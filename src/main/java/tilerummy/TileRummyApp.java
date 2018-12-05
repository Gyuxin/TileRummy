package tilerummy;

import javafx.animation.KeyFrame;

import java.io.File;
import java.io.FileNotFoundException;

import javafx.animation.Timeline;
import javafx.application.Application;

import javafx.util.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.control.TextInputDialog;


public class TileRummyApp extends Application  {
	private static ObservableValue ov = new ObservableValue(0);
	private static File file = new File("./src/tilerummy/Test/Test1.txt");
	private static Scanner sc;
	private static int numberOfTotalPlayer;
	private static ArrayList<Player> players = new ArrayList<Player>();
	private static boolean gameContinue = true;
	private static Table gameTable = new Table();
	private static Deck gameDeck = new Deck();
	private static TablePane gameTablePane;
	private static PlayerPane gamePlayerPane;
	public static int currentPlayingPlayersIndex;
	private static TileRummyApp game;
	private static MainGameView gameView;
	private static InfoView gameInfoPane;
	private final Integer starttime = 120;
	private Integer seconds = starttime;
	private static boolean useTimer = false;
	Timeline timer = new Timeline();
	private Memento memento;
	private careTaker ct = new careTaker();

	

    public void start(Stage primaryStage){
    	gameTable = new Table();
    	gameTablePane = new TablePane(gameTable);
    	gamePlayerPane = new PlayerPane(players, currentPlayingPlayersIndex);
    	gameInfoPane = new InfoView(this.numberOfTotalPlayer, this.players);
    	gameView = new MainGameView(gameTablePane, gamePlayerPane, gameInfoPane);
    	gameView.getExitButton().setOnAction(new EventHandler<ActionEvent>() {
    		 public void handle(ActionEvent actionEvent) { handleExitButtonPress(); }
    		 });
    	gameView.getSkipButton().setOnAction(new EventHandler<ActionEvent>() {
   		 public void handle(ActionEvent actionEvent) { handleSkipButtonPress(); }
   		 });
    	
    	gameView.getDealButton().setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent actionEvent) {
    			handleDealButtonPress();
    		}
    	});
    	gameView.getAIGoButton().setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent actionEvent) {
    			handleAIGolButtonPress();
    		}
    	});
    	gameView.getEndButton().setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent actionEvent) {
    			handlelEndButtonPress();
    		}
    	});
    	gameView.getResetButton().setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent actionEvent) {
    			handleResetButtonPress();
    		}
    	});   
    	
    	gameView.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent actionEvent) {
    			handleAddButtonPress();
    		}
    	});
    
    	primaryStage.setTitle("TILE RUMMT");
    	primaryStage.setResizable(true);
    	primaryStage.setScene(new Scene(gameView, 1280,713));
    	primaryStage.show();
    	if(players.get(currentPlayingPlayersIndex).getPlayerType().equals("Human Player")) {
    		startCounting();
    	} else {
    		gameInfoPane.setCounterField(99);
    	} 	
    }
    
    public void handleResetButtonPress() {
    	gameView.update();
    }
    public void handleDealButtonPress() {
    	int index = gamePlayerPane.getCurrentPlayer();
    	Player p = players.get(index);
    	CardView[] c = gamePlayerPane.getInhandTile();
    	Meld m = new Meld();
    	ArrayList<Integer> cardIndex = new ArrayList<Integer>();
    	for(int i = 0; i < p.getNumberOfHandTile(); i++) {
    		if(c[i].getSelected()) {
    			gamePlayerPane.getSelectedTiles().add(c[i]);
    			m.addTileAtLast(c[i].getTile());
    			//p.getMyHandTile().remove(i);
    			cardIndex.add(i);
    		}
    	}
    	for(int i = cardIndex.size(); i > 0; i--) {
    		int in = cardIndex.get(i-1);
    		p.getMyHandTile().remove(in);
    	}
    	gameTable.addMeld(m);
    	gameView.update();
    }
    
    public void handleExitButtonPress()
    {
    	System.exit(0);
    }
    public void handlelEndButtonPress()   // human 出完牌了，结束当前回合转到下一个p。
    {
    	if(!gameTable.checkInValid()) {
    		this.helper(ct);
    		players.get(currentPlayingPlayersIndex).drawATile(gameDeck.drawTile());
    		players.get(currentPlayingPlayersIndex).drawATile(gameDeck.drawTile());
    	} 
    	
    	
    	if(players.get(currentPlayingPlayersIndex).getMyHandTile().size()==0)
        {
         gameInfoPane.addToConsole("GAME IS END !!!! THE WINNER IS PLAYER " + (currentPlayingPlayersIndex+1));
         gameView.getSkipButton().setDisable(true);
         gameView.getDealButton().setDisable(true);
         gameView.getAIGoButton().setDisable(true);
         gameView.getEndButton().setDisable(true);
         gameView.getResetButton().setDisable(true);
         gameView.getAddButton().setDisable(true);
        }
    	timer.stop();
    	currentPlayingPlayersIndex = gamePlayerPane.resetPlayer();
        Player tempPlayer = players.get(currentPlayingPlayersIndex);
        if(tempPlayer.getPlayerType().equals("Human Player")) {
            startCounting();
        } else {
         gameInfoPane.setCounterField(99);
        }
    }
    
    
    public void handleAIGolButtonPress() 	// ai 出牌，或抽牌，紧接着结束当前回合转到下一个p。
    {
    	timer.stop();
    	
    	
    	if(players.get(currentPlayingPlayersIndex).getPlayerType() == "Coumputer:Strategy 1" || 
    			players.get(currentPlayingPlayersIndex).getPlayerType() == "Coumputer:Strategy 2"  || 
    					players.get(currentPlayingPlayersIndex).getPlayerType() == "Coumputer:Strategy 3")
    	{
    		players.get(currentPlayingPlayersIndex).playerTurn(gameTable, gameDeck, sc, gameInfoPane);
    		gameView.update();
    		if(players.get(currentPlayingPlayersIndex).getMyHandTile().size()==0)
            {
             gameInfoPane.addToConsole("\n\n\nGAME IS END !!!! THE WINNER IS PLAYER " + (currentPlayingPlayersIndex+1));
             gameView.getSkipButton().setDisable(true);
             gameView.getDealButton().setDisable(true);
             gameView.getAIGoButton().setDisable(true);
             gameView.getEndButton().setDisable(true);
             gameView.getResetButton().setDisable(true);
             gameView.getAddButton().setDisable(true);
            }
    		
    		currentPlayingPlayersIndex = gamePlayerPane.resetPlayer();
    	       Player tempPlayer = players.get(currentPlayingPlayersIndex);
    	        if(tempPlayer.getPlayerType().equals("Human Player")) {
    	            startCounting();
    	        } else {
    	         gameInfoPane.setCounterField(99);
    	        }
    	}
    	gameView.update();
    }
    
    
public void handleAddButtonPress() {
    	
    	int meldIndex = 0;
    	
    	TextInputDialog dialog = new TextInputDialog();
    	dialog.setTitle("Choose Meld");
    	dialog.setHeaderText(null);
    	dialog.setContentText("Please enter the index of a meld:");
    	
    	Optional<String> result = dialog.showAndWait();
    	if(result.isPresent()) {
    		meldIndex = Integer.parseInt(result.get());
    	}
    	
    	if(meldIndex > gameTable.getSize()-1) {
    	      meldIndex = gameTable.getSize();
    	      gameTable.addMeld(new Meld());
    	}
    	
    	Player p = players.get(currentPlayingPlayersIndex);
    	CardView[] c = gamePlayerPane.getInhandTile();
    	ArrayList<Integer> cardIndex = new ArrayList<Integer>();
    	for(int i = 0; i < p.getNumberOfHandTile(); i++) {
    		if(c[i].getSelected()) {
    			gameTable.getMeld(meldIndex).addTileAtLast(c[i].getTile());
    			cardIndex.add(i);
    		}
    	}
    	for(int i = cardIndex.size(); i > 0; i--) {
    		int in = cardIndex.get(i-1);
    		p.getMyHandTile().remove(in);
    	}
    	
    	//Get selected on table
    	for(int i = 0; i < gameTablePane.getTable().size(); i++) {
    		Meld m = gameTable.getMeld(i);
    		CardView[] cv = gameTablePane.getTable().get(i);
     		
    		ArrayList<Integer> cardIn = new ArrayList<Integer>();
    		
    		for(int j = 0; j < cv.length; j++) {
    			if(cv[j].getSelected()) {
    				cv[j].getTile().printTile();
    				gameTable.getMeld(meldIndex).addTileAtLast(cv[j].getTile());
    				cardIn.add(j);
    				//gameTable.getMeld(i).removeTile(j);
    			}
    		}
    		
    		for(int k = cardIn.size(); k > 0; k--) {
    			int ind = cardIn.get(k-1);
    			gameInfoPane.addToConsole(String.valueOf(ind));
    			m.removeTile(ind);
    		}
    		
    	}
    	
    	gameTable.removeEmptyMeld();

    	gameTable.printTable();
    	gameView.update();
    	
    }


    public void handleSkipButtonPress() // 玩家抽牌，并且转化到下一个p
    {
    	timer.stop();
        this.helper(ct);
        players.get(currentPlayingPlayersIndex).drawATile(gameDeck.drawTile());
        
        currentPlayingPlayersIndex = gamePlayerPane.resetPlayer();
        Player tempPlayer = players.get(currentPlayingPlayersIndex);
        if(tempPlayer.getPlayerType().equals("Human Player")) {
            startCounting();
        } else {
         gameInfoPane.setCounterField(99);
        }
        gameView.update();
    }
    
    public int getNextPlayerIndex()
    {
    	int nextPlayingPlayerIndex = currentPlayingPlayersIndex+1;
    	if(nextPlayingPlayerIndex == numberOfTotalPlayer)
    	{
    		nextPlayingPlayerIndex=0;
    	}
    	return nextPlayingPlayerIndex;
    }
    
    public void totalNumberOfPlayer(Scanner sc) {
    	String number = JOptionPane.showInputDialog("How many players do we have in this game? (1-4)");
		this.numberOfTotalPlayer = Integer.parseInt(number);
	}
    
    public int getNumberOfPlayers() {
    	return this.numberOfTotalPlayer;
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
	
	public void initPlayers(Scanner sc, ObservableValue ov) {
		 
		TileRummyApp.sc = sc;
		totalNumberOfPlayer(sc);
		int numberOfHuman = this.numberOfTotalPlayer - initAI(sc,ov);
		if(numberOfHuman>0) {
			if (JOptionPane.showConfirmDialog(null,
					"\n\nUSE TIMER IN THIS GAME?\n\n","^ ^",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				this.useTimer = true;
			} 
			for(int i=0;i<numberOfHuman;i++) {
				players.add(new Playercontroler(ov,sc));	
			}
		}
	}
	
	public Memento saveCurrentState() {
		Playercontroler temp = (Playercontroler) players.get(currentPlayingPlayersIndex);
		System.out.println(gameTable.printTable());
		ArrayList<Meld> tempTable = new ArrayList<Meld>(); 
		List<Tile> tempPeople = new ArrayList<Tile>();
		for(int i=0; i<gameTable.getTable().size();i++) {
			tempTable.add(gameTable.getTable().get(i));
		}
		for(int i=0; i<players.get(currentPlayingPlayersIndex).getMyHandTile().size(); i++) {
			tempPeople.add(players.get(currentPlayingPlayersIndex).getMyHandTile().get(i));
		}
		
		return new Memento(tempTable, tempPeople , currentPlayingPlayersIndex);
	}
	
	public void restoreState(Object objMemento) {
		Memento memento = (Memento) objMemento;
		gameTable.setNewTable(memento.memtable); 
		currentPlayingPlayersIndex = memento.mementoindexOfPlayer;
		players.get(currentPlayingPlayersIndex).setHandTiles(memento.memhand);
		System.out.println(gameTable.printTable());
	}
	
	public int decideWhoPlayFirst(Deck d, int n) {
		int result = -1;
		int maxNum = -1;
		
		int count = 0;
		
		for(int i=0;i<n;i++) {
			int temp = sc.nextInt();
			if(temp==maxNum) {			// 和前玩家一样大。再抽一次
				i--;
			}
			if(temp>maxNum) {
				maxNum = temp;
				result = i;
			}
		}
		
		JOptionPane.showConfirmDialog(null, "\n\nPlayer"+(result+1)+"\nGet Largest Tile: "+maxNum + "\nSo Player"+(result+1)+" plays first!\n\n");
		currentPlayingPlayersIndex = result;
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

	public void helper(careTaker ct) {
		ct.restoreState(this);
		gameView.update();
	}
	
	@SuppressWarnings("restriction")
	public void startCounting() {
		ct.saveState(this);
		if(this.useTimer) {
		      final Alert alert = new Alert(AlertType.INFORMATION,"TIME OUT !!!"); 
		         alert.setTitle(null);
		         alert.setHeaderText(null);
		   seconds= starttime;
		   timer = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){
		   public void handle(ActionEvent event) {
		       seconds--;
		       gameInfoPane.setCounterField(seconds);
		       if(seconds<=0){
		        alert.show();
		        
		        handleSkipButtonPress();
		       }   
		     }
		   }));
		    
		    timer.setCycleCount(Timeline.INDEFINITE);
		    timer.play();
		}
	  }
	
	
	// memento - object that stores the saved state of the originator
	private class Memento {
		ArrayList<Meld> memtable;
		List<Tile> memhand;
		int mementoindexOfPlayer;

		public Memento(ArrayList<Meld> m, List<Tile> h, int i) {
			memtable = m;
			memhand = h;
			mementoindexOfPlayer = i;
		}
	}
	
	public class careTaker {

		Object objMemento;

		public void saveState(TileRummyApp app) {
			System.out.println("save");
			objMemento = app.saveCurrentState();
		}

		public void restoreState(TileRummyApp app) {
			System.out.println("restore");
			app.restoreState(objMemento);
		}

	}
	
    public static void main(String[] args) throws FileNotFoundException { 
    	Scanner sc = new Scanner(file);
    	game = new TileRummyApp();
        gameDeck = new Deck();
        gameDeck.buildDeck();
    	//welcome dialog
    	JOptionPane.showMessageDialog(null,"Welcome to TILE RUMMY");
    	//initial players
    	game.initPlayers(sc,ov);
    	//system decide who start first
    	int n = game.getNumberOfPlayers();
    	currentPlayingPlayersIndex = game.decideWhoPlayFirst(gameDeck,n);
       //initial players' hand tiles
    	game.initPlayersHandTile(sc, gameDeck);
        launch(args);
    }

}


