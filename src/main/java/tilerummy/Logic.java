package tilerummy;

public class Logic {

    public static void addOneTile(Tile t, Table table){

        for(int i = 0; i < table.getSize(); i++){

            Meld currentMeld = table.getMeld(i);

            //If current meld is a set
            if(currentMeld.isSet()){
                if(!currentMeld.containsTile(t)){
                    currentMeld.addTileAtLast(t);
                }
            } else {
                //If tile's number is one less than first tile's number in current meld
                if(t.getNumber()+1 == currentMeld.getFirstTile().getNumber()){
                    currentMeld.addTileAtFirst(t);
                } 

                //If tile's number is one bigger than last tile's number in current meld
                if(t.getNumber()-1 == currentMeld.getLastTile().getNumber()){
                    currentMeld.addTileAtLast(t);
                } 
            }
        }

        table.removeEmptyMeld();

    }

}