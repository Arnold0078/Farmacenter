package co.edu.uptc.gui.botones;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;

import co.edu.uptc.gui.Eventos;

public class BotonesInicio extends ModeloBotones {

	public BotonesInicio(Eventos eventos) {
		setLayout(new GridLayout(1, 3));
		setOpaque(false);

		//BOTONES
		JButton registrarUsuario = botonNuevo(eventos, Eventos.REGISTRARUSUARIO);
		JButton usuarios = botonNuevo(eventos, Eventos.USUARIOS);
		JButton administrador = botonNuevo(eventos, Eventos.ADMINISTRADOR);

		//AÑADIMOS
		add(registrarUsuario);
		add(usuarios);
		add(administrador);
	}

}

