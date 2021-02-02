package Lab;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import core.SceneEntity;
import util.ColoredShape;

public class HouseWithDriveway extends SceneEntity {
	private static int DEFAULT_X_REF = 320;	
	private static int DEFAULT_Y_REF = 120;

	public HouseWithDriveway() {
		this(DEFAULT_X_REF, DEFAULT_Y_REF);
	}

	public HouseWithDriveway(int xx, int yy) {
		// TODO Auto-generated constructor stub
		//super();
		super.xRef = xx;
		super.yRef = yy;
		init();
	}

	private void init() {
		// driveway
		shapes.add(new ColoredShape(
				new Rectangle2D.Double(0, yRef + 40, 500, 20), Color.BLACK));
		
		// house
		shapes.add(new ColoredShape(
				new Rectangle2D.Double(xRef, yRef, 60, 30), Color.MAGENTA));
		shapes.add(new ColoredShape(
				new Rectangle2D.Double(xRef - 5, yRef - 10, 70, 10), Color.BLUE));
		shapes.add(new ColoredShape(
				new Rectangle2D.Double(xRef + 25, yRef + 15, 10, 15), Color.BLUE));
	}

}
