package Lab;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;

import javax.swing.JPanel;

import core.SceneEntity;

public class GameViewPanel extends JPanel {
		private LinkedList<SceneEntity> entities;
		private SchoolBus defaultBus = new SchoolBus(20, 140);
		
		public GameViewPanel() {
			entities = new LinkedList<SceneEntity>();
			entities.add(new HouseWithDriveway());
			
			entities.add(defaultBus);

			Dimension d = new Dimension(500, 200);
			this.setMaximumSize(d);
			this.setMinimumSize(d);
			this.setPreferredSize(d);
		}
		
		public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D)g;
			
			for (SceneEntity e : entities)
				e.draw(g2d);
		}
		
		public void moveTheBus(double dx, double dy) {
			defaultBus.move(dx, dy);
		}

}
