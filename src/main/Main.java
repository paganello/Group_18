package main;
import java.util.*;
import java.lang.*;
import goals.*;
import structure.*;
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
	int lastTurnPlayer;
	int contaUltimoTurno=0;
	
	Scanner sc= new Scanner(System.in);
	do {	
	System.out.println ("Inserire il numero di giocatori"); //ottengo in input il numero di giocatori, che è													//verificato alla fine di questo loop
		playerNum= sc.nextInt();
		if(playerNum<2 || playerNum>4) {
			System.out.println("Per favore inserire solo valori tra 2 e 4");
		}
			}while(playerNum<2||playerNum>4);
			
	stato= GameState.drawPhase;
	
	do {
		
		switch (stato) {
			
		case drawPhase:
				Pubgoal obbPubblici=new Pubgoal(); //genero goal pubblici
					for(int contaPlayerLoop=0; contaPlayerLoop<playerNum; contaPlayerLoop++) {
						Privgoal obb1= new Privgoal(); //genero due goal privati ;
						listaPlayer.add(new Player((contaPlayerLoop+1),obb1.getGoalNumber()));
						}
					

		
				
			Board tavolo= new Board(playerNum);
				tavolo.matrix.fillBoard();
				
			/*
			 * stampa della situazione attuale del tavolo*/

				stato= GameState.turnStart;
				
				break;
			case turnStart:
				for (int v=0; v<playerNum; v++) {
				System.out.println("E' il turno di "+listaPlayer.get(v).getName());
				//metodi per prelevare e depositare tiles
				if(listaPlayer.get(v).isShelfFull()== true && stato==GameState.turnStart) {
					stato= GameState.endPhase;
					lastTurnPlayer=v;
				}
				}
				break;
		
			case endPhase:
			
				break;
			
			case gameEnd:
				System.out.println("Grazie per aver giocato ");
				break;
			
			default:
				break;
				
	}
		
	
	
		
	}while(stato !=GameState.gameEnd); 
		
	
	}	
}
