package core;

import java.awt.Shape;
import java.util.LinkedList;

import util.ColoredShape;
import util.ShapeTransform;

public abstract class Sprite extends SceneEntity implements Moveable {

	public Sprite(int xRef, int yRef) {
		// TODO Auto-generated constructor stub
		super();
		super.xRef = xRef;
		super.yRef = yRef;
	}

	@Override
	public void move(double dx, double dy) {
		// TODO Auto-generated method stub
		xRef += dx;
		yRef += dy;		
		
		LinkedList<ColoredShape> newShapes = new LinkedList<ColoredShape>();
		for (ColoredShape cs : shapes) {
			//System.out.println("Before:" + s.getBounds2D().getX());
			Shape s = ShapeTransform.translateShape(cs.getShape(), dx, dy);
			newShapes.add(new ColoredShape(s, cs.getColor()));
			//System.out.println("After:" + s.getBounds2D().getX());
		}
		
		shapes = newShapes;
	}
}

