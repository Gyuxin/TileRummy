package tilerummy;

import java.util.ArrayList;
import java.util.Scanner;

public class GameMain {
	public static void main(String[] args)
	{
		System.out.println("Please input your name");
		Scanner in = new Scanner(System.in);
		String name = in.next();
		System.out.println(name + " Welcome to Runnikub");
		
		//initial three computer players
		Computer1 computer1 = new Computer1();
		Computer2 computer2 = new Computer2();
		Computer3 computer3 = new Computer3();
		
		//initial the player(need to be changed after the real player has been initialed)!!!!!!!!!!!!!!!!!!!!
		Playercontroler gamePlayer = new Playercontroler();
		
		//initial deck on the table
		Deck gameDeck = new Deck();
		gameDeck.buildDeck();
		
		//initial table 
		Table gameTable = new Table();
		
		
		//each player initial 14 titles from deck
		computer1.initialHandTile(gameDeck);
		computer2.initialHandTile(gameDeck);
		computer3.initialHandTile(gameDeck);
		gamePlayer.initialHandTile(gameDeck);
		
		boolean gameIsNotEnd = true;
		
		
		while(gameIsNotEnd)
		{
			//player class need more 
			//player class need an attribute for check if the player has been initial the first mield which grearter than 30
			computer1.sort();
			computer2.sort();
			computer3.sort();
            System.out.println("\n");
			System.out.println("computer1 hand tiles:" + computer1.toString());	
			System.out.println("computer2 hand tiles:" + computer2.toString());
			System.out.println("computer3 hand tiles:" + computer3.toString());
			System.out.println("\n");
			//player1 round
			System.out.println("Computer 1 round");
			computer1.printHandTile();
			computer1.computerTurn(computer1, gameTable, gameDeck, computer2.getNumberOfHandTile(), computer3.getNumberOfHandTile(), gamePlayer.getNumberOfHandTile());
			//player2 round
			System.out.println("\n");
			System.out.println("Computer 2 round");
			computer2.printHandTile();
			computer2.computerTurn(computer2, gameTable, gameDeck, computer1.getNumberOfHandTile(), computer3.getNumberOfHandTile(), gamePlayer.getNumberOfHandTile());
			//player3 round
			System.out.println("\n");
			System.out.println("Computer 3 round");
			computer3.printHandTile();
			computer3.computerTurn(computer3, gameTable, gameDeck, computer1.getNumberOfHandTile(), computer2.getNumberOfHandTile(), gamePlayer.getNumberOfHandTile());

			
			//check if game is end
			if(computer1.getNumberOfHandTile()==0)
			{
				gameIsNotEnd = true;
			}
			else if(computer2.getNumberOfHandTile()==0)
			{
				gameIsNotEnd = true;
			}
			else if(computer3.getNumberOfHandTile()==0)
			{
				gameIsNotEnd = true;
			}
			else if(gamePlayer.getNumberOfHandTile()==0) 
			{
				gameIsNotEnd = true;
			}	
			
			System.out.println("\ndo you want to continue");
			String answer = in.nextLine();	
			if(answer == "y")
			{
				gameIsNotEnd = true;
			}
		}
		System.out.println("Game end");
	}
	//not finish
	public void playerTurn(Playercontroler gamePlayer, Table gameTable, Deck gameDeck)
	{
		System.out.println("player's turn");
		if(!gamePlayer.firstMeldInitialCheck())
		{
			System.out.println("player has not initial the first meld");
			gamePlayer.dealmeld();
		}
		else
		{
			gamePlayer.dealornotdeal();
		}
		
			
	}
	

	

}
