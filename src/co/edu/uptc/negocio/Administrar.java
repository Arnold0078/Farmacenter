package co.edu.uptc.negocio;

import co.edu.uptc.conexion.Conexion;
import co.edu.uptc.persistencia.Producto;
import co.edu.uptc.persistencia.Usuario;
import co.edu.uptc.persistencia.Venta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Administrar extends Conexion {

    public Usuario sesionActualU;

    //////////////////////////////////////////// FUNCIONES DEL PRODUCTO ////////////////////////////////////////////

    /**
     * Guardamos el producto en la base de datos
     */
    public void guardarProducto(Producto producto) {

        PreparedStatement ps = null;
        Connection con = getConexion();
        try {

            ps= con.prepareStatement("INSERT INTO productos(nombre, marca, cantidad, precio, codigo, tipo) VALUE (?,?,?,?,?,?)");
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getMarca());
            ps.setInt(3, producto.getCantidad());
            ps.setInt(4, producto.getPrecio());
            ps.setInt(5, producto.getCodigo());
            ps.setString(6,producto.getTipo());
            ps.execute();
            
           

        } catch  (SQLException e) {
            System.err.println("ERROR EN GUARDAR DATOS EN LA BASE DE DATOS");

        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }
    
    

    /**
     * Busca un producto en la base de datos y lo retorna
     * @return Producto
     */
    public Producto buscarProducto(int codigo) {

        PreparedStatement ps =null;
        ResultSet rs =null;
        Connection con = getConexion();

        try {

            ps= con.prepareStatement("SELECT * FROM productos WHERE codigo = ?");
            ps.setInt(1,codigo);

            rs = ps.executeQuery();

            if(rs.next()) {
                Producto producto= new Producto();
                producto.setNombre(rs.getString("nombre"));
                producto.setMarca(rs.getString("marca"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setCodigo(rs.getInt("codigo"));
                producto.setTipo(rs.getString("tipo"));

                return producto;

            }

            return null;

        } catch (SQLException e) {
            System.err.println("ERROR EN BUSCAR PRODUCTO EN LA BASE DE DATOS");

            return null;
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    /**
     * Modificamos la cantidad del uno de los productos
     */
    public boolean modificarCantidad(int cantidad, int codigo) {

        PreparedStatement ps=null;
        Connection con=getConexion();

        try {

            ps= con.prepareStatement("UPDATE productos SET cantidad=? WHERE codigo= ?");
            ps.setInt(1, cantidad);
            ps.setInt(2, codigo);

            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println("ERROR EN MODIFICAR PRODUCTO EN LA BASE DE DATOS");
            return false;
        }finally {
            try {
                con.close();

            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    /**
     * Eliminamos un producto en la base de datos
     */

    public void eliminarProducto(Producto producto) {

        PreparedStatement ps=null;
        PreparedStatement ps2=null;
        Connection con=getConexion();


        try {
            ps=con.prepareStatement("DELETE FROM productos WHERE codigo=?");
            ps.setInt(1, producto.getCodigo());

            ps.execute();

        } catch (SQLException e) {
            System.err.println("ERROR EN ELIMINAR PRODUCTO EN LA BASE DE DATOS");
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    /**
     * Retorna todos los productos que hay en la base de datos
     */
    public ArrayList<Producto> listaProductos(){
        PreparedStatement ps = null;
        ResultSet resultado = null;
        Connection con = getConexion();
        try {
            ArrayList<Producto> lista = new ArrayList<Producto>();
            ps = con.prepareStatement("SELECT * FROM productos");
            resultado = ps.executeQuery();

            while (resultado.next()) {
                Producto producto = new Producto();
                producto.setNombre(resultado.getString("nombre"));
                producto.setMarca(resultado.getString("marca"));
                producto.setCantidad(Integer.parseInt(resultado.getString("cantidad")));
                producto.setPrecio(Integer.parseInt(resultado.getString("precio")));
                producto.setCodigo(Integer.parseInt(resultado.getString("codigo")));
                producto.setTipo(resultado.getNString("tipo"));

                lista.add(producto);
            }

            return lista;
        }catch (SQLException e){
            System.out.println(e);
            return null;
        }finally {
            try {
                con.close();
            }catch (SQLException e){
                System.out.println(e);
            }
        }
    }

    ////////////////////////////////////////// FIN FUNCIONES PRODUCTO /////////////////////////////////////////////

    ///////////////////////////////////////////// FUNCIONES VENTAS ////////////////////////////////////////////////

    public void nuevaVenta (Producto producto, int cantidad){
        PreparedStatement ps = null;
        Connection con = getConexion();
        System.out.println(cantidad);
        try {

            ps = con.prepareStatement("INSERT INTO ventas(codigo, nombre_producto, cantidad) VALUE (?,?,?)");
            ps.setInt(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setInt(3, cantidad);
            System.out.println(producto.getCodigo()+" "+ producto.getNombre());
            ps.execute();

        }catch (SQLException e){
            System.out.println("ERROR GUARDANDO LA NUEVA VENTA EN LA BASE DE DATOS");
        }finally {
            try {
                con.close();
            }catch (SQLException e){
                System.out.println(e);
            }
        }
    }
    
    public ArrayList<Venta> ListaVentas(){
    	ArrayList<Venta> listaVentas =new ArrayList();
    	
    	PreparedStatement ps=null;
    	ResultSet resultado=null;
    	Connection con= getConexion();
    	
    	try {
    		ps= con.prepareStatement("SELECT * FROM ventas ");
    		resultado= ps.executeQuery();
    		while(resultado.next()) {
    			Venta venta = new Venta();
    			venta.setId(resultado.getInt("id_venta"));
    			venta.setCantidad(resultado.getInt("cantidad"));
    			venta.setCodigo(resultado.getInt("codigo"));
    			venta.setNombreProducto(resultado.getString("nombre_producto"));
    			listaVentas.add(venta);
    		}
    		
    		return listaVentas;
			
		} catch (SQLException e) {
			System.out.println("ERROR RETORNANDO LISTA DE VENTAS EN LA BASE DE DATOS");
			
			return null;
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
    	
    	
    }
    

    ////////////////////////////////////////// FIN FUNCIONES VENTAS ///////////////////////////////////////////////

    public void registrarUsuario(Usuario usuario) {

        PreparedStatement ps = null;
        Connection con = getConexion();
        try {

            if(usuario.getTipo() ==null) {//VERIFICA SI EL USUARIO A REGISTRAR ES UN CLIENTE

                if (usuario.getCelular() == 0){//VERIFICA SI EL CLIENTE AÑADIO UN NUMERO DE CELULAR

                    ps= con.prepareStatement("INSERT INTO usuarios(cedula, nombre, contraseña, correo) VALUE (?,?,?,?)");
                }else {
                    ps= con.prepareStatement("INSERT INTO usuarios(cedula, nombre, contraseña, correo, celular) VALUE (?,?,?,?,?)");
                }


            }else {
                if (usuario.getCelular() == 0){//VERIFICA SI EL ADMINISTRADOR AÑADIO UN NUMERO DE CELULAR
                    ps= con.prepareStatement("INSERT INTO usuarios(cedula, nombre, contraseña, correo, tipo) VALUE (?,?,?,?,?)");
                    ps.setString(5, usuario.getTipo());
                }else {
                    ps= con.prepareStatement("INSERT INTO usuarios(cedula, nombre, contraseña, correo, celular,tipo) VALUE (?,?,?,?,?,?)");
                    ps.setString(6, usuario.getTipo());
                }
            }

            if (usuario.getCelular() == 0){//VERIFICA SI HAY UN NUMERO DE CELULAR A REGISTRAR
                ps.setInt(1, usuario.getCedula());
                ps.setString(2, usuario.getNombre());
                ps.setString(3, usuario.getContraseña());
                ps.setString(4, usuario.getCorreo());
            }else {
                ps.setInt(1, usuario.getCedula());
                ps.setString(2, usuario.getNombre());
                ps.setString(3, usuario.getContraseña());
                ps.setString(4, usuario.getCorreo());
                ps.setInt(5, usuario.getCelular());
            }

            ps.execute();

        } catch (Exception e) {
            System.err.println("ERROR EN REGISTRAR USUARIO EN LA BASE DE DATOS");
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }


    public Usuario buscarUsuario(int cedula, String contraseña) {

        PreparedStatement ps =null;
        ResultSet rs =null;
        Connection con = getConexion();

        try {
            if (contraseña != null){
                ps= con.prepareStatement("SELECT * FROM usuarios WHERE cedula = ? AND contraseña = ?  ");
                ps.setInt(1,cedula);
                ps.setString(2, contraseña);
            }else {
                ps= con.prepareStatement("SELECT * FROM usuarios WHERE cedula = ? ");
                ps.setInt(1,cedula);
            }

            rs = ps.executeQuery();

            if(rs.next()) {
                Usuario usuarios= new Usuario();
                usuarios.setCedula(rs.getInt("cedula"));
                usuarios.setNombre(rs.getString("nombre"));
                usuarios.setContraseña(rs.getString("contraseña"));
                usuarios.setCorreo(rs.getString("correo"));
                usuarios.setCelular(rs.getInt("celular"));
                usuarios.setTipo(rs.getString("tipo"));

                return usuarios;

            }

            return null;

        } catch (SQLException e) {
            System.err.println("ERROR EN BUSCAR USUARIO EN LA BASE DE DATOS");

            return null;
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

}
