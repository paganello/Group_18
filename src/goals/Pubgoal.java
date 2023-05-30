package goals;
import structure.*;


public class Pubgoal {
	private int[] nGoals;
	private boolean[] done;
	private boolean[] goalPointsJustAssigned;
	private int points;
	static int[] scoreTilesGoal1 = {8,6,6,4,4,2,2,2,2}; //array delle tessere che assegnano i punti
	static int[] scoreTilesGoal2 = {8,6,6,4,4,2,2,2,2};	//array delle tessere che assegnano i punti
	
	/*
	 *COSTRUTTORE 
	 */
	public Pubgoal(int a, int b){
		
		this.nGoals = new int[2];
		
		this.done = new boolean[2];
		this.done[0] = false;	 // init a false
		this.done[1] = false;
		this.goalPointsJustAssigned = new boolean[2];
		this.goalPointsJustAssigned[0] = false;	 // init a false
		this.goalPointsJustAssigned[1] = false;
		
		this.points = 0;
		
		this.nGoals[0] = a;
		this.nGoals[1] = b;
	}
	
	
	/*
	 * Override metodo toString per lo stamp dei goal number
	 */
	public String toString(){	//Sovrascrive il metodo toString di java
		return ("Goal 1 = " + nGoals[0]+1 + "/nGoal 2 = " + nGoals[1]+1);
	}
	
	
	/*
	 * Getter di points
	 * */
	public int getpoints() {
		return points;
	}
	
	
	/*
	 * Getter di done
	 * */
	public boolean[] isDone() {
		return done;
	}
	
	
	/*
	 * Metodo che ritorna l'array dei goals
	 */
	public int[] getGoalsNumber() {
		
		int[] tmp = new int[2];
		tmp[0] = this.nGoals[0];
		tmp[1] = this.nGoals[1];
		return tmp;
	}
	
	
	/*
	 * Metodo che esegue la verifica se un goal è stato completato con successo, verrà chiamato due volte, una per ogni goal da verificare
	 * Ritorna true se è stato completato altrimenti false.
	 * nGoal è l'obbiettivo pubblico da verificare, playerShelf è la board del player che eventualmente riceve i punti in palio
	 */
	public void verify(BoxMatrix playerShelf) {
		
		for (int i = 0; i < 2; i++) {
			if(!this.done[i]) {
				
				switch (this.nGoals[i]) {
					case 0:		//verificato
						if(isPubGoal_1_Done(playerShelf)) {
							System.out.println("Goal " + (this.nGoals[i]+1) + " verificato");
							this.done[i] = true;
						}else {
							this.done[i] = false;
							System.out.println("Goal " + (this.nGoals[i]+1) + " non verificato");
						}
						break;
				
					case 1:		//verificato
						if(isPubGoal_2_Done(playerShelf)) {
							System.out.println("Goal " + (this.nGoals[i]+1) + " verificato");
							this.done[i] = true;
						}else {
							this.done[i] = false;
							System.out.println("Goal " + (this.nGoals[i]+1) + " non verificato");
						}
						break;
				
					case 2:		//verificato
						if(isPubGoal_3_Done(playerShelf)) {
							System.out.println("Goal " + (this.nGoals[i]+1) + " verificato");
							this.done[i] = true;
						}else {
							this.done[i] = false;
							System.out.println("Goal " + (this.nGoals[i]+1) + " non verificato");
						}
						break;
				
					case 3:		//verificato
						if(isPubGoal_4_Done(playerShelf)) {
							System.out.println("Goal " + (this.nGoals[i]+1) + " verificato");
							this.done[i] = true;
						}else {
							this.done[i] = false;
							System.out.println("Goal " + (this.nGoals[i]+1) + " non verificato");
						}
						break;
				
					case 4:		//verificato
						if(isPubGoal_5_Done(playerShelf)) {
							System.out.println("Goal " + (this.nGoals[i]+1) + " verificato");
							this.done[i] = true;
						}else {
							this.done[i] = false;
							System.out.println("Goal " + (this.nGoals[i]+1) + " non verificato");
						}
						break;
				
					case 5:		//verificato
						if(isPubGoal_6_Done(playerShelf)) {
							System.out.println("Goal " + (this.nGoals[i]+1) + " verificato");
							this.done[i] = true;
						}else {
							this.done[i] = false;
							System.out.println("Goal " + (this.nGoals[i]+1) + " non verificato");
						}
						break;
				
					case 6:		//verificato
						if(isPubGoal_7_Done(playerShelf)) {
							System.out.println("Goal " + (this.nGoals[i]+1) + " verificato");
							this.done[i] = true;
						}else {
							this.done[i] = false;
							System.out.println("Goal " + (this.nGoals[i]+1) + " non verificato");
						}	
						break;
				
					case 7:
						if(isPubGoal_8_Done(playerShelf)) {
							System.out.println("Goal " + (this.nGoals[i]+1) + " verificato");
							this.done[i] = true;
						}else {
							this.done[i] = false;
							System.out.println("Goal " + (this.nGoals[i]+1) + " non verificato");
						}
						break;
				
					case 8:
						if(isPubGoal_9_Done(playerShelf)) {
							System.out.println("Goal " + (this.nGoals[i]+1) + " verificato");
							this.done[i] = true;
						}else {
							this.done[i] = false;
							System.out.println("Goal " + (this.nGoals[i]+1) + " non verificato");
						}
						break;
				
					case 9:		//verificato
						if(isPubGoal_10_Done(playerShelf)) {
							System.out.println("Goal " + (this.nGoals[i]+1) + " verificato");
							this.done[i] = true;
						}else {
							this.done[i] = false;
							System.out.println("Goal " + (this.nGoals[i]+1) + " non verificato");
						}
						break;
				
					case 10:	//verificato
						if(isPubGoal_11_Done(playerShelf)) {
							System.out.println("Goal " + (this.nGoals[i]+1) + " verificato");
							this.done[i] = true;
						}else {
							this.done[i] = false;
							System.out.println("Goal " + (this.nGoals[i]+1) + " non verificato");
						}
						break;
				
					case 11:	//
						if(isPubGoal_12_Done(playerShelf)) {
							System.out.println("Goal " + (this.nGoals[i]+1) + " verificato");
							this.done[i] = true;
						}else {
							this.done[i] = false;
							System.out.println("Goal " + (this.nGoals[i]+1) + " non verificato");
						}
						break;
					
					default:
						this.done[i] = false;
						break;
				}//ogni case contiene il metodo per verificare il goal in questione, è qui che viene scritto
			// il grosso dell'algoritmo per verificare i goal publici.
			}		
		}	
	}
	
