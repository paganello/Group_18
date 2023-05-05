package myshelfie;
import java.util.Random;


public class Pubgoal {
	private int[] nGoals;
	
	public Pubgoal(){
		
		int UPPER_BOUND = 12; //costante indicante il massimo numero estraibile	
		nGoals = new int[2];
		
		Random rand = new Random();
		do {
			nGoals[0] = rand.nextInt(UPPER_BOUND);		//questo metodo definisce solo la generazione degli obb. comuni, starà poi al main calcolare i punteggi in base
			do{											//al numero di player e ordine conseguito.		
				nGoals[1] = rand.nextInt(UPPER_BOUND);
			}while(nGoals[0]==nGoals[1]);
		}while(nGoals[0] <= 0 && nGoals[0] <= 0);
	}
	
	public String toString(){	//Sovrascrive il metodo toString di java
		return ("Goal 1 = " + nGoals[0] + "/nGoal 2 = " + nGoals[1]);
	}
	
	public int[] getGoalsNumber() {
		
		int[] tmp = new int[2];
		tmp[0] = this.nGoals[0];
		tmp[1] = this.nGoals[1];
		return tmp;
	}
	
	
	public boolean isDone(int nGoal,int turnPlayer,BoxMatrix playerShelf) {
		/*goal l'obbiettivo pubblico da verificare, turnplayer il giocatore in verifca
		 * che eventualmente riceve i punti in palio
		 *metodo che verrà chiamato due volte, una per ogni goal da verificare
		 */
		switch (nGoal) {
		
		case 1:
			/*if(isPubGoal_1_Done(playerShelf)) {
				return true;
			}
			return false;*/
			
		case 2:
			if(isPubGoal_2_Done(playerShelf)) {
				return true;
			}
			return false;
			
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		case 6:
			
			break;
		case 7:
			
			break;
		case 8:
			
			break;
		case 9:
			
			break;
		case 10:
			
			break;
		case 11:
			
			break;
		case 12:
			
			break;
			
		default:
			break;
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
}
