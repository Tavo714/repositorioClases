package ws;

import dao.EmpleadoDAO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import vo.EmpleadoVO;


@Path("empleado")
public class EmpleadoWS {

    @Context
    private UriInfo context;
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    
    public EmpleadoWS() {
    }
    
    
    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EmpleadoVO> listarEmpleados() {
        return empleadoDAO.getAllEmpleados();
    }
    @GET
    @Path("/obtener/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EmpleadoVO obtenerEmpleado(@PathParam("id") int id) {
        return empleadoDAO.getEmpleadoById(id);
    }

    @POST
    @Path("/insertar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertarEmpleado(EmpleadoVO empleado) {
        empleadoDAO.insertEmpleado(empleado);
        return Response.ok().entity(empleado).build();
    }
    
    @PUT
    @Path("/actualizar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarEmpleado(@PathParam("id") int id, EmpleadoVO empleado) {
        empleadoDAO.updateEmpleado(id, empleado);
        return Response.ok().entity(empleado).build();
    }
    
    @DELETE
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarEmpleado(@PathParam("id") int id) {
        empleadoDAO.deleteEmpleado(id);
        return Response.ok("Exito al eliminar el registro").build();
    }
    
    @GET
    @Path("/marshall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EmpleadoVO> marshallEmpleados() {
        List<EmpleadoVO> empleadosJson = empleadoDAO.marshall();
        return empleadosJson;
    }
    @GET
    @Path("/unmarshall")
    @Produces(MediaType.APPLICATION_JSON)
    public void unmarshallEmpleados() {
       empleadoDAO.unmarshall();
    }
}