	//METEODO DI DEBUG DEI GOALS
	public void verify(BoxMatrix playerShelf, int[] c) {
		
		for (int i = 0; i < 2; i++) {
			switch (c[i]) {
				case 0:		//verificato
					if(isPubGoal_1_Done(playerShelf)) {
						System.out.println("Goal " + (c[i]+1) + " verificato");
						this.done[i] = true;
					}else {
						this.done[i] = false;
						System.out.println("Goal " + (c[i]+1) + " non verificato");
					}
					break;
				
				case 1:		//verificato
					if(isPubGoal_2_Done(playerShelf)) {
						System.out.println("Goal " + (c[i]+1) + " verificato");
						this.done[i] = true;
					}else {
						this.done[i] = false;
						System.out.println("Goal " + (c[i]+1) + " non verificato");
					}
					break;
				
				case 2:
					if(isPubGoal_3_Done(playerShelf)) {
						System.out.println("Goal " + (c[i]+1) + " verificato");
						this.done[i] = true;
					}else {
						this.done[i] = false;
						System.out.println("Goal " + (c[i]+1) + " non verificato");
					}
					break;
				
				case 3:
					if(isPubGoal_4_Done(playerShelf)) {
						System.out.println("Goal " + (c[i]+1) + " verificato");
						this.done[i] = true;
					}else {
						this.done[i] = false;
						System.out.println("Goal " + (c[i]+1) + " non verificato");
					}
					break;
				
				case 4:
					if(isPubGoal_5_Done(playerShelf)) {
						System.out.println("Goal " + (c[i]+1) + " verificato");
						this.done[i] = true;
					}else {
						this.done[i] = false;
						System.out.println("Goal " + (c[i]+1) + " non verificato");
					}
					break;
				
				case 5:
					if(isPubGoal_6_Done(playerShelf)) {
						System.out.println("Goal " + (c[i]+1) + " verificato");
						this.done[i] = true;
					}else {
						this.done[i] = false;
						System.out.println("Goal " + (c[i]+1) + " non verificato");
					}
					break;
				
				case 6:
					if(isPubGoal_7_Done(playerShelf)) {
						System.out.println("Goal " + (c[i]+1) + " verificato");
						this.done[i] = true;
					}else {
						this.done[i] = false;
						System.out.println("Goal " + (c[i]+1) + " non verificato");
					}
					break;
				
				case 7:
					if(isPubGoal_8_Done(playerShelf)) {
						System.out.println("Goal " + (c[i]+1) + " verificato");
						this.done[i] = true;
					}else {
						this.done[i] = false;
						System.out.println("Goal " + (c[i]+1) + " non verificato");
					}
					break;
				
				case 8:
					if(isPubGoal_9_Done(playerShelf)) {
						System.out.println("Goal " + (c[i]+1) + " verificato");
						this.done[i] = true;
					}else {
						this.done[i] = false;
						System.out.println("Goal " + (c[i]+1) + " non verificato");
					}
					break;
				
				case 9:
					if(isPubGoal_10_Done(playerShelf)) {
						System.out.println("Goal " + (c[i]+1) + " verificato");
						this.done[i] = true;
					}else {
						this.done[i] = false;
						System.out.println("Goal " + (c[i]+1) + " non verificato");
					}
					break;
				
				case 10:
					if(isPubGoal_11_Done(playerShelf)) {
						System.out.println("Goal " + (c[i]+1) + " verificato");
						this.done[i] = true;
					}else {
						this.done[i] = false;
						System.out.println("Goal " + (c[i]+1) + " non verificato");
					}
					break;
				
				case 11:
					if(isPubGoal_12_Done(playerShelf)) {
						System.out.println("Goal " + (c[i]+1) + " verificato");
						this.done[i] = true;
					}else {
						this.done[i] = false;
						System.out.println("Goal " + (c[i]+1) + " non verificato");
					}
					break;
					
				default:
					this.done[i] = false;
					break;
			}//ogni case contiene il metodo per verificare il goal in questione, è qui che viene scritto
			// il grosso dell'algoritmo per verificare i goal publici.
		}		
	}
	
	
	/*
	 * Metodo di asseganzione dei punti (viene aggiornato l'attributo "points") in base al raggiungimento dei singoli goals pubblici.
	 * */
	public void computePoints() {
		for (int i = 0; i < 2; i++) {
			if(done[i] && !goalPointsJustAssigned[i]) {
				if(i == 0) {
					int j = 0;
					while(scoreTilesGoal1[j] == 0) {
						if(j >= 8) {
							break;
						}
						j++;
					}
					
					if(scoreTilesGoal1[j] != 0) {
						this.points = this.points + scoreTilesGoal1[j];
						scoreTilesGoal1[j] = 0;
						goalPointsJustAssigned[i] = true;
					}else {
						System.out.println("Tessere punteggio terminate!");
					}
					
				}else if(i == 1) {
					int j = 0;
					while(scoreTilesGoal2[j] == 0) {
						if(j >= 8) {
							break;
						}
						j++;
					}
					
					if(scoreTilesGoal2[j] != 0) {
						this.points = this.points + scoreTilesGoal2[j];
						scoreTilesGoal2[j] = 0;
						goalPointsJustAssigned[i] = true;
					}else {
						System.out.println("Tessere punteggio terminate!");
					}
				}
			}
		}		
	}
	
	
	/*
	 * METODI DI VERIFICA DEI SINGOLI GOALS, SONO PRIVATI E VENGONO RICHIAMATI IN verify.
	 * 
	 * ritornano true o false.
	 * */
	private boolean isPubGoal_1_Done(BoxMatrix playerShelf){
		
		int n = 0; 
		
		for (int i = 0; i < playerShelf.getNI(); i++) {
			for (int j = 0; j < playerShelf.getNJ(); j++) {
				//System.out.print("I = " + i + "  J = " + j + "  ");
				if(playerShelf.getBox(i, j).isFull() && !playerShelf.getBox(i, j).getTile().isVerified()) {
					
					int k = 0;
					for (int l = 0; l < 4; l++) {
						int a = 0;
						k = k + playerShelf.countNumberOfAdjacentsTilesWithSameColor(i, j, a);
					}
					k = k + 1;
					//System.out.println("K = " + k);
					if(k == 2 ) {
						n++;
					}
				}
			}
		}
		playerShelf.setAllVerifiedTileAttribute(false);
		//System.out.println(n);
		if(n == 6) {
			return true;
		}
		return false;
	}

