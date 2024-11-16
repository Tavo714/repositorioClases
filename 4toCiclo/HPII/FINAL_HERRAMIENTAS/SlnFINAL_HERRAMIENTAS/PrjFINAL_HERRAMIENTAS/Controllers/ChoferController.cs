using Microsoft.AspNetCore.Mvc;
using PrjFINAL_HERRAMIENTAS.Models;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace PrjFINAL_HERRAMIENTAS.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ChoferController : ControllerBase
    {
        private readonly Bdviajes2024Context ctx;

        public ChoferController(Bdviajes2024Context _ctx)
        {
            ctx= _ctx;
        }

        // GET: api/<ChoferController>
        [HttpGet("GetChoferes")]
        public List<Chofer> GetChoferes()
        {
            var listado = ctx.Chofers.ToList();
            return listado;
        }

        // GET api/<ChoferController>/5
        [HttpGet("GetChofer/{CodChof}")]
        public Chofer GetChofer(string CodChof)
        {
            var buscado=ctx.Chofers.Find(CodChof);
            return buscado!;
        }

        // POST api/<ChoferController>
        [HttpPost("PostChofer")]
        public string PostChofer([FromBody] Chofer value)
        {
            try
            {
                ctx.Chofers.Add(value);
                ctx.SaveChanges();
                return $"Chofer: {value.CodChof} registrado correctamente";
            }
            catch (Exception ex)
            {
                return ex.InnerException!.Message;
            }
        }

        // PUT api/<ChoferController>/5
        [HttpPut("PutChofer")]
        public string PutChofer([FromBody] Chofer value)
        {
            try
            {
                ctx.Chofers.Update(value);
                ctx.SaveChanges();
                return $"Chofer:{value.CodChof} actualizado correctamente";
            }
            catch (Exception ex)
            {
                return ex.InnerException!.Message;  
            }
        }

        // DELETE api/<ChoferController>/5
        [HttpDelete("DeleteChofer/{id}")]
        public string DeleteChofer(string id)
        {
            ctx.Chofers.Find(id)!.Eliminado = "Si";
            ctx.SaveChanges() ;
            return $"Chofer {id} fue eliminado logicamente";
        }
    }
}
