package co.edu.uptc.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class VentanaPrincipal extends JFrame{

    private Tabla tabla;

    public VentanaPrincipal(){
        setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/logo.png"));
        setLayout(new GridLayout(1,2));
        setSize(1000,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Farmacenter");

        JPanel panel1 = new JPanel();
        panel1.setBorder(new TitledBorder("Registrar producto"));
        panel1.setLayout(new GridLayout(2,1));
        add(panel1);

        tabla = new Tabla();
        add(tabla);
    }

    /**
     * Inicializamos el programa
     */
    public static void main(String[] args) {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.setVisible(true);
    }
}
