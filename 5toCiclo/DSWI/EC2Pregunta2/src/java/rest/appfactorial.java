
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
public class appfactorial {

    @Context
    private UriInfo context;

    public appfactorial() {
    }
 public int fact(int num) {
    int res = 1;
    for (int i = 1; i <= num; i++) {
        res *= i; 
    }
    return res;
    }
    
    @Path("mensaje/{num}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText(@PathParam("num") Integer num) {
        String response = "El factorial del numero " + num + " es " + fact(num);
        return response;
    }
     
    @Path("mensaje2")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getm2(@QueryParam("num") Integer num) {
        String response = "<h1>Calculando factorial de... " + num + "</h1>";
        response += "<p>" + fact(num) + "</p>";
        return response;
    }
    
    @Path("mensaje3/{num}")
    @GET
    @Produces(MediaType.TEXT_XML)
    public String getm3(@PathParam("num") Integer num) {
        String response = "<msg>El factorial del numero que ingresaste es: " + fact(num) + "</msg>";
        return response;
    }
    
    @Path("mensaje4")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getm4(@QueryParam("num") Integer num) {
        String response = "{\"mensaje\" : \"El factorial de tu numero: " + num + " es: " +fact(num) + "\"}";                 
        return response;
    }
}
