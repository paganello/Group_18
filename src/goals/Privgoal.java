package goals;
import java.util.Random;
import structure.BoxMatrix;

public class Privgoal {
	//gli obbiettivi personali da verificare in fase pointCheck
	
	/*dato che abbiamo necessità di funzioni che verifichino i goal abbiamo pensato: quello che andiamo a fare è la creazione
	degli oggetti goal con i medesimi attributi e costruttore, per la verifica creiamo un metodo che preso in
	input il goal (del 12 possibili) lo vada a verificare mediante uno specifico script.*/
	
	private int nGoal;    // 1 - 12
	private boolean done;
	private int points;
	
	
	
	/*
	 * COSTRUTTORE	
	 * */
	public Privgoal() { 
		this.points = 0;
		
		Random rand = new Random();
		do {
			this.nGoal = rand.nextInt(11);
		}while(nGoal < 0);	//verifica che il numero randomico sia tale che  1 <= nGoal <= 12

	}
	
	
	/*
	 * Metodo di verifica del goal privato
	 * */
	public void verifyAndComputePoints(BoxMatrix playerShelf) {  //da decidere se fare ritornare boolean o modificare il valore di State
		
		int matches = 0;
		switch (this.nGoal) {
		
		case 0:
			
			int[] iMap_0 = {0, 0, 1, 2, 3, 5};
			int[] jMap_0 = {0, 2, 4, 3, 1, 2};
			int[] colorMap_0 = {6, 4, 1, 2, 3, 5};
			
			matches = verifyIfTileMatchByArray(iMap_0, jMap_0, colorMap_0, playerShelf);
			
			if (matches > 0) {
				this.done = true;
				System.out.println("Goal privato numero " + (this.nGoal+1) + " verificato con " + matches +" corrispondenze.");
				computePoints(matches);
			}else {
				this.done = false;
				System.out.println("Goal privato numero "+(this.nGoal+1)+" non verificato. ");
			}
			//System.out.println(this.points);
			break;
			
			
		case 1:
			
			int[] iMap_1 = {1, 2, 2, 3, 4, 5};
			int[] jMap_1 = {1, 0, 2, 4, 3, 4};
			int[] colorMap_1 = {6, 1, 3, 2, 5, 4};
			
			matches = verifyIfTileMatchByArray(iMap_1, jMap_1, colorMap_1, playerShelf);
			
			if (matches > 0) {
				this.done = true;
				System.out.println("Goal privato numero " + (this.nGoal+1) + " non verificato con " + matches +" corrispondenze.");
				computePoints(matches);
			}else {
				this.done = false;
				System.out.println("Goal privato numero "+(this.nGoal+1)+" non verificato. ");
			}
			//System.out.println(this.points);
			break;
			
			
		case 2:
			
			int[] iMap_2 = {1, 1, 2, 3, 3, 5};
			int[] jMap_2 = {0, 3, 2, 1, 4, 0};
			int[] colorMap_2 = {4, 3, 6, 1, 5, 2};
			
			matches = verifyIfTileMatchByArray(iMap_2, jMap_2, colorMap_2, playerShelf);
			
			if (matches > 0) {
				this.done = true;
				System.out.println("Goal privato numero " + (this.nGoal+1) + " non verificato con " + matches +" corrispondenze.");
				computePoints(matches);
			}else {
				this.done = false;
				System.out.println("Goal privato numero "+(this.nGoal+1)+" non verificato. ");
			}
			//System.out.println(this.points);
			break;
			
			
		case 3:
			
			int[] iMap_3 = {0, 2, 2, 3, 4, 4};
			int[] jMap_3 = {4, 0, 2, 3, 1, 2};
			int[] colorMap_3 = {2, 5, 4, 6, 2, 2};
			
			matches = verifyIfTileMatchByArray(iMap_3, jMap_3, colorMap_3, playerShelf);
			
			if (matches > 0) {
				this.done = true;
				System.out.println("Goal privato numero " + (this.nGoal+1) + " non verificato con " + matches +" corrispondenze.");
				computePoints(matches);
			}else {
				this.done = false;
				System.out.println("Goal privato numero "+(this.nGoal+1)+" non verificato. ");
			}
			//System.out.println(this.points);
			break;
			
			
		case 4:
			
			int[] iMap_4 = {1, 3, 3, 4, 5, 5};
			int[] jMap_4 = {1, 1, 2, 4, 0, 3};
			int[] colorMap_4 = {5, 4, 2, 6, 3, 1};
			
			matches = verifyIfTileMatchByArray(iMap_4, jMap_4, colorMap_4, playerShelf);
			
			if (matches > 0) {
				this.done = true;
				System.out.println("Goal privato numero " + (this.nGoal+1) + " non verificato con " + matches +" corrispondenze.");
				computePoints(matches);
			}else {
				this.done = false;
				System.out.println("Goal privato numero "+(this.nGoal+1)+" non verificato. ");
			}
			//System.out.println(this.points);
			break;
			
			
		case 5:
			
			int[] iMap_5 = {0, 0, 2, 4, 4, 5};
			int[] jMap_5 = {2, 4, 3, 1, 3, 0};
			int[] colorMap_5 = {5, 1, 2, 3, 4, 6};
			
			matches = verifyIfTileMatchByArray(iMap_5, jMap_5, colorMap_5, playerShelf);
			
			if (matches > 0) {
				this.done = true;
				System.out.println("Goal privato numero " + (this.nGoal+1) + " non verificato con " + matches +" corrispondenze.");
				computePoints(matches);
			}else {
				this.done = false;
				System.out.println("Goal privato numero "+(this.nGoal+1)+" non verificato. ");
			}
			//System.out.println(this.points);
			break;
			
			
		case 6:
			
			int[] iMap_6 = {0, 1, 2, 3, 4, 5};
			int[] jMap_6 = {0, 3, 1, 0, 4, 2};
			int[] colorMap_6 = {1, 4, 6, 5, 3, 2};
			
			matches = verifyIfTileMatchByArray(iMap_6, jMap_6, colorMap_6, playerShelf);
			
			if (matches > 0) {
				this.done = true;
				System.out.println("Goal privato numero " + (this.nGoal+1) + " non verificato con " + matches +" corrispondenze.");
				computePoints(matches);
			}else {
				this.done = false;
				System.out.println("Goal privato numero "+(this.nGoal+1)+" non verificato. ");
			}
			//System.out.println(this.points);
			break;
			
			
		case 7:
			
			int[] iMap_7 = {0, 1, 2, 3, 4, 5};
			int[] jMap_7 = {4, 1, 2, 0, 3, 3};
			int[] colorMap_7 = {4, 1, 5, 6, 2, 3};
			
			matches = verifyIfTileMatchByArray(iMap_7, jMap_7, colorMap_7, playerShelf);
			
			if (matches > 0) {
				this.done = true;
				System.out.println("Goal privato numero " + (this.nGoal+1) + " non verificato con " + matches +" corrispondenze.");
				computePoints(matches);
			}else {
				this.done = false;
				System.out.println("Goal privato numero "+(this.nGoal+1)+" non verificato. ");
			}
			//System.out.println(this.points);
			break;
			
			
		case 8:
			
			int[] iMap_8 = {0, 2, 3, 4, 4, 5};
			int[] jMap_8 = {2, 2, 4, 1, 4, 0};
			int[] colorMap_8 = {3, 1, 2, 5, 6, 4};
			
			matches = verifyIfTileMatchByArray(iMap_8, jMap_8, colorMap_8, playerShelf);
			
			if (matches > 0) {
				this.done = true;
				System.out.println("Goal privato numero " + (this.nGoal+1) + " non verificato con " + matches +" corrispondenze.");
				computePoints(matches);
			}else {
				this.done = false;
				System.out.println("Goal privato numero "+(this.nGoal+1)+" non verificato. ");
			}
			//System.out.println(this.points);
			break;
			
			
		case 9:
			
			int[] iMap_9 = {0, 1, 2, 3, 4, 5};
			int[] jMap_9 = {4, 1, 0, 3, 1, 3};
			int[] colorMap_9 = {5, 3, 2, 1, 4, 6};
			
			matches = verifyIfTileMatchByArray(iMap_9, jMap_9, colorMap_9, playerShelf);
			
			if (matches > 0) {
				this.done = true;
				System.out.println("Goal privato numero " + (this.nGoal+1) + " non verificato con " + matches +" corrispondenze.");
				computePoints(matches);
			}else {
				this.done = false;
				System.out.println("Goal privato numero "+(this.nGoal+1)+" non verificato. ");
			}
			//System.out.println(this.points);
			break;
			
			
		case 10:
			
			int[] iMap_10 = {0, 1, 2, 3, 4, 5};
			int[] jMap_10 = {2, 1, 0, 2, 4, 3};
			int[] colorMap_10 = {6, 2, 3, 4, 1, 5};
			
			matches = verifyIfTileMatchByArray(iMap_10, jMap_10, colorMap_10, playerShelf);
			
			if (matches > 0) {
				this.done = true;
				System.out.println("Goal privato numero " + (this.nGoal+1) + " non verificato con " + matches +" corrispondenze.");
				computePoints(matches);
			}else {
				this.done = false;
				System.out.println("Goal privato numero "+(this.nGoal+1)+" non verificato. ");
			}
			//System.out.println(this.points);
			break;
			
			
		case 11:
			
			int[] iMap_11 = {0, 1, 2, 3, 4, 5};
			int[] jMap_11 = {2, 1, 2, 3, 4, 0};
			int[] colorMap_11 = {2, 6, 4, 5, 3, 1};
			
			matches = verifyIfTileMatchByArray(iMap_11, jMap_11, colorMap_11, playerShelf);
			
			if (matches > 0) {
				this.done = true;
				System.out.println("Goal privato numero " + (this.nGoal+1) + " non verificato con " + matches +" corrispondenze.");
				computePoints(matches);
			}else {
				this.done = false;
				System.out.println("Goal privato numero "+(this.nGoal+1)+" non verificato. ");
			}
			//System.out.println(this.points);
			break;
			
			
		default:
			this.done = false;
			break;
		}
	}
	
