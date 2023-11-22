package co.edu.uptc.gui.ventanas;

import java.awt.*;

import co.edu.uptc.gui.Eventos;
import co.edu.uptc.gui.botones.BotonesInicio;
import co.edu.uptc.negocio.Administrar;
import co.edu.uptc.gui.paneles.PanelUsuarios;

import javax.swing.*;

public class VentanaPrincipal extends ModeloVentana{
	
	private VentanaAdministrador ventanaA;
	private Administrar administrar;
	private Eventos eventos;
	private PanelUsuarios panelUsuarios;
	
	public VentanaPrincipal() {
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(100, 200, 200));
		fondo.setLayout(new BorderLayout());

		administrar = new Administrar();
		panelUsuarios = new PanelUsuarios();
		eventos = new Eventos(this, administrar);
		BotonesInicio botones = new BotonesInicio(eventos);

		fondo.add(panelUsuarios, BorderLayout.CENTER);
		fondo.add(botones, BorderLayout.SOUTH);

		add(fondo);
	}
	
	
	
	
public static void main(String[] args) {
	VentanaPrincipal ventanaInicio= new VentanaPrincipal();
	ventanaInicio.setVisible(true);
}

}
