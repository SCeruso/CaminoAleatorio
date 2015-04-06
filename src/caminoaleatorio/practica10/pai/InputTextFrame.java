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
import javax.swing.JTextField;

import caminoaleatorio.practica10.pai.DensityFrame.AceptarButtonHandler;

public class InputTextFrame extends JFrame{

	private JTextField textArea;
	private JButton aceptar;
	
	public final static int WIDTH = 400;
	public final static int HEIGHT = 100;
	
	/**
	 * Crea un cuadro de dialogo con un area de texto y un boton.
	 * @param title
	 */
	public InputTextFrame(String title) {
		this.setTitle(title);
		this.setSize(WIDTH, HEIGHT);	
		this.setLayout(new GridLayout(2, 1));
		setTextArea(new JTextField());
		setAceptar(new JButton ("Aceptar"));
		
		add(getTextArea());
		add(getAceptar());
		}

	public JTextField getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextField textArea) {
		this.textArea = textArea;
	}

	public JButton getAceptar() {
		return aceptar;
	}

	public void setAceptar(JButton aceptar) {
		this.aceptar = aceptar;
	}

	public String getText() {
		return textArea.getText();
	}
	
	/**
	 * A�ade un listener al boton aceptar.
	 * @param buttonHandler
	 */
	public void setHandler(ActionListener buttonHandler) {
		aceptar.addActionListener(buttonHandler);
	}
}
