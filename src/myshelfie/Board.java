package myshelfie;

public class Board {
	int playercount;
	public Board(int i, int j, int playercount) {
		int[][] board= new int [i][j];
			for(int k=0; k<i; k++) {
				for(int l=0; l<j; l++) {
					board[k][l]=0;
				}
			}
	}
}


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