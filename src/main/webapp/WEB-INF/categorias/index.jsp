<%-- 
    Document   : index
    Created on : 09-25-2019, 10:44:20 AM
    Author     : aaramirez
--%>
<%@page import="java.util.List"%>
<%@page import="com.akinramirez.model.Categoria"%>
<%@page import="com.akinramirez.model.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <title>JSP Page</title>
  </head>
  <%
    List<Categoria> listaCategoria = (List<Categoria>) request.getAttribute("categorias");
  %>
  <body>
    <div class="container mt-4">
      <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8"> 
          <div class="card">
            <div class="card-header">
              <form method="POST" action="categoria">
                <button class="btn btn-primary btn-sm" type="submit" name="accion" value="agregar">Nuevo</button>
              </form>
            </div>
            <div class="card-body">
              <table class="table table-sm table-responsive-sm table-hover"> 
                <thead>
                  <tr>
                    <th>#</th>
                    <th>Nombre</th>
                    <th style="width: 180px;">Acciones</th>
                  </tr>
                </thead>
                <tbody>
                  <% for (Categoria cat : listaCategoria) {%>
                  <tr>
                    <td><%= cat.getIdCategoria()%></td>
                    <td><%= cat.getNombreCategoria()%></td>
                    <td>
                      <a href="categoria?accion=mostrar&id=<%= cat.getIdCategoria()%>" class="btn btn-warning btn-sm"> Editar</a>
                      <a href="categoria?accion=eliminar&id=<%= cat.getIdCategoria()%>" class="btn btn-danger btn-sm"> Eliminar</a>
                    </td>
                  </tr>
                  <%}%>
                </tbody>
              </table>
            </div>
          </div>      
        </div>
      </div>
    </div>
  </body>
</html>
