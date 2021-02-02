package util;

import java.awt.Color;
import java.awt.Shape;

public final class ColoredShape {

	private Shape shape;
	private Color color;
	
	public ColoredShape(Shape shape, Color color) {
		this.shape = shape;
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
			
	public Shape getShape() {
		return shape;
	}
	
	
}
