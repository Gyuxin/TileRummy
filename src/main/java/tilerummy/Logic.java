package tilerummy;

public class Logic {

    public void addOneTile(Tile t, Table table){

        for(int i = 0; i < table.getSize(); i++){

            Meld currentMeld = table.getMeld(i);
            String type = currentMeld.getType();

            //If current meld is a set
            if(type.indexOf('S') == 0){
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