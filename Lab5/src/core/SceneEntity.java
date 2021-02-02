package core;

import java.awt.Graphics2D;
import java.util.LinkedList;
import util.ColoredShape;


public abstract class SceneEntity implements Drawable{

	protected double xRef;
	protected double yRef;
	protected LinkedList<ColoredShape> shapes;
	
	public SceneEntity() {
		shapes = new LinkedList<ColoredShape>();
	}
	
	public void draw(Graphics2D g2) {
		for (ColoredShape cs : shapes) {
			g2.setColor(cs.getColor());
			g2.draw(cs.getShape());
		}
	}
	
	
}
