package calculator;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GraphPanel extends JPanel {
	int width = this.getWidth();
	int height = this.getHeight();
	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(0, height/2, width, height/2);
		
	}

}
