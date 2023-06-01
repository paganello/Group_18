package goals;
import structure.BoxMatrix;

public class Gengoal {
	//gli obbiettivi sempre validi da verificare in fase pointCheck
	private boolean done;
	private int points;
	
	
	/*
	 * COSTRUTTORE
	 * */
	public Gengoal(){
		this.done = false;
		this.points = 0;
	}
	
	
	/*
	 * Getter ad Setters
	 * */
	public boolean isDone(){
		return this.done;
	}
	
	public int getPoints(){
		return this.points;
	}
	
	
	/*
	 * Metodo che verifica il raggiungimento e assegna i relatvi punti per i goals generali.
	 * */
	public void verifyAndComputePoints(BoxMatrix playerShelf){
		//funzione che computa il numero di punti dei goal generici sempre validi, ritorna il valore in points	
		
		for (int i = 0; i < playerShelf.getNI(); i++) {
			for (int j = 0; j < playerShelf.getNJ(); j++) {
				if(playerShelf.getBox(i, j).isFull()) {
					int k = 0;
					for (int l = 0; l < 4; l++) {
						int a = 0;
						k = k + playerShelf.countNumberOfAdjacentsTilesWithSameColor(i, j, a);
					}
					k = k + 1;
					//System.out.println(k);
					if(k == 3) {
						this.points = this.points + 2;
						
					}else if(k == 4) {
						this.points = this.points + 3;
					}
					else if(k == 5) {
						this.points = this.points + 5;
						
					}else if(k >= 6) {
						this.points = this.points + 8;
					}
				}
			}
		}
		playerShelf.setAllVerifiedTileAttribute(false);
		
	}
	
}
