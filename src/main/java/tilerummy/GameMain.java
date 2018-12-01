package tilerummy;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class GameMain {
	
	private ArrayList<Player> players;
	private boolean gameContinue;
	private Table gameTable;
	private Deck gameDeck;
	private int currentPlayerIndex;
	
	public GameMain(Table aTable, Deck aDeck, boolean gameContinueCheck, ArrayList<Player> playersList)
	{
		players = playersList;
		gameContinue = gameContinueCheck;
		gameTable = aTable;
		gameDeck = aDeck;
	}
	
	
	public ArrayList<Player> getPlayers(){
		return players;
	}
	
	public Table getTable() {
		return gameTable;
	}
	
	



	

	
	public void printPlayersHandTile() {
		for(int i=0;i<players.size();i++) {
			System.out.println("\nPLAYER"+(i+1)+" hand tiles: " + players.get(i).toString());	
		}
	}
	public void playGame(Table t, Deck d, Scanner sc, int index, MainGameView aView) {
		
		// 某个player 先出牌。
		System.out.println("\n\nPLAYER"+(index+1)+"'s round !!! !!! !!!\n\n");
		System.out.println(players.get(index).toString());
		players.get(index).playerTurn(t,d,sc);
		aView.update();
		
		for(int i=0;i<players.size() && i!=index;i++) {
			System.out.println("\n\nPLAYER"+(i+1)+"'s round !!! !!! !!!\n\n");
			System.out.println(players.get(i).toString());
			
			players.get(i).playerTurn(t,d,sc);
			aView.update();
		}
	}
	public void checkGameEnd() {
		for(int i=0;i<players.size();i++) {
			if(players.get(i).getNumberOfHandTile()==0)
			{
				gameContinue=false;
				System.out.println("\n\n\n\n PLAYER"+(i+1)+" WIN THE GAME!!! !!! !!! !!!\n\n\n\n");
				JOptionPane.showConfirmDialog(null, "\n\n\n\n PLAYER"+(i+1)+" WIN THE GAME!!! !!! !!! !!!\n\n\n\n");
				break;
			}
		}
	}

}