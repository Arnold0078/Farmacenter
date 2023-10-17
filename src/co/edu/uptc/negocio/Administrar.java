package co.edu.uptc.negocio;

import co.edu.uptc.conexion.Conexion;
import co.edu.uptc.persistencia.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Administrar extends Conexion {

    //////////////////////////////////////////// FUNCIONES DEL PROGRAMA ///////////////////////////////////

    /**
     * Guardamos el producto en la base de datos
     */
    public void guardarProducto(Producto producto) {

        PreparedStatement ps = null;
        Connection con = getConexion();
        try {

            ps= con.prepareStatement("INSERT INTO productos(nombre, marca, cantidad, precio, codigo) VALUE (?,?,?,?,?)");
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getMarca());
            ps.setInt(3, producto.getCantidad());
            ps.setInt(4, producto.getPrecio());
            ps.setInt(5, producto.getCodigo());
            ps.execute();


        } catch  (SQLException e) {
            System.err.println(e);


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

                return producto;

            }

            return null;

        } catch (SQLException e) {
            System.err.println(e);

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
    public void modificarCantidad(int cantidad, int codigo) {

        PreparedStatement ps=null;
        Connection con=getConexion();

        try {

            ps= con.prepareStatement("UPDATE productos SET cantidad=? WHERE codigo= ?");
            ps.setInt(1, cantidad);
            ps.setInt(2, codigo);

            ps.execute();

        } catch (SQLException e) {
            System.err.println(e);
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

    public void eliminarProducto(Producto producto ) {

        PreparedStatement ps=null;
        PreparedStatement ps2=null;
        Connection con=getConexion();


        try {

            ps=con.prepareStatement("DELETE FROM productos WHERE codigo=?");
            ps.setInt(1, producto.getCodigo());

            if (producto.getTipo().equals("COMERCIAL")) {
                ps2=con.prepareStatement("DELETE FROM productos_comerciales WHERE producto_id = ?");
            } else {
                ps=con.prepareStatement("DELETE FROM productos_genericos WHERE codigo=?");
            }

            ps2.setInt(1, producto.getId());
            ps2.execute();
            ps.execute();

        } catch (SQLException e) {
            System.err.println(e);
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    /////////////////////////////////////////// FIN FUNCIONES /////////////////////////////////////////////

    ////////////////////////////////////////////// LISTAS /////////////////////////////////////////////////

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

    /**
     * Retorna todos los productos genericos
     */
    public ArrayList<Producto> listaGenericos(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        try {
            ArrayList<Producto> lista = new ArrayList<Producto>();
            ps = con.prepareStatement("SELECT * FROM productos_genericos");
            rs = ps.executeQuery();

            while (rs.next()){
                Producto producto = new Producto();
                producto.setNombre(rs.getString("producto_id"));
                lista.add(producto);
            }
            return lista;
        }catch (SQLException e){
            System.err.println(e);
            return null;
        }finally {
            try {
                con.close();
            }catch (SQLException e){
                System.err.println(e);
            }
        }
    }

    /**
     * retorna todos los productos comerciales
     */
    public ArrayList<Producto> listaComerciales(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        try {
            ArrayList<Producto> lista = new ArrayList<Producto>();
            ps = con.prepareStatement("SELECT * FROM productos_genericos");
            rs = ps.executeQuery();

            while (rs.next()){
                Producto producto = new Producto();
                producto.setNombre(rs.getString("producto_id"));
                lista.add(producto);
            }
            return lista;
        }catch (SQLException e){
            System.err.println(e);
            return null;
        }finally {
            try {
                con.close();
            }catch (SQLException e){
                System.err.println(e);
            }
        }
    }

    ///////////////////////////////////////FINAL LISTAS//////////////////////////////////////////////////
}
