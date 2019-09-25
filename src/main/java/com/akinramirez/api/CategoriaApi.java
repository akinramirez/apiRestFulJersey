package com.akinramirez.api;

import com.akinramirez.dao.CategoriaDao;
import com.akinramirez.model.Categoria;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/categorias")
public class CategoriaApi {

  CategoriaDao daoCategoria = new CategoriaDao();

  @Path("/listar")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response listar() {
    return Response.status(Response.Status.OK).entity(daoCategoria.listar()).build();
  }

  @Path("/listar/{id}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response listarid(@PathParam("id") long id) {
    return Response.status(Response.Status.OK).entity(daoCategoria.listarId(id)).build();
  }

  @Path("/crear")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response crear(Categoria cat) {
    return Response.status(Response.Status.CREATED).entity(daoCategoria.crear(cat)).build();
  }

  @Path("/actualizar")
  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response actualizar(Categoria cat) {
    return Response.status(Response.Status.OK).entity(daoCategoria.actualizar(cat)).build();
  }

  @Path("eliminar/{id}")
  @DELETE
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response eliminar(@PathParam("id") long id) {
    return Response.status(Response.Status.OK).entity(daoCategoria.eliminar(id)).build();
  }

}
