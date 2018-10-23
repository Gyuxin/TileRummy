package tilerummy;

public class Tile {
	
	private String color;
	private int number;
	private boolean justPlayed;
	private boolean justMoved;
	
	public Tile(String color, int number) {
		this.color = color;
		this.number = number;
		this.justPlayed = false;
		this.justMoved = false;
	}

	public Tile(String name) {
		this.color = name.substring(0,1);
		this.number = Integer.parseInt(name.substring(1));
		this.justPlayed = false;
		this.justMoved = false;
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

	public boolean getJustPlayed(){
		return this.justPlayed;
	}

	public void setJustPlayed(){
		if(getJustPlayed()){
			justPlayed = false;
		} else {
			justPlayed = true;
		}
	}

	public boolean getJustMoved(){
		return this.justMoved;
	}

	public void setJustMoved(){
		if(getJustMoved()){
			justMoved = false;
		} else {
			justMoved = true;
		}
	}

}
