package com.akinramirez.config;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class AppConfiguration extends ResourceConfig{
  
  public AppConfiguration(){
    packages("com.akinramirez.api");
  }
}
