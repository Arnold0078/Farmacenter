package co.edu.uptc.gui;

import co.edu.uptc.gui.ventanas.VentanaAdministrador;
import co.edu.uptc.gui.ventanas.VentanaPrincipal;
import co.edu.uptc.gui.ventanas.VentanaTabla;
import co.edu.uptc.gui.ventanas.VentanaUsuario;
import co.edu.uptc.negocio.Administrar;

import co.edu.uptc.persistencia.Producto;
import co.edu.uptc.persistencia.Usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Eventos implements ActionListener {

    public static final String USUARIOS="INICIAR SESION USUARIOS";
    public static final String ADMINISTRADOR="INICIAR SESION ADMINISTRADOR";
    public static final String CERRARSESION = "CERRAR SESION";
    public static final String REGISTRARUSUARIO = "REGISTRAR USUARIO";
    public static final String REGISTRAR = "REGISTRAR";
    public static final String BUSCAR = "BUSCAR";
    public static final String AGREGARUNIDADES = "AGREGAR UNIDADES";
    public static final String ELIMINARPRODUCTO = "ELIMINAR PRODUCTO";
    public static final String LISTAVENTAS="LISTA DE VENTAS";


    private VentanaPrincipal ventanaPrincipal;
    private Administrar administrar;
    private VentanaAdministrador ventanaAdministrador;
    private VentanaUsuario ventanaUsuario;

    public Eventos(VentanaPrincipal ventanaPrincipal, Administrar administrar) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.administrar = administrar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object decision = e.getActionCommand();

        //////////////////////////////////////VENTANA PRINCIPAL/////////////////////////////////////////////////

        if(decision.equals(USUARIOS)) {//SE VERIFICA SI EL USUARIO QUE VA A INICIAR SESION EXISTE EN LA BASE DE DATOS
            Usuario usuario = ventanaPrincipal.sesionUsuario();
            if(usuario!= null){
                ventanaUsuario = new VentanaUsuario(this, administrar, usuario);
                ventanaPrincipal.setVisible(false);
                ventanaUsuario.setVisible(true);
            }
        }
        
        else if(decision.equals(ADMINISTRADOR)) {//SE VERIFICA SI EL ADMINISTRADOR QUE VA A INICIAR SESION EXISTE EN LA BASE DE DATOS
            ventanaAdministrador = new VentanaAdministrador(this, administrar);
            Usuario usuario = ventanaPrincipal.sesionAdministrador();
            if (usuario != null){
                ventanaPrincipal.setVisible(false);
                JOptionPane.showMessageDialog(null, "BIENVENIDO: ");
                ventanaAdministrador.setVisible(true);
            }
        }

        else if (decision.equals(REGISTRARUSUARIO)) {//SE VERIFICA SI EL NUEVO USUARIO ES APTO PARA REGISTRARSE
            ventanaPrincipal.guardarUsuario();
        }

        //////////////////////////////////////FIN VENTANA PRINCIPAL//////////////////////////////////////////////

        ///////////////////////////////////VENTANA DE ADMINISTRADOR/////////////////////////////////////////////

        else if (decision.equals(REGISTRAR)) {//inicia el proceso para registrar el producto nuevo
            ventanaAdministrador.registrarProducto();
        }

        else if (decision.equals(BUSCAR)) {//Buscamos un producto mediante el codigo

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


        }

        else if (decision.equals(AGREGARUNIDADES)) {

            try {

                int codigo= Integer.parseInt(JOptionPane.showInputDialog(null,"por favor ingresar el codigo del producto",null,JOptionPane.INFORMATION_MESSAGE));

                if(administrar.buscarProducto(codigo)!=null) {
                    Producto producto= administrar.buscarProducto(codigo);

                    int agregarCantidad =Integer.parseInt(JOptionPane.showInputDialog(null,"porfavor ingrese la cantidad de unidades",null,JOptionPane.INFORMATION_MESSAGE));

                    int total=producto.getCantidad() + agregarCantidad;

                    administrar.modificarCantidad(total, codigo);
                    ventanaAdministrador.setVisible(false);
                    VentanaAdministrador ventanaPrincipal=new VentanaAdministrador(this, administrar);
                    
                    JOptionPane.showMessageDialog(null,"SE HAN AÑADIDO NUEVOS PRODUCTOS",null,JOptionPane.INFORMATION_MESSAGE);
                    ventanaPrincipal.setVisible(true);

                }else {
                    JOptionPane.showMessageDialog(null,"no se ha encontrado el producto",null,JOptionPane.ERROR_MESSAGE);
                }


            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null,"ingrese unicamente dato numericos",null,JOptionPane.ERROR_MESSAGE);
            }

        }

        else if (decision.equals(ELIMINARPRODUCTO)) {
            try {
                int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingrese el codigo del producto que desea eliminar", null, JOptionPane.INFORMATION_MESSAGE));
                Producto producto = administrar.buscarProducto(codigo);

                if (producto != null){
                    ventanaAdministrador.eliminarProductoTabla(producto);
                    administrar.eliminarProducto(producto);
                    JOptionPane.showMessageDialog(null, "Producto eliminado", null, JOptionPane.INFORMATION_MESSAGE);

                }else{
                    JOptionPane.showMessageDialog(null, "Producto no encontrado", null, JOptionPane.WARNING_MESSAGE);
                }
            }catch (NumberFormatException exception){
                JOptionPane.showMessageDialog(null, "por favor no ingrese letras en el codigo a buscar", null, JOptionPane.WARNING_MESSAGE);
            }

        }

        else if(decision.equals(LISTAVENTAS)) {
        	VentanaTabla ventanaTabla = new VentanaTabla(administrar);
        	ventanaTabla.setVisible(true);
        }

        ///////////////////////////////////FIN VENTANA DE ADMINISTRADOR/////////////////////////////////////////////

        ///////////////////////////////////////////VENTANA DE USUARIO//////////////////////////////////////////////

        

        ///////////////////////////////////////////FIN VENTANA DE USUARIO//////////////////////////////////////////////


        else if (decision.equals(CERRARSESION)) {//CIERRA LA SESION DEL USUARIO O DEL ADMINISTRADOR
            if(ventanaUsuario != null && ventanaUsuario.isVisible()){
                ventanaUsuario.setVisible(false);
                ventanaPrincipal.setVisible(true);
            }else {
                ventanaAdministrador.setVisible(false);
                ventanaPrincipal.setVisible(true);
            }
        }
    }
}
