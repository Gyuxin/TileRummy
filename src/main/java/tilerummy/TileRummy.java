package tilerummy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TileRummy {

    public static Deck deck = new Deck();
    public static Table table = new Table();

    public static boolean fileIn = false;
    public static ArrayList<String> playerCommand = new ArrayList<String>();

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException{
        
        initDeck();

    }

    public static void initDeck() throws FileNotFoundException {

        System.out.println("Do you want to console(C) or file(F) input? ");
        String choice = sc.next();

        //Initial Deck
        if(choice.indexOf('C') == 0 || choice.indexOf('c') == 0){
            deck.buildDeck();
        } else if (choice.indexOf('F') == 0 || choice.indexOf('f') == 0){
            fileInit(sc);
        } else {
            System.out.print("Invalid Input");
            System.exit(0);
        }

    }

    public static void fileInit(Scanner sc) throws FileNotFoundException{

        fileIn = true;

        System.out.println("Please enter file name: ");
        File fl = new File(sc.next());
        @SuppressWarnings("resource")
		Scanner fs = new Scanner(fl);
        String[] commands = fs.nextLine().split("\\s+");

        //Check if a command is a tile or player's command
        //If it is a tile, add it to deck
        //It it is a command, add it to player's commands

        for(int i = 0; i < commands.length; i++){
            if(commands[i].length() > 1){
                deck.addTile(new Tile(commands[i]));
            } else {
                playerCommand.add(commands[i]);
            }
        }
    }


}