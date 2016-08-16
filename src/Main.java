
public class Main {

	final static int n = 8;
	final static int nt = 64;
	final static int[] h = {2, 1, -1, -2, -2, -1,  1,  2};
	final static int[] v = {1, 2,  2,  1, -1, -2, -2, -1};
	static int[][] table;
	
	

	public static void main(String[] args) {

		table = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				table[i][j] = 0;
			}
		}
		
		table[0][0] = 1;
		
		if (tryMove(2, 0, 0)) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(table[i][j] + "\t");
				}
				System.out.println();
			}
		} else {
			System.out.println("deu ruim");
		}
	}

	
	static boolean tryMove(int i, int x, int y) {
		boolean done = (i > nt);
		int m = 0;
		int xn, yn;
		
		while (!done && m < n) {
			xn = x + h[m];
			yn = y + v[m];
			
			if (xn >= 0 && xn < n 
					&& yn >= 0 && yn < n
					&& table[xn][yn] == 0) {
				
					table[xn][yn] = i;
					done = tryMove(i+1, xn, yn);
				
					if (!done) {
						table[xn][yn] = 0;
					}
			}
			m++;
		}
		return done;
	}
}
