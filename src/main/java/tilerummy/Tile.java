package tilerummy;

public class Tile {
	
	private String color;
	private int rank;

	
	public Tile(String color, int rank) {
		this.color = color;
		this.rank = rank;
	}
	
	public void printTile() {
		System.out.println(this.color + this.rank);
	}
	
	public String getColor() {
		return this.color;
	}
	
	public int getRank() {
		return this.rank;
	}

}
