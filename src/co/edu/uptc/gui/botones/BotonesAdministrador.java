package co.edu.uptc.gui.botones;

import javax.swing.*;

import co.edu.uptc.gui.Eventos;

import java.awt.*;

public class BotonesAdministrador extends JPanel {

    public BotonesAdministrador(Eventos eventos){
        setOpaque(false);
        setLayout(new GridLayout(2,3));

        JButton registrar = new JButton(Eventos.REGISTRAR);
        registrar.setActionCommand(Eventos.REGISTRAR);
        registrar.addActionListener(eventos);
        add(registrar);

        JButton buscar = new JButton(Eventos.BUSCAR);
        buscar.setActionCommand(Eventos.BUSCAR);
        buscar.addActionListener(eventos);
        add(buscar);

        JButton agregarUnidades = new JButton(Eventos.AGREGARUNIDADES);
        agregarUnidades.setActionCommand(Eventos.AGREGARUNIDADES);
        agregarUnidades.addActionListener(eventos);
        add(agregarUnidades);

        JButton eliminarProducto = new JButton(Eventos.ELIMINARPRODUCTO);
        eliminarProducto.setActionCommand(Eventos.ELIMINARPRODUCTO);
        eliminarProducto.addActionListener(eventos);
        add(eliminarProducto);
        
        JButton listaVentas= new JButton(Eventos.LISTAVENTAS);
        listaVentas.setActionCommand(Eventos.LISTAVENTAS);
        listaVentas.addActionListener(eventos);
        add(listaVentas);
    }
}
