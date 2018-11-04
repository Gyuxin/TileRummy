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
	
	public void printTile() {
		if(this.justMoved == true){
			System.out.print("!" + this.color + this.number + " ");
		} else if(this.justPlayed == true){
			System.out.print("*" + this.color + this.number + " ");
		} else {
			System.out.print(this.color + this.number + " ");
		}
		
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
