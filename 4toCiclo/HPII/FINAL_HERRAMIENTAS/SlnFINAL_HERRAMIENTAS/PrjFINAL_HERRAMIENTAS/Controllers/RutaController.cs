using Microsoft.AspNetCore.Mvc;
using PrjFINAL_HERRAMIENTAS.Models;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace PrjFINAL_HERRAMIENTAS.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class RutaController : ControllerBase
    {
        private readonly Bdviajes2024Context ctx;

        public RutaController(Bdviajes2024Context _ctx)
        {
            ctx= _ctx;
        }

        // GET: api/<RutaController>
        [HttpGet("GetRutas")]
        public List<Ruta> GetRutas()
        {
            var listado=ctx.Rutas.ToList();
            return listado;
        }

        // GET api/<RutaController>/5
        [HttpGet("GetRuta/{id}")]
        public Ruta GetRuta(string id)
        {
            var buscado=ctx.Rutas.Find(id);
            return buscado!;
        }

        // POST api/<RutaController>
        [HttpPost("PostRuta")]
        public string PostRuta([FromBody] Ruta value)
        {
            try
            {
                ctx.Rutas.Add(value);
                ctx.SaveChanges();
                return $"Ruta: {value.CodRut} registrada correctamente";
            }
            catch (Exception ex)
            {
                return ex.InnerException!.Message;
            }
        }

        // PUT api/<RutaController>/5
        [HttpPut("PutRuta")]
        public string PutRuta([FromBody] Ruta value)
        {
            try
            {
                ctx.Rutas.Update(value);
                ctx.SaveChanges();
                return $"Ruta: {value.CodRut} actualizada correctamente";
            }
            catch (Exception ex)
            {
                return ex.InnerException!.Message;  
            }
        }

        // DELETE api/<RutaController>/5
        [HttpDelete("DeleteRuta/{id}")]
        public string DeleteRuta(string id)
        {
            ctx.Rutas.Find(id)!.Eliminado = "Si";
            ctx.SaveChanges();
            return $"Ruta {id} fue eliminada logicamente";
        }
    }
}