	private boolean isPubGoal_2_Done(BoxMatrix playerShelf){
	
		if(playerShelf.getBox(0, 0).isFull() && playerShelf.getBox(0, 4).isFull() && playerShelf.getBox(0, 0).getTile().getColor() == playerShelf.getBox(0, 4).getTile().getColor()) {
			if(playerShelf.getBox(5, 4).isFull() && playerShelf.getBox(0, 4).getTile().getColor() == playerShelf.getBox(5, 4).getTile().getColor()) {
				if(playerShelf.getBox(5, 0).isFull() && playerShelf.getBox(5, 4).getTile().getColor() == playerShelf.getBox(5, 0).getTile().getColor()) {
					return true;
				}
			}
		}
		return false;
	}
	

	private boolean isPubGoal_3_Done(BoxMatrix playerShelf){
		/*
		 * Quattro gruppi separati formati ciascuno da quattro tessere adiacenti dello stesso tipo
		 * quindi per ogni tessera verificare che ne abbia almeno 1 adicente dello steso tipo e passare a quella dopo, raggiunte le 4 adiacenti passare
		 * a quelle dopo
		 * quindi devo scorrere tutta la shelf, parto dalla prima tessera e guardo se ne ha una adiacente se ce l'ha passo a quella e vado avanti così fino a 4
		 * poi devo scartare quelle appena conteggiate e passare alla tessera dopo, fare la stessa cosa fatta in precedenza e scartare quelle conteggiare e cosi via
		 * se riesco a trovarne 4 per 4 volte allora torna vero 
		 */
		
		int n = 0; 
		for (int i = 0; i < playerShelf.getNI(); i++) {
			for (int j = 0; j < playerShelf.getNJ(); j++) {
				//System.out.print("I = " + i + "  J = " + j + "  ");
				if(playerShelf.getBox(i, j).isFull() && !playerShelf.getBox(i, j).getTile().isVerified()) {
					
					int k = 0;
					for (int l = 0; l < 4; l++) {
						int a = 0;
						k = k + playerShelf.countNumberOfAdjacentsTilesWithSameColor(i, j, a);
					}
					k = k + 1;
					//System.out.println("K = " + k);
					if(k == 4 ) {
						if(playerShelf.getBox(i, j).isFull() && playerShelf.boxExistAndIsFillable(i+1, j) && playerShelf.getBox(i+1, j).isFull() && playerShelf.getBox(i, j).getTile().getColor() == playerShelf.getBox(i+1, j).getTile().getColor()) {
							if(playerShelf.boxExistAndIsFillable(i+2, j) && playerShelf.getBox(i+2, j).isFull() && playerShelf.getBox(i, j).getTile().getColor() == playerShelf.getBox(i+2, j).getTile().getColor()) {
								if(playerShelf.boxExistAndIsFillable(i+3, j) && playerShelf.getBox(i+3, j).isFull() && playerShelf.getBox(i, j).getTile().getColor() == playerShelf.getBox(i+3, j).getTile().getColor()) {
									n++;
								}
							}
						}
						if(playerShelf.getBox(i, j).isFull() && playerShelf.boxExistAndIsFillable(i, j+1) && playerShelf.getBox(i, j+1).isFull() && playerShelf.getBox(i, j).getTile().getColor() == playerShelf.getBox(i, j+1).getTile().getColor()) {
							if(playerShelf.boxExistAndIsFillable(i, j+2) && playerShelf.getBox(i, j+2).isFull() && playerShelf.getBox(i, j).getTile().getColor() == playerShelf.getBox(i, j+2).getTile().getColor()) {
								if(playerShelf.boxExistAndIsFillable(i, j+3) && playerShelf.getBox(i, j+3).isFull() && playerShelf.getBox(i, j).getTile().getColor() == playerShelf.getBox(i, j+3).getTile().getColor()) {
									n++;
								}
							}
						}
					}
					//System.out.println("N = " + n);
				}
			}
		}
		playerShelf.setAllVerifiedTileAttribute(false);
		//System.out.println(n);
		if(n == 4) {
			return true;
		}
		return false;
	}
	
