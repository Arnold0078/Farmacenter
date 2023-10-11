package co.edu.uptc.gui.tablas;

import co.edu.uptc.negocio.Administrar;
import co.edu.uptc.persistencia.Producto;

import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class TablaGenericos extends ModeloTabla{

    public TablaGenericos(Administrar administrar){
        setBorder(new TitledBorder("Productos Genericos"));
        setBackground(new Color(0,150,200));
        ArrayList<Producto> lista = administrar.listaGenericos();

        for (Producto producto: lista) {
            guardarDatos(producto.getNombre(), producto.getMarca(), producto.getCantidad(), producto.getPrecio(), producto.getCodigo());

        }

        añadirTabla();
    }
}