	/*
	 * Metodo PRIVATO usato da verify per controllare i match
	 * */
	private int verifyIfTileMatchByArray(int[] iMap, int[] jMap, int[] colorMap, BoxMatrix playerShelf) {
		
		int k = 0;
		
		for (int i = 0; i < playerShelf.getNI(); i++) {
			for (int j = 0; j < playerShelf.getNJ(); j++) {
				if(i == iMap[k] && j == jMap[k]) {
					if (playerShelf.getBox(i, j).isFull() && playerShelf.getBox(i, j).getTile().getColor() == colorMap[k]) {
						k++;
						if(k == 6) {
							return k;
						}
					}
				}
			}
		}
		return k;
	}

	
	/*
	 * Metodo PRIVATO usato da verify per la computazione dei punti 
	 * */
	private void computePoints(int m) {
		switch (m) {
		
		case 1:
			this.points = 1;
			break;
			
		case 2:
			this.points = 2;
			break;
			
		case 3:
			this.points = 4;
			break;
			
		case 4:
			this.points = 6;
			break;
			
		case 5:
			this.points = 9;
			break;
			
		case 6:
			this.points = 12;
			break;

		default:
			break;
		}
	}
	
	
	/*
	 * Getter and Setters
	 * */
	public boolean isDone() {
		
		return done;
	}
	
	public int getGoalNumber() {
		
		return nGoal;
	}


	public int getPoints() {
		return points;
	}	
	
	/*
	 *  Setters di debug
	 * */
	public void setGoalNumber(int a) {
		this.nGoal = a;
	}
	
}
