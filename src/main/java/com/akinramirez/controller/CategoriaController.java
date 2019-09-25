package com.akinramirez.controller;

import com.akinramirez.dao.CategoriaDao;
import com.akinramirez.model.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CategoriaController", urlPatterns = {"/categoria"})
public class CategoriaController extends HttpServlet {

  private String accion;
  private long idCategoria;
  private String nombreCategoria;
  private String mensaje;
  CategoriaDao daoCategoria2 = new CategoriaDao();
  
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    this.accion = request.getParameter("accion") == null ? "listar" : request.getParameter("accion");

    switch (this.accion) {
      case "listar":
        List<Categoria> listaCategoria = daoCategoria2.listar();
        request.setAttribute("categorias", listaCategoria);
        request.getRequestDispatcher("/WEB-INF/categorias/index.jsp").forward(request, response);        
        break;
      case "agregar":
        request.getRequestDispatcher("/WEB-INF/categorias/add.jsp").forward(request, response);   
        break;
      case "crear":
        this.nombreCategoria = request.getParameter("nombreCategoria");
        this.mensaje = daoCategoria2.crear(new Categoria(idCategoria, nombreCategoria));
        request.setAttribute("mensaje", this.mensaje);
        response.sendRedirect("categoria");
        break;
      case "mostrar":
        this.idCategoria = Integer.parseInt(request.getParameter("id"));
        Categoria categoria = daoCategoria2.listarId(idCategoria);
        request.setAttribute("categoria", categoria);
        request.getRequestDispatcher("/WEB-INF/categorias/edit.jsp").forward(request, response);   
        break;
      case "actualizar":
        this.idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
        this.nombreCategoria = request.getParameter("nombreCategoria");
        this.mensaje = daoCategoria2.actualizar(new Categoria(idCategoria, nombreCategoria));
        request.setAttribute("mensaje", this.mensaje);
        response.sendRedirect("categoria");
        break;
      case "eliminar":
        this.idCategoria = Integer.parseInt(request.getParameter("id"));
        this.mensaje = daoCategoria2.eliminar(idCategoria);
        request.setAttribute("mensaje", this.mensaje);
        response.sendRedirect("categoria");
        break;
      default:
        break;
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

}
