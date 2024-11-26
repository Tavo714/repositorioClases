package ws;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import dao.alumnosdao;
import vo.alumnosvo;
import java.util.Collection;

@Path("alumno")
public class alumnorest {

    @Context
    private UriInfo context;

    private alumnosdao alumnodao = new alumnosdao();

    public alumnorest() {
    }

    @Path("/agregar")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregar(alumnosvo alumno) {
        alumnodao.insert(alumno);
        return Response.ok().entity(alumno).build();
    }

    @Path("/listarPorEmpresa/{nombreEmpresa}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPorEmpresa(@PathParam("nombreEmpresa") String nombreEmpresa) {
        Collection<alumnosvo> alumnos = alumnodao.findByEmpresa(nombreEmpresa);
        if (alumnos.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No se encontraron alumnos para la empresa: " + nombreEmpresa)
                    .build();
        }
        return Response.ok().entity(alumnos).build();
    }
}
