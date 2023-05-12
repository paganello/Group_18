package structure;


public class Tile { 
	
	private int owner;	//0 = board
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
	private int i, j;
	private boolean verified; //serve per i goal
	
	public Tile (int i, int j, int color) {
		
		this.setOwner(0);
		this.setVerified(false);
		this.setI(i);
		this.setJ(j);
		this.color = color;
	}
	
	public void changeTileOwner(int newOwner) {
		this.setOwner(newOwner);
	}
	
	public void changeTileCoordinates(int i, int j) {
		this.setI(i);
		this.setJ(j);
	}
	
	
	
	/*
	 * Getters and Setters
	 * */
	public int getColor() {
		return this.color;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	
	
}