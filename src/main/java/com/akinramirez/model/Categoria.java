package com.akinramirez.model;

public class Categoria {

  private Long idCategoria;
  private String nombreCategoria;

  public Categoria() {
  }

  public Categoria(Long idCategoria) {
    this.idCategoria = idCategoria;
  }

  public Categoria(String nombreCategoria) {
    this.nombreCategoria = nombreCategoria;
  }

  public Categoria(Long idCategoria, String nombreCategoria) {
    this.idCategoria = idCategoria;
    this.nombreCategoria = nombreCategoria;
  }

  public String getNombreCategoria() {
    return nombreCategoria;
  }

  public void setNombreCategoria(String nombreCategoria) {
    this.nombreCategoria = nombreCategoria;
  }

  public Long getIdCategoria() {
    return idCategoria;
  }

  public void setIdCategoria(Long idCategoria) {
    this.idCategoria = idCategoria;
  }

}
