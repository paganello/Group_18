package main;
import java.util.Scanner;

import goals.Gengoal;
import goals.Privgoal;
import goals.Pubgoal;
import structure.BoxMatrix;

public class Player {
	
	private String name;
	private int points = 0;
	private boolean chair;
	private Privgoal privateGoal;
	private Pubgoal publicGoals;
	private Gengoal genGoal;
	private BoxMatrix shelf; 
	
	/*
	 * COSTRUTTORE
	 * */
	public Player (int nPlayer, int pGoal_1, int pGoal_2) {
		
		System.out.println("Inserisci il nome del giocatore " + (nPlayer+1) + ": ");	//set name
		Scanner sc = new Scanner(System.in);
		this.name = sc.nextLine();
		sc.close();
		
		if(nPlayer == 1) {	//set chair
			this.chair = true;
		}else {
			this.chair = false;
		}
		
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
		privateGoal.verify(shelf);
		//genGoal.verify(shelf);
		this.points = publicGoals.getpoints() + privateGoal.getPoints() + genGoal.getPoints();
	}
	
}