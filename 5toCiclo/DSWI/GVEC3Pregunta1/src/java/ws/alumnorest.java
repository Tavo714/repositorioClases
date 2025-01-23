package ws;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

import dbase.conexiondb;
import vo.alumnosvo;
import vo.empresasvo;

@Path("alumno")
public class alumnorest {

    @Context
    private UriInfo context;

    public alumnorest() {
    }

    /**
     * Método para agregar un alumno (cambia a POST)
     */
    @Path("/agregar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregar(alumnosvo alumno) {
        try (Connection conn = conexiondb.MySQL();
             PreparedStatement ps = conn.prepareStatement(
                     "INSERT INTO alumnos (dni, nombre, apellido1, apellido2, direccion, telefono, edad, cif) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
            ps.setString(1, alumno.getDni());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido1());
            ps.setString(4, alumno.getApellido2());
            ps.setString(5, alumno.getDireccion());
            ps.setString(6, alumno.getTelefono());
            ps.setInt(7, alumno.getEdad());
            ps.setString(8, alumno.getEmpresa().getCif());
            int rows = ps.executeUpdate();
            if (rows == 1) {
                return Response.ok().entity(alumno).build();
            } else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                               .entity("Error al insertar el alumno").build();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error al agregar el alumno. Detalle: " + ex.getMessage()).build();
        }
    }

    /**
     * Método para listar todos los alumnos
     */
    @Path("/listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<alumnosvo> listar() {
        Collection<alumnosvo> alumnos = new ArrayList<>();
        try (Connection conn = conexiondb.MySQL();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM alumnos");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                alumnosvo alumno = new alumnosvo();
                alumno.setDni(rs.getString("dni"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido1(rs.getString("apellido1"));
                alumno.setApellido2(rs.getString("apellido2"));
                alumno.setDireccion(rs.getString("direccion"));
                alumno.setTelefono(rs.getString("telefono"));
                alumno.setEdad(rs.getInt("edad"));

                empresasvo empresa = findEmpresaByCif(conn, rs.getString("cif"));
                alumno.setEmpresa(empresa);

                alumnos.add(alumno);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return alumnos;
    }

    /**
     * Método para listar alumnos por empresa
     */
    @Path("/listarPorEmpresa/{nombreEmpresa}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPorEmpresa(@PathParam("nombreEmpresa") String nombreEmpresa) {
        Collection<alumnosvo> alumnos = new ArrayList<>();
        try (Connection conn = conexiondb.MySQL();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT a.* FROM alumnos a JOIN empresas e ON a.cif = e.cif WHERE e.nombre = ?")) {
            ps.setString(1, nombreEmpresa);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    alumnosvo alumno = new alumnosvo();
                    alumno.setDni(rs.getString("dni"));
                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setApellido1(rs.getString("apellido1"));
                    alumno.setApellido2(rs.getString("apellido2"));
                    alumno.setDireccion(rs.getString("direccion"));
                    alumno.setTelefono(rs.getString("telefono"));
                    alumno.setEdad(rs.getInt("edad"));

                    empresasvo empresa = findEmpresaByCif(conn, rs.getString("cif"));
                    alumno.setEmpresa(empresa);

                    alumnos.add(alumno);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error al listar alumnos por empresa. Detalle: " + ex.getMessage()).build();
        }
        if (alumnos.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("No se encontraron alumnos para la empresa: " + nombreEmpresa).build();
        }
        return Response.ok().entity(alumnos).build();
    }

    /**
     * Método auxiliar para buscar una empresa por su CIF
     */
    private empresasvo findEmpresaByCif(Connection conn, String cif) throws SQLException {
        empresasvo empresa = null;
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM empresas WHERE cif = ?")) {
            ps.setString(1, cif);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    empresa = new empresasvo();
                    empresa.setCif(rs.getString("cif"));
                    empresa.setNombre(rs.getString("nombre"));
                    empresa.setTelefono(rs.getString("telefono"));
                    empresa.setDireccion(rs.getString("direccion"));
                }
            }
        }
        return empresa;
    }
}
