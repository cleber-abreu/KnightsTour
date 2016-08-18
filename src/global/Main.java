package global;
import gui.MainWindow;

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
		
//		Random r = new Random();
//		int x = r.nextInt(7);
//		int y = r.nextInt(7);
		
		int x = 7;
		int y = 2;
		
		table[x][y] = 1;

//		MainWindow window = new MainWindow();
		
		if (tryMove(2, x, y)) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(table[i][j] + "\t");
//					window.getBoard().setFieldNumber(i, j, table[i][j]);
				}
				System.out.println();
			}
//			window.getBoard().repaint();
		} else {
			System.out.println("deu ruim");
		}
		
	}

	
	static boolean tryMove(int i, int x, int y) {
//		System.out.println(x+","+y+" "+i);
		boolean done = (i > nt);
		int m = 0;
		int xn, yn;
		
		while (!done && m < 8) {
			xn = x + h[m];
			yn = y + v[m];
			
			if (xn >= 0 && xn < n 
					&& yn >= 0 && yn < n
					&& table[xn][yn] == 0) {
				
//					System.out.println(xn+","+yn+" "+i);
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
