package myshelfie;

public class Matrix {
	//dichiarazione variabili
	private int [][]m;
	private int i;
	private int j;	
	
	//costruttore matrice
	public Matrix(int i, int j) {
		this.i = i;
		this.j = j;
		m = new int[this.i][this.j];
		
		for (int k=0; k <= this.i; k++) {
			for(int n=0; n <= this.j; n++) {
				m [k][n]= 0;
			}
		}
	}
	public Matrix modmat(Matrix mat, int i, int j, int value) {
		this.i=i;
		this.j=j;
		int mat [i][j]= 7;
		
	}
}