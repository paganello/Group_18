package myshelfie;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		
		
		//codice di debug
		System.out.println("inserisci numero giocatori= ");
		Scanner sc = new Scanner(System.in);
		int nPlayers = sc.nextInt();
	
	    //scorrimento di board per verificare le classi e relativi costruttori
		Board table = new Board(nPlayers);
	
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				table.matrix.printTile(i,j);
			}
		System.out.println();
		}
	}	
}
