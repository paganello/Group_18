package myshelfie;

public class Box {
	/*public int cont1=22;
	public int cont2=22;
	public int cont3=22;
	public int cont4=22;
	public int cont5=22;
	public int cont6=22;*/
	
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
}

