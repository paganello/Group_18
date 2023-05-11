package myshelfie;

public class Gengoal {
	//gli obbiettivi sempre validi da verificare in fase pointCheck
	private boolean done;
	private int points;
	
	public Gengoal(){
		this.done = false;
		this.points = 0;
	}
	
	public boolean isDone(){
		return this.done;
	}
	
	public int getPoints(){
		return this.points	
	}
	
	public void computePoints(){
		//funzione che computa il numero di punti dei goal generici sempre validi, ritorna il valore in points	
	}
	
}
