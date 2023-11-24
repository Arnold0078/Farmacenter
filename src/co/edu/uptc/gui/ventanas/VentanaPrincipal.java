package co.edu.uptc.gui.ventanas;

import java.awt.*;

import co.edu.uptc.gui.Eventos;
import co.edu.uptc.gui.botones.BotonesInicio;
import co.edu.uptc.negocio.Administrar;
import co.edu.uptc.gui.paneles.PanelUsuarios;
import co.edu.uptc.persistencia.Usuario;

import javax.swing.*;

public class VentanaPrincipal extends ModeloVentana{

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
		panelUsuarios = new PanelUsuarios(administrar);
		eventos = new Eventos(this, administrar);
		BotonesInicio botones = new BotonesInicio(eventos);

		fondo.add(panelUsuarios, BorderLayout.CENTER);
		fondo.add(botones, BorderLayout.SOUTH);

		add(fondo);
	}
	
	public Usuario sesionAdministrador(){
		try {
			int cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingrese su cedula", null, JOptionPane.INFORMATION_MESSAGE));
			String contraseña = JOptionPane.showInputDialog(null, "Por favor ingrese su contraseña", null, JOptionPane.INFORMATION_MESSAGE);

			Usuario sesionA = administrar.buscarUsuario(cedula, contraseña);

			if (sesionA != null && sesionA.getTipo().equals("ADMINISTRADOR")){
                return sesionA;
			}else {
				JOptionPane.showMessageDialog(null, "Cedula o contraseña incorrecta", null, JOptionPane.ERROR_MESSAGE);
			}

			return null;
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Por favor ingrese unicamente numeros en la cedula", null, JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	public Usuario sesionUsuario(){
		try {
			int cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingrese su cedula", null, JOptionPane.INFORMATION_MESSAGE));
			String contraseña = JOptionPane.showInputDialog(null, "Por favor ingrese su contraseña", null, JOptionPane.INFORMATION_MESSAGE);

			Usuario sesionU = administrar.buscarUsuario(cedula, contraseña);

			if (sesionU != null && sesionU.getTipo().equals("CLIENTE")){
				return sesionU;
			}else {
				JOptionPane.showMessageDialog(null, "Cedula o contraseña incorrecta", null, JOptionPane.ERROR_MESSAGE);
			}

			return null;
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Por favor ingrese unicamente numeros en la cedula", null, JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	public void guardarUsuario(){
		Usuario nuevo = panelUsuarios.nuevoUsuario();
		if (nuevo != null){
			administrar.registrarUsuario(nuevo);
			JOptionPane.showMessageDialog(null, "Usuario registrado", null, JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void main(String[] args) {
		VentanaPrincipal ventanaPrincipal= new VentanaPrincipal();
		ventanaPrincipal.setVisible(true);
	}

}
