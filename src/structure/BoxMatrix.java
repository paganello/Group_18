package structure;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;


public class BoxMatrix {
	//dichiarazione variabili
	private Box[][] m;
	private int nI;	//numero max di righe
	private int nJ;	//numero max di colonne
	
	public static final String resetTextColor = "\u001B[0m";
	public static final String textGreen = "\u001B[32m";
	public static final String textYellow = "\u001B[33m";
	public static final String textBlue = "\u001B[34m";
	public static final String textPink = "\u001B[35m";
	public static final String textCyan = "\u001B[36m";
	public static final String textWhite = "\u001B[37m";
	
	/**
	 * Realizza una matrice di oggetti Box di dimensioni i j (Paramentri in input)
	 * @param i
	 * @param j
	 */
	public BoxMatrix(int i, int j) {
		
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
	
	
	/**
	 * Ritorna l'oggetto Box alla posizione i j
	 * @param i
	 * @param j
	 * @return
	 */
	public Box getBox(int i, int j){
		return this.m[i][j];
	}
	
	
	/**
	 * Ritorna in numero di righe della matrice
	 * @return
	 */
	public int getNI(){
		return this.nI;
	}
	
	/**
	 * Ritorna in numero di colonne della matrice
	 * @return
	 */
	public int getNJ(){
		return this.nJ;
	}
	
	
	/**
	 * Metodo che modifica lo stato dell'attributo fillable delle boxes passate (arrays)
	 * @param iMap
	 * @param jMap
	 * @param fillable
	 */
	public void modFillableByArrayMaps(int[] iMap, int[] jMap, boolean fillable) {
		for(int i = 0; i < iMap.length; i++) {
			this.m[iMap[i]-1][jMap[i]-1].setFillable(fillable);
		}
	}
	
	
	/**
	 * Metodo che permette al giocatore di mettere nell'ordine di preferenza le caselle prese dal tavolo di gioco
	 * @param tiles
	 * @return
	 */
	private Tile[] orderTilesArray (Tile[] tiles) {
		System.out.println("Queste sono le tue tessere");
		System.out.println("1\t2\t3\t ");
		
		for (int i=0; i<3; i++) {
			if(tiles[i]!= null) {
				switch(tiles[i].getColor()) {
				case 1:
					System.out.print(textGreen+"G\t"+resetTextColor); //G=verde
					break;
				case 2:
					System.out.print(textWhite+"W\t"+resetTextColor); //W=bianco
					break;
				case 3:
					System.out.print(textYellow+"Y\t"+resetTextColor); //Y=giallo
					break;
				case 4:
					System.out.print(textBlue+"B\t"+resetTextColor); //B=blu
					break;
				case 5:
					System.out.print(textCyan+"C\t"+resetTextColor); //C=azzurro
					break;
				case 6:
					System.out.print(textPink+"P\t"+resetTextColor); //P=rosa
					break;
				default:
					System.out.print(" \t");
				};
			}else {
				System.out.println("\t");
			}
		}
		
		Scanner sc = new Scanner (System.in);
		Tile[] newTilesOrder = new Tile [3];
		int selectedTile;
		int modCheck;
		modCheck= getIntData("Vuoi modificare l'ordine di inserimento nella libreria?\n1-Si\n2-No\nScelta:");
		if(modCheck==1) {
		if(tiles[0] != null) {
			do {
			selectedTile = getIntData("Quale Tessera vuoi inserire per prima nella libreria?\nScelta:")-1;
			if(tiles [selectedTile] == null)
				System.out.println("La posizione selezionata non contiene alcuna tessera.");
			if(selectedTile>tiles.length)
				System.out.println("Non esiste questa posizione.");
			}while(selectedTile>tiles.length ||  tiles [selectedTile] == null);
			newTilesOrder [0] = tiles[selectedTile];
			tiles [selectedTile] = null;
			
			if(tiles[0] != null || tiles[1] != null || tiles[2] != null) {
				do {
				selectedTile = getIntData("\nQuale Tessera vuoi inserire dopo nella libreria?\nScelta:")-1;
				if(tiles [selectedTile] == null)
					System.out.println("La posizione selezionata non contiene alcuna tessera o la tessera qui presente e' gia' stata posizionata.");
				if(selectedTile>tiles.length)
					System.out.println("Non esiste questa posizione.");
				}while(selectedTile>tiles.length ||  tiles [selectedTile] == null);
				newTilesOrder [1] = tiles[selectedTile];
				tiles [selectedTile] = null;
			}
			
			if(tiles[0] != null || tiles[1] != null || tiles[2] != null) {
				do {
				selectedTile = getIntData("\nQuale Tessera vuoi inserire dopo nella libreria?\nScelta:")-1;
				if(tiles [selectedTile] == null)
					System.out.println("La posizione selezionata non contiene alcuna tessera.");
				if(selectedTile>tiles.length)
					System.out.println("Non esiste questa posizione.");
				}while(selectedTile>tiles.length ||  tiles [selectedTile] == null);
				newTilesOrder [2] = tiles[selectedTile];
				tiles [selectedTile] = null;
			}
		
		}
		else {
			System.out.println("Non e'possibile che si siano prese piu' di 3 tessere.");
		}
		}
		else {
			newTilesOrder=tiles;
		}
		return newTilesOrder;
	}
	
	
	/**
	 * Metedo che inserisce una tile nella shelf del player
	 * la j che viene fornita DEVE essere gia decrementate e adattandola alla gestione della matrice (che ricordiamo parire da riga zero e non da riga uno)
	 * @param tiles
	 * @param j
	 * @param nPlayer
	 */
	public void putTilesInPlayerShelf(Tile[] tiles, int j, int nPlayer) {
		if (tiles [1] != null) {
			tiles = orderTilesArray(tiles);
		}
		for (int n = 0; n < tiles.length; n++) {
			if(tiles[n] != null) {
				for (int i = 0; i < this.nI; i++) {
					if(!this.m[i][j].isFull() && boxExistAndIsFillable(i+1, j) && this.m[i+1][j].isFull() || (i+1) == this.nI && !this.m[i][j].isFull()) {
						this.m[i][j].fillBox(tiles[n]);
						this.m[i][j].getTile().setOwner(nPlayer);
						this.m[i][j].getTile().setI(i);
						this.m[i][j].getTile().setJ(j);
						i = this.nI;
					}	
					//System.out.println(i);
				}
			}
		}
		
	}
	
	
	/**
	 * Metodo che verifica che una data box piena sia abbia almeno un lato confinante con una box vuota
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean freeSide (int i, int j) {
		
		if(boxExistAndIsFillable(i, j+1)) {
			if(!m[i][j+1].isFull() || !m[i][j+1].isFillable())
				return true;
		}else {
			return true;
		}
		
		if(boxExistAndIsFillable(i, j-1)) {
			if(!m[i][j-1].isFull() || !m[i][j-1].isFillable())
				return true;
		}else {
			return true;
		}
		
		if(boxExistAndIsFillable(i+1, j)) {
			if(!m[i+1][j].isFull() || !m[i+1][j].isFillable())
				return true;
		}else {
			return true;
		}
		
		if(boxExistAndIsFillable(i-1, j)) {
			if(!m[i-1][j].isFull() || !m[i-1][j].isFillable())
				return true;
		}else {
			return true;
		}
		
		return false;
	}	

	
	/**
	 * Metodo che date le coordinate di una tile (param) verifica la sua idoneita' e permette di selezionare aletre tile;
	 * le tile vengono quaidni ritornate sotto forma di array di Tile.
	 * @param i
	 * @param j
	 * @return Tile array
	 */
	public Tile [] removeTilesFromBoard (int i, int j) {
		Scanner sc=new Scanner (System.in);
		Tile  removedTiles [] = new Tile [3];
		
		removedTiles [0] = this.getBox(i, j).getTile();	// la tile e' gia verificato che esista
		
		int choice;
		boolean tileExist;
		
		do {
			do {
				choice = getIntData("\nChe cosa vuoi fare?\n1-Prendi la casella a destra.\n2-Prendi la casella a sinistra\n3-Prendi la casella in basso.\n4-Prendi la casella in alto\n5-Prendi solo la casella selezionata\nScelta: ");
			}while(choice<1||choice>5);
		    
			switch (choice) {
		    
		    case 1:
		    	
			    if(this.boxExistAndIsFillable(i, j+1) && m[i][j+1].isFull() && this.freeSide(i, j+1)) {
				    removedTiles [1] = this.getBox(i, j+1).getTile();
				    
				    do{
				    	do {
				    		choice = getIntData("\nVuoi prendere anche una terza tessera?\n1-Si\n2-No\nScelta: ");
				    	}while(choice<1||choice>2);
				        
				        switch (choice) {
				    
				        case 1:
					        if(this.boxExistAndIsFillable(i, j+2) && m[i][j+2].isFull() && this.freeSide(i, j+2)) {
						        removedTiles [2] = this.getBox(i, j+2).getTile();
						        tileExist=true;
					        }
					        else {
					        	System.err.println("Non è possibile prendere questa tessera.");
					        	tileExist=false;
					        }
					        break;
					    
				        case 2:
				        	tileExist=true;
					    	break;
					       
				        default:
					       System.err.println("Alla scelta fatta non corrisponde alcuna azione.");
					       tileExist=false;
					       break;
				        } 
				    } while (!tileExist);
				    
			    }else {
				    System.err.println("Non è possibile prendere questa tessera.");
				    tileExist=false;
			    }
			    break;
			
			
		    case 2:
		    	
			    if(this.boxExistAndIsFillable(i, j-1) && m[i][j-1].isFull() && this.freeSide(i, j-1)) {
				    removedTiles [1] = this.getBox(i, j-1).getTile();
				    
				    do {
				    	do {
				    		choice = getIntData("\nVuoi prendere anche una terza tessera?\n1-Si\n2-No\nScelta: ");;
					    }while(choice<1||choice>2);
				        
				        switch (choice) {
				        case 1:
				    	    if(this.boxExistAndIsFillable(i, j-2) && m[i][j-2].isFull() && this.freeSide(i, j-2)) {
				    	    	removedTiles [2] = this.getBox(i, j-2).getTile();
				    	    	tileExist=true;
				    	    }
					        else {
					        	System.err.println("Non e' possibile prendere questa tessera.");
					        	tileExist=false;
					        }
						    break;
					    
				        case 2:
				        	tileExist=true;
					        break;
					    
					    default:
						    System.err.println("Alla scelta fatta non corrisponde alcuna azione.");
					        tileExist=false;
						    break;
				        }
				    }while(!tileExist);
			    }
			    
			    else {
			    	System.err.println("Non e' possibile prendere questa tessera.");
			    	tileExist=false;
			    }
			    break;
			    
			    
		    case 3:
		    	
			    if(this.boxExistAndIsFillable(i+1, j) && m[i+1][j].isFull() && this.freeSide(i+1, j)) {
				    removedTiles [1] = this.getBox(i+1, j).getTile();
				    
				    do {
				    	do {
				    		choice = getIntData("\nVuoi prendere anche una terza tessera?\n1-Si\n2-No\nScelta: ");
				    	}while(choice<1||choice>2);
				    
				        switch (choice) {
				        case 1:
					        if(this.boxExistAndIsFillable(i+2, j) && m[i+2][j].isFull() && this.freeSide(i+2, j)) {
					        	removedTiles [2] = this.getBox(i+2, j).getTile();
					        	tileExist=true;
					        }
					        else {
					    	    System.err.println("Non e' possibile prendere questa tessera.");
					    	    tileExist=false;
					        }
					        break;
					    
				        case 2:
				    	    tileExist=true;
					        break;
					    
				        default:
					        System.err.println("Alla scelta fatta non corrisponde alcuna azione.");
					        tileExist=false;
					        break;
				        }
				     
				    }while (!tileExist);
			    }
			    
			    else {
				    System.err.println("Non e' possibile prendere questa tessera.");
				    tileExist=false;
			    }
			    break;
			    
			    
		    case 4:
		    	
			    if(this.boxExistAndIsFillable(i-1, j) && m[i-1][j].isFull() && this.freeSide(i-1, j)) {
				    removedTiles [1] = this.getBox(i-1, j).getTile();
				    
				    do {
				    	do {
				    		choice = getIntData("\nVuoi prendere anche una terza tessera?\n1-Si\n2-No\nScelta: ");
					    }while(choice<1||choice>2);
				        
				        switch (choice) {
				        case 1:
					        if(this.boxExistAndIsFillable(i-2, j) && m[i-2][j].isFull() && this.freeSide(i-2, j)) {
					    	    removedTiles [2] = this.getBox(i-2, j).getTile();
					    	    tileExist=true;
					        }
					        else {
						        System.err.println("Non e' possibile prendere questa tessera.");
						        tileExist=false;
					        }
					        break;
					    
				        case 2:
				    	    tileExist=true;
					        break;
					    
				        default:
					        System.err.println("Alla scelta fatta non corrisponde alcuna azione");
					        tileExist=false;
					        break;
				        }
				    }while(!tileExist);
			    }
			    
			    else {
				    System.err.println("Non e' possibile prendere questa tessera.");
				    tileExist=false;
			    }
			    break;
			    
		    case 5:
		    	tileExist=true;
			    break;
			    
		    default:
			    System.err.println("Alla scelta fatta non corrisponde alcuna azione.");
			    tileExist=false;
			    break;
		   }
		    
		}while(!tileExist);
		
		for(int c = 0; c < 3; c++) {
			if(removedTiles[c] != null) {
				int y = removedTiles[c].getI();
				int x = removedTiles[c].getJ();
				this.getBox(y, x).setFull(false);
				this.getBox(y, x).setTile(null);
				
			}
		}
		return removedTiles;
	}
	
	
	/**
	 * Metodo che riempie la board in modo randomico
	 * Date le dimensioni della matrice di box (se essere sono vuote e riempibili) 
	 * gli assegna un nuovo oggetto tile di colore randomico (una per box)
	 */
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

	
	/**
	 * Metodo di verifica delle caselle (box).
	 * 
	 * vanno verificate che le caselle intorno a quelle piene siano piene,
	 * basta che 1 tile sia prendibile per tornare falso, affinchè 1 tile sia
	 * prendibile deve avere almeno un lato scoperto ma non può averli tutti scoperti,
	 * non devo verificare i lati, coperti devo verificare che abbia un lato in comune
	 * con un altra tile.
	 * @param i
	 * @param j
	 * @return boolean
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
	
	
	/**
	 * Metodo di verifica se la board e' da rifillare di tiles
	 * @return boolean
	 */
	public boolean checkIfBoardNeedToBeRefilled () {
		int sideCovered = 0;

		//int emptyBox = 0;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(m[i][j].isFull()) { //se la casella e' piena controllo che si possa prendere
					//System.out.print("i = "+i+"   j = " + j + "  --> ");
					//System.out.println(takeable(i, j));
					if(boxExistAndIsFillable(i+1, j)) {
						if(m[i+1][j].isFull()) { //controlla la box accanto
							sideCovered++; 
						}
					}
					if(boxExistAndIsFillable(i-1, j)) {
						if(m[i-1][j].isFull()) { //controlla la box accanto
							sideCovered++; 
						}
					}
					if(boxExistAndIsFillable(i, j+1)) {
						if(m[i][j+1].isFull()) { //controlla la box accanto
							sideCovered++; 
						}
					}
					if(boxExistAndIsFillable(i, j-1)) {
						if(m[i][j-1].isFull()) { //controlla la box accanto
							sideCovered++; 
						}
					}
					
					if(sideCovered > 0) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	
	/**
	 * Metedo che verifica se una determinata box (coordinate in param) esiste ed e' riempibile 
	 * @param i
	 * @param j
	 * @return boolean
	 */
	public boolean boxExistAndIsFillable(int i, int j) {
		if(i >= 0 && i < this.nI) {
			if(j >= 0 && j < this.nJ) {
				if(m[i][j].isFillable()) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	/**
	 * Metodo ricorsivo che controlla che data una box esista almeno una tile, tra le box adiacenti, dello stesso colore.
	 * k viene incrementato un numero di volte pari al numero di tile "in fila" o comunque "attaccate" trovate
	 * @param j
	 * @param k
	 * @return k incrementato
	 */
	public int countNumberOfAdjacentsTilesWithSameColor(int i, int j, int k) {

		
		m[i][j].getTile().setVerified(true);
		//System.out.println(i + " " + j);
		if(boxExistAndIsFillable(i-1, j) && m[i-1][j].isFull() && !m[i-1][j].getTile().isVerified()){
			if(m[i-1][j].getTile().getColor() == m[i][j].getTile().getColor()) {
				//m[i][j].getTile().setVerified(true);
				k++;
				//System.out.println(k);
				k = countNumberOfAdjacentsTilesWithSameColor((i-1), j, k);
			}
		}
		if(boxExistAndIsFillable(i, j+1) && m[i][j+1].isFull() && !m[i][j+1].getTile().isVerified()){
			if(m[i][j+1].getTile().getColor() == m[i][j].getTile().getColor()) {
				//m[i][j].getTile().setVerified(true);
				k++;
				//System.out.println(k);
				k = countNumberOfAdjacentsTilesWithSameColor(i, (j+1), k);
			}
		}
		if(boxExistAndIsFillable(i+1, j) && m[i+1][j].isFull() && !m[i+1][j].getTile().isVerified()){
			if(m[i+1][j].getTile().getColor() == m[i][j].getTile().getColor()) {
				//m[i][j].getTile().setVerified(true);
				k++;
				//System.out.println(k);
				k =countNumberOfAdjacentsTilesWithSameColor((i+1), j, k);
			}
		}
		if(boxExistAndIsFillable(i, j-1) && m[i][j-1].isFull() && !m[i][j-1].getTile().isVerified()){
			if(m[i][j-1].getTile().getColor() == m[i][j].getTile().getColor()) {
				//m[i][j].getTile().setVerified(true);
				k++;
				//System.out.println(k);
				k = countNumberOfAdjacentsTilesWithSameColor(i, (j-1), k);
			}
		}
		return k;
	}
	

	
	
	/**
	 * Metodo che setta tutti gli attributi verified di tutte le tile a un valore boleano specificato (param)
	 * @param b
	 */
	public void setAllVerifiedTileAttribute(boolean b) {
		
		for (int i = 0; i < nI; i++) {
			for (int j = 0; j < nJ; j++) {
				if(m[i][j].isFull()) {
					m[i][j].getTile().setVerified(b);
				}
			}
		}
	}
	
	
	/**
	 * Metodo di print della matrice (con relativi colori)
	 */
	public void showTable () {
		int i = this.nI;
		int j = this.nJ;
		System.out.print(" \t");
		for (int k = 0; k < j; k++) {
			System.out.print(k+1 + "\t");
		}
		System.out.println("\n");
		
		for(int y = 0; y < i; y++) {
			System.out.print(y+1 + "\t");
			for (int x = 0; x < j; x++) {
				if(boxExistAndIsFillable(y, x) && this.m[y][x].isFull()) {
					switch(this.m[y][x].getTile().getColor()) {
					case 1:
						System.out.print(textGreen+"G\t"+resetTextColor); //G=verde
						break;
					case 2:
						System.out.print(textWhite+"W\t"+resetTextColor); //W=bianco
						break;
					case 3:
						System.out.print(textYellow+"Y\t"+resetTextColor); //Y=giallo
						break;
					case 4:
						System.out.print(textBlue+"B\t"+resetTextColor); //B=blu
						break;
					case 5:
						System.out.print(textCyan+"C\t"+resetTextColor); //C=azzurro
						break;
					case 6:
						System.out.print(textPink+"P\t"+resetTextColor); //P=rosa
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
	
	
	/**
	 * Metodo pubblico per la gestione delle eccezioni in input, stampa la String passata in param
	 * @param r
	 * @return
	 */
	public static int getIntData(String r) {
		Scanner sc = new Scanner(System.in);
		int s = 0;
		boolean retry;
		do {
			retry = false;
			try {
				System.out.print(r);
				s = sc.nextInt();
			
			}catch(InputMismatchException c){
				System.err.println("Devi inserire un NUMERO intero.");
				retry = true;
			}catch(Exception c){
				System.err.println("Errore di inserimento: Devi inserire un NUMERO INTERO");
				retry = true;
			}
			sc.nextLine();
			
		}while(retry);
		
		return s;
	}
	
	/*
	 * Metodo che verifica se la colonna della shelf in cui si vogliono inserire le tiles prese puo' contenere tutte le tiles
	 */
	public boolean eligibleColumn (Tile [] tiles, int column) {
		int freeSpaces=0;
		int compare=0;
		for (int n=0; n<tiles.length; n++) {
			if(tiles[n] != null) {
				compare++;
			   //System.out.println("Vettore: " + compare);
			}	
		}
		for (int i = 0; i < this.getNI(); i++){
			//System.out.println(this.m[i][column].isFull());
			if (!this.m[i][column].isFull()) {
				freeSpaces++;
				//System.out.println("Colonna: " + freeSpaces);
			}
		}
		if(freeSpaces >= compare)
			return true;
		else
			return false;	
	}
}
