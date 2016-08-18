package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	
	private static Board board;
	
	public MainWindow() {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | 
                		InstantiationException | 
                		IllegalAccessException | 
                		UnsupportedLookAndFeelException e) {
                }
				
				JFrame frmMain = new JFrame("Knigh's Tour");
				setBoard(new Board());
//				JPanel pnlStatus = new JPanel();
				frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frmMain.setLayout(new BorderLayout());
				frmMain.setBackground(Color.DARK_GRAY);
				frmMain.add(new JButton("(Re)iniciar"), BorderLayout.NORTH);
				frmMain.add(getBoard(), BorderLayout.CENTER);
//				frmMain.add(pnlStatus, BorderLayout.SOUTH);
				frmMain.pack();
				frmMain.setLocationRelativeTo(null);
				frmMain.setVisible(true);
			}
		});
	}

	public Board getBoard() {
		return board;
	}

	public static void setBoard(Board board) {
		MainWindow.board = board;
	}
}