	private boolean isPubGoal_4_Done(BoxMatrix playerShelf){
		/*
		 * Due gruppi separati di 4 tessere dello stesso tipo che formano un quadrato 2x2.
		 * Le tessere dei due gruppi devono essere dello stesso tipo.
		 * quindi posso fare una verifica per tipo, quindi passo il primo tipo, scorro tutta la shelf, verifico il tipo e che ne ha 3 adiacenti (per formare un quadrato...)
		 * scarto quelle trovate e faccio la stessa cosa per lo stesso tipo, se ne trovo 2 allora passo al tipo successivo 
		 */
		
		int n = 0; 
		int tmpColorMem = 0;
		
		for (int i = 0; i < playerShelf.getNI(); i++) {
			for (int j = 0; j < playerShelf.getNJ(); j++) {
				//System.out.print("I = " + i + "  J = " + j + "  ");
				if(playerShelf.getBox(i, j).isFull() && !playerShelf.getBox(i, j).getTile().isVerified()) {
					
					int k = 0;
					for (int l = 0; l < 4; l++) {
						int a = 0;
						k = k + playerShelf.countNumberOfAdjacentsTilesWithSameColor(i, j, a);
					}
					k = k + 1;
					//System.out.println("K = " + k);
					if(k == 4 ) {
						if(playerShelf.getBox(i, j).isFull() && playerShelf.boxExistAndIsFillable(i, j+1) && playerShelf.getBox(i, j+1).isFull() && playerShelf.getBox(i, j).getTile().getColor() == playerShelf.getBox(i, j+1).getTile().getColor() && tmpColorMem == playerShelf.getBox(i, j).getTile().getColor()) {
							if(playerShelf.boxExistAndIsFillable(i+1, j) && playerShelf.getBox(i+1, j).isFull() && playerShelf.getBox(i, j).getTile().getColor() == playerShelf.getBox(i+1, j).getTile().getColor()) {
								if(playerShelf.boxExistAndIsFillable(i+1, j+1) && playerShelf.getBox(i+1, j+1).isFull() && playerShelf.getBox(i, j).getTile().getColor() == playerShelf.getBox(i+1, j+1).getTile().getColor()) {
									n++;
								}
							}
						}
						
						if(tmpColorMem == 0 && playerShelf.getBox(i, j).isFull() && playerShelf.boxExistAndIsFillable(i, j+1) && playerShelf.getBox(i, j+1).isFull() && playerShelf.getBox(i, j).getTile().getColor() == playerShelf.getBox(i, j+1).getTile().getColor()) {
							if(playerShelf.boxExistAndIsFillable(i+1, j) && playerShelf.getBox(i+1, j).isFull() && playerShelf.getBox(i, j).getTile().getColor() == playerShelf.getBox(i+1, j).getTile().getColor()) {
								if(playerShelf.boxExistAndIsFillable(i+1, j+1) && playerShelf.getBox(i+1, j+1).isFull() && playerShelf.getBox(i, j).getTile().getColor() == playerShelf.getBox(i+1, j+1).getTile().getColor()) {
									n++;
									tmpColorMem = playerShelf.getBox(i, j).getTile().getColor();
								}
							}
						}
						//System.out.println("N = " + n);
					}
				}
			}
		}
		playerShelf.setAllVerifiedTileAttribute(false);
		//System.out.println(n);
		if(n == 2) {
			return true;
		}
		return false;
	}
	
	
	private boolean isPubGoal_5_Done(BoxMatrix playerShelf) {	//da sistemare

		int col_counter = 0;
		int[] col_colors = new int[3];
		
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < col_colors.length; i++) {
				col_colors[i] = 0;
			}
			
