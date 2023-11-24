package co.edu.uptc.gui.ventanas;

import co.edu.uptc.gui.Eventos;
import co.edu.uptc.negocio.Administrar;
import co.edu.uptc.persistencia.Usuario;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class VentanaUsuario extends ModeloVentana{
    private Administrar administrar;
    private Usuario usuario;

    public VentanaUsuario(Eventos eventos, Administrar administrar, Usuario usuario){
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Farmacenter/Usuario");

        this.administrar = administrar;
        this.usuario = usuario;

        JPanel fondo = new JPanel();
        fondo.setBorder(new TitledBorder("Bienvenid@ " + usuario.getNombre()));

        add(fondo);

    }
}
