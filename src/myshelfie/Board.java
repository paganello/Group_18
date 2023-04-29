package myshelfie;

public class Board {
	int nPlayers;
	Matrix matrix;
		
	public Board(int nPlayers) {
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