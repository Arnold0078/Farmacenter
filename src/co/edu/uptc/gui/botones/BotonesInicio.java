package co.edu.uptc.gui.botones;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;

import co.edu.uptc.gui.Eventos;

public class BotonesInicio extends JPanel{
	
public BotonesInicio(Eventos eventos) {
	setLayout(new GridLayout(1,3));
	setOpaque(false);

	JButton registrarUsuario = new JButton(Eventos.REGISTRARUSUARIO);
	registrarUsuario.setActionCommand(Eventos.REGISTRARUSUARIO);
	registrarUsuario.addActionListener(eventos);
	add(registrarUsuario);

	JButton usuarios =new JButton(Eventos.USUARIOS);
	usuarios.setActionCommand(Eventos.USUARIOS);
	usuarios.addActionListener(eventos);
	add(usuarios);

	JButton administrador = new JButton(Eventos.ADMINISTRADOR);
	administrador.setActionCommand(Eventos.ADMINISTRADOR);
	administrador.addActionListener(eventos);
	add(administrador);
	
}
	

}

