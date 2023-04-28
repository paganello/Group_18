package myshelfie;

public class Board {
	int playercount;
	Matrix matrix;
		
	public Board(int playercount) {
		this.playercount = playercount;
		Matrix matrix = new Matrix(9,9);

			int[] iExceptMap = {1,1,1,1,1,1,1,2,2,2,2,2,2,3,3,3,3,4,6,7,7,7,7,8,8,8,8,8,8,9,9,9,9,9,9,9};  //array di coppie righe-colonne (coocrdinate) delle tiles da porre a 7
			int[] jExceptMap = {1,2,3,6,7,8,9,1,2,3,7,8,9,1,2,8,9,1,9,1,2,8,9,1,2,3,7,8,9,1,2,3,4,7,8,9};

			changeTileValue(matrix, iExceptMap, jExceptMap);
		
		if(playercount <= 2) {
			
			int[] iExceptTmpMap = {1,1,2,3,3,4,4,5,5,6,6,7,7,8,9,9};
			int[] jExceptTmpMap = {4,5,6,3,7,2,9,1,9,1,8,3,7,4,5,6};
			
			changeTileValue(matrix, iExceptTmpMap, jExceptTmpMap);
			
		}else if(playercount == 3) {
			
			int[] iExceptTmpMap = {1,2,4,5,5,6,8,9};
			int[] jExceptTmpMap = {5,6,2,1,9,8,4,5};
			
			changeTileValue(matrix, iExceptTmpMap, jExceptTmpMap);
			
		}
			
		this.matrix = matrix; //Assegna la matrice modificata all'oggetto matrice che è arributo di Board
	}
	
	
	
	private void changeTileValue(Matrix matrix, int[] iExceptMap, int[] jExceptMap) {
		
		for(int i = 0; i < iExceptMap.length; i++) {
			matrix.modmat(iExceptMap[i]-1, jExceptMap[i]-1, 7); //decrementa tutto di uno per adattare all'array che parte da 0 e non da 1, poi scrive nella tile ij il valore 7
		}
		
		this.matrix = matrix; //Assegna la matrice modificata all'oggetto matrice che è arributo di Board
	}
}



/*
[1][1]= 7;
[1][2]= 7;
[1][6]= 7;
[1][7]= 7;
[1][8]= 7;
[1][9]= 7;
[2][1]= 7;
[2][2]= 7;
[2][3]= 7;
[2][7]= 7;
[2][8]= 7;	
[2][9]= 7;
[3][2]= 7;
[3][8]= 7;
[3][9]= 7;
[4][1]= 7;
[7][1]= 7;
[7][2]= 7;
[7][8]= 7;
[7][9]= 7;
[8][1]= 7;
[8][2]= 7;
[8][3]= 7;
[8][7]= 7;
[8][8]= 7;
[8][9]= 7;
[9][1]= 7;
[9][2]= 7;
[9][3]= 7;
[9][4]= 7;
[9][7]= 7;
[9][8]= 7;
[9][9]= 7;

if (playercount<4) {
	[1][5]=7;
	[2][6]=7;
	[4][2]=7;
	[5][1]=7;
	[5][9]=7;
	[6][8]=7;
	[8][4]=7;
	[9][5]=7;
if (playercount<3) {
	[4][4]=7;
	[3][3]=7;
	[3][7]=7;
	[4][9]=7;
	[6][1]=7;
	[7][3]=7;
	[7][7]=7;
	[9][6]=7;


}
*/