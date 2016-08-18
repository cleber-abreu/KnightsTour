package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import global.KnigthTour;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	
	private static Board board;
	private static JPanel statusBar;
	private static JLabel lblStatus;
	private static JTextField txtX;
	private static JTextField txtY;
	private static JTextField txtSize;
	
	public static void main(String[] args) {
		
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
				
				board = new Board();
				board.paintBoard(KnigthTour.n);
				
				JButton btnStart = new JButton("Iniciar");
				btnStart.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						lblStatus.setText("Processando...");
						board.paintBoard(KnigthTour.n);
						if (KnigthTour.tour(Integer.parseInt(txtY.getText()), 
								Integer.parseInt(txtX.getText()), 
								Integer.parseInt(txtSize.getText()))) {
							board.paintNumbers();
							lblStatus.setText("Pronto");
						} else {
							lblStatus.setText("Ocorreu uma falha");
						}
						super.mouseClicked(arg0);
					}
				});
				
				JPanel pnlOptions = new JPanel();
				statusBar = new JPanel();

				txtX = new JTextField("0");
				txtY = new JTextField("0");
				txtSize = new JTextField("8");
				
				txtX.setPreferredSize(new Dimension(48, 32));
				txtY.setPreferredSize(new Dimension(48, 32));
				txtSize.setPreferredSize(new Dimension(48, 32));
				
				statusBar.setBackground(Color.LIGHT_GRAY);
				lblStatus = new JLabel(" ");
				statusBar.add(lblStatus);
				
				pnlOptions.add(new JLabel("X"));
				pnlOptions.add(txtX);
				pnlOptions.add(new JLabel("Y"));
				pnlOptions.add(txtY);
				pnlOptions.add(new JLabel("Tamanho"));
				pnlOptions.add(txtSize);
				pnlOptions.add(btnStart);
				
				frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frmMain.setLayout(new BorderLayout());
				frmMain.setBackground(Color.DARK_GRAY);
				frmMain.add(pnlOptions, BorderLayout.NORTH);
				frmMain.add(board, BorderLayout.CENTER);
				frmMain.add(statusBar, BorderLayout.SOUTH);
				frmMain.pack();
				frmMain.setLocationRelativeTo(null);
				frmMain.setVisible(true);
			}
		});
	}

}
