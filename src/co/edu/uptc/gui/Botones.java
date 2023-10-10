package co.edu.uptc.gui;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class Botones extends JPanel {

    public Botones(Eventos eventos){
        setOpaque(false);

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
    }
}
