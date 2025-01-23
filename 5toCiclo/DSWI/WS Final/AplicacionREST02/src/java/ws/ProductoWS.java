package ws;

import dao.ProductoDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import vo.ProductoVO;


@Path("producto")
public class ProductoWS {

    @Context
    private UriInfo context;
    private ProductoDAO productoDAO = new ProductoDAO();
    
    public ProductoWS() {
    }
    
    
    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductoVO> listarProductos() {
        return productoDAO.getAllProductos();
    }
    
    @GET
    @Path("/obtener/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductoVO obtenerProducto(@PathParam("id") int id) {
        return productoDAO.getProductoById(id);
    }

    @POST
    @Path("/insertar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertarProducto(ProductoVO producto) {
        productoDAO.insertProducto(producto);
        return Response.ok().entity(producto).build();
    }
    
    @PUT
    @Path("/actualizar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarProducto(@PathParam("id") int id, ProductoVO producto) {
        productoDAO.updateProducto(id, producto);
        return Response.ok().entity(producto).build();
    }
    
    @DELETE
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarProducto(@PathParam("id") int id) {
        productoDAO.deleteProducto(id);
        return Response.ok("Exito al eliminar el registro").build();
    }

    @GET
    @Path("/marshall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductoVO> marshallProductos() {
        List<ProductoVO> productosJson = productoDAO.marshall();
        return productosJson;
    }
    @GET
    @Path("/unmarshall")
    @Produces(MediaType.APPLICATION_JSON)
    public void unmarshallProductos() {
       productoDAO.unmarshall();
    }
    
}
