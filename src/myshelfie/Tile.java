package myshelfie;

import java.util.Scanner;

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

}