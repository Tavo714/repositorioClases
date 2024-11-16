using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using PrjFinalHerramientas.Models;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace PrjFinalHerramientas.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ListarUsuariosConPenalidadesController : ControllerBase
    {
        private readonly HpiifinalBibliotecaContext ctx;

        public ListarUsuariosConPenalidadesController(HpiifinalBibliotecaContext _ctx)
        {
            ctx = _ctx;
        }


        // GET api/<LibroController>/GetLibrosNoDevueltos
        [HttpGet("GetListarUsuariosConPenalidades")]
        public List<ListarUsuariosConPenalidades> GetListarUsuariosConPenalidades()
        {
            var listado = ctx.ListarUsuariosConPenalidades
                .FromSqlRaw($"EXEC ListarUsuariosConPenalidades")
                .ToList();
            return listado;
        }

        // POST api/CambiarPenalidadUsuario/CambiarPenalidad/5
        [HttpPost("CambiarPenalidad/{usuarioId}")]
        public IActionResult CambiarPenalidad(int usuarioId)
        {
            try
            {
                ctx.Database.ExecuteSqlRaw("EXEC CambiarPenalidadUsuario @UsuarioID = {0}", usuarioId);

                return Ok($"Penalidad del usuario con ID {usuarioId} ha sido actualizada correctamente.");
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Error en el servidor: {ex.Message}");
            }
        }
    }
}
