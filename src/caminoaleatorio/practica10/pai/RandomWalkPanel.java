package caminoaleatorio.practica10.pai;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * ProgramaciÃ³n de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, EspaÃ±a.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import javax.swing.JPanel;

public class RandomWalkPanel  extends JPanel{
	private int density;			// Número aproximado de casillas a dibujar.
	private int rows;				// Número de filas.
	private int cols;				// Número de columnas.
	private RandomWalk walk;		// Camino aleatorio.
	private Color color;			// Color con el que dibujar.
	
	/**
	 * 
	 * @param density Densidad deseada.
	 */
	public RandomWalkPanel(int density) {
		setDensity(density);
	}
	/**
	 * Calcula un único paso de la simulación y pinta.
	 */
	public void nextStep() {
		getWalk().nextPosition();
		repaint();
	}
	/**
	 * Calcula todos los pasos hasta el final de la simulación y luego pinta.
	 */
	public void continueWalk(){
		while (getWalk().nextPosition());
		repaint();
	}
	/**
	 * Reinicia la simulación.
	 */
	public void reset() {
		setWalk(new RandomWalk(new Point(getCols() / 2, getRows() / 2), getRows(), getCols()));
		repaint();
	}
	
	/**
	 * **************************************************************************Getters and Setters************************************************************************************************************
	 * 
	 */
	public int getDensity() {
		return density;
	}
	
	public void setDensity(int density) {
		this.density = density;
		int lines = (int)Math.sqrt(density);
		setRows(lines);
		setCols(lines);
		setWalk(new RandomWalk(new Point(getCols() / 2, getRows() / 2), getRows(), getCols()));
		repaint();
	}

	public RandomWalk getWalk() {
		return walk;
	}

	public void setWalk(RandomWalk walk) {
		this.walk = walk;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		repaint();
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	
	protected void paintComponent(Graphics g) {	
		super.paintComponent(g);	
		drawTable(g);	
		
		g.setColor(getColor());
		drawWalk(g);
		
		
	}
	/**
	 * Dibuja el camino en el panel.
	 * @param g
	 */
	protected void drawWalk(Graphics g) {
		double rowSpace = (double)this.getHeight() / (double)getRows();
		double colSpace = (double)this.getWidth() / (double)getCols();
		
		Polygon graphicWalk1 = new Polygon();
		Polygon graphicWalk2 = new Polygon();
		Polygon graphicWalk3 = new Polygon();
		Polygon graphicWalk4 = new Polygon();
		Polygon graphicWalk5 = new Polygon();
		
		for (int i = 0; i < getWalk().getWalk().size(); i++) {
			graphicWalk1.addPoint((int)(getWalk().getWalk().get(i).getX() * colSpace), (int)(getWalk().getWalk().get(i).getY() * rowSpace));
			graphicWalk2.addPoint((int)(getWalk().getWalk().get(i).getX() * colSpace - 1.0), (int)(getWalk().getWalk().get(i).getY() * rowSpace));
			graphicWalk3.addPoint((int)(getWalk().getWalk().get(i).getX() * colSpace + 1.0), (int)(getWalk().getWalk().get(i).getY() * rowSpace));
			graphicWalk4.addPoint((int)(getWalk().getWalk().get(i).getX() * colSpace), (int)(getWalk().getWalk().get(i).getY() * rowSpace + 1.0));
			graphicWalk5.addPoint((int)(getWalk().getWalk().get(i).getX() * colSpace), (int)(getWalk().getWalk().get(i).getY() * rowSpace - 1.0));
		}
		g.drawPolyline(graphicWalk1.xpoints, graphicWalk1.ypoints, graphicWalk1.npoints);
		g.drawPolyline(graphicWalk2.xpoints, graphicWalk2.ypoints, graphicWalk2.npoints);
		g.drawPolyline(graphicWalk3.xpoints, graphicWalk3.ypoints, graphicWalk3.npoints);
		g.drawPolyline(graphicWalk4.xpoints, graphicWalk4.ypoints, graphicWalk2.npoints);
		g.drawPolyline(graphicWalk5.xpoints, graphicWalk5.ypoints, graphicWalk3.npoints);
	}
	/**
	 * Dibuja la cuadricula.
	 * @param g
	 */
	protected void drawTable(Graphics g) {
		double rowSpace = (double)this.getHeight() / (double)getRows();
		double colSpace = (double)this.getWidth() / (double)getCols();
		
		g.setColor(Color.GRAY);
		
		for (int i = 1; i < getCols(); i++) {
			g.drawLine(0, (int)(i * rowSpace), this.getWidth(), (int)(i * rowSpace));
		}
		for (int i = 1; i < getRows(); i++) {
			g.drawLine((int)(i * colSpace), 0, (int)(i * colSpace), this.getHeight());
		}
	}
}
