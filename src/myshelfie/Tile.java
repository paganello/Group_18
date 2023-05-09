package myshelfie;

public class Tile { 
	
	int owner;	//0 = board
				//1 = palyer 1
				//2 = palyer 2
				//3 = palyer 3
				//4 = palyer 4
	
	private int color; 	//1 = verde
						//2 = bianco
						//3 = giallo
						//4 = blu
						//5 = azzurro
						//6 = rosa
	int i, j;
	boolean verified;
	
	public Tile (int i, int j, int color) {
		
		this.owner = 0;
		this.verified = false;
		this.i = i;
		this.j = j;
		this.color = color;
	}
	
	public void changeTileOwner(int newOwner) {
		this.owner = newOwner;
	}
	
	public void changeTileCoordinates(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public int getColor() {
		return this.color;
	}
	
	/*
	 * Method freeSide checks if the input tile has at least a free side in the board 
	 */
public boolean freeSide (BoxMatrix Board, Tile tile, int i, int j) {
		tile.changeTileCoordinates(this.i, this.j+1);
		if(tile.color==0 || tile.color==7){
			return true;
		tile.changeTileCoordinates(this.i, this.j-1);  //devo sottrarre a partire dal valore iniziale o da quello modificato?
		if(tile.color==0 || tile.color==7){
			return true;
		tile.changeTileCoordinates(this.i+1, this.j);
		if(tile.color==0 || tile.color==7){
			return true;
		tile.changeTileCoordinates(this.i-1, this.j);
		if(tile.color==0 || tile.color==7){
			return true;
		return false;
	}
}











