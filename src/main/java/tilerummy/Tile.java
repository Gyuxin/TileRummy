package tilerummy;

public class Tile {
	
	private String color;
	private String rank;

	
	public Tile(String color, String rank) {
		this.color = color;
		this.rank = rank;
	}
	
	public Tile(String name) {
		this.color = name.substring(0, 1);
		this.rank = name.substring(1);
	}
	
	public void printTile() {
		System.out.println(this.color + this.rank);
	}
	
	public String getColor() {
		return this.color;
	}
	
	public String getRank() {
		return this.rank;
	}

}
