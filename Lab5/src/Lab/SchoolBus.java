package Lab;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import core.Sprite;
import util.ColoredShape;

public class SchoolBus extends Sprite {

	public SchoolBus(int xRef, int yRef) {
		super(xRef, yRef);

		// yellow body
		shapes.add(new ColoredShape(
				new Rectangle2D.Double(xRef, yRef, 70, 30), Color.YELLOW));
		shapes.add(new ColoredShape(
				new Rectangle2D.Double(xRef + 70, yRef + 10, 10, 20), Color.YELLOW));
		
		// black wheels
		shapes.add(new ColoredShape(
				new Ellipse2D.Double(xRef + 20, yRef + 25, 10, 10), Color.BLACK));
		shapes.add(new ColoredShape(
				new Ellipse2D.Double(xRef + 60, yRef + 25, 10, 10), Color.BLACK));
	}
}

