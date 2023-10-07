package co.edu.uptc.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private Connection con = null;
    private String base = "farmacenter";
    private String url ="jdbc:mysql://localhost:3306/" + base;
    private String user = "root";
    private String password = "";

    public Connection getConexion (){
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection(url,user,password);
       }catch (Exception e){
           System.err.println(e);
       }
       return con;
    }
}
