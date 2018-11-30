package tilerummy;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class GameMain {
	
	private int numberOfTotalPlayer;
	private ArrayList<Player> players = new ArrayList<Player>();
	private boolean gameContinue = true;
	private static Table gameTable = new Table();
	
	public ArrayList<Player> getPlayers(){
		return players;
	}
	
	public Table getTable() {
		return gameTable;
	}
	
	public void totalNumberOfPlayer(Scanner sc) {
		System.out.println("\n\nHOW MANY PLAYER IN TOTAL(2-4) ??? \n\n");
		this.numberOfTotalPlayer = sc.nextInt();
	}
	
	public int initAI(Scanner sc, ObservableValue ov) {
		System.out.println("\n\nHOW MANY AI PLAYER(0-4) ??? \n\n ");
		int numberOfAI = sc.nextInt();
		if(numberOfAI>0) {
			System.out.println("\n\nASSIGN STRATEGY 1-3 TO THEM IN ORDER: \n\n");
			for(int i=0; i<numberOfAI; i++) {
				int temp = sc.nextInt();
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
		totalNumberOfPlayer(sc);
		int numberOfHuman = this.numberOfTotalPlayer - initAI(sc,ov);
		if(numberOfHuman>0) {
			for(int i=0;i<numberOfHuman;i++) {
				players.add(new Playercontroler(ov,sc));	
			}
		}
	}
	
	public void initPlayersHandTile(Scanner sc, Deck d) {
		for(int i=0;i<players.size();i++) {
			players.get(i).initialHandTile(sc, d);
			players.get(i).sort();
		}
	}
	
	public void printPlayersHandTile() {
		for(int i=0;i<players.size();i++) {
			System.out.println("\nPLAYER"+(i+1)+" hand tiles: " + players.get(i).toString());	
		}
	}
	
	// return index of Player who start first;
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
		System.out.println("\n\nPlayer"+(result+1)+"\nGet Largest Tile: "+maxNum);
		System.out.println("So Player"+(result+1)+" plays first!\n\n");
		return result;
	}
	
	// 随机抽一张不是鬼的牌
	public int generateRandonTile(Deck d) {
		while(true) {
			int temp = d.getARandomTile().getNumber();
			if(temp!=0) {		// 不是鬼
				return temp;
			}
			System.out.println("抽到鬼啦");
		}
	}
	
	public void playGame(Table t, Deck d, Scanner sc, int first) {
		
		// 某个player 先出牌。
		System.out.println("\n\nPLAYER"+(first+1)+"'s round !!! !!! !!!\n\n");
		System.out.println(players.get(first).toString());
		players.get(first).computerTurn(t,d,sc);
		
		for(int i=0;i<players.size() && i!=first;i++) {
			System.out.println("\n\nPLAYER"+(i+1)+"'s round !!! !!! !!!\n\n");
			System.out.println(players.get(i).toString());
			players.get(i).computerTurn(t,d,sc);
		}
	}
	
	public void checkGameEnd() {
		for(int i=0;i<players.size();i++) {
			if(players.get(i).getNumberOfHandTile()==0)
			{
				gameContinue=false;
				System.out.println("\n\n\n\n PLAYER"+(i+1)+" WIN THE GAME!!! !!! !!! !!!\n\n\n\n");
				break;
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		File file = new File("./src/main/java/tilerummy/File7.txt");
		//Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		GameMain newGame = new GameMain();

		System.out.println("\n\n\nWelcome to Runnikub\n\n\n");
		
		//initial three computer players
		ObservableValue ov = new ObservableValue(0);
		
		
		//initial human players and AI players as requested by users.
		newGame.initPlayers(sc,ov);	

		//initial deck on the table
		Deck gameDeck = new Deck();
		gameDeck.buildDeck();
		
		// 谁先开始
		int firstPlayerIndex = newGame.decideWhoPlayFirst(gameDeck);
		
		//initial table 		
		//each player initial 14 titles from deck
		newGame.initPlayersHandTile(sc, gameDeck);
		
		while(newGame.gameContinue)
		{
			//player class need more 
			//player class need an attribute for check if the player has been initial the first mield which grearter than 30

			newGame.printPlayersHandTile();
			
			newGame.playGame(gameTable, gameDeck, sc, firstPlayerIndex);
			
			newGame.checkGameEnd();

		}
		System.out.println("\n\n\n\n\n\nGGGGGGAAAAAMMMMMMEEEEEEE  EEEEENNNNNNNDDDDD\n\n\n\n\n");
	}
}