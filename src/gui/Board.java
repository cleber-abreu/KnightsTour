package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Board extends JPanel {

	static Field[][] fields = new Field[8][8];

	public Board() {

		setLayout(new GridBagLayout());
		setBackground(Color.DARK_GRAY);

		GridBagConstraints grid = new GridBagConstraints();
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				grid.gridx = col;
				grid.gridy = row;

				if ((col % 2 + row % 2) == 0 
						|| (col % 2 + row % 2) == 2) {
					fields[row][col] = new Field(Color.WHITE);
				} 
				else {
					fields[row][col] = new Field(Color.BLACK);
				}
				add(fields[row][col], grid); 
			}
		}
	}
	
	public void setFieldNumber(int row, int col, int i) {
//		System.out.print(row+","+col);
//		System.out.println(" "+i);
		
		fields[row][col].add(new JLabel(String.valueOf(i)));
		fields[row][col].repaint();
	}
}
