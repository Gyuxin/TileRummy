package tilerummy;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class GameMain {
	public static void main(String[] args) throws FileNotFoundException
	{
		File file = new File("./src/main/java/tilerummy/File4.txt");
		Scanner sc = new Scanner(file);
	

		System.out.println("Welcome to Runnikub");
		
		//initial three computer players
		ObservableValue ov = new ObservableValue(0);
		
		//initial the player(need to be changed after the real player has been initialed)!!!!!!!!!!!!!!!!!!!!
		Playercontroler gamePlayer = new Playercontroler(ov,sc);
		
		Computer1 computer1 = new Computer1(ov,sc);
		Computer2 computer2 = new Computer2(ov,sc);
		Computer3 computer3 = new Computer3(ov,sc);
		

		
		ov.addObserver(computer3);
		
		//initial deck on the table
		Deck gameDeck = new Deck();
		gameDeck.buildDeck();
		
		//initial table 
		Table gameTable = new Table();
		
		
		//each player initial 14 titles from deck
		gamePlayer.initialHandTile(sc);
		computer1.initialHandTile(sc);
		computer2.initialHandTile(sc);
		computer3.initialHandTile(sc);
		
		
		boolean gameIsNotEnd = true;
		
		
		while(gameIsNotEnd)
		{
			//player class need more 
			//player class need an attribute for check if the player has been initial the first mield which grearter than 30
			gamePlayer.sort();
			computer1.sort();
			computer2.sort();
			computer3.sort();

            System.out.println("\n");
			System.out.println("computer1 hand tiles:" + computer1.toString());	
			System.out.println("computer2 hand tiles:" + computer2.toString());
			System.out.println("computer3 hand tiles:" + computer3.toString());
			System.out.println("your hand tiles:" + gamePlayer.toString());
			System.out.println("\n");
			//human's round
			System.out.println("\n");
			System.out.println("Your round");
			gamePlayer.printHandTile();
			gamePlayer.dealornotdeal(gameTable,gameDeck,sc);
			//player1 round
			System.out.println("\nComputer 1 round");
			computer1.printHandTile();
			computer1.computerTurn(computer1, gameTable, gameDeck);
			//player2 round
			System.out.println("\n");
			System.out.println("Computer 2 round");
			computer2.printHandTile();
			computer2.computerTurn(computer2, gameTable, gameDeck);
			//player3 round
			System.out.println("\n");
			System.out.println("Computer 3 round");
			computer3.printHandTile();
			computer3.computerTurn(computer3, gameTable, gameDeck);

			
			
			System.out.println("DO YOU WANT TO CONTINUE? (Y/N)");
			if(sc.next().equals("Y")) {
				System.out.println("\n\n**********  Start a new round ...  **********\n\n");
				gameIsNotEnd = true;
			} else {
				gameIsNotEnd = false;
			}
			
			//check if game is end
			if(computer1.getNumberOfHandTile()==0)
			{
				gameIsNotEnd = false;
				System.out.println("Computer1 Win!");
			}
			else if(computer2.getNumberOfHandTile()==0)
			{
				gameIsNotEnd = false;
				System.out.println("Computer2 Win!");
			}
			else if(computer3.getNumberOfHandTile()==0)
			{
				gameIsNotEnd = false;
				System.out.println("Computer3 Win!");
			}
			else if(gamePlayer.getNumberOfHandTile()==0) 
			{
				gameIsNotEnd = false;
				System.out.println("you Win!");
			}	

		}
		System.out.println("Game end");
	}
}