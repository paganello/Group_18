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
	public void verifyAndComputePoints(BoxMatrix shelf){
		//funzione che computa il numero di punti dei goal generici sempre validi, ritorna il valore in points	
		
		for (int i = 0; i < shelf.getNI(); i++) {
			for (int j = 0; j < shelf.getNJ(); j++) {
				if(shelf.getMatrix(i, j).isFull()) {
					int k = 0;
					k = shelf.countNumberOfAdjacentsTilesWithSameColor(i, j, k);
					
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
		shelf.setAllVerifiedTileAttribute(false);
		
	}
	
}
