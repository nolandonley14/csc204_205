package Lab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class GameTest {
	public static void main(String[] args) {
		final JFrame f = new JFrame("What A Nice Day!");

		GameViewPanel game = new GameViewPanel();
		f.add(game);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		class BusDriver implements ActionListener {
	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				game.moveTheBus(5, 0);
				
				f.repaint();
			}
			
		}
		
		JTextField status = new JTextField();
		status.setEnabled(false);
		status.setDisabledTextColor(Color.BLUE);
		
		// add bus starter
		JButton jbtnStart = new JButton("Start");
		final Timer t = new Timer(30, new BusDriver());
		jbtnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				t.start();
				status.setText("Game started!");
				f.repaint();
			}
			
		});
		
		JPanel controlPanel = new JPanel();
		controlPanel.add(jbtnStart);
		f.add(controlPanel, BorderLayout.WEST);
		f.add(status, BorderLayout.SOUTH);
		
		f.pack();
		f.setVisible(true);
	}

}

