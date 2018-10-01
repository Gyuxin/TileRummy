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
		
		if(checkMeld(meld)){
			table.add(meld);
		} else {
			//the tiles will go back to the player or table
		}

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

	//check if the meld is a valid meld
	public boolean checkMeld(Meld meld){
		if(meld.getType().indexOf('S') == 0 || meld.getType().indexOf('R') == 0){
			return true;
		} else {
			return false;
		}
	}

}
