import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class DanceOfPlanets extends JComponent {
	
	static double outerDistance;
	static double outerDays;
	static double innerDistance;
	static double innerDays;
	static double years;
	static ArrayList<Line2D.Double> lines1st = new ArrayList<Line2D.Double>();
	static ArrayList<Line2D.Double> lines = new ArrayList<Line2D.Double>();
	static ArrayList<Color> colors = new ArrayList<Color>();
	static double sizeRatio;
	static double dayRatio;
	static double innerX;
	static double innerY;
	static int iD;
	

	public static void main(String[] args) {
		
		
		//describing the program to the user
		System.out.println("This program is going to show you the orbits of two made up planets from the user.");
		System.out.println("The user needs to input the radius of the outer planet and the inner planet as well");
		System.out.println("as the number of years they want the outer planet to orbit the sun. ENJOY :)");
		
		System.out.println();
		
		// asking the user to input the necessary variables
		Scanner scan = new Scanner(System.in);
		System.out.print("Please input the outer planet's distance from the sun: ");
		outerDistance = scan.nextDouble();
		System.out.print("Please input the outer planet's number of days it takes to orbit the sun: ");
		outerDays = scan.nextDouble();
		System.out.print("Please input the inner planet's distance from the sun: ");
		innerDistance = scan.nextDouble();
		System.out.print("Please input the inner planet's number of days it takes to orbit the sun: ");
		innerDays = scan.nextDouble();
		System.out.print("How many years do you want the outer planet to orbit the sun? ");
		years = scan.nextDouble();
		
		sizeRatio = innerDistance/outerDistance;
		outerDistance = 800;
		innerDistance = 800*sizeRatio;
		dayRatio = innerDays/outerDays;

		
		Coords outerCircle = new Coords(outerDistance, outerDistance);
		Coords innerCircle = new Coords(innerDistance, innerDistance);
		
		ArrayList<Coords> outerPoints = new ArrayList<Coords>();
		double outerDist = (2 * Math.PI) / outerDays;
			for (int i = 0; i < outerDays; i++)
			{
				outerCircle.x =  (Math.cos(outerDist*i)) * outerDistance;
				outerCircle.y = (Math.sin(outerDist*i)) * outerDistance  + outerDistance/2;
				Coords point = new Coords(outerCircle.x, outerCircle.y);
				outerPoints.add(point);	
			}
			
		ArrayList<Coords> innerPoints = new ArrayList<Coords>();
		double innerDist = 2 * Math.PI / innerDays*dayRatio;
			for (int i = 0; i < outerDays; i++)
			{
				innerCircle.x =  (Math.cos(innerDist*i)) * innerDistance/2 + outerDistance/2;
				innerCircle.y = (Math.sin(innerDist*i)) * innerDistance/2 + outerDistance/2;
				Coords point = new Coords(innerCircle.x, innerCircle.y);
				innerPoints.add(point);	
			}
			
			System.out.println(outerPoints);
			System.out.println(innerPoints);
			
			
			
			for (int i = 0; i < outerDays; i++)
			{
				for (int j = 0; j < 1; j++)
				{
					if (i >= innerDays)
					iD = (int) innerDays;
					innerX = innerPoints.get(i-iD).getX();
					innerY = innerPoints.get(i-iD).getY();
					Line2D.Double line = new Line2D.Double(outerPoints.get(i).getX(), outerPoints.get(i).getY(), innerX, innerY);
					lines1st.add(line);
				}
			}
		
			
			colors.add(Color.RED);
			colors.add(Color.BLUE);
			colors.add(Color.GREEN);
			colors.add(Color.PINK);
			colors.add(Color.MAGENTA);
			colors.add(Color.BLACK);
			colors.add(Color.ORANGE);
			
			for (int i = 0; i < years; i++)
			{
				for (int j = 0; j < lines1st.size(); j++)
				{
					Point2D P1 = lines1st.get(j).getP1();
					Point2D P2 = lines1st.get(j).getP2();
					Line2D.Double theLine = new Line2D.Double(P1, P2);
					lines.add(theLine);
					;
			
				}
			}
			
			
			JFrame frame = new JFrame();
			frame.setBackground(Color.DARK_GRAY);
			frame.setSize( (int) outerDistance, (int) outerDistance);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("Nolan's Dance of the Planets");

			Planets component = new Planets(colors, (int) years, lines);
			
			frame.add(component);
			frame.setVisible(true);
			
	}
	
		
}

					
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

