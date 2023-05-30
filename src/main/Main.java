package main;
import java.util.*;
import structure.*;


public class Main {
	public static void main(String[] args) {
		
		
		System.out.println("\nBENVENUTO IN");
		System.out.println("                  _____ _          _  __ _      ");				//NON MODIFICARE
		System.out.println("                 /  ___| |        | |/ _(_)     ");
		System.out.println("  _ __ ___  _   _\\ `--.| |__   ___| | |_ _  ___ ");
		System.out.println(" | '_ ` _ \\| | | |`--. \\ '_ \\ / _ \\ |  _| |/ _ \\");
		System.out.println(" | | | | | | |_| /\\__/ / | | |  __/ | | | |  __/");
		System.out.println(" |_| |_| |_|\\__, \\____/|_| |_|\\___|_|_| |_|\\___|");
		System.out.println("             __/ |                              ");
		System.out.println("            |___/                    by Gruop_18\n\n           ");

		
		GameState stato;
		int playerNum = 0;
		int lastTurnPlayer;
		int countLastTourn = 0;
		
		ArrayList<Player> listaPlayer= new ArrayList<Player>();
	
		Scanner sc = new Scanner(System.in);
		
		boolean retry = false;
		do {
			retry = false;
			
			try {
				System.out.print("Inserire il numero di giocatori (min: 2, max: 4): "); //ottengo in input il numero di giocatori, che è verificato alla fine di questo loop
				playerNum = sc.nextInt();
				
			}catch(InputMismatchException c){
				System.out.println("Devi inserire un NUMERO intero.\n");
				retry = true;
			}
			
			if(!retry) {
				if(playerNum < 2 || playerNum > 4) {
					System.out.println("Per favore inserire solo valori compresi tra 2 e 4.\n");
					retry = true;
				}
			}
			sc.nextLine();
			
		}while(retry);	
		
		System.out.println();
		int[] nGoals = randPubGoals();
		System.out.println();
		for(int i = 0; i < playerNum; i++) {
			System.out.print("Inserire il nome del giocatore " + (i+1) + ": ");
			
			if(sc.hasNextLine()) {
				String playerName = sc.nextLine();
				listaPlayer.add(new Player((i), nGoals, playerName,i+1));

			}else {
				System.out.println("Error (row 43): nextLine non found");
			}
		}
		
		Board tavolo= new Board(playerNum);
		tavolo.matrix.fillBoard();
			
		/*
		 * stampa della situazione attuale del tavolo*/
		
		stato = GameState.turnStart;
		
		do {
			switch (stato) {
							
				/*
				 * Fase di gioco (un player alla volta)
				 * */
				case turnStart:
					if(tavolo.matrix.checkIfBoardNeedToBeRefilled(playerNum)) {
						tavolo.matrix.fillBoard();
					}
					/* CODICE DI DEBUG
					 * 				
					BoxMatrix m = new BoxMatrix(6, 5);
					m.fillBoard();
					listaPlayer.get(0).setShelf(m);
					
					listaPlayer.get(0).getShelf().showTable();
					
					System.out.println("\n1) quale goal vuoi verificare?");
					int c = sc.nextInt();
					sc.nextLine();
					
					listaPlayer.get(0).getPrivateGoal().setGoalNumber(c);
					listaPlayer.get(0).getPrivateGoal().verifyAndComputePoints(listaPlayer.get(0).getShelf());
					System.out.println("end");
					int[] c = new int[2];
					
					System.out.println("\n1) quale goal vuoi verificare?");
					c[0] = sc.nextInt();
					sc.nextLine();
					
					System.out.println("\n2) quale goal vuoi verificare?");
					c[1] = sc.nextInt();
					sc.nextLine();
					
					listaPlayer.get(0).getPublicGoals().verify(listaPlayer.get(0).getShelf(), c);
					 * 
					 */

					
				
					for (int v=0; v < listaPlayer.size(); v++) {
						
						System.out.println("E' il turno di " + listaPlayer.get(v).getName() + "\n");
						tavolo.matrix.showTable();
						
						//metodi per prelevare e depositare tiles
						int i;
						int j;
						do {
							do{
								//System.out.print("Inserisci la riga sulla quale si trova la prima tile che vuoi prendere: ");
								i = getIntData("Inserisci la riga sulla quale si trova la prima tile che vuoi prendere: ");
								//sc.nextLine();
								if(i < 1 || i > 9) {
									System.out.println("Riga non valida!");
								}
							}while(i < 1 || i > 9);
							
							do {
								//System.out.print("Inserisci la colonna sulla quale si trova la prima tile che vuoi prendere: ");
								j = getIntData("Inserisci la colonna sulla quale si trova la prima tile che vuoi prendere: ");
								//sc.nextLine();
								if(j < 1 || j > 9) {
									System.out.println("Colonna non valida!");
								}
							}while(j < 1 || j > 9);
							
							if(!tavolo.matrix.getBox(i-1,j-1).isFillable() || !tavolo.matrix.getBox(i-1,j-1).isFull()) {
								System.out.println("La casella selezioanta non contiene una tessera!");
							}
							
							if (!tavolo.matrix.freeSide(i-1, j-1)) {
								System.out.println("La casella selezionata contiene una tessera che ha tutti i lati occupati.");
							}
							
						}while(!tavolo.matrix.getBox(i-1,j-1).isFillable() || !tavolo.matrix.getBox(i-1,j-1).isFull() || !tavolo.matrix.freeSide(i-1, j-1));
						
						Tile[] t = new Tile[3];
						t = tavolo.matrix.removeTilesFromBoard(i-1, j-1);	//decremento in quanto gli array vanno da 0 a 8 e non da 1 a 9
						
						System.out.println("Ecco la tua libreria!");
						listaPlayer.get(v).getShelf().showTable();
					
						do {
						System.out.print("\nInserisci la colonna dove vuoi inserire le tile selezionate: ");
						j = sc.nextInt();
						sc.nextLine();
							if(j<1||j>9) {
								System.out.println("Colonna non valida!");
							}
						}
						while (j<1||j>9);
						
						listaPlayer.get(v).getShelf().putTilesInPlayerShelf(t, j-1, v); //decremento in quanto l'array va da 0 a 4 e non da 1 a 5
					
						listaPlayer.get(v).getShelf().showTable();

						
						if(listaPlayer.get(v).isShelfFull() == true && stato == GameState.turnStart) {
							stato = GameState.endPhase;
							listaPlayer.get(v).endPhaseBonus();
							
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
					int contaSpareggio=1; //conteggio dei giocatori in situazione di parità per il primo posto
					for(int i=1; i<listaPlayer.size()-1;i++) {
						if(listaPlayer.get(i).getPoints()==listaPlayer.get(0).getPoints()) {
							contaSpareggio++;
						}
					}
					isNotSorted=true;
					while(isNotSorted) {
						isNotSorted=false;
						for (int i=0; i<contaSpareggio; i++) {
						if(listaPlayer.get(i+1).getOrder()<listaPlayer.get(i).getOrder()) {//bubble sort per order
							 tmp = listaPlayer.get(i);
								listaPlayer.set(i, listaPlayer.get(i+1));
								listaPlayer.set(i, tmp);
								isNotSorted = true;
						}
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
		/*goals[0] = 2; goals[1] = 3;*/
		System.out.print("PRIMO OBIETTIVO: ");
		showPubGoal (goals[0]);
		System.out.print("SECONDO OBIETTIVO: ");
		showPubGoal (goals[1]);
		return goals;
	}
	
	
	/*
	 * Metodo che stampa gli obiettivi comuni che sono stati randdomicamente selezionati
	 */
	private static void showPubGoal (int PubGoal) {
		System.out.print("Avere nella propria libreria ");
		switch (PubGoal) {
		case 0:
			System.out.println("sei gruppi separati formati ciascuno da due tessere adiacenti dello stesso tipo "
					+ " (le tessere di un gruppo possono essere diverse da quelle di un altro gruppo).");
			break;
		case 1:
			System.out.println("quattro tessere dello stesso tipo ai quattro angoli.");
			break;
		case 2:
			System.out.println("quattro gruppi separati formati ciascuno da quattro tessere adiacenti dello stesso"
					+ "tipo (le tessere di un gruppo possono essere diverse da quelle di un altro gruppo).");
			break;
		case 3:
			System.out.println("due gruppi separati di 4 tessere dello stesso tipo che formano un quadrato 2x2 "
					+ "(le tessere dei due gruppi devono esseredello stesso tipo).");
			break;
		case 4:
			System.out.println("Tre colonne formate ciascuna da 6 tessere di uno, due o tre tipi differenti "
					+ "(colonne diverse possono avere combinazioni diverse di tipi di tessere).");
			break;
		case 5:
			System.out.println("otto tessere dello stesso tipo (non ci sono restrizioni sulla posizione di queste tessere).");
			break;
		case 6:
			System.out.println("cinque tessere dello stesso tipo che formano una diagonale.");
			break;
		case 7:
			System.out.println("quattro righe formate ciascuna da 5 tessere di uno, due o tre tipi differenti "
					+ "(righe diverse possono avere combinazioni diverse di tipi di tessere).");
			break;
		case 8:
			System.out.println("due colonne formate ciascuna da 6 diversi tipi di tessere.");
			break;
		case 9:
			System.out.println("due righe formate ciascuna da 5 diversi tipi di tessere.");
			break;
		case 10:
			System.out.println("cinque tessere dello stesso tipo che formano una X.");
			break;
		case 11:
			System.out.println("cinque colonne di altezza crescente o decrescente (a partire dalla prima colonna "
					+ "a sinistra o a destra, ogni colonna successiva deve essere formata da una tessera in più; "
					+ "le tessere possono essere di qualsiasi tipo).");
			break;
		default:
			System.out.println("Obiettivo non trovato");
			break;
		}
    }
	
	/*
	 * Metodo pubblico per la gestione delle eccezioni in input
	 * */
	public static int getIntData(String r) {
		Scanner sc = new Scanner(System.in);
		int s = 0;
		boolean retry;
		do {
			retry = false;
			try {
				System.out.print(r);
				s = sc.nextInt();
			
			}catch(InputMismatchException c){
				System.out.println("Devi inserire un NUMERO intero.\n");
				retry = true;
			}catch(Exception c){
				System.out.println("Errore di inserimento: Devi inserire un NUMERO INTERO\n");
				retry = true;
			}
			sc.nextLine();
			
		}while(retry);
		
		return s;
	}
	
	/*
	 * Metodo pubblico per la gestione delle eccezioni in input
	 * */
	public String getStrData(String r) {
		Scanner sc = new Scanner(System.in);
		String s = "";
		boolean retry;
		do {
			retry = false;
			try {
				System.out.print(r);
				s = sc.nextLine();
				
			}catch(Exception c){
				System.out.println("Errore di inserimento: Devi inserire una stringa!\n");
				retry = true;
			}
			
			if(s == "" || s == "\n" || s == "\t" || s == " ") {
				System.out.println("Devi inserire una stringa!");
				retry = false;
			}
				
			sc.nextLine();
			
		}while(retry);
		
		return s;
	}
}
