package tilerummy;

import java.util.ArrayList;
import java.util.List;

public class Logic {

	public static boolean addOneTile(Tile t, Table table){

        for(int i = 0; i < table.getSize(); i++){

            Meld currentMeld = table.getMeld(i);

            //If current meld is a set
            if(currentMeld.isSet()){
                if(!currentMeld.containsTile(t) && currentMeld.sameNumber(t)){
                    currentMeld.addTileAtLast(t);
                    return true;
                }
            } else {
                //If tile's number is one less than first tile's number in current meld
                if(t.getNumber()+1 == currentMeld.getFirstTile().getNumber() && currentMeld.sameColor(t)){
                    currentMeld.addTileAtFirst(t);
                    return true;
                } 

                //If tile's number is one bigger than last tile's number in current meld
                else if(t.getNumber()-1 == currentMeld.getLastTile().getNumber() && currentMeld.sameColor(t)){
                    currentMeld.addTileAtLast(t);
                    return true;
                } 
                
                //add a tile to the middle of a run
                /* e.x O5 -> {O3, O4, O5, O6, O7}
                 *  newmeld = {O3, O4}
                 *  oldmeld = {O5, O6, O7}
                 *  O5 -> newmeld
                 *  oldmeld = {O3, O4, O5}
                 * */
   
                
                else if(currentMeld.getMeldSize()>=5) {
            		for(int j = 2; j < currentMeld.getMeldSize()-2; j++){
            			Tile tempTile = currentMeld.get(j);
            			if(t.getColor().equals(tempTile.getColor()) && t.getNumber() == tempTile.getNumber()){
            				Meld newMeld = new Meld(currentMeld.getMeld());
            				newMeld.slice(0, j);	// create a new meld to store the first half of the meld
            				currentMeld.slice(j, currentMeld.getMeldSize()); 	// the old meld becoming the last half of the meld 
            				newMeld.addTileAtLast(t);  		//add the tile to the newmeld
            				table.addMeld(newMeld);
            				return true;
            			}
            		}
                } 
                
            }
        }

        table.removeEmptyMeld();
        return false;

    }
    
    //Use one tile on the table and form a run
    //the used tile must be gotten from the meld whose size is bigger than 4
    public static boolean addTwoTiles(ArrayList<Tile> tileArray, Table table) {
        
        String color = tileArray.get(0).getColor();
        
        Meld newMeld = new Meld();
        newMeld.addTileAtLast(tileArray.get(0));
        newMeld.addTileAtLast(tileArray.get(1));

    	for(int i = 0; i < table.getSize(); i++){
            if(table.getMeld(i).getMeldSize() > 3){

                Meld currentMeld = table.getMeld(i);

                //If the meld is a set 
                if(currentMeld.isSet()){

                    //check if the number of the set is 1 larger than tile array 
                    //or 1 smaller than tile array

                    int num = currentMeld.getFirstTile().getNumber();
                    if(num-tileArray.get(1).getNumber() == 1 || tileArray.get(0).getNumber()-num == 1){
                        //find same color as tiles in tile array
                        for(int j = 0; i < currentMeld.getMeldSize(); j++){
                            if(currentMeld.get(j).getColor().equals(color)){
                                Tile t = currentMeld.removeTile(j);
                                //If number of t is larger than tile array
                                //add it to the end of tile Array
                                //add the tileArray to table
                                if(t.getNumber() > tileArray.get(1).getNumber()){
                                    newMeld.addTileAtLast(t);
                                    table.addMeld(newMeld);                 
                                    return true;
                                } else {
                                    newMeld.addTileAtFirst(t);
                                    table.addMeld(newMeld);
                                    return true;

                                }
                            }
                        }
                    }
                // If the meld is a run
                } else {

                    //check if the color is same
                    if(currentMeld.sameColor(tileArray.get(0))){

                        //check if the last tile in the meld is one bigger than tilearray
                        //or the first tile in the meld is one smaller than the array

                        Tile first = currentMeld.getFirstTile();
                        Tile last = currentMeld.getLastTile();

                        //If the first tile in the meld is one smaller than the array
                        //remove it from current meld
                        //add it to the tilearray at position 0
                        //add the tile array to table as a meld
                        if(tileArray.get(0).getNumber() - first.getNumber() == 1){
                            Tile t = currentMeld.removeFirstTile();
                            newMeld.addTileAtFirst(t);
                            table.addMeld(newMeld);
                            return true;
                        }

                        //else if the last tile in the meld is bigger than the array
                        //remove it from current meld
                        //add it the the tilearray 
                        // add the tile array to table as a meld

                        else if(last.getNumber() - tileArray.get(1).getNumber() == 1){
                            Tile t = currentMeld.removeLastTile();
                            newMeld.addTileAtLast(t);
                            table.addMeld(newMeld);
                            return true;
                        }

                        else return false;

                    }

                }
            }
        }
    	
    	return false;
    	
    }

