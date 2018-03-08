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
	private Color strokeColor = Color.BLACK;
	
	private int xMin;
	private int xMax;
	private int yMin;
	private int yMax;
	
	
	public GraphPanel() {
		
	}
	

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		graph = g;
		//Draw axis
		graph.drawLine( 0, 600/2, 794, 600/2 );
		graph.drawLine( 794/2, 0, 794/2, 600 );
		//Name axis
		graph.drawString("X-axis", 744, 290);
		graph.drawString("Y-axis", 792/2 + 5, 15);
		//draw origin
		graph.drawString("(0,0)", 792/2 + 5, 315);
		
		if (graphEquation != null) {
			g.setColor(strokeColor);
			plotGraph();
		}
		
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
		for(int i = xMin; i < xMax; i++) {
			//distance of x from origin
//			double x = i - WIDTH / 2;
//			x = x / xPixels;
			double y = ValidateEquation.evaluateExpression(graphEquation.replaceAll("x", String.valueOf(i))); 
			y = y / yRange;
			y = HEIGHT / 2 - y;
			if (y > 0 && y < HEIGHT) {
				graph.drawString(".", i + WIDTH / 2, (int) y);
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
	
	public void setStrokeColor(Color color) {
		strokeColor = color;
	}
	
	public Color getStrokeColor() {
		return strokeColor;
	}


	public int getxMin() {
		return xMin;
	}


	public void setxMin(int xMin) {
		this.xMin = xMin;
	}


	public int getxMax() {
		return xMax;
	}


	public void setxMax(int xMax) {
		this.xMax = xMax;
	}


	public int getyMin() {
		return yMin;
	}


	public void setyMin(int yMin) {
		this.yMin = yMin;
	}


	public int getyMax() {
		return yMax;
	}


	public void setyMax(int yMax) {
		this.yMax = yMax;
	}
	
	
	

}
