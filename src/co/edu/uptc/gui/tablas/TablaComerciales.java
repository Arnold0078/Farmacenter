package co.edu.uptc.gui.tablas;

import co.edu.uptc.negocio.Administrar;
import co.edu.uptc.persistencia.Producto;

import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class TablaComerciales extends ModeloTabla{

    public TablaComerciales (Administrar administrar){
        setBorder(new TitledBorder("Productos Comerciales"));
        setBackground(new Color(0,160,180));
        ArrayList<Producto> lista = administrar.listaComerciales();

        for (Producto producto: lista) {
            guardarDatos(producto.getNombre(), producto.getMarca(), producto.getCantidad(), producto.getPrecio(), producto.getCodigo());

        }

        añadirTabla();
    }


}
