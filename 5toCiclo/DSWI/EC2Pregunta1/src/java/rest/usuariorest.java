
package rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("version1")
public class usuariorest {

    @Context
    private UriInfo context;

    public usuariorest() {
    }

   private boolean yearBisiesto(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    @Path("mensaje/{year}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getm1(@PathParam("year") Integer year) {
        String mensaje = "Ingresa un year para saber si es bisiesto...: ";
        mensaje += "El year " + year + (yearBisiesto(year) ? " es bisiesto." : " no es bisiesto.");
        return mensaje;
    }
    @Path("mensaje2")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getm2(@QueryParam("year") Integer year) {
        String mensaje = "<h1>Tu year de la suerte es bisiesto?</h1> " + year;
        mensaje += "<p>El year " + year + (yearBisiesto(year) ? " es bisiesto." : " no es bisiesto.") + "</p>";
        return mensaje;
    }
    
    @Path("mensaje3/{year}")
    @GET
    @Produces(MediaType.TEXT_XML)
    public String getm3(@PathParam("year") Integer year) {
        String mensaje = "<msg>" + (yearBisiesto(year) ? " El year que elegiste es bisiesto." : " El year que elegiste no es bisiesto.") +"</msg>";
        return mensaje;
    }
    
    @Path("mensaje4")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getm4(@QueryParam("year") Integer year) {
        String response = "{\"mensaje\":\"Quieres saber si un year es bisiesto?.\"," +
                         "\"resultado\":\"" + year + (yearBisiesto(year) ? " es bisiesto." : " no es bisiesto.") + "\"}";
        return response;
    }

}
