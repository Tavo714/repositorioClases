using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using PrjFINAL_HERRAMIENTAS.Models;
using System.Threading.Tasks;

namespace PrjFINAL_HERRAMIENTAS.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class sp_ObtenerIngresosPorRutaYAñoController : ControllerBase
    {
        private readonly Bdviajes2024Context _context;

        public sp_ObtenerIngresosPorRutaYAñoController(Bdviajes2024Context context)
        {
            _context = context;
        }

        // GET: api/sp_ObtenerIngresosPorRutaYAño?año=2024
        [HttpGet]
        public async Task<IActionResult> GetIngresosPorRutaYAño([FromQuery] int año)
        {
            try
            {
                // Ejecutar el procedimiento almacenado con el parámetro @Año
                var result = await _context.sp_ObtenerIngresosPorRutaYAño
                    .FromSqlRaw("EXEC sp_ObtenerIngresosPorRutaYAño @Año = {0}", año)
                    .AsNoTracking()
                    .ToListAsync();

                // Verificar si hay resultados
                if (result == null || result.Count == 0)
                {
                    return NotFound("No se encontraron ingresos para las rutas en el año especificado.");
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
