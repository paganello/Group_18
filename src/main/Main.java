package main;
import java.util.*;
import structure.*;


public class Main {
	public static void main(String[] args) {
		
		GameState stato;
		stato = GameState.drawPhase;
	
		int playerNum;
		int lastTurnPlayer;
		int contaUltimoTurno = 0;
		
		ArrayList<Player> listaPlayer= new ArrayList<Player>();
	
		Scanner sc = new Scanner(System.in);
		do {
			
			System.out.print("Inserire il numero di giocatori: "); //ottengo in input il numero di giocatori, che è verificato alla fine di questo loop
			playerNum = sc.nextInt();
			sc.nextLine();
			
			if(playerNum < 2 || playerNum > 4) {
				System.out.println("Per favore inserire solo valori tra 2 e 4!");
			}
		}while(playerNum < 2 || playerNum > 4);	
		
		stato = GameState.drawPhase;
		
		do {
			switch (stato) {
				
				/*
				 * Fase di inizializzazione della partita
				 * */
				case drawPhase:
					int[] nGoals = randPubGoals();
					
					for(int i = 0; i < playerNum; i++) {
						System.out.print("Inserire il nome del giocatore " + (i+1) + ": ");
						if(sc.hasNextLine()) {
							String playerName = sc.nextLine();
							listaPlayer.add(new Player((i), nGoals, playerName));
						}else {
							System.out.println("Error (row 43): nextLine non found");
						}
					}
					
					Board tavolo= new Board(playerNum);
					tavolo.matrix.fillBoard();
					System.out.println(tavolo.matrix.getBox(0, 3).getTile().getColor());
					
					tavolo.matrix.showTable();			
					/*
					 * stampa della situazione attuale del tavolo*/

					stato= GameState.turnStart; 
				
					break;
						
				case turnStart:
					for (int v=0; v < listaPlayer.size(); v++) {
						System.out.println("E' il turno di " + listaPlayer.get(v).getName() + "\n");
						
						//metodi per prelevare e depositare tiles
						System.out.print("Inserisci la riga sulla quale si trova la prima tile che vuoi prendere: ");
						int i = sc.nextInt();
						sc.nextLine();
						System.out.print("Inserisci la colonna sulla quale si trova la prima tile che vuoi prendere: ");
						int j = sc.nextInt();
						sc.nextLine();
						
						Tile[] t = new Tile[3];
						//t = removeTilesFromBoard(listaPlayer.get(v).getShelf(), i, j);
						
						if(listaPlayer.get(v).isShelfFull() == true && stato == GameState.turnStart) {
							stato = GameState.endPhase;
							lastTurnPlayer = v;
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
	
	private static int[] randPubGoals() {
		
		int[] goals = new int[2];
		
		Random rand = new Random();
		do {
			goals[0] = rand.nextInt(11);		//questo metodo definisce solo la generazione degli obb. comuni, starà poi al main calcolare i punteggi in base
			do{											//al numero di player e ordine conseguito.		
				goals[1] = rand.nextInt(11);
			}while(goals[0] == goals[1]);
		}while(goals[0] < 0 && goals[1] < 0);
		
		return goals;
	}
}
