package structure;
import java.util.Scanner;
import java.util.Random;

public class BoxMatrix {
	//dichiarazione variabili
	private Box[][] m;
	private int nI;	//numero max di righe
	private int nJ;	//numero max di colonne
	
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
	
	
	/*
	 * Getter m
	 * */
	public Box getMatrix(int i, int j){
		return this.m[i][j];
	}
	
	
	/*
	 * Getter nI
	 * */
	public int getNI(){
		return this.nI;
	}
	
	
	/*
	 * Getter nJ
	 * */
	public int getNJ(){
		return this.nJ;
	}
	
	
	/*
	 * Metodo che modifica lo stato dell'attributo fillable dati array di coordinate e il nuovo valore di fillable
	 * */
	public void modFillableByArrayMaps(int[] iMap, int[] jMap, boolean fillable) {
		for(int i = 0; i < iMap.length; i++) {
			this.m[iMap[i]-1][jMap[i]-1].setFillable(fillable);
		}
	}
	
	
	/*
	 * Metodi di print (pincipalmente usati in debug)
	 * */
	public void printTileFillable(int i, int j) {	//temporaneo, stampa il val di fillable
		System.out.print(this.m[i][j].isFillable() + " ");
	}
	public void printTileColor(int i, int j) {	//temporaneo, stampa il val di color
		System.out.print(this.m[i][j].getTile().getColor() + " ");
	}
	
	
	/*
	 * Metedo che inserisce una tile nella shelf del player
	 * 
	 * la j che viene fornita DEVE essere gia decrementate e adattandola alla gestione della matrice (che ricordiamo parire da riga zero e non da riga uno)
	 * */
	public void putTileIn(Tile tile, int j, int nPlayer) {
		
		for (int i = 0; i < this.nI; i++) {
			if(!this.m[i][j].isFull() && this.m[i+1][j].isFull()) {
				this.m[i][j].setTile(tile);
				this.m[i][j].getTile().setOwner(nPlayer);
				this.m[i][j].getTile().setI(i);
				this.m[i][j].getTile().setJ(j);
			}	
		}
	}
	
	
	/*
	 * Method freeSide checks if the input tile has at least a free side in the board 
	 * */
	public boolean freeSide (int i, int j) {
		
		if(!m[i][j+1].isFull() || !m[i][j+1].isFillable())
			return true;
		if(!m[i][j-1].isFull() || !m[i][j-1].isFillable())
			return true;
		if(!m[i+1][j].isFull() || !m[i+1][j].isFillable())
			return true;
		if(!m[i-1][j].isFull() || !m[i-1][j].isFillable())
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
		
		sc.close();
		return removedTiles;
	}
	
	
	/*
	 * Metodo che riempie la board in modo randomico
	 * */
	public void fillBoard () {
		for(int i = 1; i <= nI; i++) {
			for(int j = 1; j <= nJ; j++) {
				if(m[i][j].isFillable() == true && !m[i][j].isFull()) {	//controllo che il box di coordinate (i,j) sia riempibile e vuoto
					int UPPER_BOUND = 6;
					int LOWER_BOUND = 1;
					Random rand = new Random();
					
					int color = rand.nextInt(LOWER_BOUND, UPPER_BOUND); 	//estraggo un numero tra 1 e 6
					
					Tile newTile = new Tile(i, j, color); //creo la nuova tile
					
					m[i][j].fillBox(newTile); //inserisco la tile nel box
				}
			}
		}
		
	}

	
	
	public boolean takeable(int i, int j) {
		int sideCovered = 0;
		int sideUncovered = 0;
		int adjacentTile = 0;
		/* 
		 * vanno verificate che le caselle intorno a quelle piene siano piene,
		 *  basta che 1 tile sia prendibile per tornare falso, affinchè 1 tile sia
		 *  prendibile deve avere almeno un lato scoperto ma non può averli tutti scoperti
		 *  ma non devo verificare i lati coperti devo verificare che abbia un lato in comune
		 *  con un altra tile
		 */
		if(m[i+1][j].isFull()) { //controlla la box accanto
			sideCovered++; 
			if(freeSide(i+1, j) == true) {
				adjacentTile++;
			}
			
		}
		else {
			sideUncovered++; 
		}
		
		if(m[i-1][j].isFull()) {
			sideCovered++;
			if(freeSide(i-1, j) == true) {
				adjacentTile++;
			}
		}
		else {
			sideUncovered++; 
		}
		
		if(m[i][j+1].isFull()) {
			sideCovered++;
			if(freeSide(i, j+1) == true) {
				adjacentTile++;
			}
		}
		
		else {
			sideUncovered++; 
		}
		
		if(m[i][j-1].isFull()) {
			sideCovered++; 
			if(freeSide(i, j-1) == true) {
				adjacentTile++;
			}
		}
		else {
			sideUncovered++;
		}
		
		if(sideUncovered >= 1 && sideCovered >= 1 && adjacentTile >= 1) { //se la casella ha almeno un lato scoperto (quindi è prendibile) ed ha almeno un lato coperto (quindi ha una casella affianco) e questa a sua volta ha un lato libero segna la casella in questione come prendibile
			return true;
		}
		else {
			return false;
		}
	}
	
	

	public boolean checkBoard (int nPlayer) {
		//int emptyBox = 0;
		for(int i = 1; i <= nI; i++) {
			for(int j = 1; j <= nJ; j++) {
				if(m[i][j].isFull()) { //se la casella e' piena controllo che si possa prendere
					if(takeable(i, j) == true) {
						return false; //se anche solo una casella è prendibile e ne ha una accanto allora torno false
					}
				}
				/*else if(matrix.m[i][j].empty == true) {
					emptyBox++;
				}*/
			}
		}
		/*if(nPlayer == 2 && emptyBox == 28 || nPlayer == 3 && emptyBox == 36 || nPlayer == 4 && emptyBox == 42) {
			return true;	//se la board è vuota torno true
		}*/
		return true;
	}
	
}
