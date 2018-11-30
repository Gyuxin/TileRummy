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
	
	public void setNumber(int num) {
		this.number = num;				// for joker
	}
	
	public void setColor(String color) {
		this.color = color;            // for highlight tile
		
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

	public void  hightlightrecenttile(Tile t) {
		
		 t.setColor(t.getColor()+"*");
	 }
	 public void resettile(Tile t) {
		 
	   t.setColor(t.getColor().substring(0,1));
	  
		 
	 }
<<<<<<< Updated upstream
}
=======
}
>>>>>>> Stashed changes
