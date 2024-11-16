using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using PrjFINAL_HERRAMIENTAS.Models;
using System.Threading.Tasks;

namespace PrjFINAL_HERRAMIENTAS.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class sp_ObtenerPasajerosPorMesController : ControllerBase
    {
        private readonly Bdviajes2024Context _context;

        public sp_ObtenerPasajerosPorMesController(Bdviajes2024Context context)
        {
            _context = context;
        }

        // GET: api/sp_ObtenerPasajerosPorMes?mes=3&año=2024
        [HttpGet]
        public async Task<IActionResult> GetPasajerosPorMes([FromQuery] int mes, [FromQuery] int año)
        {
            try
            {
                // Ejecutar el procedimiento almacenado con los parámetros @Mes y @Año
                var result = await _context.sp_ObtenerPasajerosPorMes
                    .FromSqlRaw("EXEC sp_ObtenerPasajerosPorMes @Mes = {0}, @Año = {1}", mes, año)
                    .AsNoTracking()
                    .ToListAsync();

                // Verificar si hay resultados
                if (result == null || result.Count == 0)
                {
                    return NotFound("No se encontraron pasajeros para el mes y año especificados.");
                }

                // Retornar los resultados obtenidos
                return Ok(result);
            }
            catch (Exception ex)
            {
                // Manejar errores
                return StatusCode(500, $"Error en el servidor: {ex.Message}");
            }
        }
    }
}
