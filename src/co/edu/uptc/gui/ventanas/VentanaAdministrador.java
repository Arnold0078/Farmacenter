package co.edu.uptc.gui.ventanas;

import co.edu.uptc.gui.Eventos;
import co.edu.uptc.gui.paneles.PanelProductos;
import co.edu.uptc.gui.botones.BotonesAdministrador;
import co.edu.uptc.gui.tablas.TablaComerciales;
import co.edu.uptc.gui.tablas.TablaGeneral;
import co.edu.uptc.gui.tablas.TablaGenericos;
import co.edu.uptc.negocio.Administrar;
import co.edu.uptc.persistencia.Producto;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class VentanaAdministrador extends ModeloVentana {

    private Administrar administrar;
    private PanelProductos panelRegistro;
    public VentanaAdministrador(Eventos eventos, Administrar administrar) {
        setLayout(new GridLayout(1, 2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Farmacenter");

        this.administrar = administrar;
        panelRegistro = new PanelProductos(administrar);

        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(100, 200, 200));
        panel1.setBorder(new TitledBorder("Registrar producto"));
        panel1.setLayout(new BorderLayout());
        BotonesAdministrador botones = new BotonesAdministrador(eventos);
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
     * Verificamos si el producto a registrar es apto para la base de datos
     */
    public void registrarProducto (){
        if (panelRegistro.obtenerProducto() != null) {
            Producto nuevo = panelRegistro.obtenerProducto();
            administrar.guardarProducto(nuevo);
            panelRegistro.limpiarJTextFields();
            JOptionPane.showMessageDialog(null, "Producto registrado", null, JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
