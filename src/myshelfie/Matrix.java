package myshelfie;

public class Matrix {
	//dichiarazione variabili
	private int[][] m;
	private int nI;	//numero max di righe
	private int nJ;	//numero max di colonne
	
	public Matrix(int i, int j) {	//costruttore matrice, Funziona!
		this.nI = i;
		this.nJ = j;
		int[][] m = new int[i][j];
		
		for (int k=0; k < i; k++) {
			for(int n=0; n < j; n++) {
				m [k][n]= 0;
			}
		};
		this.m = m;	//dopo la modifica assegna all'oggetto matrice la matrice attributo modificata
	}
	
	public void modMat(int i, int j, int value) {	//metodo di modifica delle singole celle della tabella
		//if(i <= nI && j <= nJ){
			this.m [i][j] = value;
		/*}else{
			System.out.println("Coding Error");
		}*/
	}
	
	public void modMatByArrayMaps(int[] iMap, int[] jMap, int value) {
		for(int i = 0; i < iMap.length; i++) {
			modMat(iMap[i]-1, jMap[i]-1, 7); //decrementa tutto di uno per adattare all'array che parte da 0 e non da 1, poi scrive nella tile ij il valore 7
		}
	}
	
	public void printTile(int i, int j) {
		System.out.print(this.m[i][j] + " ");
	}
}
