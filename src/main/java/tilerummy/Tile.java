// Joker tile name: J0

package tilerummy;

public class Tile {
	
	private String color;
	private int number;
	
	public Tile(String color, int number) {
		this.color = color;
		this.number = number;
	}

	public Tile(String name) {
		this.color = name.substring(0,1);
		this.number = Integer.parseInt(name.substring(1));
	}
	
	public boolean compareTile(Tile t1) {

		if(this.color.equals(t1.color)&&this.number==t1.number) return true;
		return false;
	}
	
	public void printTile() {
		System.out.print(this.color + this.number + " ");
	}
	
	public String getColor() {
		return this.color;
	}
	
	public int getNumber() {
		return this.number;
	}
}
