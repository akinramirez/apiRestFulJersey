package com.akinramirez.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/saludo")
public class HolaMundoApi {
  
  @Path("/saludar")
  @GET
  public String getSaludo(){
    return "Hola Mundo!!!";
  }
}
