import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class FourCircles  extends JComponent{
	   public void paintComponent(Graphics g)
	   {  
	      // Recover Graphics2D 
	      Graphics2D g2 = (Graphics2D) g;
	      double height = getHeight();
	      double width = getWidth();
	      g2.setColor(Color.DARK_GRAY);
	      Rectangle2D.Double back = new Rectangle2D.Double(0, 0, width, height);
	      g2.fill(back);
	      
	      // Draw the yellow Circle upper left
	      g2.setColor(Color.PINK);
	      Ellipse2D.Double pinkCircle = new Ellipse2D.Double(0, 0, width/2, height/2);
	      g2.fill(pinkCircle);
	      
	      //Draw the black Circle upper right
	      g2.setColor(Color.CYAN);
	      Ellipse2D.Double cyanCircle = new Ellipse2D.Double(width * .5, 0, width/2, height/2);
	      g2.fill(cyanCircle);
	      
	      //Draw the red Circle lower left
	      g2.setColor(Color.RED);
	      Ellipse2D.Double redCircle = new Ellipse2D.Double(0, height * .5, width/2, height/2);
	      g2.fill(redCircle);
	      
	      //Draw the orange Circle lower right
	      g2.setColor(Color.ORANGE);
	      Ellipse2D.Double orangeCircle = new Ellipse2D.Double(width * .5, height * .5, width/2, height/2);
	      g2.fill(orangeCircle);

	   }

}
