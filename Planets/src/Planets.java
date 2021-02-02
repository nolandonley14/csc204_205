import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;

import java.awt.BasicStroke;

public class Planets extends JComponent{
	
	private ArrayList<Color> colors;
	private ArrayList<Line2D.Double> lines;
	private int years;
	
	public Planets(ArrayList<Color> colorList, int y, ArrayList<Line2D.Double> lineList)
	{
		colors = colorList;
		lines = lineList;
		years = y;
		System.out.println(colors);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		double x = getWidth()/2;
		double y = getHeight()/2;
		
	for (int i = 0; i < years; i++)
	{
		g2.setColor(colors.get(i));
		for (int j = 0; j < lines.size(); j++)
		{
			g2.draw(lines.get(j));
		}
		
	}

}

}
