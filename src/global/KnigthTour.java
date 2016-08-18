package global;

public class KnigthTour {

	private final static int[] H = {2, 1, -1, -2, -2, -1,  1,  2};
	private final static int[] V = {1, 2,  2,  1, -1, -2, -2, -1};
	public static int[][] table;
	public static int n = 8;
	public static int nt;

	public static boolean tour(int row, int col, int size) {
		n = size;
		nt = n * n;
		table = new int[n][n];
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				table[r][c] = 0;
			}
		}
		
		table[row][col] = 1;

		if (tryMove(2, row, col)) {
			
//			for (int r = 0; r < n; r++) {
//				for (int c = 0; c < n; c++) {
//					System.out.print(table[r][c] + "\t");
//				}
//				System.out.println();
//			}
			return true;
		} 
		else {
			return false;
		}
		
	}
	
	private static boolean tryMove(int i, int row, int col) {
		boolean done = (i > nt);
		int m = 0;
		int r, c;
		while (!done && m < 8) {
			r = row + H[m];
			c = col + V[m];
			
			if (r >= 0 && r < n 
					&& c >= 0 && c < n
					&& table[r][c] == 0) {
				
					table[r][c] = i;
					done = tryMove(i+1, r, c);
				
					if (!done) {
						table[r][c] = 0;
					}
			}
			m++;
		}
		return done;
	}
	
}
