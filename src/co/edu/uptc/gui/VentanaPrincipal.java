package co.edu.uptc.gui;

import co.edu.uptc.gui.tablas.TablaComerciales;
import co.edu.uptc.gui.tablas.TablaGeneral;
import co.edu.uptc.gui.tablas.TablaGenericos;
import co.edu.uptc.negocio.Administrar;
import co.edu.uptc.persistencia.Producto;
import co.edu.uptc.persistencia.Venta;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class VentanaPrincipal extends ModeloVentana {

    public VentanaPrincipal() {
        setLayout(new GridLayout(1, 2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Farmacenter");

        Administrar administrar = new Administrar();
        PanelRegistro panelRegistro = new PanelRegistro(administrar);
        Eventos eventos = new Eventos(this, administrar, panelRegistro);

        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(100,200,200));
        panel1.setBorder(new TitledBorder("Registrar producto"));
        panel1.setLayout(new BorderLayout());
        Botones botones = new Botones(eventos);
        panel1.add(panelRegistro, BorderLayout.CENTER);
        panel1.add(botones, BorderLayout.SOUTH);
        add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3, 1));
        TablaGeneral tablaGeneral = new TablaGeneral(administrar);
        TablaComerciales tablaComerciales = new TablaComerciales(administrar);
        TablaGenericos tablaGenericos = new TablaGenericos(administrar);
        panel2.add(tablaGeneral);
        panel2.add(tablaComerciales);
        panel2.add(tablaGenericos);
        add(panel2);
    }

    /**
     * Inicializamos el programa
     */
    public static void main(String[] args) {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.setVisible(true);
    }
}
