package ws;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.Collection;

import dao.Empleadodao;
import vo.Empleadovo;

@Path("empleado")
public class Empleadorest {

    @Context
    private UriInfo context;

    private Empleadodao empleadosdao = new Empleadodao();

    public Empleadorest() {
    }

    @Path("/agregar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregar(Empleadovo empleado) {
        try {
            empleadosdao.insert(empleado);
            return Response.ok().entity(empleado).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error al agregar el empleado. Detalle: " + ex.getMessage()).build();
        }
    }

    @Path("/listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Empleadovo> listar() {
        return empleadosdao.findAll();
    }

    @Path("/listarPorDepartamento/{id_departamento}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPorDepartamento(@PathParam("id_departamento") int id_departamento) {
        Collection<Empleadovo> empleados = empleadosdao.findByDepartamento(id_departamento);
        if (empleados.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("No se encontraron empleados para el departamento con ID: " + id_departamento)
                           .build();
        }
        return Response.ok().entity(empleados).build();
    }
}
