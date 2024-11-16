/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;


import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;


import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author ACER
 */
@Path("version1")
public class usuariorest {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of usuariorest
     */
    public usuariorest() {
    }

    /**
     * Retrieves representation of an instance of rest.usuariorest
     * @return an instance of java.lang.String
     */
    @Path("mensaje")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText() {
        String nombre = "Juan Perez";
        String respuesta = "Bienvenido " + nombre + ", a nuestro WebService con REST";
        return respuesta;
    }
    
    @Path("mensaje1/{usuario}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage1(@PathParam("usuario") String usuario) {
        String respuesta = "Bienvenido " + usuario + ", a nuestro WebService con REST";
        return respuesta;
    }
    
    @Path("mensaje2")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getMessage2(@QueryParam("usuario") String usuario) {
        String respuesta = "<h1>Bienvenido <b>" + usuario + "</b>, a nuestro WebService con REST</h1>";
        return respuesta;
    }
    
    @Path("mensaje3/{usuario}")
    @GET
    @Produces(MediaType.TEXT_XML)
    public String getMessage3(@PathParam("usuario") String usuario) {
        String respuesta = "<msg>Bienvenido " + usuario + ", a nuestro WebService con REST</msg>";
        return respuesta;
    }
    
    @Path("mensaje4")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getMessage4(@QueryParam("usuario") String usuario) {
        String respuesta = "{\"Respuesta\" : \"Bienvenido " + usuario + ", a nuestro WebService con REST\"}";
        return respuesta;
    }

    /**
     * PUT method for updating or creating an instance of usuariorest
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(String content) {
    }
}
