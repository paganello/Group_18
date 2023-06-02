package structure;


public class Board {

	public BoxMatrix matrix;
	
	
	/*
	 * COSTRUTTORE
	 * */
	public Board(int nPlayers) {
				
		BoxMatrix matrix = new BoxMatrix(9,9);
		
		int[] iExceptMap = {1,1,1,1,1,1,1,2,2,2,2,2,2,3,3,3,3,4,6,7,7,7,7,8,8,8,8,8,8,9,9,9,9,9,9,9};  //array di coppie righe-colonne (coordinate) delle tiles da porre a non fillable
		int[] jExceptMap = {1,2,3,6,7,8,9,1,2,3,7,8,9,1,2,8,9,1,9,1,2,8,9,1,2,3,7,8,9,1,2,3,4,7,8,9};
		matrix.modFillableByArrayMaps(iExceptMap, jExceptMap, false);
		
		if(nPlayers == 2) {
			
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
}
