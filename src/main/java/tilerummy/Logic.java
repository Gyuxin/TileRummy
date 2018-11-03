package tilerummy;

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
            				Meld newMeld = currentMeld;
            				newMeld.slice(0, j);	// create a new meld to store the first half of the meld
            				currentMeld.slice(j, currentMeld.getMeldSize()); 	// the old meld becoming the last half of the meld 
            				newMeld.addTileAtLast(t);  		//add the tile to the newmeld
            				table.addMeld(newMeld);
            				return true;
            			}
            		}
                } 
                
                else return false;
                
            }
        }

        table.removeEmptyMeld();
        return false;

    }
    

}