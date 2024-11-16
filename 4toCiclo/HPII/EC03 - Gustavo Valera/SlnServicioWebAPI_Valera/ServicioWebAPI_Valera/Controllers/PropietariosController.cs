using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using ServicioWebAPI_Valera.Models;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace ServicioWebAPI_Valera.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class PropietariosController : ControllerBase
    {
        private readonly Bdtransito2024Context ctx;

        public PropietariosController(Bdtransito2024Context _ctx)
        {
            ctx=_ctx;
        }

        // GET: api/<PropietariosController>
        [HttpGet("GetPropietarios")]
        public List<Propietario> GetPropietarios()
        {
            var listado= ctx.Propietarios.ToList();

            return listado;
        }

        // GET api/<PropietariosController>/5
        [HttpGet("GetPropietario/{id}")]
        public Propietario GetPropietario(string id)
        {
            var buscado = ctx.Propietarios.Find(id);
            return buscado!;
        }

        // POST api/<PropietariosController>
        [HttpPost("PostPropietario")]
        public string PostPropietario([FromBody] Propietario value)
        {
            try
            {
                ctx.Propietarios.Add(value);
                ctx.SaveChanges();

                return $"Propietario: {value.Dnipro} registrado correctamente";
            }
            catch (Exception ex)
            {
                return ex.InnerException!.Message;
            }
        }

        // PUT api/<PropietariosController>/5
        [HttpPut("PutPropietario")]
        public string PutPropietario([FromBody] Propietario value)
        {
            try
            {
                ctx.Propietarios.Update(value);
                ctx.SaveChanges();

                return $"Propietario: {value.Dnipro} actualizado correctamente";
            }
            catch (Exception ex)
            {
                return ex.InnerException!.Message;
            }
        }

        // DELETE api/<PropietariosController>/5
        [HttpDelete("DeletePropietario/{id}")]
        public string DeletePropietario(string id)
        {
            ctx.Propietarios.Find(id)!.Eliminado = "Si";
            ctx.SaveChanges();

            return $"Propietario {id} fue eliminado logicamente";
        }

        // GET api/Propietarios/GetListarPropietariosPorInicial/A
        [HttpGet("GetListarPropietariosPorInicial/{inicial}")]
        public List<ListarPropietariosPorInicial> GetListarPropietariosPorInicial(string inicial)
        {
            var listado = ctx.ListarPropietariosPorInicial
                                    .FromSql($"exec ListarPropietariosPorInicial {inicial}")
                                    .ToList();
            return listado;
        }

        // GET api/Propietarios/ListarPapeletasNoPagadasPorDNI
        [HttpGet("GetListarPapeletasNoPagadasPorDNI/{dni}")]
        public List<ListarPapeletasNoPagadasPorDNI> GetListarPapeletasNoPagadasPorDNI(string dni)
        {
            var listado = ctx.ListarPapeletasNoPagadasPorDNI
                                    .FromSql($"exec ListarPapeletasNoPagadasPorDNI {dni}")
                                    .ToList();
            return listado;
        }

        // GET api/Propietarios/PutActualizarPapeletaAPagada
        [HttpGet("PutActualizarPapeletaAPagada/{nropap}")]
        public string PutActualizarPapeletaAPagada(int nropap)
        {
            try
            {
                ctx.Database.ExecuteSqlRaw($"exec ActualizarPapeletaAPagada {nropap}");
                return $"Papeleta {nropap} fue pagada correctamente";
            }
            catch (Exception ex)
            {
                return ex.InnerException!.Message;
            }
        }
    }
}
