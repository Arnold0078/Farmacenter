package co.edu.uptc.gui;

import javax.swing.JFrame;

import co.edu.uptc.gui.tablas.TablaVentas;
import co.edu.uptc.negocio.Administrar;

public class VentanaTabla extends ModeloVentana{
	
	private TablaVentas tablaVentas;
	
	
	public VentanaTabla(Administrar administrar) {

		setTitle("LISTA DE VENTAS");
		
		tablaVentas = new TablaVentas(administrar);
		add(tablaVentas);
	}
	

}
