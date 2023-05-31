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
	
	
	/*
	 * COSTRUTTORE
	 * */
	public Tile (int i, int j, int color) {
		
		this.owner = 0;
		this.verified = false;
		this.i = i;
		this.j = j;
		this.color = color;
	}
	
	
	/*
	 * Metotodo per la modifica dell'owner di una tile
	 * */
	public void changeTileOwner(int newOwner) {
		this.setOwner(newOwner);
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

	/* Setter di debug
	 * */
	public void setColor(int i) {
		this.color = i;
	}
}