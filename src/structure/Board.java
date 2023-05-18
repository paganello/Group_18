package structure;


public class Board {

	public BoxMatrix matrix;
	
	
	/*
	 * COSTRUTTORE
	 * */
	public Board(int nPlayers) {
		
		/*
		this.nPlayers = nPlayers;
		Matrix tmpMatrix = new Matrix(9,9);

			int[] iExceptMap = {1,1,1,1,1,1,1,2,2,2,2,2,2,3,3,3,3,4,6,7,7,7,7,8,8,8,8,8,8,9,9,9,9,9,9,9};  //array di coppie righe-colonne (coocrdinate) delle tiles da porre a 7
			int[] jExceptMap = {1,2,3,6,7,8,9,1,2,3,7,8,9,1,2,8,9,1,9,1,2,8,9,1,2,3,7,8,9,1,2,3,4,7,8,9};
			tmpMatrix.modMatByArrayMaps(iExceptMap, jExceptMap, 7);
		
		if(nPlayers <= 2) {
			
			int[] iExceptTmpMap = {1,1,2,3,3,4,4,5,5,6,6,7,7,8,9,9};
			int[] jExceptTmpMap = {4,5,6,3,7,2,9,1,9,1,8,3,7,4,5,6};
			tmpMatrix.modMatByArrayMaps(iExceptTmpMap, jExceptTmpMap, 7);
			
		}else if(nPlayers == 3) {
			
			int[] iExceptTmpMap = {1,2,4,5,5,6,8,9};
			int[] jExceptTmpMap = {5,6,2,1,9,8,4,5};
			tmpMatrix.modMatByArrayMaps(iExceptTmpMap, jExceptTmpMap, 7);
			
		}
			
		this.matrix = tmpMatrix; //Assegna la matrice modificata all'oggetto matrice che è arributo di Board
		*/
		
		BoxMatrix matrix = new BoxMatrix(9,9);
		
		int[] iExceptMap = {1,1,1,1,1,1,1,2,2,2,2,2,2,3,3,3,3,4,6,7,7,7,7,8,8,8,8,8,8,9,9,9,9,9,9,9};  //array di coppie righe-colonne (coocrdinate) delle tiles da porre a 7
		int[] jExceptMap = {1,2,3,6,7,8,9,1,2,3,7,8,9,1,2,8,9,1,9,1,2,8,9,1,2,3,7,8,9,1,2,3,4,7,8,9};
		matrix.modFillableByArrayMaps(iExceptMap, jExceptMap, false);
		
		if(nPlayers <= 2) {
			
			int[] iExceptTmpMap = {1,1,2,3,3,4,4,5,5,6,6,7,7,8,9,9};
			int[] jExceptTmpMap = {4,5,6,3,7,2,9,1,9,1,8,3,7,4,5,6};
			matrix.modFillableByArrayMaps(iExceptTmpMap, jExceptTmpMap, false);
			
		}else if(nPlayers == 3) {
			
			int[] iExceptTmpMap = {1,2,4,5,5,6,8,9};
			int[] jExceptTmpMap = {5,6,2,1,9,8,4,5};
			matrix.modFillableByArrayMaps(iExceptTmpMap, jExceptTmpMap, false);
			
		}
		this.matrix = matrix;
	}
	
	/*
	 * Metodo che stampa
	 */
	public void showTable (int i, int j) {
		int n = this.matrix.getBox(i, j).getI();
		int m = this.matrix.getBox(i, j).getJ();
		System.out.print(" /t");
		for (int k=0; k<m; m++) {
			System.out.print(k + "/t");
		}
		System.out.println();
		
		for(int y=0; y<n; y++) {
			System.out.print(y + "/t");
			for (int x=0; x<m; x++) {
				switch(this.matrix.getBox(y, x).getTile().getColor()) {
				case 1:
					System.out.print("G/t"); //G=verde
					break;
				case 2:
					System.out.print("W/t"); //W=bianco
				    break;
				case 3:
					System.out.print("Y/t"); //Y=giallo
					break;
				case 4:
					System.out.print("B/t"); //B=blu
					break;
				case 5:
					System.out.print("A/t"); //A=azzurro
					break;
				case 6:
					System.out.print("P/t"); //P=rosa
					break;
				default:
					System.out.print(" /t");
					break;
				}
			}
			System.out.println();
		}
    }
}
