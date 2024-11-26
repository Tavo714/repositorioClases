package ws;
 
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
 
import java.util.Collection;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import dao.productodao;
import vo.productovo;
 
@Path("producto")
public class productorest {
 
    @Context
    private UriInfo context;
 
    /**
     * Creates a new instance of productorest
     */
    private productodao productodao = new productodao();
    public productorest() {
    }
 
    /**
     * Retrieves representation of an instance of ws.productorest
     * @return an instance of java.lang.String
     */
    @Path("/agregar")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregar(productovo producto)
    {
        productodao.insert(producto);
        return Response.ok().entity(producto).build();
    }
    @Path("/listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<productovo> listar(){
        return productodao.findAll();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
 
    /**
     * PUT method for updating or creating an instance of productorest
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
