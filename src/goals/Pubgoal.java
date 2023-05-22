package goals;
import structure.*;


public class Pubgoal {
	private int[] nGoals;
	private boolean[] done;
	private int points;
	static int[] scoreTiles = {8,6,6,4,4,2,2,2,2}; //array delle tessere che assegnano i punti
	
	
	/*
	 *COSTRUTTORE 
	 */
	public Pubgoal(int a, int b){
		
		this.nGoals = new int[2];
		
		this.done = new boolean[2];
		this.done[0] = false;	 // init a false
		this.done[1] = false;
		
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
			switch (this.nGoals[i]) {
				case 0:
					if(isPubGoal_1_Done(playerShelf)) {
						this.done[i] = true;
					}
					this.done[i] = false;
				
				case 1:
					if(isPubGoal_2_Done(playerShelf)) {
						this.done[i] = true;
					}
					this.done[i] = false;
				
				case 2:
					if(isPubGoal_3_Done(playerShelf)) {
						this.done[i] = true;
					}
					this.done[i] = false;
				
				case 3:
					if(isPubGoal_4_Done(playerShelf)) {
						this.done[i] = true;
					}
					this.done[i] = false;
				
				case 4:
				
					this.done[i] = false;
				
				case 5:
					if(isPubGoal_6_Done(playerShelf)) {
						this.done[i] = true;
					}
					this.done[i] = false;
				
				case 6:
					if(isPubGoal_7_Done(playerShelf)) {
						this.done[i] = true;
					}
					this.done[i] = false;
				
				case 7:
				
					this.done[i] = false;
				
				case 8:
				
					this.done[i] = false;
				
				case 9:
				
					this.done[i] = false;
				
				case 10:
					if(isPubGoal_11_Done(playerShelf)) {
						this.done[i] = true;
					}					
					this.done[i] = false;
					break;
				
				case 11:
					if(isPubGoal_12_Done(playerShelf)) {
						this.done[i] = true;
					}					
					this.done[i] = false;
					break;
				default:
					this.done[i] = false;
			}//ogni case contiene il metodo per verificare il goal in questione, è qui che viene scritto
			// il grosso dell'algoritmo per verificare i goal publici.
		}		
	}
	
	
	/*
	 * Metodo di asseganzione dei punti (viene aggiornato l'attributo "points") in base al raggiungimento dei singoli goals pubblici.
	 * */
	public void computePoints() {
		for (int i = 0; i < 2; i++) {
			if(done[i]) {
				int j = 0;
				while(scoreTiles[j] == 0) {
					j++;
				}
				
				if(scoreTiles[j] != 0) {
					this.points = this.points + scoreTiles[j];
					scoreTiles[j] = 0;
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
			for (int j = 0; j < playerShelf.getNI(); j++) {
				if(playerShelf.getBox(i, j).isFull() && !playerShelf.getBox(i, j).getTile().isVerified()) {
					int k = 0;
					k = playerShelf.countNumberOfAdjacentsTilesWithSameColor(i, j, k);
					
					if(k == 2 ) {
						n++;
					}
				}
			}
		}
		playerShelf.setAllVerifiedTileAttribute(false);
		if(n == 6) {
			return true;
		}
		return false;
	}

	private boolean isPubGoal_2_Done(BoxMatrix playerShelf){
	
		if(playerShelf.getBox(0, 0).getTile().getColor() == playerShelf.getBox(0, 4).getTile().getColor()) {
			if(playerShelf.getBox(0, 4).getTile().getColor() == playerShelf.getBox(5, 4).getTile().getColor()) {
				if(playerShelf.getBox(5, 4).getTile().getColor() == playerShelf.getBox(5, 0).getTile().getColor()) {
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
			for (int j = 0; j < playerShelf.getNI(); j++) {
				if(playerShelf.getBox(i, j).isFull() && !playerShelf.getBox(i, j).getTile().isVerified()) {
					int k = 0;
					k = playerShelf.countNumberOfAdjacentsTilesWithSameColor(i, j, k);
					
					if(k == 4 ) {
						n++;
					}
				}
			}
		}
		playerShelf.setAllVerifiedTileAttribute(false);
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
		int color = 1;
		
		for (int i = 0; i < playerShelf.getNI(); i++) {
			for (int j = 0; j < playerShelf.getNI(); j++) {
				if(playerShelf.getBox(i, j).isFull() && !playerShelf.getBox(i, j).getTile().isVerified() && playerShelf.getBox(i, j).getTile().getColor() == color && color <= 6) {
					
					boolean f = false;
					
					if (color == playerShelf.getBox(i, j + 1).getTile().getColor() && color == playerShelf.getBox(i + 1, j).getTile().getColor() && color == playerShelf.getBox(i + 1, j + 1).getTile().getColor()) {
						playerShelf.getBox(i, j + 1).getTile().setVerified(true);
						playerShelf.getBox(i + 1, j).getTile().setVerified(true);
						playerShelf.getBox(i + 1, j + 1).getTile().setVerified(true);
						f = true;
					}
					else if (color == playerShelf.getBox(i, j + 1).getTile().getColor() && color == playerShelf.getBox(i - 1, j).getTile().getColor() && color == playerShelf.getBox(i - 1, j + 1).getTile().getColor()) {
						playerShelf.getBox(i, j + 1).getTile().setVerified(true);
						playerShelf.getBox(i - 1, j).getTile().setVerified(true);
						playerShelf.getBox(i - 1, j + 1).getTile().setVerified(true);
						f = true;
					}
					else if (color == playerShelf.getBox(i, j - 1).getTile().getColor() && color == playerShelf.getBox(i - 1, j).getTile().getColor() && color == playerShelf.getBox(i - 1, j - 1).getTile().getColor()) {
						playerShelf.getBox(i, j - 1).getTile().setVerified(true);
						playerShelf.getBox(i - 1, j).getTile().setVerified(true);
						playerShelf.getBox(i - 1, j - 1).getTile().setVerified(true);
						f = true;
					}
					else if (color == playerShelf.getBox(i, j - 1).getTile().getColor() && color == playerShelf.getBox(i + 1, j).getTile().getColor() && color == playerShelf.getBox(i + 1, j - 1).getTile().getColor()) {
						playerShelf.getBox(i, j - 1).getTile().setVerified(true);
						playerShelf.getBox(i + 1, j).getTile().setVerified(true);
						playerShelf.getBox(i + 1, j - 1).getTile().setVerified(true);
						f = true;
					}
					
					if(f == true ) {
						n++;
					}
					else {
						color++;
						n = 0;
					}
				}
			}
		}
		playerShelf.setAllVerifiedTileAttribute(false);
		if(n == 2) {
			return true;
		}
		return false;
	}

	
	private boolean isPubGoal_6_Done(BoxMatrix playerShelf) {
		int counter=0;
		int c=1;
		int verifier=1;
			while(c < 7) {
				for (int m=0; m<6;m++) {
					for(int n=0; n<5; n++) {
						if(playerShelf.getBox(m, n).getTile().getColor() == c) {
							counter++;
						}
					}
				}
				if (counter>6) {
					verifier=0;
				}
				else if(counter<7 && c<7) {
					counter=0;
					c++;
				}
				else if(counter<7 && c>6) {
					verifier= verifier*1;
				}
			};
			
		if (verifier== 0) {
			return true;
		}
		else {
			return false;
		}
	}

	
	private boolean isPubGoal_7_Done(BoxMatrix playerShelf) {
		int verifier=1;
		int c=0;
			while(c<2) {
				if(playerShelf.getBox(1, 1+c).getTile().getColor() == playerShelf.getBox(2, 2+c).getTile().getColor())
					if(playerShelf.getBox(2, 2+c).getTile().getColor() == playerShelf.getBox(3, 3+c).getTile().getColor())
						if(playerShelf.getBox(3, 3+c).getTile().getColor() == playerShelf.getBox(4, 4+c).getTile().getColor())
							if(playerShelf.getBox(4, 4+c).getTile().getColor() == playerShelf.getBox(5, 5+c).getTile().getColor()) {
									verifier=0;
								}
								else {
									verifier=verifier*1;
								}
				
			if(playerShelf.getBox(1, 6-c).getTile().getColor() == playerShelf.getBox(2, 5-c).getTile().getColor())
				if(playerShelf.getBox(2, 5-c).getTile().getColor() == playerShelf.getBox(3, 4-c).getTile().getColor())
					if(playerShelf.getBox(3, 4-c).getTile().getColor() == playerShelf.getBox(4, 3-c).getTile().getColor())
						if(playerShelf.getBox(4, 3-c).getTile().getColor() == playerShelf.getBox(5, 2-c).getTile().getColor()) {
								verifier=0;
						     }
							else {
								verifier=verifier*1;
							}
				c++;
			}

		if(verifier==0) {
			return true;	
		}
		else {
			return false;
		}
	}
	
	/*
	 * Metodo per la verifica del Common Goal nr.11
	 * Scorre la Shelf personale del giocatore e conrolla se ci sono 5 Tiles
	 * dello stesso colore che formano una "X"
	 */
	private boolean isPubGoal_11_Done (BoxMatrix playerShelf) {
		for(int n=1; n<4; n++) {
			for(int m=1; m<3;m++) {
				if(playerShelf.getBox(n, m).getTile().getColor() == playerShelf.getBox(n+1, m+1).getTile().getColor()
						&& playerShelf.getBox(n, m).getTile().getColor() == playerShelf.getBox(n-1, m-1).getTile().getColor()
						&& playerShelf.getBox(n, m).getTile().getColor() == playerShelf.getBox(n+1, m-1).getTile().getColor()
						&& playerShelf.getBox(n, m).getTile().getColor() == playerShelf.getBox(n-1, m+1).getTile().getColor()) {
					return true;
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
		final int maxTiles=5;
		int count, m, n;
		boolean verify=false;
		
		//Altezza delle colonne decrescente da sinistra verso destra
		for (m=0; m<4; m++) {
			count=0;
			for (n=0; n<5; n++) {
				if (playerShelf.getBox(n, m).isFull())
					count++;
			}
			if ((maxTiles-count)==m)
				verify=true;
			else
				verify=false;			
		}
		if(verify)
			return true;
		
		//Altezza delle colonne crescente da sinistra verso destra
		for (m=0; m<4; m++) {
			count=0;
			for (n=0; n<5; n++) {
				if (playerShelf.getBox(n, m).isFull())
					count++;
			}
			if ((maxTiles-count)==(4-m))
				verify=true;
			else
				verify=false;			
		}
		if (verify)
			return true;
		
		return false;
	}
}
