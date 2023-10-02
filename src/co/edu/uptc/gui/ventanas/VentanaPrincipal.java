package co.edu.uptc.gui.ventanas;

import javax.swing.*;

public class VentanaPrincipal extends ModeloVentana{

    public VentanaPrincipal(){
        setTitle("Farmacenter");
    }

    /**
     * Inicializamos el programa
     */
    public static void main(String[] args) {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.setVisible(true);
    }
}
