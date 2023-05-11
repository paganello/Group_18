package myshelfie;
import java.util.Random;


public class Pubgoal {
	private int[] nGoals;
	private boolean done;
	private int points;
	
	
	/*
	 *COSTRUTTORE 
	 */
	public Pubgoal(){
		
		int UPPER_BOUND = 11; //costante indicante il massimo numero estraibile	=> vanno da 0 a 11 = 12 goals
		this.nGoals = new int[2];
		this.done = false;	 // init a false
		this.points = 0;
		
		Random rand = new Random();
		do {
			this.nGoals[0] = rand.nextInt(UPPER_BOUND);		//questo metodo definisce solo la generazione degli obb. comuni, starà poi al main calcolare i punteggi in base
			do{											//al numero di player e ordine conseguito.		
				this.nGoals[1] = rand.nextInt(UPPER_BOUND);
			}while(this.nGoals[0] == this.nGoals[1]);
		}while(this.nGoals[0] < 0 && this.nGoals[1] < 0);
		
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
	public boolean isDone() {
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
	public void isDone(int nGoal, BoxMatrix playerShelf) {
		
		switch (nGoal) {
		
		case 0:
			/*if(isPubGoal_1_Done(playerShelf)) {
				return true;
			}*/
			this.done = false;
			
		case 1:
			if(isPubGoal_2_Done(playerShelf)) {
				this.done = true;
			}
			this.done = false;
			
		case 2:
			
			this.done = false;
			
		case 3:
			
			this.done = false;
			
		case 4:
			
			this.done = false;
			
		case 5:
			if(isPubGoal_6_Done(playerShelf)) {
				this.done = true;
			}
			this.done = false;
			
		case 6:
			if(isPubGoal_7_Done(playerShelf)) {
				this.done = true;
			}
			this.done = false;
			
		case 7:
			
			this.done = false;
			
		case 8:
			
			this.done = false;
			
		case 9:
			
			this.done = false;
			
		case 10:
			
			this.done = false;
			
		case 11:
			
			this.done = false;
			
		default:
			this.done = false;
		}//ogni case contiene il metodo per verificare il goal in questione, è qui che viene scritto
		// il grosso dell'algoritmo per verificare i goal publici.
	}
	
	
	/*private boolean isPubGoal_1_Done(BoxMatrix playerShelf){
		for (int k = 0; k < playerShelf.nI; k++) {
			for (int n = 0; n < playerShelf.nJ; n++) {
				if(playerShelf.m[k][n].empty) {
					if(!playerShelf.m[k][n].tile.verified) {
						if((k+1) < 6 && (n+1) < 5) {
							if(playerShelf.m[k][n].tile.getColor() == playerShelf.m[k][n+1].tile.getColor()) {
								if(playerShelf.m[k][n].tile.getColor() != playerShelf.m[k+1][n].tile.getColor() && playerShelf.m[k][n+1].tile.getColor() != playerShelf.m[k+1][n+1].tile.getColor() && playerShelf.m[k][n+1].tile.getColor() != playerShelf.m[k][n+2].tile.getColor()) {
									
								}
								
							}else {
								
							}
							if(playerShelf.m[k][n].tile.getColor() == playerShelf.m[k+1][n].tile.getColor()) {
								if(playerShelf.m[k+1][n].tile.getColor() != playerShelf.m[k+2][n].tile.getColor() && playerShelf.m[k+1][n].tile.getColor() != playerShelf.m[k+1][n+1].tile.getColor() && playerShelf.m[k][n].tile.getColor() != playerShelf.m[k][n+1].tile.getColor()) {
									
								}
							}
						}
						if(playerShelf.m[k][n].tile.getColor() == playerShelf.m[k][n+1].tile.getColor()) {
							
						}else {
							
						}
					}
				}
			}
		}
	}*/

	/*
	 * METODI DI VERIFICA DEI SINGOLI GOALS, SONO PRIVATI E VENGONO RICHIAMATI IN isDone.
	 * RITORNANO TRUE O FALSE
	 * */
	private boolean isPubGoal_2_Done(BoxMatrix playerShelf){
		if(playerShelf.m[0][0].tile.getColor() == playerShelf.m[0][4].tile.getColor()) {
			if(playerShelf.m[0][4].tile.getColor() == playerShelf.m[5][4].tile.getColor()) {
				if(playerShelf.m[5][4].tile.getColor() == playerShelf.m[5][0].tile.getColor()) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isPubGoal_6_Done(BoxMatrix playerShelf) {
		int counter=0;
		int c=1;
		int verifier=1;
			while(c<7) {
				for (int m=0; m<6;m++) {
					for(int n=0; n<5; n++) {
						if(playerShelf.m[m][n].tile.getColor() ==c) {
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
				if(playerShelf.m[1][1+c].tile.getColor() == playerShelf.m[2][2+c].tile.getColor())
					if(playerShelf.m[2][2+c].tile.getColor() == playerShelf.m[3][3+c].tile.getColor())
						if(playerShelf.m[3][3+c].tile.getColor() == playerShelf.m[4][4+c].tile.getColor())
							if(playerShelf.m[4][4+c].tile.getColor() == playerShelf.m[5][5+c].tile.getColor()) {
									verifier=0;
								}
								else {
									verifier=verifier*1;
								}
								
			if(playerShelf.m[1][6-c].tile.getColor() == playerShelf.m[2][5-c].tile.getColor())
				if(playerShelf.m[2][5-c].tile.getColor() == playerShelf.m[3][4-c].tile.getColor())
					if(playerShelf.m[3][4-c].tile.getColor() == playerShelf.m[4][3-c].tile.getColor())
						if(playerShelf.m[4][3-c].tile.getColor() == playerShelf.m[5][2-c].tile.getColor()) {
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

}
