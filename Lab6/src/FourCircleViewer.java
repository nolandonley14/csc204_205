// Nolan Donley
// CSC 204
// Lab 6 

import java.awt.Color;

import javax.swing.JFrame;

public class FourCircleViewer {

	public static void main(String[] args) {
		
		
		  JFrame frame = new JFrame();
	      frame.setSize(450, 450);
	      frame.setTitle("Nolan's Four Circles");
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      

	      FourCircles component = new FourCircles();
	      frame.add(component);

	      frame.setVisible(true);
	}

}