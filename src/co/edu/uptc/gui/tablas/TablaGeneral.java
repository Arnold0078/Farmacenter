package co.edu.uptc.gui.tablas;

import co.edu.uptc.negocio.Administrar;
import co.edu.uptc.persistencia.Producto;

import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class TablaGeneral extends ModeloTabla{

    ArrayList<Producto> lista;

    public TablaGeneral(Administrar administrar){
        setBorder(new TitledBorder("Productos"));
        setBackground(new Color(0,175,200));
        lista = administrar.listaProductos();

        for (Producto producto: lista) {
            guardarDatos(producto.getNombre(), producto.getMarca(), producto.getCantidad(), producto.getPrecio(), producto.getCodigo());

        }

        añadir();
    }

    public void guardarDato(Producto producto){
        guardarDatos(producto.getNombre(), producto.getMarca(), producto.getCantidad(), producto.getPrecio(), producto.getCodigo());
    }

    public void borrarDato(Producto producto){
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getCodigo() == producto.getCodigo()){
                borrar(i);
            }
        }
    }
}
