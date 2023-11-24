package co.edu.uptc.gui.botones;

import javax.swing.*;

import co.edu.uptc.gui.Eventos;

import java.awt.*;

public class BotonesAdministrador extends ModeloBotones {

    public BotonesAdministrador(Eventos eventos){
        setOpaque(false);
        setLayout(new GridLayout(2,3));

        //BOTONES
        JButton registrar = botonNuevo(eventos, Eventos.REGISTRAR);
        JButton buscar = botonNuevo(eventos, Eventos.BUSCAR);
        JButton agregarUnidades = botonNuevo(eventos, Eventos.AGREGARUNIDADES);
        JButton eliminarProducto = botonNuevo(eventos, Eventos.ELIMINARPRODUCTO);
        JButton listaVentas= botonNuevo(eventos, Eventos.LISTAVENTAS);
        JButton cerrarSesion = botonNuevo(eventos, Eventos.CERRARSESION);

        //AÑADIMOS
        add(registrar);
        add(buscar);
        add(agregarUnidades);
        add(eliminarProducto);
        add(listaVentas);
        add(cerrarSesion);
    }
}
