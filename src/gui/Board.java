package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import global.KnigthTour;

@SuppressWarnings("serial")
public class Board extends JPanel {

	private static Field[][] fields;

	public void paintBoard(int size) {
		
		removeAll();
		setLayout(new GridBagLayout());
		setBackground(Color.DARK_GRAY);

		fields = new Field[8][8];
		
		GridBagConstraints grid = new GridBagConstraints();
		
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				grid.gridx = col;
				grid.gridy = row;

				if ((col % 2 + row % 2) == 0 || (col % 2 + row % 2) == 2) {
					fields[row][col] = new Field(Color.WHITE);
				} else {
					fields[row][col] = new Field(Color.BLACK);
				}
				add(fields[row][col], grid);
			}
		}
	}

	public void paintNumbers() {
		for (int r = 0; r < KnigthTour.n; r++) {
			for (int c = 0; c < KnigthTour.n; c++) {
				fields[r][c].add(new JLabel(String.valueOf(KnigthTour.table[r][c])));
				fields[r][c].revalidate();
			}
		}
	}

}
