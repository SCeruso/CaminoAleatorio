package caminoaleatorio.practica10.pai;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Programación de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DensityFrame extends InputTextFrame{
	
	private RandomWalkPanel randomWalk;

	/**
	 * Crea el frame para introducir la densidad.
	 * @param title
	 * @param walk Panel a modificar la densidad
	 */
	public DensityFrame(String title, RandomWalkPanel walk) {	
		super(title);

		setRandomWalk(walk);
		setHandler(new AceptarButtonHandler());
	}

	public RandomWalkPanel getRandomWalk() {
		return randomWalk;
	}

	public void setRandomWalk(RandomWalkPanel randomWalk) {
		this.randomWalk = randomWalk;
	}
	/**
	 * Listener para el boton aceptar.
	 * @author Sabato
	 *
	 */
	class AceptarButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Integer density;
			try {
				density = Integer.parseInt(getText());
				getRandomWalk().setDensity(density);
				dispose();
			}
			catch (Exception exc) {
				JOptionPane.showMessageDialog(null, "Formato erroneo");
			}
			
		}
		
	}
}
