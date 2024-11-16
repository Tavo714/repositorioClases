using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using PrjFINAL_HERRAMIENTAS.Models;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace PrjFINAL_HERRAMIENTAS.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class sp_ObtenerIngresosPorMesYAñoController : ControllerBase
    {
        private readonly Bdviajes2024Context ctx;

        public sp_ObtenerIngresosPorMesYAñoController(Bdviajes2024Context _ctx)
        {
            ctx = _ctx;
        }

        // GET: api/sp_ObtenerIngresosPorMesYAño?mes=3&año=2024
        [HttpGet]
        public async Task<IActionResult> GetIngresosPorMesYAño([FromQuery] int mes, [FromQuery] int año)
        {
            try
            {
                // Ejecuta el procedimiento almacenado directamente en el controlador
                var result = await ctx.sp_ObtenerIngresosPorMesYAño
                    .FromSqlRaw("EXEC sp_ObtenerIngresosPorMesYAño @Mes = {0}, @Año = {1}", mes, año)
                    .AsNoTracking()
                    .ToListAsync();

                // Retorna el resultado
                return Ok(result);
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Error en el servidor: {ex.Message}");
            }
        }
    }
}
