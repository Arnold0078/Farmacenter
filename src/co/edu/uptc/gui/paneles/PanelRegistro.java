package co.edu.uptc.gui.paneles;

import co.edu.uptc.persistencia.Producto;

import javax.swing.*;

public class PanelRegistro extends ModeloPaneles{

    private JTextField jxNombre;
    private JTextField jxMarca;
    private JTextField jxCantidad;
    private JTextField jxPrecio;
    private JTextField jxCodigo;

    public PanelRegistro(){
        jxNombre = jx1(59);
        jxMarca = new JTextField(59);
        jxCantidad = new JTextField();
        jxPrecio = new JTextField();
        jxCodigo = new JTextField(5);
    }

    public Producto obtenerProducto(){
        try {
            Producto nuevo = new Producto();

            if (verificarRegistro()){
                nuevo.setNombre(jxNombre.getText());
                nuevo.setMarca(jxMarca.getText());
                nuevo.setCantidad(Integer.parseInt(jxCantidad.getText()));
                nuevo.setPrecio(Integer.parseInt(jxCantidad.getText()));
                nuevo.setCodigo(Integer.parseInt(jxCodigo.getText()));
            }

            return nuevo;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ingrese unicamente numeros (Cantidad, " +
                    "Precio, Codigo)", null, JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    private boolean verificarRegistro(){
        boolean v = true;
        String nombre = jxNombre.getText();
        String marca = jxMarca.getText();
        String cantidad = jxCantidad.getText();
        String precio = jxPrecio.getText();
        String codigo = jxCodigo.getText();


        if (nombre.isEmpty() || marca.isEmpty() || cantidad.isEmpty() || precio.isEmpty() || codigo.isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor rellene todos los " +
                    "espacios para registrar el producto", null, JOptionPane.WARNING_MESSAGE);
            v = false;
        }else if(codigo.length() < 5){
            JOptionPane.showMessageDialog(null, "El codigo del producto debe tener " +
                    "una longitud de 5", null, JOptionPane.WARNING_MESSAGE);
            v = false;
        }

        return v;
    }

}
