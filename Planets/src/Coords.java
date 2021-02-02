
public class Coords {
	
	
	public double x;
	public double y;
	
	public Coords()
	{
		x = 0;
		y = 0;
	}
	
	public Coords(double xvalue, double yvalue)
	{
		x = xvalue;
		y = yvalue;
	}

	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
	public String toString()
	{
		String xval = String.format("%.2f", x);
		String yval = String.format("%.2f", y);
		
		
		return ("(" + xval + ", " + yval + ")");
	}
}
