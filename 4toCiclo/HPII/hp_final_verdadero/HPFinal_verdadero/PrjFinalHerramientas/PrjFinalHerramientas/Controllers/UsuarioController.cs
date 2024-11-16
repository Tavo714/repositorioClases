using Microsoft.AspNetCore.Mvc;
using PrjFinalHerramientas.Models;


// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace PrjFinalHp2.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UsuarioController : ControllerBase
    {
        private readonly HpiifinalBibliotecaContext ctx;

        public UsuarioController(HpiifinalBibliotecaContext _ctx)
        {
            ctx = _ctx;
        }

        // GET: api/<UsuarioController>
        [HttpGet("GetUsuarios")]
        public List<Usuario> GetUsuarios()
        {
            var listado = ctx.Usuarios.ToList();
            return listado;
        }

        // GET api/<UsuarioController>/5
        [HttpGet("GetUsuario/{id}")]
        public Usuario GetUsuario(int id)
        {
            var buscado = ctx.Usuarios.Find(id);
            return buscado!;
        }

        // POST api/<UsuarioController>
        [HttpPost("PostUsuario")]
        public string PostUsuario([FromBody] Usuario value)
        {
            try
            {
                ctx.Usuarios.Add(value);
                ctx.SaveChanges();
                return $"Usuario:{value.Dni} registrado correctamente";
            }
            catch (Exception ex)
            {
                return ex.InnerException!.Message;
            }
        }

        //PUT api/<UsuarioController>/5
        [HttpPut("PutUsuario")]
        public string PutUsuario([FromBody] Usuario value)
        {
            try
            {
                ctx.Usuarios.Update(value);
                ctx.SaveChanges();
                return $"Usuario: {value.Dni} actualizado correctamente";
            }
            catch (Exception ex)
            {
                return ex.InnerException!.Message;
            }
        }




        // DELETE api/<UsuarioController>/5
        [HttpDelete("DeleteUsuario/{id}")]
        public string DeleteUsuario(int id)
        {
            ctx.Usuarios.Find(id)!.EstadoUsuario = "Inactivo";
            ctx.SaveChanges();

            return $"Usuario {id} fue eliminado logicamente";
        }
    }
}