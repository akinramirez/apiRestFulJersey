<%-- 
    Document   : edit
    Created on : 09-25-2019, 10:44:37 AM
    Author     : aaramirez
--%>

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
    Categoria categoria = (Categoria) request.getAttribute("categoria");
  %>
  <body>
    <div class="container mt-4">
      <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8"> 
          <div class="card">
            <div class="card-header">
              <h6>Actualizar Categoria</h6>
            </div>
            <div class="card-body">
              <form role="form" action="categoria" method="post">
                <input type="hidden" name="accion" value="actualizar">
                <input type="hidden" name="idCategoria" value="<%= categoria.getIdCategoria()%>">
                <label>Nombre</label>
                <input type="text" name="nombreCategoria" class="form-control form-control-sm" value="<%= categoria.getNombreCategoria()%>" autocomplete="off">
                <br>
                <a href="categoria" class="btn btn-secondary btn-sm">Regresar</a>
                <button type="submit" class="btn btn-success btn-sm">Guardar</button>
              </form>
            </div>
          </div>      
        </div>
      </div>
    </div>
  </body>
</html>
