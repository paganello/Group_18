package myshelfie;
import java.util.Random;

public class Privgoal {
	//gli obbiettivi personali da verificare in fase pointCheck
	
	/*dato che abbiamo necessità di funzioni che verifichino i goal abbiamo pensato: quello che andiamo a fare è la creazione
	degli oggetti goal con i medesimi attributi e costruttore, per la verifica creiamo un metodo che preso in
	input il goal (del 12 possibili) lo vada a verificare mediante uno specifico script.*/
	
	int nGoal;    // 1 - 12
	boolean state;
	
	public Privgoal(int nGoal) {
		this.nGoal = nGoal;  
		this.state = false;
		
		Random rand = new Random();
		do {
			nGoal = rand.nextInt(12);
		}while(nGoal <= 0);	//verifica che il numero randomico sia tale che  1 <= nGoal <= 12

	}
	
	
	public void isDone() {  //da decidere se fare ritornare boolean o modificare il valore di State
		
		switch (this.nGoal) {
		
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
			
		default:
			break;
		}
	}
	
}
