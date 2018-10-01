package tilerummy;

public class Tile {
	
	private String color;
	private int number;
	private boolean isOnTable;

	
	public Tile(String color, int number) {
		this.color = color;
		this.number = number;
		this.isOnTable = false;
	}
	
	public void printTile() {
		System.out.println(this.color + this.number);
	}
	
	public String getColor() {
		return this.color;
	}
	
	public int getNumber() {
		return this.number;
	}

	//return if the tile is already on the table
	public boolean getOnTable(){
		return this.isOnTable;
	}

	public void setOnTable(){
		this.isOnTable = true;
	}

}
