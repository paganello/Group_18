package structure;
import java.util.Scanner;
import java.util.Random;

public class BoxMatrix {
	//dichiarazione variabili
	private Box[][] m;
	private int nI;	//numero max di righe
	private int nJ;	//numero max di colonne
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PINK = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	/*
	 * COSTRUTTORE
	 * */
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
	public Box getBox(int i, int j){
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
	public void putTilesInPlayerShelf(Tile[] tiles, int j, int nPlayer) {
		
		for (int n = 0; n <= tiles.length; n++) {
			for (int i = 0; i <= this.nI; i++) {
				if(!this.m[i][j].isFull() && this.m[i+1][j].isFull()) {
					this.m[i][j].setTile(tiles[n]);
					this.m[i][j].getTile().setOwner(nPlayer);
					this.m[i][j].getTile().setI(i);
					this.m[i][j].getTile().setJ(j);
					break;
				}	
			}
		}
	}
	
	
	/*
	 * Method freeSide checks if the input tile has at least a free side in the board 
	 * */
	public boolean freeSide (int i, int j) {
		
		if(boxExistAndIsFillable(i, j-1)) {
			if(!m[i][j+1].isFull() || !m[i][j+1].isFillable())
				return true;
			return false;
		}
		
		if(boxExistAndIsFillable(i, j-1)) {
			if(!m[i][j-1].isFull() || !m[i][j-1].isFillable())
				return true;
			return false;
		}
		
		if(boxExistAndIsFillable(i+1, j)) {
			if(!m[i+1][j].isFull() || !m[i+1][j].isFillable())
				return true;
			return false;
		}
		
		if(boxExistAndIsFillable(i-1, j)) {
			if(!m[i-1][j].isFull() || !m[i-1][j].isFillable())
				return true;
			return false;
		}
		return true;
	}	

	
	
	/*
	 * Metodo che serve per rimuovere tiles dalla board
	 * */
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
		
		if(this.boxExistAndIsFillable(i, j) && this.m[i][j].isFull()) {
			
			removedTiles [0] = this.getBox(i, j).getTile();
		}
		
		int choice;
		boolean tileExist;
		
		do {
			do {
		    System.out.println("Che cosa vuoi fare?\n1-Prendi la casella a destra.\n2-Prendi la casella a sinistra\n3-Prendi la casella in alto.\n4-Prendi la casella in basso\n5-Prendi solo la casella selezionata");
		    choice=sc.nextInt();
		    sc.nextLine();
			}while(choice<1||choice>5);
		    switch (choice) {
		    
		    case 1:
		    	
			    if(this.boxExistAndIsFillable(i, j+1) && m[i][j+1].isFull() && this.freeSide(i, j+1)) {
				    removedTiles [1] = this.getBox(i, j+1).getTile();
				    do{
				        System.out.println("Vuoi prendere anche una terza tessera?\n1-Si\n2-No");
				        choice=sc.nextInt();
				        sc.nextLine();
				        
				        switch (choice) {
				    
				        case 1:
					        if(this.boxExistAndIsFillable(i, j+2) && m[i][j+2].isFull() && this.freeSide(i, j+2)) {
						        removedTiles [2] = this.getBox(i, j+2).getTile();
						        tileExist=true;
					        }
					        else {
					        	System.out.println("Non è possibile prendere questa tessera.");
					        	tileExist=false;
					        }
					        break;
					    
				        case 2:
				        	tileExist=true;
					    	break;
					       
				        default:
					       System.out.println("Alla scelta fatta non corrisponde alcuna azione.");
					       tileExist=false;
					       break;
				        } 
				    } while (!tileExist);
				    
			    }else {
				    System.out.println("Non è possibile prendere questa tessera.");
				    tileExist=false;
			    }
			    break;
			
			
		    case 2:
		    	
			    if(this.boxExistAndIsFillable(i, j-1) && m[i][j-1].isFull() && this.freeSide(i, j-1)) {
				    removedTiles [1] = this.getBox(i, j-1).getTile();
				    do {
				        System.out.println("Vuoi prendere anche una terza tessera?\n1-Si\n2-No");
				        choice=sc.nextInt();
				        sc.nextLine();
				        
				        switch (choice) {
				        case 1:
				    	    if(this.boxExistAndIsFillable(i, j-2) && m[i][j-2].isFull() && this.freeSide(i, j-2)) {
				    	    	removedTiles [2] = this.getBox(i, j-2).getTile();
				    	    	tileExist=true;
				    	    }
					        else {
					        	System.out.println("Non è possibile prendere questa tessera.");
					        	tileExist=false;
					        }
						    break;
					    
				        case 2:
				        	tileExist=true;
					        break;
					    
					    default:
						    System.out.println("Alla scelta fatta non corrisponde alcuna azione.");
					        tileExist=false;
						    break;
				        }
				    }while(!tileExist);
			    }
			    
			    else {
			    	System.out.println("Non è possibile prendere questa tessera.");
			    	tileExist=false;
			    }
			    break;
			    
			    
		    case 3:
		    	
			    if(this.boxExistAndIsFillable(i+1, j) && m[i+1][j].isFull() && this.freeSide(i+1, j)) {
				    removedTiles [1] = this.getBox(i+1, j).getTile();
				    do {
				    do {
				        System.out.println("Vuoi prendere anche una terza tessera?\n1-Si\n2-No");
				        choice=sc.nextInt();
				        sc.nextLine();
				    }while(choice<1||choice>2);
				        switch (choice) {
				        case 1:
					        if(this.boxExistAndIsFillable(i+2, j) && m[i+2][j].isFull() && this.freeSide(i+2, j)) {
					        	removedTiles [2] = this.getBox(i+2, j).getTile();
					        	tileExist=true;
					        }
					        else {
					    	    System.out.println("Non è possibile prendere questa tessera.");
					    	    tileExist=false;
					        }
					        break;
					    
				        case 2:
				    	    tileExist=true;
					        break;
					    
				        default:
					        System.out.println("Alla scelta fatta non corrisponde alcuna azione.");
					        tileExist=false;
					        break;
				        }
				     
				    }while (!tileExist);
			    }
			    
			    else {
				    System.out.println("Non è possibile prendere questa tessera.");
				    tileExist=false;
			    }
			    break;
			    
			    
		    case 4:
		    	
			    if(this.boxExistAndIsFillable(i-1, j) && m[i-1][j].isFull() && this.freeSide(i-1, j)) {
				    removedTiles [1] = this.getBox(i-1, j).getTile();
				    do {
				    	System.out.println("Vuoi prendere anche una terza tessera?\n1-Si\n2-No");
				        choice=sc.nextInt();
				        sc.nextLine();
				        
				        switch (choice) {
				        case 1:
					        if(this.boxExistAndIsFillable(i-2, j) && m[i-2][j].isFull() && this.freeSide(i-2, j)) {
					    	    removedTiles [2] = this.getBox(i-2, j).getTile();
					    	    tileExist=true;
					        }
					        else {
						        System.out.println("Non è possibile prendere questa tessera.");
						        tileExist=false;
					        }
					        break;
					    
				        case 2:
				    	    tileExist=true;
					        break;
					    
				        default:
					        System.out.println("Alla scelta fatta non corrisponde alcuna azione");
					        tileExist=false;
					        break;
				        }
				    }while(!tileExist);
			    }
			    
			    else {
				    System.out.println("Non è possibile prendere questa tessera.");
				    tileExist=false;
			    }
			    break;
			    
		    case 5:
		    	tileExist=true;
			    break;
			    
		    default:
			    System.out.println("Alla scelta fatta non corrisponde alcuna azione.");
			    tileExist=false;
			    break;
		   }
		    
		}while(!tileExist);
		
		for(int c = 0; c < 3; c++) {
			if(removedTiles[c] != null) {
				int y = removedTiles[c].getI();
				int x = removedTiles[c].getJ();
				this.getBox(y, x).setFillable(false);
			}
		}
		return removedTiles;
	}
	
	
	/*
	 * Metodo che riempie la board in modo randomico
	 * */
	public void fillBoard () {
		for(int i = 0; i < nI; i++) {
			for(int j = 0; j < nJ; j++) {
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

	
	/* 
	 * 	Metodo di verifica delle caselle (box).
	 * 
	 * 	vanno verificate che le caselle intorno a quelle piene siano piene,
	 *  basta che 1 tile sia prendibile per tornare falso, affinchè 1 tile sia
	 *  prendibile deve avere almeno un lato scoperto ma non può averli tutti scoperti,
	 *  non devo verificare i lati, coperti devo verificare che abbia un lato in comune
	 *  con un altra tile.
	 */
	public boolean takeable(int i, int j) {
		int sideCovered = 0;
		int sideUncovered = 0;
		int adjacentTile = 0;
		
		if(boxExistAndIsFillable(i+1, j)) {
			if(m[i+1][j].isFull()) { //controlla la box accanto
				sideCovered++; 
				if(freeSide(i+1, j) == true) {
					adjacentTile++;
				}
			
			}
			else {
				sideUncovered++; 
			}
		}
		
		if(boxExistAndIsFillable(i-1, j)) {
			if(m[i-1][j].isFull()) {
				sideCovered++;
				if(freeSide(i-1, j) == true) {
					adjacentTile++;
				}
			}
			else {
				sideUncovered++; 
			}
		}
		
		if(boxExistAndIsFillable(i, j+1)) {
			if(m[i][j+1].isFull()) {
				sideCovered++;
				if(freeSide(i, j+1) == true) {
					adjacentTile++;
				}
			}
			else {
				sideUncovered++; 
			}
		}
		
		if(boxExistAndIsFillable(i, j-1)) {
			if(m[i][j-1].isFull()) {
				sideCovered++; 
				if(freeSide(i, j-1) == true) {
					adjacentTile++;
				}
			}
			else {
				sideUncovered++;
			}
		}
		
		if(sideUncovered >= 1 && sideCovered >= 1 && adjacentTile >= 1) { //se la casella ha almeno un lato scoperto (quindi è prendibile) ed ha almeno un lato coperto (quindi ha una casella affianco) e questa a sua volta ha un lato libero segna la casella in questione come prendibile
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/*
	 * Metodo di verifica se la board e' da rifillare di tiles
	 * */
	public boolean checkIfBoardNeedToBeRefilled (int nPlayer) {
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
	
	
	/*
	 * Metedo PRIVATO che verifica se una determinata box esiste ed e' riempibile 
	 * */
	private boolean boxExistAndIsFillable(int i, int j) {
		if(i >= 0 && i <= this.nI) {
			if(j >= 0 && j <= this.nJ) {
				if(m[i][j].isFillable()) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	/*
	 * Metodo ricorsivo che controlla che data una box esista almeno una tile nelle box adiacenti dello stesso colore.
	 * */
	public int countNumberOfAdjacentsTilesWithSameColor(int i, int j, int k) {

		if(boxExistAndIsFillable(i-1, j) && m[i-1][j].isFull() && !m[i][j].getTile().isVerified()){
			if(m[i-1][j].getTile().getColor() == m[i][j].getTile().getColor()) {
				k++;
				i--;
				countNumberOfAdjacentsTilesWithSameColor(i, j, k);
			}
		}
		if(boxExistAndIsFillable(i, j+1) && m[i][j+1].isFull() && !m[i][j].getTile().isVerified()){
			if(m[i][j+1].getTile().getColor() == m[i][j].getTile().getColor()) {
				k++;
				j++;
				countNumberOfAdjacentsTilesWithSameColor(i, j, k);
			}
		}
		if(boxExistAndIsFillable(i+1, j) && m[i+1][j].isFull() && !m[i][j].getTile().isVerified()){
			if(m[i+1][j].getTile().getColor() == m[i][j].getTile().getColor()) {
				k++;
				i++;
				countNumberOfAdjacentsTilesWithSameColor(i, j, k);
			}
		}
		if(boxExistAndIsFillable(i, j-1) && m[i][j-1].isFull() && !m[i][j].getTile().isVerified()){
			if(m[i][j-1].getTile().getColor() == m[i][j].getTile().getColor()) {
				k++;
				j--;
				countNumberOfAdjacentsTilesWithSameColor(i, j, k);
			}
		}
		return k;
	}
	
	
	/*
	 * Metodo che setta tutti gli attributi verified di tutte le tile a un valore boleano specificato
	 * */
	public void setAllVerifiedTileAttribute(boolean b) {
		
		for (int i = 0; i < nI; i++) {
			for (int j = 0; j < nJ; j++) {
				if(m[i][j].isFillable()) {
					m[i][j].getTile().setVerified(b);
				}
			}
		}
	}
	
	/*
	 * Metodo che stampa la tabella con relativi colori
	 */
	public void showTable () {
		int i = this.nI;
		int j = this.nJ;
		System.out.print(" \t");
		for (int k = 0; k < i; k++) {
			System.out.print(k + "\t");
		}
		System.out.println("\n");
		
		for(int y = 0; y < i; y++) {
			System.out.print(y + "\t");
			for (int x = 0; x < j; x++) {
				if(boxExistAndIsFillable(y, x) && this.m[y][x].isFull()) {
					switch(this.m[y][x].getTile().getColor()) {
					case 1:
						System.out.print(ANSI_GREEN+"G\t"+ANSI_RESET); //G=verde
						break;
					case 2:
						System.out.print(ANSI_WHITE+"W\t"+ANSI_RESET); //W=bianco
						break;
					case 3:
						System.out.print(ANSI_YELLOW+"Y\t"+ANSI_RESET); //Y=giallo
						break;
					case 4:
						System.out.print(ANSI_BLUE+"B\t"+ANSI_RESET); //B=blu
						break;
					case 5:
						System.out.print(ANSI_CYAN+"C\t"+ANSI_RESET); //C=azzurro
						break;
					case 6:
						System.out.print(ANSI_PINK+"P\t"+ANSI_RESET); //P=rosa
						break;
					default:
						System.out.print(" \t");
						break;
					}
				}else{
					System.out.print(" " + "\t");
				}
				
			}
			System.out.println("\n\n");
		}
    }
}
