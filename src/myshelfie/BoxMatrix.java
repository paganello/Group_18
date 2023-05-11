package myshelfie;

import java.util.Scanner;

public class BoxMatrix {
	//dichiarazione variabili
	Box[][] m;
	int nI;	//numero max di righe
	int nJ;	//numero max di colonne
	
	public BoxMatrix(int i, int j) {	//costruttore matrice, Funziona!
		
		/*
		this.nI = i;
		this.nJ = j;
		int[][] m = new int[i][j];
		
		for (int k = 0; k < i; k++) {
			for(int n = 0; n < j; n++) {
				m[k][n] = 0;
			}
		};
		this.m = m;
		*/
		
		this.nI = i;
		this.nJ = j;
		Box[][] m = new Box[i][j];
		
		for (int k = 0; k < i; k++) {
			for(int n = 0; n < j; n++) {
				m[k][n] = new Box(k, n, true);
			}
		}
		
		this.m = m;	
	}
	
	
	public void modBox(int i, int j, boolean fillable) {	//modifica fillable
		//if(i <= nI && j <= nJ){
		//	this.m[i][j] = value;
		this.m[i][j].fillable = fillable;
		/*}else{
			System.out.println("Coding Error");
		}*/
	}
	
	
	public void modBoxesByArrayMaps(int[] iMap, int[] jMap, boolean fillable) {
		for(int i = 0; i < iMap.length; i++) {
			modBox(iMap[i]-1, jMap[i]-1, fillable); //decrementa tutto di uno per adattare all'array che parte da 0 e non da 1, poi scrive nella box ij
		}
	}
	
	
	public void printTileFillable(int i, int j) {	//temporaneo, stampa il val di fillable
		System.out.print(this.m[i][j].fillable + " ");
	}
	public void printTileColor(int i, int j) {	//temporaneo, stampa il val di color
		System.out.print(this.m[i][j].tile.getColor() + " ");
	}
	
	
	public void putTileIn(Tile tile, int c, int player) {
		
		int j = c - 1;
		switch (j) {
		case 0:
			for (int i = 0; i < this.nI; i++) {
				if(this.m[i][j].empty && !this.m[i+1][j].empty) {
					this.m[i][j].tile = tile;
					this.m[i][j].tile.owner = player;
					this.m[i][j].tile.i = i; 
					this.m[i][j].tile.j = j;
				}
			}
			break;
			
		case 1:
			for (int i = 0; i < this.nI; i++) {
				if(this.m[i][j].empty && !this.m[i+1][j].empty) {
					this.m[i][j].tile = tile;
					this.m[i][j].tile.owner = player;
					this.m[i][j].tile.i = i; 
					this.m[i][j].tile.j = j;
				}
			}
			break;
			
		case 2:
			for (int i = 0; i < this.nI; i++) {
				if(this.m[i][j].empty && !this.m[i+1][j].empty) {
					this.m[i][j].tile = tile;
					this.m[i][j].tile.owner = player;
					this.m[i][j].tile.i = i; 
					this.m[i][j].tile.j = j;
				}
			}
			break;
			
		case 3:
			for (int i = 0; i < this.nI; i++) {
				if(this.m[i][j].empty && !this.m[i+1][j].empty) {
					this.m[i][j].tile = tile;
					this.m[i][j].tile.owner = player;
					this.m[i][j].tile.i = i; 
					this.m[i][j].tile.j = j;
				}
			}
			break;
			
		case 4:
			for (int i = 0; i < this.nI; i++) {
				if(this.m[i][j].empty && !this.m[i+1][j].empty) {
					this.m[i][j].tile = tile;
					this.m[i][j].tile.owner = player;
					this.m[i][j].tile.i = i; 
					this.m[i][j].tile.j = j;
				}
			}
			break;

		default:
			break;
		}
	}
	
	
	/*
	 * Method freeSide checks if the input tile has at least a free side in the board 
	 */
	public boolean freeSide (int i, int j) {
		
		if(m[i][j+1].empty || !m[i][j+1].fillable)
			return true;
		if(m[i][j-1].empty || !m[i][j-1].fillable)
			return true;
		if(m[i+1][j].empty || !m[i+1][j].fillable)
			return true;
		if(m[i-1][j].empty || !m[i-1][j].fillable)
			return true;
		
		return false;
	}

	
	public Tile [] removeTilesFromBoard (int i, int j) {
		/*nel main
		 * System.out.println("Inserisci le coordinate della prima tessera che vuoi prendere dal tabellone.");
		Scanner sc=new Scanner (System.in);
		do{
			scatola.nI=sc.nextInt();
			scatola.nJ=sc.nextInt();
			
		}while (!scatola.freeSide(nI, nJ));*/
		Scanner sc=new Scanner (System.in);
		Tile  removedTiles [] = new Tile [3];
		int choice;
		System.out.println("Che cosa vui fare?/n1-Prendi la casella a destra./n2-Prendi la casella a sinistra/n3-Prendi la casella in alto./n4-Prendi la casella in basso/n5-Prendi solo le caselle selezionate");
		choice=sc.nextInt();
		switch (choice) {
		case 1:
			
		case 2:
		case 3:
		case 4:
		case 5:
		default:
		}
		
		return removedTiles;
	}
}
