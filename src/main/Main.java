package main;
import java.util.*;
import java.lang.*;
import goals.*;
import main.Player;
public class Main {	
	public static void main(String[] args) {
		
		
		
		/*//codice di debug
		System.out.println("inserisci numero giocatori= ");
		Scanner sc = new Scanner(System.in);
		int nPlayers = sc.nextInt();
		sc.close();
	
	    //scorrimento di board per verificare le classi e relativi costruttori
		Board table = new Board(nPlayers);
	
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				table.matrix.printTileColor(i,j);
			}
		
	System.out.println();/
	*/
	GameState stato;
	stato = GameState.drawPhase;
	int playerNum;
	ArrayList<Player> listaPlayer= new ArrayList<Player>();
	
	Scanner sc= new Scanner(System.in);
	do {
		
		switch (stato) {
			case drawPhase:
				Pubgoal obbPubblici=new Pubgoal(); //genero goal pubblici
				
				System.out.println ("Inserire il numero di giocatori"); //ottengo in input il numero di giocatori, che è
				do {													//verificato alla fine di questo looè
				playerNum= sc.nextInt();
				if(playerNum<2 || playerNum>4) {
					System.out.println("Per favore inserire solo valori tra 2 e 4");
				}
				else {
					for(int contaPlayerLoop=0; contaPlayerLoop<playerNum; contaPlayerLoop++) {
						Privgoal obb1= new Privgoal(); //genero due goal privati 
						Privgoal obb2= new Privgoal();
						listaPlayer.add(new Player((contaPlayerLoop+1),obb1.getGoalNumber(),obb2.getGoalNumber()));
						}
					
				}
				
				}
				while(playerNum<2 && playerNum>4);
			
				break;
		
			case turnStart:
			
				break;
		
			case lastTurnStart:
			
				break;
		
			case endPhase:
			
				break;
	
		}
		
	}while(stato !=GameState.gameEnd); 
		
	
	}	
}
