package co.edu.uptc.negocio;

import co.edu.uptc.conexion.Conexion;
import co.edu.uptc.persistencia.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Administrar extends Conexion {

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
                producto.setTipo(resultado.getString("tipo"));

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

}
