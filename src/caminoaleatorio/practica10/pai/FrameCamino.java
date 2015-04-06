package caminoaleatorio.practica10.pai;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * ProgramaciÃ³n de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, EspaÃ±a.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FrameCamino extends JFrame{
	private JPanel buttonsPanel;							// Panel con los botones.
	private JButton continuar;								// Boton que continuará con la simulación hasta el final sin mostrar la animación.
	private JButton reset;									// Boton de reset.
	private JButton densidad;								// Boton utilizado para modficar la densidad de casillas.
	private JButton color;									// Boton para cambiar el color.
	private JButton startStop;								// Boton de parar o continuar con la animación.
	private RandomWalkPanel randomWalkPanel;				// Panel donde se dibujará el camino.
	private Timer temporizador;								// Temporizador utilizado en la animación.
	public final int DEFAULT_DENSITY = 10000;
	public final Color DEFAULT_COLOR = Color.RED;
	public final int DELAY = 5;
	
	public FrameCamino() {
		setButtonsPanel(new JPanel());
		setContinuar(new JButton("Continuar"));
		setReset(new JButton("Reset"));
		setDensidad(new JButton ("Densidad"));
		setColor(new JButton("Color"));
		setStartStop(new JButton("Start"));
		setRandomWalkPanel(new RandomWalkPanel(DEFAULT_DENSITY));
		setTemporizador(new Timer(DELAY, new TimerHandler()));
		
		
		getContinuar().addActionListener(new ButtonsHandler());
		getStartStop().addActionListener(new ButtonsHandler());
		getColor().addActionListener(new ButtonsHandler());
		getDensidad().addActionListener(new ButtonsHandler());
		getReset().addActionListener(new ButtonsHandler());
		
		getButtonsPanel().setLayout(new GridLayout(1, 5));
		
		getButtonsPanel().add(getStartStop());
		getButtonsPanel().add(getContinuar());
		getButtonsPanel().add(getColor());
		getButtonsPanel().add(getDensidad());
		getButtonsPanel().add(getReset());
		
		getRandomWalkPanel().setBackground(Color.WHITE);
		getRandomWalkPanel().setColor(DEFAULT_COLOR);
	
		this.add(getRandomWalkPanel());
		this.add(getButtonsPanel(), BorderLayout.SOUTH);
		
		
	}
	/**
	 * ********************************************************************************Getters and setters 	************************************************************************************************
	 * 
	 * 
	 */
	public JPanel getButtonsPanel() {
		return buttonsPanel;
	}



	public void setButtonsPanel(JPanel buttonsPanel) {
		this.buttonsPanel = buttonsPanel;
	}



	public JButton getContinuar() {
		return continuar;
	}



	public void setContinuar(JButton continuar) {
		this.continuar = continuar;
	}



	public JButton getReset() {
		return reset;
	}



	public void setReset(JButton reset) {
		this.reset = reset;
	}



	public JButton getDensidad() {
		return densidad;
	}



	public void setDensidad(JButton densidad) {
		this.densidad = densidad;
	}



	public JButton getColor() {
		return color;
	}



	public void setColor(JButton color) {
		this.color = color;
	}



	public JButton getStartStop() {
		return startStop;
	}



	public void setStartStop(JButton startStop) {
		this.startStop = startStop;
	}



	public Timer getTemporizador() {
		return temporizador;
	}



	public void setTemporizador(Timer temporizador) {
		this.temporizador = temporizador;
	}



	public void setRandomWalkPanel(RandomWalkPanel randomWalkPanel) {
		this.randomWalkPanel = randomWalkPanel;
	}



	public RandomWalkPanel getRandomWalkPanel() {
		return randomWalkPanel;
	}

	public FrameCamino getThis() {
		return this;
	}
	
	/**
	 * Clase utilizada para el manejo de los botones.
	 * @author Sabato
	 *
	 */
	class ButtonsHandler implements ActionListener  {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == getStartStop()) {
				if (getTemporizador().isRunning()) {
					getTemporizador().stop();
					getStartStop().setText("Start");
				}
				else {
					getTemporizador().start();
					getStartStop().setText("Stop");
				}
			}
			else if(e.getSource() == getContinuar()) {
				getTemporizador().stop();
				getRandomWalkPanel().continueWalk();
				getStartStop().setText("Start");
			}
			else if (e.getSource() == getColor()) {
				Color color = JColorChooser.showDialog(getThis(), "Elija un color", Color.RED);
				if (color != null)
					getRandomWalkPanel().setColor(color);
			}
			else if (e.getSource() == getReset()) {
				getRandomWalkPanel().reset();
				getTemporizador().stop();
				getStartStop().setText("Start");
			}
			else if (e.getSource() == getDensidad()) {
				 DensityFrame frame = new DensityFrame("Indique el número aproximado de casillas", randomWalkPanel);
				 frame.setLocationRelativeTo(null); 
				 frame.setVisible(true);
				 getTemporizador().stop();
				 getStartStop().setText("Start");
			}
			
		}
		
	}
	
	/**
	 * Clase utilizada para manejar las acciones del temporizdor.
	 * @author Sabato
	 *
	 */
	class TimerHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			getRandomWalkPanel().nextStep();		
		}
		
	}

}
