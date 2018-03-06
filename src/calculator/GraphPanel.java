package calculator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GraphPanel extends JPanel {
	private String graphEquation;
	final int WIDTH = 792;
	final int HEIGHT = 600;
	private int xRange;
	private int yRange;
	//number of pixels per unit
	private double xPixels;
	private double yPixels;
	Graphics graph;
	
	
	public GraphPanel() {
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		graph = g;
		//Draw axis
		g.drawLine( 0, 600/2, 794, 600/2 );
		g.drawLine( 794/2, 0, 794/2, 600 );
		//Name axis
		g.drawString("X-axis", 744, 290);
		g.drawString("Y-axis", 792/2 + 5, 15);
		//draw origin
		g.drawString("(0,0)", 792/2 + 5, 315);
		
		/*for(int i = 0; i < WIDTH; i++) {
			//distance of x from origin
			double x = i - WIDTH / 2;
			x = x / xPixels;
			double y = ValidateEquation.evaluateExpression(graphEquation.replaceAll("x", String.valueOf(x))); 
			y = y * yPixels;
			y = HEIGHT - y;
			g.drawString("", i, (int)y);
		}*/
	}
	
	public void plotGraph() {
		for(int i = 0; i < WIDTH; i++) {
			//distance of x from origin
			double x = i - WIDTH / 2;
			x = x / xPixels;
			double y = ValidateEquation.evaluateExpression(graphEquation.replaceAll("x", String.valueOf(x))); 
			y = y * yPixels;
			y = HEIGHT - y;
			if(y > 0 && y < HEIGHT) {
			graph.drawString("-", i, (int)y);
			}
		}
	}
	
	public void setGraphEquation(String equation) {
		graphEquation = equation;
	}
	
	public String getGraphEquation() {
		return graphEquation;
	}
	
	public int getXRange() {
		return xRange;
	}
	
	public int getYRange() {
		return yRange;
	}
	
	public void setXRange(int range) {
		xRange = range;
		setXPixels();
	}
	
	public void setYRange(int range) {
		yRange = range;
		setYPixels();
	}
	
	public void setXPixels() {
		xPixels = WIDTH / xRange;
	}
	
	public void setYPixels() {
		yPixels = HEIGHT / yRange;
	}
	

}
