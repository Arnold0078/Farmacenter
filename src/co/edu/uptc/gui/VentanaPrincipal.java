package co.edu.uptc.gui;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame{

    public VentanaPrincipal(){
        setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/logo.png"));
        setLayout(new BorderLayout());
        setSize(600,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
