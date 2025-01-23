/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import dao.ProveedorDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import vo.ProveedorVO;

/**
 * REST Web Service
 *
 * @author gero6
 */
@Path("proveedor")
public class ProveedorWS {

    @Context
    private UriInfo context;
    private ProveedorDAO proveedorDAO = new ProveedorDAO();
    
    public ProveedorWS() {
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProveedorVO> listarProveedores() {
        return proveedorDAO.getAllProveedores();
    }
    @GET
    @Path("/obtener/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProveedorVO obtenerProveedores(@PathParam("id") int id) {
        return proveedorDAO.getProveedorById(id);
    }

    @POST
    @Path("/insertar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertarProveedor(ProveedorVO proveedor) {
        proveedorDAO.insertProveedor(proveedor);
        return Response.ok().entity(proveedor).build();
    }
    
    @PUT
    @Path("/actualizar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarProveedor(@PathParam("id") int id, ProveedorVO proveedor) {
        proveedorDAO.updateProveedor(id, proveedor);
        return Response.ok().entity(proveedor).build();
    }
    
    @DELETE
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarProveedor(@PathParam("id") int id) {
        proveedorDAO.deleteProveedor(id);
        return Response.ok("Exito al eliminar el registro").build();
    }
    
    @GET
    @Path("/marshall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProveedorVO> marshallProductos() {
        List<ProveedorVO> proveedoresJson = proveedorDAO.marshall();
        return proveedoresJson;
    }
    
    @GET
    @Path("/unmarshall")
    @Produces(MediaType.APPLICATION_JSON)
    public void unmarshallProductos() {
       proveedorDAO.unmarshall();
    }
}
