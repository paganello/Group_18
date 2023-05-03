package myshelfie;
import java.util.Scanner;

public class Player {
	
	//dichiarazione variabile classe player
	String nome;
	int points;
	boolean chair;
	int numShelf;
	int privateGoal;
	int[] publicGoals;
	BoxMatrix shelf; 
	
	//costruttore per il player
	public Player (int order) {
		
		points = 0;
		//da aggiungere asseganzione dei goals
		this.chair = false;
		
		//assegnazione sedia al primo player
		if(order == 1) {
			this.chair = true;
		}
		//richiesta nome
		System.out.println("Inserisci il nome del giocatore " + (order+1) + ": ");
		Scanner sc = new Scanner(System.in);
		this.nome = sc.nextLine();
		sc.close();
		
		//creazione libreria del player 
		this.numShelf = order;
		this.shelf = new BoxMatrix(6,5);
	}
}