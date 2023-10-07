package co.edu.uptc.gui.tablas;

import co.edu.uptc.negocio.Administrar;
import co.edu.uptc.persistencia.Producto;

import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class TablaGeneral extends ModeloTabla{

    public TablaGeneral(Administrar administrar){
        setBorder(new TitledBorder("Productos"));
        setBackground(new Color(0,175,200));
        ArrayList<Producto> lista = administrar.listaProductos();

        for (Producto producto: lista) {
            guardarDatos(producto.getNombre(), producto.getMarca(), producto.getCantidad(), producto.getPrecio(), producto.getCodigo());

        }

        añadirTabla();
    }
}
