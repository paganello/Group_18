package main;
import java.util.*;
import goals.*;
import structure.*;


public class Main {
	public static void main(String[] args) {
		
		GameState stato;
		stato = GameState.drawPhase;
	
		int playerNum;
		int lastTurnPlayer;
		int contaUltimoTurno=0;
		
		ArrayList<Player> listaPlayer= new ArrayList<Player>();
	
		Scanner sc= new Scanner(System.in);
		do {
			
			System.out.println ("Inserire il numero di giocatori"); //ottengo in input il numero di giocatori, che è													//verificato alla fine di questo loop
			playerNum= sc.nextInt();
			if(playerNum < 2 || playerNum > 4) {
				System.out.println("Per favore inserire solo valori tra 2 e 4");
			}
			
		}while(playerNum < 2 || playerNum > 4);	
		
		stato = GameState.drawPhase;
	
		
		
		do {
			switch (stato) {
			
				case drawPhase:
					Pubgoal obbPubblici=new Pubgoal(); //genero goal pubblici
					
						for(int contaPlayerLoop=0; contaPlayerLoop < playerNum; contaPlayerLoop++) {
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
					for (int v=0; v < listaPlayer.size(); v++) {
						System.out.println("E' il turno di "+listaPlayer.get(v).getName());
						//metodi per prelevare e depositare tiles
						if(listaPlayer.get(v).isShelfFull()== true && stato==GameState.turnStart) {
							stato= GameState.endPhase;
							lastTurnPlayer=v;
						}
						listaPlayer.get(v).computePubGoals();
					}
					break;
		
				case endPhase:
					
					for (int i = 0; i < listaPlayer.size(); i++) {
						listaPlayer.get(i).computesFinalPoints();
					}
					
					// Algoritmo di bubble sort per ordinare la classifica => primo e' il vincitore
					Player tmp;
					boolean isNotSorted = true;
					while(isNotSorted) {
						isNotSorted = false;
						for (int i = 0; i < listaPlayer.size()-1; i++) {
							if(listaPlayer.get(i+1).getPoints() > listaPlayer.get(i).getPoints()) {
				                tmp = listaPlayer.get(i);
								listaPlayer.set(i, listaPlayer.get(i+1));
								listaPlayer.set(i, tmp);
								isNotSorted = true;
							}
							i++;
						}
					}
					
					System.out.println("*--------------------- CLASSIFICA -------------------------*");
					System.out.println("il giocatore che ha vinto la partita e': " + listaPlayer.get(0).getName() + "\n");
					
					for (int i = 0; i < listaPlayer.size(); i++) {
						System.out.println((i+1) + listaPlayer.get(i).getName() + " -> " + listaPlayer.get(i).getPoints() + " punti.");
					}
					stato = GameState.gameEnd;
					
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
