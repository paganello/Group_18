package structure;

public class Box {
	
	private boolean fillable;
	private boolean full;
	private Tile tile;
	private int i;
	private int j;
	
	
	/*
	 * COSTRUTTORE
	 * */
	public Box(int i, int j, boolean fillable) {
		this.i = i;
		this.j = j;
		this.full = false;
		this.fillable = fillable;
	}
	
	
	/*
	 * Metodo che presa una tile la assegna alla box e aggiorna il volare di full (false -> true)
	 * */
	public void fillBox(Tile tile) {
		if(this.fillable) {
			this.tile = tile;
			this.full = true;
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
	
	public boolean isFull() {
		return this.full;
	}
	
	public void setFull(boolean d) {
		this.full = d;
	}
	
	public int getI() {
		return this.i;
	}
	
	public int getJ() {
		return this.j;
	}
}