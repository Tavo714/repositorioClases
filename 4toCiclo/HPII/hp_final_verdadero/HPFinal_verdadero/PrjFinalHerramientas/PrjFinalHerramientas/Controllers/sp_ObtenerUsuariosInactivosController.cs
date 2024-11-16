using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using PrjFinalHerramientas.Models;
// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace PrjFinalHerramientas.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class sp_ObtenerUsuariosInactivosController : ControllerBase
    {
        private readonly HpiifinalBibliotecaContext ctx;

        public sp_ObtenerUsuariosInactivosController(HpiifinalBibliotecaContext _ctx)
        {
            ctx = _ctx;
        }


        // GET api/<LibroController>/GetLibrosNoDevueltos
        [HttpGet("GetObtenerUsuariosInactivos")]
        public List<sp_ObtenerUsuariosInactivos> GetObtenerUsuariosInactivos()
        {
            var listado = ctx.sp_ObtenerUsuariosInactivos
                .FromSqlRaw($"EXEC sp_ObtenerUsuariosInactivos")
                .ToList();
            return listado;
        }

    }
}
