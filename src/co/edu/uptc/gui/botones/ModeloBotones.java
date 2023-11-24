package co.edu.uptc.gui.botones;

import co.edu.uptc.gui.Eventos;

import javax.swing.*;

public class ModeloBotones extends JPanel {

    /**
     * MODELO BASE PARA LA CREACION DE UN NUEVO BOTON
     * @param eventos RECIBE LA CLASE "Eventos"
     * @param nombre RECIBE EL NOMBRE DEL NUEVO BOTON
     * @return RETORNA EL NUEVO BOTON
     */
    public JButton botonNuevo(Eventos eventos, String nombre){
        JButton nuevo = new JButton(nombre);
        nuevo.setActionCommand(nombre);
        nuevo.addActionListener(eventos);
        return nuevo;
    }
}
