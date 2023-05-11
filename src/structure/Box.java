package structure;

public class Box {
	
	boolean fillable;
	boolean empty;
	Tile tile;
	int i;
	int j;
	
	public Box(int i, int j, boolean fillable) {
		this.i = i;
		this.j = j;
		this.empty = false;
		this.fillable = fillable;
	}
	
	public void fillBox(Tile tile) {
		if(fillable) {
			this.tile = tile;
			this.empty = true;
		}
	}
	
	public Tile getTile() {
		return this.tile;
	}
}