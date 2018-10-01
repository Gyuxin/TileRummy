package tilerummy;

import java.util.ArrayList;

public class Table {
	
	private ArrayList<Meld> table;
	
	public Table() {
		
		table = new ArrayList<Meld>();
		
	}
	
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