			for (int i = 0; i < 6; i++) {
				System.out.println(col_colors[0] + " " + col_colors[1] + " " + col_colors[2]);
				if(playerShelf.getBox(i, j).isFull()) {
					if(col_colors[0] == 0) {
						col_colors[0] = playerShelf.getBox(i, j).getTile().getColor();
						
					}else if(col_colors[1] == 0) {
						col_colors[1] = playerShelf.getBox(i, j).getTile().getColor();
						
					}else if(col_colors[2] == 0) {
						col_colors[2] = playerShelf.getBox(i, j).getTile().getColor();
						
					}else {
						
						if(col_colors[0] != 0 && col_colors[1] != 0 && col_colors[2] != 0) {	
							if(col_colors[0] != playerShelf.getBox(i, j).getTile().getColor() && col_colors[1] != playerShelf.getBox(i, j).getTile().getColor() && col_colors[2] != playerShelf.getBox(i, j).getTile().getColor()) {
								
								if(col_colors[0] != 0 && col_colors[1] != 0 && col_colors[0] == col_colors[1]) {
									col_colors[0] = playerShelf.getBox(i, j).getTile().getColor();
									if(col_colors[0] != playerShelf.getBox(i, j).getTile().getColor() && col_colors[1] != playerShelf.getBox(i, j).getTile().getColor() && col_colors[2] != playerShelf.getBox(i, j).getTile().getColor()) {
										break;
									}else {
										if(i == 5) {
											col_counter++;
											System.out.println("CC = " + col_counter);
										}
									}
								}else if(col_colors[1] != 0 && col_colors[2] != 0 && col_colors[1] == col_colors[2]) {
									col_colors[1] = playerShelf.getBox(i, j).getTile().getColor();
									if(col_colors[0] != playerShelf.getBox(i, j).getTile().getColor() && col_colors[1] != playerShelf.getBox(i, j).getTile().getColor() && col_colors[2] != playerShelf.getBox(i, j).getTile().getColor()) {
										break;
									}else {
										if(i == 5) {
											col_counter++;
											System.out.println("CC = " + col_counter);
										}
									}
									
								}else if(col_colors[0] != 0 && col_colors[2] != 0 && col_colors[0] == col_colors[2]) {
									col_colors[2] = playerShelf.getBox(i, j).getTile().getColor();
									if(col_colors[0] != playerShelf.getBox(i, j).getTile().getColor() && col_colors[1] != playerShelf.getBox(i, j).getTile().getColor() && col_colors[2] != playerShelf.getBox(i, j).getTile().getColor()) {
										break;
									}else {
										if(i == 5) {
											col_counter++;
											System.out.println("CC = " + col_counter);
										}
									}
								}else{
									if(col_colors[0] != playerShelf.getBox(i, j).getTile().getColor() && col_colors[1] != playerShelf.getBox(i, j).getTile().getColor() && col_colors[2] != playerShelf.getBox(i, j).getTile().getColor()) {
										break;
									}else {
										if(i == 5) {
											col_counter++;
											System.out.println("CC = " + col_counter);
										}
									}
								}
							}else {
								if(i == 5) {
									col_counter++;
									System.out.println("CC = " + col_counter);
								}
							}
						}
					}
				}else {
					break;
				}
			}
			
		}
		
		if (col_counter <= 3) {
			return true;
		}
		return false; 
	}

	
	private boolean isPubGoal_6_Done(BoxMatrix playerShelf) {
		
		int counter=0;
		int c=1;
		
		for (int m=0; m<6;m++) {
			for(int n=0; n<5; n++) {
				if(playerShelf.getBox(m, n).isFull() && playerShelf.getBox(m, n).getTile().getColor() == c) {
					counter++;
				}
			}
		}
			
		if (counter == 8) {
				return true;
			}
				
		else if(counter < 8 && c < 7) {
				counter=0;
				c++;
			}
		
		return false;
	}

	
	private boolean isPubGoal_7_Done(BoxMatrix playerShelf) {
	    if (playerShelf.getBox(0, 0).isFull() && playerShelf.getBox(1, 1).isFull() && playerShelf.getBox(2, 2).isFull()
	    		&& playerShelf.getBox(3, 3).isFull() && playerShelf.getBox(4, 4).isFull()) {
	    	if(playerShelf.getBox(0, 0).getTile().getColor() == playerShelf.getBox(1, 1).getTile().getColor()
	    			&& playerShelf.getBox(0, 0).getTile().getColor() == playerShelf.getBox(2, 2).getTile().getColor()
	    			&& playerShelf.getBox(0, 0).getTile().getColor() == playerShelf.getBox(3, 3).getTile().getColor()
	    			&& playerShelf.getBox(0, 0).getTile().getColor() == playerShelf.getBox(4, 4).getTile().getColor()){
	    		return true;
	    	}
	    }
	    
	    if (playerShelf.getBox(1, 0).isFull() && playerShelf.getBox(2, 1).isFull() && playerShelf.getBox(3, 2).isFull()
	    		&& playerShelf.getBox(4, 3).isFull() && playerShelf.getBox(5, 4).isFull()) {
	    	if(playerShelf.getBox(1, 0).getTile().getColor() == playerShelf.getBox(2, 1).getTile().getColor()
	    			&& playerShelf.getBox(1, 0).getTile().getColor() == playerShelf.getBox(3, 2).getTile().getColor()
	    			&& playerShelf.getBox(1, 0).getTile().getColor() == playerShelf.getBox(4, 3).getTile().getColor()
	    			&& playerShelf.getBox(1, 0).getTile().getColor() == playerShelf.getBox(5, 4).getTile().getColor()){
	    		return true;
	    	}
	    }
	    
	    if (playerShelf.getBox(4, 0).isFull() && playerShelf.getBox(3, 1).isFull() && playerShelf.getBox(2, 2).isFull()
	    		&& playerShelf.getBox(1, 3).isFull() && playerShelf.getBox(0, 4).isFull()) {
	    	if(playerShelf.getBox(4, 0).getTile().getColor() == playerShelf.getBox(3, 1).getTile().getColor()
	    			&& playerShelf.getBox(4, 0).getTile().getColor() == playerShelf.getBox(2, 2).getTile().getColor()
	    			&& playerShelf.getBox(4, 0).getTile().getColor() == playerShelf.getBox(1, 3).getTile().getColor()
	    			&& playerShelf.getBox(4, 0).getTile().getColor() == playerShelf.getBox(0, 4).getTile().getColor()){
	    		return true;
	    	}
	    }
	    
	    if (playerShelf.getBox(1, 4).isFull() && playerShelf.getBox(2, 3).isFull() && playerShelf.getBox(3, 2).isFull()
	    		&& playerShelf.getBox(4, 1).isFull() && playerShelf.getBox(5, 0).isFull()) {
	    	if(playerShelf.getBox(1, 4).getTile().getColor() == playerShelf.getBox(2, 3).getTile().getColor()
	    			&& playerShelf.getBox(1, 4).getTile().getColor() == playerShelf.getBox(3, 2).getTile().getColor()
	    			&& playerShelf.getBox(1, 4).getTile().getColor() == playerShelf.getBox(4, 1).getTile().getColor()
	    			&& playerShelf.getBox(1, 4).getTile().getColor() == playerShelf.getBox(5, 0).getTile().getColor()){
	    		return true;
	    	}
	    }
	    
		return false;
	}
	
	private boolean isPubGoal_8_Done(BoxMatrix playerShelf) {
		
		int col_counter = 0;
		
		int[] col_colors = new int[3];
		
		for (int i = 0; i < 6; i++) {
			
			for (int j = 0; j < col_colors.length; j++) {
				col_colors[j] = 0;
			}
			
			for (int j = 0; j < 5; j++) {
				
				System.out.println(col_colors[0] + " " + col_colors[1] + " " + col_colors[2]);
				if(playerShelf.getBox(i, j).isFull()) {
					
					if(col_colors[0] == 0) {
						col_colors[0] = playerShelf.getBox(i, j).getTile().getColor();
						
					}else if(col_colors[1] == 0) {
						col_colors[1] = playerShelf.getBox(i, j).getTile().getColor();
						
					}else if(col_colors[2] == 0) {
						col_colors[2] = playerShelf.getBox(i, j).getTile().getColor();
						
					}else {
						
						if(col_colors[0] != 0 && col_colors[1] != 0 && col_colors[2] != 0) {	
							if(col_colors[0] != playerShelf.getBox(i, j).getTile().getColor() && col_colors[1] != playerShelf.getBox(i, j).getTile().getColor() && col_colors[2] != playerShelf.getBox(i, j).getTile().getColor()) {
								
								if(col_colors[0] != 0 && col_colors[1] != 0 && col_colors[0] == col_colors[1]) {
									col_colors[0] = playerShelf.getBox(i, j).getTile().getColor();
									if(col_colors[0] != playerShelf.getBox(i, j).getTile().getColor() && col_colors[1] != playerShelf.getBox(i, j).getTile().getColor() && col_colors[2] != playerShelf.getBox(i, j).getTile().getColor()) {
										break;
									}else {
										if(j == 4) {
											col_counter++;
											System.out.println("CC = " + col_counter);
										}
									}
								}else if(col_colors[1] != 0 && col_colors[2] != 0 && col_colors[1] == col_colors[2]) {
									col_colors[1] = playerShelf.getBox(i, j).getTile().getColor();
									if(col_colors[0] != playerShelf.getBox(i, j).getTile().getColor() && col_colors[1] != playerShelf.getBox(i, j).getTile().getColor() && col_colors[2] != playerShelf.getBox(i, j).getTile().getColor()) {
										break;
									}else {
										if(j == 4) {
											col_counter++;
											System.out.println("CC = " + col_counter);
										}
									}
								}else if(col_colors[0] != 0 && col_colors[2] != 0 && col_colors[0] == col_colors[2]) {
									col_colors[2] = playerShelf.getBox(i, j).getTile().getColor();
									if(col_colors[0] != playerShelf.getBox(i, j).getTile().getColor() && col_colors[1] != playerShelf.getBox(i, j).getTile().getColor() && col_colors[2] != playerShelf.getBox(i, j).getTile().getColor()) {
										break;
									}else {
										if(j == 4) {
											col_counter++;
											System.out.println("CC = " + col_counter);
										}
									}
								}else{
									if(col_colors[0] != playerShelf.getBox(i, j).getTile().getColor() && col_colors[1] != playerShelf.getBox(i, j).getTile().getColor() && col_colors[2] != playerShelf.getBox(i, j).getTile().getColor()) {
										break;
									}else {
										if(j == 4) {
											col_counter++;
											System.out.println("CC = " + col_counter);
										}
									}
								}
							}else {
								if(j == 4) {
									col_counter++;
									System.out.println("CC = " + col_counter);
								}
							}
						}
					}
				}else {
					break;
				}
			}
			
		}
		
		if (col_counter <= 3) {
			return true;
		}
		return false;
	}
	
	
	private boolean isPubGoal_9_Done (BoxMatrix playerShelf) {

		int conta = 0;
		int incremento = 0;
		int colonneDiverse = 0;
		for(int j=0;j<5;j++) {	
			for(int i=0;i<6;i++) {
				for(int k=0;k<6;k++) {
					if(playerShelf.getBox(i,j).getTile()!=null){
						if(!(playerShelf.getBox(i, j).getTile().getColor()==playerShelf.getBox(k, j).getTile().getColor())) {
							conta ++;
						}
					}
				}
				if(conta==5)
					incremento++;
				conta = 0;
			}
			if(incremento == 6) {
				colonneDiverse++;
				System.out.println("Gli elementi della colonna " + (j+1) + " sono tutti diversi" );
			}
			incremento = 0;
		}
		
		if(colonneDiverse >= 2) {
			System.out.println("Punti Guadagnati");
			return true;
		}
		
		return false;
	}

	private boolean isPubGoal_10_Done (BoxMatrix playerShelf) {

		
		int conta = 0;
		int incremento = 0;
		int righeDiverse = 0;
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 5; j++) {
				for(int k = 0; k < 5; k++) {
					if(playerShelf.getBox(i,j).getTile()!=null){
						if(!(playerShelf.getBox(i, j).getTile().getColor()==playerShelf.getBox(i, k).getTile().getColor())) {
							conta ++;
							//System.out.println("inLine: "+conta);
						}
					}
				}
				//System.out.println("outLine: "+conta);
				if(conta==4)
					incremento++;
					//System.out.println("INC: "+incremento);
				conta = 0;
			}
			if(incremento == 5) {
				righeDiverse++;
				System.out.println("Gli elementi della riga " + (i+1) + " sono tutti diversi");
			}
			incremento = 0;
		}
		
		if(righeDiverse >= 2) {
			System.out.println("Punti Guadagnati");
			return true;
		}
		
		return false;
	}
	
	
	/*
	 * Metodo per la verifica del Common Goal nr.11
	 * Scorre la Shelf personale del giocatore e conrolla se ci sono 5 Tiles
	 * dello stesso colore che formano una "X"
	 */
	private boolean isPubGoal_11_Done (BoxMatrix playerShelf) {
		for (int i = 1; i < (playerShelf.getNI()-1); i++) {
			for (int j = 1; j < (playerShelf.getNJ()-1); j++) {
				if(playerShelf.getBox(i, j).isFull() 
						&& playerShelf.getBox((i+1), (j+1)).isFull() 
						&& playerShelf.getBox((i-1), (j-1)).isFull() 
						&& playerShelf.getBox((i+1), (j-1)).isFull()
						&& playerShelf.getBox((i-1), (j+1)).isFull()) {
					if (playerShelf.getBox(i, j).getTile().getColor() == playerShelf.getBox((i+1), (j+1)).getTile().getColor()
							&& playerShelf.getBox(i, j).getTile().getColor() == playerShelf.getBox((i-1), (j-1)).getTile().getColor()
						    && playerShelf.getBox(i, j).getTile().getColor() == playerShelf.getBox((i+1), (j-1)).getTile().getColor()
						    && playerShelf.getBox(i, j).getTile().getColor() == playerShelf.getBox((i-1), (j+1)).getTile().getColor()) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/*
	 * Metodo per la verifica del Common Goal nr.12
	 * Verifica che le colonne della Shelf di un Player abbiano altezza crescente (da 1 a 5)
	 * o decrescente (da 5 a 1) da sinistra verso destra
	 */
	private boolean isPubGoal_12_Done (BoxMatrix playerShelf) {
		final int maxTiles=6;
		int count, m, n;
		boolean verify=false;
		
		//Altezza delle colonne decrescente da sinistra verso destra
		for (m=0; m<4; m++) {
			count=0;
			for (n=0; n<6; n++) {
				if (playerShelf.getBox(n, m).isFull())
					count++;
			}
			if ((maxTiles-count)== (m+1))
				verify=true;
			else
				verify=false;			
		}
		if(verify)
			return true;
		
		//Altezza delle colonne crescente da sinistra verso destra
		for (m=0; m<4; m++) {
			count=0;
			for (n=0; n<6; n++) {
				if (playerShelf.getBox(n, m).isFull())
					count++;
			}
			if ((maxTiles-count)==(5-m))
				verify=true;
			else
				verify=false;			
		}
		if (verify)
			return true;
		
		return false;
	}
}


