package src.myshelfie;



public class matrix {
	private int [][]m;
	private int i;
	private int j;	
	public void matrix(int i, int j) {
		
		m= new int[i][j];
		for (int k=0; k<i; k++) {
			for(int n=0; n<j; j++) {
				m[k][n]=0;
			}
		}
}
;	
	
}
