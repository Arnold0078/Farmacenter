package co.edu.uptc.gui.tablas;

import co.edu.uptc.negocio.Administrar;
import co.edu.uptc.persistencia.Producto;

import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class TablaComerciales extends ModeloTabla{
    int i = 7;
    public TablaComerciales (Administrar administrar){

        super(obtenerLongitud(administrar));
        setBorder(new TitledBorder("Productos Comerciales"));
        setBackground(new Color(0,160,180));
        ArrayList<Producto> lista = administrar.listaProductos();


        for (Producto producto: lista) {
            if(producto.getTipo().equals("COMERCIAL")){
                guardarDatos(producto.getNombre(), producto.getMarca(), producto.getCantidad(), producto.getPrecio(), producto.getCodigo());
            }
        }

        añadirTabla();
    }

    public static int obtenerLongitud(Administrar administrar) {
        ArrayList<Producto> lista = new ArrayList<>();
        for(Producto p : administrar.listaProductos()) {
            if (p.getTipo().equals("COMERCIAL")) {
                lista.add(p);
            }
        }
        return lista.size();
    }

}
