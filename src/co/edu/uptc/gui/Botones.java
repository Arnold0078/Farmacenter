package co.edu.uptc.gui;

import javax.swing.*;
import java.awt.*;

public class Botones extends JPanel {

    public Botones(Eventos eventos){
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
        agregarUnidades.setActionCommand(Eventos.BUSCAR);
        agregarUnidades.addActionListener(eventos);
        add(agregarUnidades);

        JButton venderProducto = new JButton(Eventos.VENDERPRODUCTO);
        venderProducto.setActionCommand(Eventos.VENDERPRODUCTO);
        venderProducto.addActionListener(eventos);
        add(venderProducto);

        JButton eliminarProducto = new JButton(Eventos.ELIMINARPRODUCTO);
        venderProducto.setActionCommand(Eventos.ELIMINARPRODUCTO);
        venderProducto.addActionListener(eventos);
        add(eliminarProducto);
    }
}
