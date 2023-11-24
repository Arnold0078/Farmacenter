package co.edu.uptc.gui.tablas;

import co.edu.uptc.negocio.Administrar;
import co.edu.uptc.persistencia.Producto;

import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class TablaComerciales extends ModeloTabla{

    int i = 7;
    ArrayList<Producto> lista;

    public TablaComerciales (Administrar administrar){
        setBorder(new TitledBorder("Productos Comerciales"));
        setBackground(new Color(0,160,180));
        lista = administrar.listaProductos();


        for (Producto producto: lista) {
            if(producto.getTipo().equals("COMERCIAL")){
                guardarDatos(producto.getNombre(), producto.getMarca(), producto.getCantidad(), producto.getPrecio(), producto.getCodigo());
            }
        }

        añadir();
    }

    public void borrarDato(Producto producto){
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getCodigo() == producto.getCodigo()){
                borrar(i);
            }
        }
    }

    public void guardarDato(Producto producto){
        guardarDatos(producto.getNombre(), producto.getMarca(), producto.getCantidad(), producto.getPrecio(), producto.getCodigo());
    }

}
