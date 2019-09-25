package com.akinramirez.dao;

import com.akinramirez.conexion.Conexion;
import com.akinramirez.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {

  Conexion conex = new Conexion();
  Connection con;
  PreparedStatement ps;
  ResultSet rs;
  int respuesta;
  String mensaje;

  public List listar() {
    List<Categoria> listaCategoria = new ArrayList<>();
    String sql = "SELECT * FROM TBL_CATEGORIAS";

    try {
      con = conex.getConnection();
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();

      while (rs.next()) {
        Categoria cat = new Categoria();
        cat.setIdCategoria(rs.getLong(1));
        cat.setNombreCategoria(rs.getString(2));
        listaCategoria.add(cat);
      }
    } catch (SQLException ex) {
      System.out.println("Error! " + ex.getMessage());
    }
    return listaCategoria;
  }

  public Categoria listarId(long id) {
    String sql = "SELECT * FROM TBL_CATEGORIAS WHERE IDCATEGORIA = ?";
    Categoria cat = new Categoria();

    try {
      con = conex.getConnection();
      ps = con.prepareStatement(sql);
      ps.setLong(1, id);
      rs = ps.executeQuery();

      while (rs.next()) {
        cat.setIdCategoria(rs.getLong(1));
        cat.setNombreCategoria(rs.getString(2));
      }
    } catch (SQLException ex) {
      System.out.println("Error! " + ex.getMessage());
    }
    return cat;
  }

  public String crear(Categoria cat) {

    String sql = "INSERT INTO TBL_CATEGORIAS (NOMBRECATEGORIA) VALUES (?)";

    try {
      con = conex.getConnection();
      ps = con.prepareStatement(sql);
      ps.setString(1, cat.getNombreCategoria());
      respuesta = ps.executeUpdate();
      if (respuesta == 1) {
        mensaje = "Registro creado correctamente";
      } else {
        mensaje = "Error! al crear el registro";
      }
    } catch (SQLException ex) {
      System.out.println("Error! " + ex.getMessage());
    }
    return mensaje;
  }

  public String actualizar(Categoria cat) {
    String sql = "UPDATE TBL_CATEGORIAS SET NOMBRECATEGORIA = ? WHERE IDCATEGORIA = ?";

    try {
      con = conex.getConnection();
      ps = con.prepareStatement(sql);
      ps.setString(1, cat.getNombreCategoria());
      ps.setLong(2, cat.getIdCategoria());
      respuesta = ps.executeUpdate();
      if (respuesta == 1) {
        mensaje = "Registro actualizado correctamente";
      } else {
        mensaje = "Error! al actualizar el registro";
      }
    } catch (SQLException ex) {
      System.out.println("Error! " + ex.getMessage());
    }
    return mensaje;
  }

  public String eliminar(long id) {
    String sql = "DELETE FROM TBL_CATEGORIAS WHERE IDCATEGORIA = ?";

    try {
      con = conex.getConnection();
      ps = con.prepareStatement(sql);
      ps.setLong(1, id);
      respuesta = ps.executeUpdate();
      if (respuesta == 1) {
        mensaje = "Registro eliminado correctamente";
      } else {
        mensaje = "Error! al eliminar el registro";
      }
    } catch (SQLException ex) {
      System.out.println("Error! " + ex.getMessage());
    }
    return mensaje;
  }

}
