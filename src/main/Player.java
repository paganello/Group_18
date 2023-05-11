package myshelfie;
import java.util.Scanner;

public class Player {
	
	//dichiarazione variabile classe player
	private String name;
	private int points = 0;
	private boolean chair;
	private Privgoal privateGoal;
	private Pubgoal publicGoals;
	BoxMatrix shelf; 
	
	//costruttore per il player
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
		
		this.privateGoal = new Privgoal();	//assegan goal personale
	}
	
	
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
}