package caminoaleatorio.practica10.pai;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * ProgramaciÃ³n de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, EspaÃ±a.
 */
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class RandomWalk {
	private Random engine;			// Motor de cálculo de números aleatorios.
	private Point startPoint;		// Punto de partida.
	private Point actualPoint;		// Punto actual.
	private int nRows;				// Número de filas.
	private int nCols;				// Número de columnas.
	private ArrayList<Point> walk;	// Lista de puntos visitados.
	
	/**
	 *  
	 * @param start Punto de inicio.
	 * @param rows Número de filas.
	 * @param cols Número de columnas.
	 */
	public RandomWalk(Point start, int rows, int cols) {
		setEngine(new Random());
		setWalk(new ArrayList<Point>());
		
		setStartPoint(start);
		setActualPoint(start);
		setnRows(rows);
		setnCols(cols);
		getWalk().add(start);
	}

	/**
	 * Calcula una dirección al azar.
	 * @return
	 */
	private Direction nextStep() {
		int choice = getEngine().nextInt(4);
		
		switch (choice) {
		case 0: return Direction.NORTH;
		case 1: return Direction.SOUTH;
		case 2: return Direction.EAST;
		case 3: return Direction.WEST;
		default: return null;
		}
	}
	/**
	 * Calcula el siguiente punto del camino.
	 * @return true si se pudo calcular otro punto.
	 */
	public boolean nextPosition() {
		Direction choice;
		Point newPosition = null;
	
		if (!boundaryReached(getActualPoint()))  {
			choice = nextStep();
		
			switch(choice) {
			case NORTH: newPosition = new Point((int)getActualPoint().getX(), (int)(getActualPoint().getY() - 1)); break;
			case SOUTH: newPosition = new Point((int)getActualPoint().getX(), (int)(getActualPoint().getY() + 1)); break;
			case EAST: newPosition = new Point((int)(getActualPoint().getX() + 1), (int)(getActualPoint().getY())); break;
			case WEST: newPosition = new Point((int)(getActualPoint().getX() - 1), (int)(getActualPoint().getY())); break;
			}
			getWalk().add(newPosition);
			setActualPoint(newPosition);
			return true;
		}
		return false;
	}
	/**
	 * Función que calcula si un punto pertenece a los límites.
	 * @param position Posición a analizar.
	 * @return true si es una posición del borde de la ventana.
	 */
	private boolean boundaryReached(Point position) {
		if (position.getX() == 0 || position.getX() == getnCols())
			return true;
		if (position.getY() == 0 || position.getY() == getnRows())
			return true;
		return false;
		
	}
	/**
	 * *****************************************************************************************Getters and Setters**********************************************************************************************
	 * 
	 */
	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getActualPoint() {
		return actualPoint;
	}

	public void setActualPoint(Point actualPoint) {
		this.actualPoint = actualPoint;
	}

	public int getnRows() {
		return nRows;
	}

	public void setnRows(int nRows) {
		this.nRows = nRows;
	}

	public int getnCols() {
		return nCols;
	}

	public void setnCols(int nCols) {
		this.nCols = nCols;
	}

	public ArrayList<Point> getWalk() {
		return walk;
	}

	
	public Random getEngine() {
		return engine;
	}

	public void setEngine(Random engine) {
		this.engine = engine;
	}

	public void setWalk(ArrayList<Point> walk) {
		this.walk = walk;
	}
}
