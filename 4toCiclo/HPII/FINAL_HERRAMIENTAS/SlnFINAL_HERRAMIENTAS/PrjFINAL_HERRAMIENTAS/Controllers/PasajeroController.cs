using Microsoft.AspNetCore.Mvc;
using PrjFINAL_HERRAMIENTAS.Models;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace PrjFINAL_HERRAMIENTAS.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class PasajeroController : ControllerBase
    {
        private readonly Bdviajes2024Context ctx;

        public PasajeroController(Bdviajes2024Context _ctx)
        {
            ctx= _ctx;
        }


        // GET: api/<PasajeroController>
        [HttpGet("GetPasajeros")]
        public List<Pasajero> GetPasajeros()
        {
            var listado=ctx.Pasajeros.ToList();
            return listado;
        }

        // GET api/<PasajeroController>/5
        [HttpGet("GetPasajero/{NroBol}")]
        public Pasajero GetPasajero(string NroBol)
        {
            var buscado = ctx.Pasajeros.Find(NroBol);
            return buscado!;
        }

        // POST api/<PasajeroController>
        [HttpPost("PostPasajero")]
        public string PostPasajero([FromBody] Pasajero value)
        {
            try
            {
                ctx.Pasajeros.Add(value);
                ctx.SaveChanges();
                return $"Pasajero: {value.NroBol} registrado correctamente";
            }
            catch (Exception ex)
            {
                return ex.InnerException!.Message;
            }
        }

        // PUT api/<PasajeroController>/5
        [HttpPut("PutPasajero")]
        public string PutPasajero([FromBody] Pasajero value)
        {
            try
            {
                ctx.Pasajeros.Update(value);
                ctx.SaveChanges();

                return $"Pasajero: {value.NroBol} actualizado correctamente";
            }
            catch(Exception ex)
            {
                return ex.InnerException!.Message;
            }
        }

        // DELETE api/<PasajeroController>/5
        [HttpDelete("DeletePasajero/{NroBol}")]
        public string DeletePasajero(string NroBol)
        {
            ctx.Pasajeros.Find(NroBol)!.Eliminado = "Si";
            ctx.SaveChanges() ;
            return $"Pasajero{NroBol} fue eliminado logicamente";
        }
    }
}
