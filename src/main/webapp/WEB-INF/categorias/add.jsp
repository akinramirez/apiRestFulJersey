<%-- 
    Document   : add
    Created on : 09-25-2019, 10:44:26 AM
    Author     : aaramirez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <title>JSP Page</title>
  </head>
  <body>
    <div class="container mt-4">
      <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8"> 
          <div class="card">
            <div class="card-header">
              <h6>Agregar Categoria</h6>
            </div>
            <div class="card-body">
              <form role="form" action="categoria" method="post">
                <label>Nombre</label>
                <input type="hidden" name="accion" value="crear" autocomplete="off">
                <input type="text" name="nombreCategoria" class="form-control form-control-sm" autocomplete="off">
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
