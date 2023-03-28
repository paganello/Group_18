package src.myshelfie;

public class board {
	public int playercount;

	matrix game= new matrix();
	game.matrix(9,9);
	game[1][1]=7;
	game[1][2]=7;
	game[1][3]=7;
	game[1][6]=7;
	game[1][7]=7;
	game[1][8]=7;
	game[1][9]=7;
	game[2][1]=7;
	game[2][2]=7;
	game[2][3]=7;
	game[2][7]=7;
	game[2][8]=7;	
	game[2][9]=7;
	game[3][2]=7;
	game[3][8]=7;
	game[3][9]=7;
	game[4][1]=7;
	game[7][1]=7;
	game[7][2]=7;
	game[7][8]=7;
	game[7][9]=7;
	game[8][1]=7;
	game[8][2]=7;
	game[8][3]=7;
	game[8][7]=7;
	game[8][8]=7;
	game[8][9]=7;
	game[9][1]=7;
	game[9][2]=7;
	game[9][3]=7;
	game[9][4]=7;
	game[9][7]=7;
	game[9][8]=7;
	game[9][9]=7;
	if (playercount<4) {
	game[1][5]=7;
	game[2][6]=7;
	game[4][2]=7;
	game[5][1]=7;
	game[5][9]=7;
	game[6][8]=7;
	game[8][4]=7;
	game[9][5]=7;
	if (playercount<3) {
		game[4][4]=7;
		game[3][3]=7;
		game[3][7]=7;
		game[4][9]=7;
		game[6][1]=7;
		game[7][3]=7;
		game[7][7]=7;
		game[9][6]=7;
		}
	}	
}
