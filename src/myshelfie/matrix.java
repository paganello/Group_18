package src.myshelfie;

public class matrix {
	//dichiarazione variabili
	private int [][]m;
	private int i;
	private int j;	
	
	//costruttore matrice
	public void Matrix(int i, int j) {
		this.i = i;
		this.j = j;
		this.m = new int[this.i][this.j];
		
		for (int k=0; k<this.i; k++) {
			for(int n=0; n<this.j; n++) {
				this.m [k][n]=0;
			}
		}
	}	
}
