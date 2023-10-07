package co.edu.uptc.gui;

import co.edu.uptc.gui.Eventos;

import javax.swing.*;
import java.awt.*;

public class Botones extends JPanel {

    public Botones(Eventos eventos){
        setBackground(new Color(100,200,200));

        JButton registrar = new JButton(Eventos.REGISTRAR);
        registrar.setActionCommand(Eventos.REGISTRAR);
        registrar.addActionListener(eventos);
        add(registrar);

        JButton buscar = new JButton(Eventos.BUSCAR);
        buscar.setActionCommand(Eventos.BUSCAR);
        buscar.addActionListener(eventos);
        add(buscar);
    }
}
