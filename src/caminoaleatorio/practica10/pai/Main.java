package caminoaleatorio.practica10.pai;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Programación de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		 FrameCamino frame = new FrameCamino();
		 frame.setTitle("Camino aleatorio");
		 frame.setSize(500, 500);
	 	 frame.setLocationRelativeTo(null); // Center the frame
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true);
		 
		
		// frame.initialize();

	}

}
