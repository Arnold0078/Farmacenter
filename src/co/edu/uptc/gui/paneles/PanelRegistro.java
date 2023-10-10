package co.edu.uptc.gui.paneles;

import co.edu.uptc.persistencia.Producto;

import javax.swing.*;
import java.awt.*;

public class PanelRegistro extends JPanel{

    private final JTextField jxNombre;
    private final JTextField jxMarca;
    private final JTextField jxCantidad;
    private final JTextField jxPrecio;
    private final JTextField jxCodigo;
    private final JTextField jxTipo;

    public PanelRegistro(){
        setLayout(new GridLayout(6,2));
        setOpaque(false);

        jxNombre = new JTextField(59);
        jxMarca = new JTextField(59);
        jxCantidad = new JTextField();
        jxPrecio = new JTextField();
        jxCodigo = new JTextField(5);
        jxTipo = new JTextField();

        JLabel jlNombre = new JLabel("Nombre del producto");
        JLabel jlMarca = new JLabel("Marca");
        JLabel jlCantidad = new JLabel("Cantidad");
        JLabel jlPrecio = new JLabel("Precio");
        JLabel jlCodigo = new JLabel("Codigo");
        JLabel jlTipo = new JLabel("Tipo (COMERCIAL o GENERICO)");

        add(jlNombre);
        add(jxNombre);
        add(jlMarca);
        add(jxMarca);
        add(jlCantidad);
        add(jxCantidad);
        add(jlPrecio);
        add(jxPrecio);
        add(jlCodigo);
        add(jxCodigo);
        add(jlTipo);
        add(jxTipo);

    }

    public Producto obtenerProducto(){
        try {
            Producto nuevo = new Producto();

            if (verificarRegistro()){
                nuevo.setNombre(jxNombre.getText().toUpperCase());
                nuevo.setMarca(jxMarca.getText().toUpperCase());
                nuevo.setCantidad(Integer.parseInt(jxCantidad.getText()));
                nuevo.setPrecio(Integer.parseInt(jxCantidad.getText()));
                nuevo.setCodigo(Integer.parseInt(jxCodigo.getText()));
                nuevo.setTipo(jxTipo.getText().toUpperCase());
            }

            return nuevo;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ingrese unicamente numeros en (Cantidad, " +
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
        String tipo = jxTipo.getText().toUpperCase();


        if (nombre.isEmpty() || marca.isEmpty() || cantidad.isEmpty() || precio.isEmpty() || codigo.isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor rellene todos los " +
                    "espacios para registrar el producto", null, JOptionPane.WARNING_MESSAGE);
            v = false;
        }else if(codigo.length() < 5){
            JOptionPane.showMessageDialog(null, "El codigo del producto debe tener " +
                    "una longitud de 5", null, JOptionPane.WARNING_MESSAGE);
            v = false;
        } else if (!tipo.equals("COMERCIAL") && !tipo.equals("GENERICO")){
            JOptionPane.showMessageDialog(null, "Por favor unicamente ingrese en el " +
                    "tipo (COMERCIAL o GENERICO)", null, JOptionPane.WARNING_MESSAGE);
            v = false;
        }

        return v;
    }

    public void limpiarJTextFields(){
        jxNombre.setText("");
        jxMarca.setText("");
        jxCantidad.setText("");
        jxPrecio.setText("");
        jxCodigo.setText("");
    }

}
