package src.myshelfie;

import java.util.Scanner;

public class Player {
	
	//dichiarazione variabile classe player
	String nome;
	int points;
	int order;
	boolean chair;
	int numshelf;
	Matrix shelf; 
	
	//costruttore per il player
	public Player (int order) {
		this.order = order;
		this.chair = false;
		//assegnazione sedia al primo player
		if(this.order == 1) {
			this.chair = true;
		}
		//richiesta nome
		System.out.println("Inserisci il nome del giocatore " + this.order + ": ");
		Scanner sc = new Scanner(System.in);
		this.nome = sc.nextLine();
		sc.close();
		
		//creazione libreria del player 
		this.numshelf = this.order;
		this.shelf = new Matrix(6,5);
	}
}