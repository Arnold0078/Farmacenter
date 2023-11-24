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
    private Eventos eventos;
    private TablaGeneral tablaGeneral;
    private TablaGenericos tablaGenericos;
    private TablaComerciales tablaComerciales;

    public VentanaAdministrador(Eventos eventos, Administrar administrar) {
        setLayout(new GridLayout(1, 2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Farmacenter/Administrador");

        this.administrar = administrar;
        this.eventos = eventos;
        panelRegistro = new PanelProductos(administrar);

        add(registro());
        add(tablas());
    }

    /**
     * Verificamos si el producto a registrar es apto para la base de datos
     */
    public void registrarProducto (){
        Producto nuevo = panelRegistro.obtenerProducto();
        if (nuevo != null) {
            administrar.guardarProducto(nuevo);
            panelRegistro.limpiarJTextFields();

            //Agregando a las tablas de los productos
            tablaGeneral.guardarDato(nuevo);
            if(nuevo.getTipo().equals("COMERCIAL")) {
                tablaComerciales.guardarDato(nuevo);
            }else {
                tablaGenericos.guardarDato(nuevo);
            }

            JOptionPane.showMessageDialog(null, "Producto registrado", null, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private JLabel registro(){
        JLabel izquierda = new JLabel();
        izquierda.setBackground(new Color(100, 200, 200));
        izquierda.setBorder(new TitledBorder("Registrar producto"));
        izquierda.setLayout(new BorderLayout());
        BotonesAdministrador botones = new BotonesAdministrador(eventos);
        izquierda.add(panelRegistro, BorderLayout.CENTER);
        izquierda.add(botones, BorderLayout.SOUTH);
        return izquierda;
    }

    private JLabel tablas(){
        JLabel derecha = new JLabel();
        derecha.setLayout(new GridLayout(3, 1));
        tablaGeneral = new TablaGeneral(administrar);
        tablaComerciales = new TablaComerciales(administrar);
        tablaGenericos = new TablaGenericos(administrar);
        JScrollPane jsGeneral = new JScrollPane(tablaGeneral);
        JScrollPane jsComerciales = new JScrollPane(tablaComerciales);
        JScrollPane jsGenericos = new JScrollPane(tablaGenericos);
        derecha.add(jsGeneral);
        derecha.add(jsComerciales);
        derecha.add(jsGenericos);
        return derecha;
    }

    public void eliminarProductoTabla(Producto producto){
        tablaGeneral.borrarDato(producto);

        if (producto.getTipo().equals("COMERCIAL")){
            tablaComerciales.guardarDato(producto);
        }else {
            tablaGenericos.borrarDato(producto);
        }
    }
}
