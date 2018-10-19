package tilerummy;

import java.util.ArrayList;

public class Table {
	
	private ArrayList<Meld> table;
	
	public Table() {
		
		table = new ArrayList<Meld>();
		
	}

	public int getSize(){
		return table.size();
	}

	public Meld getMeld(int position){
		return table.get(position);
	}

	public void printTable(){
		for(int i = 0; i < table.size(); i++){
			table.get(i).printMeld();
		}
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