    //in: player's in hand tiles
    //out: all possible two consecutive tiles
    public static ArrayList<ArrayList<Tile>> twoConsecutiveTiles(List<Tile> myMeld){

        ArrayList<ArrayList<Tile>> twoConsecutiveTiles = new ArrayList<ArrayList<Tile>>();

        //classify myMeld by color
        ArrayList<Tile> red = new ArrayList<Tile>();
        ArrayList<Tile> blue = new ArrayList<Tile>();
        ArrayList<Tile> green = new ArrayList<Tile>();
        ArrayList<Tile> oragne = new ArrayList<Tile>();

        for(int i = 0; i < myMeld.size(); i++){
            if(myMeld.get(i).getColor().equals("R")){
                red.add(myMeld.get(i));
            } else if (myMeld.get(i).getColor().equals("B")){
                blue.add(myMeld.get(i));
            } else if (myMeld.get(i).getColor().equals("G")){
                green.add(myMeld.get(i));
            } else {
                oragne.add(myMeld.get(i));
            }
        }

        //find two consecutive tiles in each Arraylist
        //in red tiles
        for(int i = 0; i < red.size()-1; i++){
            if(red.get(i+1).getNumber()-red.get(i).getNumber() == 1){
                ArrayList<Tile> tiles = new ArrayList<Tile>();
                tiles.add(red.get(i));
                tiles.add(red.get(i+1));
                twoConsecutiveTiles.add(tiles);
            }
        }

        //in blue tiles
        for(int i = 0; i < blue.size()-1; i++){
            if(blue.get(i+1).getNumber()-blue.get(i).getNumber() == 1){
                ArrayList<Tile> tiles = new ArrayList<Tile>();
                tiles.add(blue.get(i));
                tiles.add(blue.get(i+1));
                twoConsecutiveTiles.add(tiles);
            }
        }

        //in green tiles
        for(int i = 0; i < green.size()-1; i++){
            if(green.get(i+1).getNumber()-green.get(i).getNumber() == 1){
                ArrayList<Tile> tiles = new ArrayList<Tile>();
                tiles.add(green.get(i));
                tiles.add(green.get(i+1));
                twoConsecutiveTiles.add(tiles);
            }
        }

        //in orange tiles
        for(int i = 0; i < oragne.size()-1; i++){
            if(oragne.get(i+1).getNumber()-oragne.get(i).getNumber() == 1){
                ArrayList<Tile> tiles = new ArrayList<Tile>();
                tiles.add(oragne.get(i));
                tiles.add(oragne.get(i+1));
                twoConsecutiveTiles.add(tiles);
            }
        }
        
        //System.out.println(twoConsecutiveTiles.size());

        
        /*System.out.println("Tiles*******");
        for(int i = 0; i < twoConsecutiveTiles.size(); i++){
            for(int j = 0; j < twoConsecutiveTiles.get(i).size(); j++){
                twoConsecutiveTiles.get(i).get(j).printTile();
                System.out.println("\n");
            }
        }*/
        
        //System.out.println("Finished");
        
        return twoConsecutiveTiles;

    }

    /*public static void main(String[] args){
        
        List<Tile> handTiles = new ArrayList<Tile>();

        handTiles.add(new Tile("B1"));
        handTiles.add(new Tile("B2"));
        handTiles.add(new Tile("O3"));
        handTiles.add(new Tile("O4"));
        handTiles.add(new Tile("R4"));
        handTiles.add(new Tile("R7"));

        ArrayList<ArrayList<Tile>> tiles = twoConsecutiveTiles(handTiles);

        System.out.println("Table******");
        Table t = new Table();

        Meld m1 = new Meld();
        m1.addTileAtLast(new Tile("O2"));
        m1.addTileAtLast(new Tile("B2"));
        m1.addTileAtLast(new Tile("R2"));
        m1.addTileAtLast(new Tile("G2"));
        
        t.addMeld(m1);
        
        t.printTable();
        System.out.println("\n");
        
        System.out.println("In hand tiles");
        for(int i = 0; i < handTiles.size(); i++) {
        	handTiles.get(i).printTile();
        }


        for(int i = 0; i < tiles.size(); i++){
            boolean changed = addTwoTiles(tiles.get(i), t);

            if(changed) {
            	System.out.println("Size" + tiles.get(i).size());
            	removeTwoTiles(tiles.get(i), handTiles);
            }
        }

        t.printTable();
        
        System.out.println("In hand tiles");
        for(int i = 0; i < handTiles.size(); i++) {
        	handTiles.get(i).printTile();
        }

    }
    
    
    Process of add two tiles
    tiles = twoConsecutiveTiles(handTiles)
	for(int i = 0; i < tiles.size; i++){
		
		changed = addTwoTiles(tiles.get(i),t)
     	if(changed)
     		print handTiles(i)
     		remove tiles in handTiles
    */
    
    
    
    public static void removeTwoTiles(ArrayList<Tile> tiles, List<Tile> handTiles){

    	Tile t1 = tiles.get(0);
    	Tile t2 = tiles.get(1);
    	
    	for(int i = 0; i < handTiles.size(); i++){
    		if((handTiles.get(i).getColor().equals(t1.getColor())) 
    				&& (handTiles.get(i).getNumber() == t1.getNumber())){
    			handTiles.remove(i);
    			break;
    		}
    	}
    
    	for(int i = 0; i < handTiles.size(); i++){
    		if((handTiles.get(i).getColor().equals(t2.getColor())) 
    				&& (handTiles.get(i).getNumber() == t2.getNumber())){
    			handTiles.remove(i);
    			break;
    		}
    	}
    }

}