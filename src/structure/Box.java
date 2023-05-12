package structure;

public class Box {
	
	private boolean fillable;
	private boolean empty;
	private Tile tile;
	private int i;
	private int j;
	
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
	
	
	
	/*
	 * Getters and Setters
	 * */
	public Tile getTile() {
		return this.tile;
	}
	
	public void setTile(Tile t) {
		this.tile = t;
	}
	
	public boolean isFillable() {
		return this.fillable;
	}
	
	public void setFillable(boolean d) {
		this.fillable = d;
	}
	
	public boolean isEmpty() {
		return this.empty;
	}
	
	public int getI() {
		return this.i;
	}
	
	public int getJ() {
		return this.j;
	}
}