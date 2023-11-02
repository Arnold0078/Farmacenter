package co.edu.uptc.gui;

import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class ModeloVentana extends JFrame {
	
	public ModeloVentana() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/logo.png"));
		setSize(1000, 600);
		setLocationRelativeTo(null);
	}

}
