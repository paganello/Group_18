package main;

import goals.Gengoal;
import goals.Privgoal;
import goals.Pubgoal;
import structure.*;
import java.util.*;

public class Player {
	public int number;
	private String name;
	private int points = 0;
	private boolean chair;
	private Privgoal privateGoal;
	private Pubgoal publicGoals;
	private Gengoal genGoal;
	private BoxMatrix shelf; 
	private int orderPlayer;//l'ordine nel quale i gicoatori vengono costruiti nel main e nel quale giocano; necessario per lo spareggio
	
	
	/*
	 * COSTRUTTORE
	 * */
	public Player (int nPlayer, int[] PubGoalsNumbers, String playerName,int orderPlayer) {
		
		this.name = playerName;
		
		this.number = nPlayer;
		
		this.orderPlayer = orderPlayer;
		
		if(nPlayer == 0) {	//set chair
			this.chair = true;
		}else {
			this.chair = false;
		}
		
		this.publicGoals = new Pubgoal(PubGoalsNumbers[0], PubGoalsNumbers[1]);
		
		this.shelf = new BoxMatrix(6,5);	//creazione libreria del player 
		
		this.privateGoal = new Privgoal();	//assegna goal personale
		
		this.genGoal = new Gengoal();	//crea l'oggetto attributo genGoal che serve per stabile se il goal è stato fatto e i punti che attribuisce
	}
	
	
	
	/*
	 * Getters and Setters
	 * 
	 * */
	public String getName() {
	
		return name;
	}
	
	public int getPoints() {
		
		return points;
	}
	
	public void setPoints(int points) {
		
		this.points = points;
	}
	public void endPhaseBonus() {
		this.points++;
	}

	public boolean isChair() {
		
		return chair;
	}
	
	public Privgoal getPrivateGoal() {
		
		return privateGoal;
	}

	public void setPrivateGoal(Privgoal privateGoal) {
		
		this.privateGoal = privateGoal;
	}
	
	public Pubgoal getPublicGoals() {
		
		return publicGoals;
	}
	
	public void setPublicGoals(Pubgoal publicGoal) {
		
		this.publicGoals = publicGoal; 
	}
	
	
	public boolean isShelfFull() {
		for (int i=0; i<6; i++) {
			for(int j=0; j<5;j++) {
				if (!shelf.getBox(i,j).isFull()) {
					return false;
				}
			}
		}
			return true;
	}
	
	public BoxMatrix getShelf() {
		return shelf;
	}
	public int getOrder() {
		return orderPlayer;
	}


	public void setShelf(BoxMatrix shelf) {
		this.shelf = shelf;
	}



	
	
	/*
	 * Metodo di computazione dei punti derivanti da goals pubblici.
	 * 
	 * modifica direttamente l'attributo points di publicGoals.
	 * */
	public void computePubGoals() {		//DA VERIFICARE REGOLAMENTO CON LA GESTIONE DEI PUNTI E DI QUANTE VOLTE VALE UN OBBIETTIVO !!!!
		publicGoals.verify(shelf);
		publicGoals.computePoints();
	}
	
	
	/*
	 * Metodo di computazione dei punti derivanti da goals privati + genGoals.
	 * 
	 * modifica direttamente l'attributo points di publicGoals.
	 * */
	public void computesFinalPoints() {
		privateGoal.verifyAndComputePoints(shelf);
		genGoal.verifyAndComputePoints(shelf);
		this.points = publicGoals.getpoints() + privateGoal.getPoints() + genGoal.getPoints();
	}
	
	
	public void debugFillShelf() {
		Scanner sc= new Scanner(System.in);
		int c;
		for (int i=0; i<6; i++) {
			for (int j=0; j<5; j++) {
				System.out.println("Inserire la tile alla posizione "+(i+1)+" "+(j+1));
				c= sc.nextInt();
				Tile tessera= new Tile(i,j,c);
				this.shelf.getBox(i,j).fillBox(tessera);
			}
		
		}
	}
}