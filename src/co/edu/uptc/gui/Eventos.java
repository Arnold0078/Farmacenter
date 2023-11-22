package co.edu.uptc.gui;

import co.edu.uptc.gui.ventanas.VentanaPrincipal;
import co.edu.uptc.gui.ventanas.VentanaTabla;
import co.edu.uptc.negocio.Administrar;

import co.edu.uptc.persistencia.Producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Eventos implements ActionListener {

    public static final String REGISTRAR = "REGISTRAR";
    public static final String BUSCAR = "BUSCAR";
    public static final String AGREGARUNIDADES = "AGREGAR UNIDADES";
    public static final String VENDERPRODUCTO = "VENDER PRODUCTO";
    public static final String ELIMINARPRODUCTO = "ELIMINAR PRODUCTO";
    public static final String LISTAVENTAS="LISTA DE VENTAS";


    private VentanaPrincipal ventanaPrincipal;
    private Administrar administrar;
    private PanelRegistro panelRegistro;

    public Eventos(VentanaPrincipal ventanaPrincipal, Administrar administrar, PanelRegistro panelRegistro) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.administrar = administrar;
        this.panelRegistro = panelRegistro;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object decision = e.getActionCommand();

        if (decision.equals(REGISTRAR)) {//inicia el proceso para registrar el producto nuevo
            if (panelRegistro.obtenerProducto() != null) {//verificamos si el producto ingresado es apto para guardarlo en la base de datos
                Producto nuevo = panelRegistro.obtenerProducto();
                administrar.guardarProducto(nuevo);
                panelRegistro.limpiarJTextFields();
                JOptionPane.showMessageDialog(null, "Producto registrado", null, JOptionPane.INFORMATION_MESSAGE);
                ventanaPrincipal.setVisible(false);
                ventanaPrincipal = new VentanaPrincipal();
                ventanaPrincipal.setVisible(true);
            }
        } else if (decision.equals(BUSCAR)) {//Buscamos un producto mediante el codigo

            try {

                int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingrese el codigo del producto ", null, JOptionPane.INFORMATION_MESSAGE));

                if (administrar.buscarProducto(codigo) != null) {//verifica si el producto esta registrado en la base de datos
                    Producto producto = administrar.buscarProducto(codigo);
                    JOptionPane.showMessageDialog(null, "nombre del producto:" + producto.getNombre() + "\n codigo:" + producto.getCodigo()
                            + "\n marca:" + producto.getMarca() + "\n cantidad:" + producto.getCantidad() + "\n precio:" + producto.getPrecio() + "\n tipo:"
                            + producto.getTipo(), null, JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "producto no registrado", null, JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception n) {//verificamos si el cliente ingreso alguna letra en un dato numerico

                JOptionPane.showMessageDialog(null, "ingrese unicamente datos numericos", null, JOptionPane.ERROR_MESSAGE);
            }


        } else if (decision.equals(AGREGARUNIDADES)) {

            try {

                int codigo= Integer.parseInt(JOptionPane.showInputDialog(null,"por favor ingresar el codigo del producto",null,JOptionPane.INFORMATION_MESSAGE));

                if(administrar.buscarProducto(codigo)!=null) {
                    Producto producto= administrar.buscarProducto(codigo);

                    int agregarCantidad =Integer.parseInt(JOptionPane.showInputDialog(null,"porfavor ingrese la cantidad de unidades",null,JOptionPane.INFORMATION_MESSAGE));

                    int total=producto.getCantidad() + agregarCantidad;

                    administrar.modificarCantidad(total, codigo);
                    ventanaPrincipal.setVisible(false);
                    VentanaPrincipal ventanaPrincipal=new VentanaPrincipal();
                    
                    JOptionPane.showMessageDialog(null,"SE HAN AÑADIDO NUEVOS PRODUCTOS",null,JOptionPane.INFORMATION_MESSAGE);
                    ventanaPrincipal.setVisible(true);

                }else {
                    JOptionPane.showMessageDialog(null,"no se ha encontrado el producto",null,JOptionPane.ERROR_MESSAGE);
                }


            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null,"ingrese unicamente dato numericos",null,JOptionPane.ERROR_MESSAGE);
            }

        } else if (decision.equals(VENDERPRODUCTO)) {
            try {
                int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingrese el codigo del producto a vender", null, JOptionPane.INFORMATION_MESSAGE));
                Producto producto = administrar.buscarProducto(codigo);

                if (producto != null) {
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingrese la cantidad a vender", null, JOptionPane.INFORMATION_MESSAGE));

                    if (producto.getCantidad() >= cantidad) {
                        administrar.modificarCantidad((producto.getCantidad() - cantidad), codigo);
                        administrar.nuevaVenta(producto,cantidad);
                        JOptionPane.showMessageDialog(null, "Producto vendido", null, JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "cantidad no disponible ", null, JOptionPane.WARNING_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado o no registrado", null, JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception r) {
                JOptionPane.showMessageDialog(null, "ingrese unicamente datos numericos", null, JOptionPane.WARNING_MESSAGE);
            }

        } else if (decision.equals(ELIMINARPRODUCTO)) {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingrese el codigo del producto que desea eliminar", null, JOptionPane.INFORMATION_MESSAGE));
            Producto producto = administrar.buscarProducto(codigo);

            if (producto != null){
                administrar.eliminarProducto(producto);
                JOptionPane.showMessageDialog(null, "Producto eliminado", null, JOptionPane.INFORMATION_MESSAGE);

            }else{
                JOptionPane.showMessageDialog(null, "Producto no encontrado", null, JOptionPane.WARNING_MESSAGE);
            }

        }else if(decision.equals(LISTAVENTAS)) {
        	VentanaTabla ventanaTabla = new VentanaTabla(administrar);
        	ventanaTabla.setVisible(true);
        }
    }
}
