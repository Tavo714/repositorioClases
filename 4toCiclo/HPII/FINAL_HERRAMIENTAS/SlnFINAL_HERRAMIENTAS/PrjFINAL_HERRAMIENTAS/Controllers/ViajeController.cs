using Microsoft.AspNetCore.Mvc;
using PrjFINAL_HERRAMIENTAS.Models;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace PrjFINAL_HERRAMIENTAS.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ViajeController : ControllerBase
    {
        private readonly Bdviajes2024Context ctx;

        public ViajeController(Bdviajes2024Context _ctx)
        {
            ctx = _ctx;
        }

        // GET: api/<ViajeController>
        [HttpGet("GetViajes")]
        public List<Viaje> GetViajes()
        {
            var listado=ctx.Viajes.ToList();
            return listado;
        }

        // GET api/<ViajeController>/5
        [HttpGet("GetViaje/{NroVia}")]
        public Viaje GetViaje(string NroVia)
        {
            var buscado = ctx.Viajes.Find(NroVia);
            return buscado!;
        }

        // POST api/<ViajeController>
        [HttpPost("PostViaje")]
        public string PostViaje([FromBody] Viaje value)
        {
            try
            {
                ctx.Viajes.Add(value);
                ctx.SaveChanges();

                return $"Viaje: {value.NroVia} registrado correctamente";
            }
            catch (Exception ex)
            {
                return ex.InnerException!.Message;
            }
        }

        // PUT api/<ViajeController>/5
        [HttpPut("PutViaje")]
        public string PutViaje([FromBody] Viaje value)
        {
            try
            {
                ctx.Viajes.Update(value);
                ctx.SaveChanges();
                return $"Viaje: {value.NroVia} actualizado correctamente";
            }
            catch (Exception ex)
            {
                return ex.InnerException!.Message;
            }
        }

        // DELETE api/<ViajeController>/5
        [HttpDelete("DeleteViaje/{NroViaje}")]
        public string DeleteViaje(string NroViaje)
        {
            ctx.Viajes.Find(NroViaje)!.Eliminado = "Si";
            ctx.SaveChanges();
            return $"Viaje {NroViaje} fue eliminado logicamente";
        }
    }
}
