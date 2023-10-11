package co.edu.uptc.negocio;

import co.edu.uptc.conexion.Conexion;
import co.edu.uptc.persistencia.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Administrar extends Conexion {

    ////////////////////////////////////////////LISTAS///////////////////////////////////////////

    /**
     * Retorna todos los productos que hay en la base de datos
     */
    public ArrayList<Producto> listaProductos(){
        PreparedStatement preparar = null;
        ResultSet resultado = null;
        Connection con = getConexion();
        try {
            ArrayList<Producto> lista = new ArrayList<Producto>();
            preparar = con.prepareStatement("SELECT * FROM productos");
            resultado = preparar.executeQuery();

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
                producto.setNombre(rs.getString("nombre"));
                producto.setMarca(rs.getString("marca"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setCodigo(rs.getInt("codigo"));
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
                producto.setNombre(rs.getString("nombre"));
                producto.setMarca(rs.getString("marca"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setCodigo(rs.getInt("codigo"));
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
