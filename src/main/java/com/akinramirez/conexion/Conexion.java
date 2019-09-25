package com.akinramirez.conexion;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
  Connection con = null;
  
  public Conexion(){
//    String urlBD = "jdbc:postgresql://localhost:5432/apirestfuljersey";
//    String userDB = "postgres";
//    String passDB = "ReadyIS2019#";  
    try {
//      Class.forName("com.mysql.jdbc.Driver");
      Class.forName("org.mariadb.jdbc.Driver");
//      con = DriverManager.getConnection(urlBD, userDB, passDB);
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/apirestfuljersey", "root", "");
    } catch (SQLException ex) {
      System.out.println("EXCEPCION!" + ex.getMessage());
    } catch (ClassNotFoundException ex) {
      System.out.println("Excepción no encontró driver: " + ex.getMessage());
    }
  }
  
  public Connection getConnection(){
    return con;
  }
  
  public void desconectar(){
    System.out.println("Cerrar conecion a base de datos");
    if(con != null){
      try {
        con.close();
      } catch (SQLException ex) {
        System.out.println("No se realizo la desconexion : " + ex.getMessage());
      }
    }
  }
  
}
