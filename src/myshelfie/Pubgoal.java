package myshelfie;
import java.util.Random;
public class Pubgoal {
	
	public void Extgoal(){
		int pGoal1;
		int pGoal2;
		Random rand= new Random();
		int upperbound =12;
		pGoal1= rand.nextInt(upperbound);//questo metodo definisce solo la generazione e la ricerca degli obb.
		do{								//comuni, starà poi al main calcolare i punteggi in palio in base al
		pGoal2= rand.nextInt(upperbound);//playercount e all'ordine di conseguimento.
		}while(pGoal1==pGoal2);
	}
	public void checkgoal(int goal,int turnplayer,int turnshelf) {//goal l'obbiettivo pubblico da verificare, turnplayer il giocatore in verifca
		// che eventualmente riceve i punti in palio
		//metodo che verrà chiamato due volte, una per ogni goal da verificare
		switch (goal) {
		case 1:
			 break;
		case 2:
			 break;
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
		}//ogni case contiene il metodo per verificare il goal in questione, è qui che viene scritto
		// il grosso dell'algoritmo per verificare i goal publici.
	}
}
