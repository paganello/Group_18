package myshelfie;
import java.util.Random;

public class Privgoal {
	//gli obbiettivi personali da verificare in fase pointCheck
	
	/*dato che abbiamo necessità di funzioni che verifichino i goal abbiamo pensato: quello che andiamo a fare è la creazione
	degli oggetti goal con i medesimi attributi e costruttore, per la verifica creiamo un metodo che preso in
	input il goal (del 12 possibili) lo vada a verificare mediante uno specifico script.*/
	
	private int nGoal;    // 1 - 12
	private boolean state;
	
	public Privgoal() { 
		this.setState(false);
		
		Random rand = new Random();
		do {
			this.nGoal = rand.nextInt(12);
		}while(nGoal <= 0);	//verifica che il numero randomico sia tale che  1 <= nGoal <= 12

	}
	
	
	public boolean isDone(BoxMatrix playerShelf) {  //da decidere se fare ritornare boolean o modificare il valore di State
		
		switch (this.nGoal) {
		
		case 1:
			
			int[] iMap_0 = {0, 0, 1, 2, 3, 5};
			int[] jMap_0 = {0, 2, 4, 3, 1, 2};
			int[] colorMap_0 = {6, 4, 1, 2, 3, 5};
			
			if (verifyIfTileMatchByArray(iMap_0, jMap_0, colorMap_0, playerShelf)) {
				this.state = true;
				return true;
			}else {
				return false;
			}
			
			
		case 2:
			
			int[] iMap_1 = {1, 2, 2, 3, 4, 5};
			int[] jMap_1 = {1, 0, 2, 4, 3, 4};
			int[] colorMap_1 = {6, 1, 3, 2, 5, 4};
			
			if (verifyIfTileMatchByArray(iMap_1, jMap_1, colorMap_1, playerShelf)) {
				this.state = true;
				return true;
			}else {
				return false;
			}
			
			
		case 3:
			
			int[] iMap_2 = {1, 1, 2, 3, 3, 5};
			int[] jMap_2 = {0, 3, 2, 1, 4, 0};
			int[] colorMap_2 = {4, 3, 6, 1, 5, 2};
			
			if (verifyIfTileMatchByArray(iMap_2, jMap_2, colorMap_2, playerShelf)) {
				this.state = true;
				return true;
			}else {
				return false;
			}
			
			
		case 4:
			
			int[] iMap_3 = {0, 2, 2, 3, 4, 4};
			int[] jMap_3 = {4, 0, 2, 4, 1, 2};
			int[] colorMap_3 = {2, 5, 4, 6, 2, 2};
			
			if (verifyIfTileMatchByArray(iMap_3, jMap_3, colorMap_3, playerShelf)) {
				this.state = true;
				return true;
			}else {
				return false;
			}
			
			
		case 5:
			
			int[] iMap_4 = {1, 3, 3, 4, 5, 5};
			int[] jMap_4 = {1, 1, 2, 5, 0, 3};
			int[] colorMap_4 = {5, 4, 2, 6, 3, 1};
			
			if (verifyIfTileMatchByArray(iMap_4, jMap_4, colorMap_4, playerShelf)) {
				this.state = true;
				return true;
			}else {
				return false;
			}
			
			
		case 6:
			
			int[] iMap_5 = {0, 0, 2, 4, 4, 5};
			int[] jMap_5 = {2, 4, 3, 1, 3, 0};
			int[] colorMap_5 = {5, 1, 2, 3, 4, 6};
			
			if (verifyIfTileMatchByArray(iMap_5, jMap_5, colorMap_5, playerShelf)) {
				this.state = true;
				return true;
			}else {
				return false;
			}
			
			
		case 7:
			
			int[] iMap_6 = {0, 1, 2, 3, 4, 5};
			int[] jMap_6 = {0, 3, 1, 0, 4, 2};
			int[] colorMap_6 = {1, 4, 6, 5, 3, 2};
			
			if (verifyIfTileMatchByArray(iMap_6, jMap_6, colorMap_6, playerShelf)) {
				this.state = true;
				return true;
			}else {
				return false;
			}
			
			
		case 8:
			
			int[] iMap_7 = {0, 1, 2, 3, 4, 5};
			int[] jMap_7 = {4, 1, 2, 0, 3, 3};
			int[] colorMap_7 = {4, 1, 5, 6, 2, 3};
			
			if (verifyIfTileMatchByArray(iMap_7, jMap_7, colorMap_7, playerShelf)) {
				this.state = true;
				return true;
			}else {
				return false;
			}
			
			
		case 9:
			
			int[] iMap_8 = {0, 2, 3, 4, 4, 5};
			int[] jMap_8 = {2, 2, 4, 1, 4, 0};
			int[] colorMap_8 = {3, 1, 2, 5, 6, 4};
			
			if (verifyIfTileMatchByArray(iMap_8, jMap_8, colorMap_8, playerShelf)) {
				this.state = true;
				return true;
			}else {
				return false;
			}
			
			
		case 10:
			
			int[] iMap_9 = {0, 1, 2, 3, 4, 5};
			int[] jMap_9 = {4, 1, 0, 3, 1, 3};
			int[] colorMap_9 = {5, 3, 2, 1, 4, 6};
			
			if (verifyIfTileMatchByArray(iMap_9, jMap_9, colorMap_9, playerShelf)) {
				this.state = true;
				return true;
			}else {
				return false;
			}
			
			
		case 11:
			
			int[] iMap_10 = {0, 1, 2, 3, 4, 5};
			int[] jMap_10 = {2, 1, 0, 2, 4, 3};
			int[] colorMap_10 = {6, 2, 3, 4, 1, 5};
			
			if (verifyIfTileMatchByArray(iMap_10, jMap_10, colorMap_10, playerShelf)) {
				this.state = true;
				return true;
			}else {
				return false;
			}
			
			
		case 12:
			
			int[] iMap_11 = {0, 1, 2, 3, 4, 5};
			int[] jMap_11 = {2, 1, 2, 3, 4, 0};
			int[] colorMap_11 = {2, 6, 4, 5, 3, 1};
			
			if (verifyIfTileMatchByArray(iMap_11, jMap_11, colorMap_11, playerShelf)) {
				this.state = true;
				return true;
			}else {
				return false;
			}
			
			
		default:
			return false;
		}
	}
	
	
	private boolean verifyIfTileMatchByArray(int[] iMap, int[] jMap, int[] colorMap, BoxMatrix playerShelf) {
		
		int k = 0;
		
		for (int i = 0; i < playerShelf.nI; i++) {
			for (int j = 0; j < playerShelf.nJ; j++) {
				if(i == iMap[k] && j == jMap[k]) {
					if (playerShelf.m[i][j].tile.getColor() == colorMap[k]) {
						k++;
					}else {
						return false;
					}
				}
			}
		}
		return true;
	}


	public boolean getState() {
		
		return state;
	}


	public void setState(boolean state) {
		
		this.state = state;
	}
	
	
	public int getGoalNumber() {
		
		return nGoal;
	}	
	
}
