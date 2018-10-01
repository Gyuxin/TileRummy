package tilerummy;

import java.util.ArrayList;

public class Table {
	
	private ArrayList<Meld> table;
	
	public Table() {
		
		table = new ArrayList<Meld>();
		
	}
	
	//if the meld you want to add to the table is a valid meld, the meld is added to table
	//if it's not a valid meld, the tiles will go back to the player or table
	public void addMeld(Meld meld) {
		table.add(meld);
	}

	//remove empty meld
	public void removeEmptyMeld(){
		
		for(int i = 0; i < table.size(); i++){
			if(table.get(i).getMeldSize() == 0){
				table.remove(i);
				i--;
			}
		}
	}

}
