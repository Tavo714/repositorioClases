using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using PrjFinalHerramientas.Models;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace PrjFinalHerramientas.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class PrestamoController : ControllerBase
    {
        private readonly HpiifinalBibliotecaContext ctx;

        public PrestamoController(HpiifinalBibliotecaContext _ctx)
        {
            ctx=_ctx;
        }

        // GET: api/<PrestamoController>


        [HttpGet("GetPrestamos")]
        public List<Prestamo> GetPrestamos()
        {
            var listado = ctx.Prestamos.ToList();

            return listado;
        }

        // GET api/<PrestamoController>/5


        [HttpGet("GetPrestamo/{id}")]
        public Prestamo GetPrestamo(int id)
        {
            var buscado = ctx.Prestamos.Find(id);

            return buscado!;
        }

        // POST api/<PrestamoController>
        [HttpPost("PostPrestamo")]
        public IActionResult PostPrestamo([FromBody] Prestamo value)
        {
            try
            {
                // Verificar que el usuario y el libro existan en la base de datos
                var usuario = ctx.Usuarios.Find(value.UsuarioId);
                var libro = ctx.Libros.Find(value.LibroId);

                if (usuario == null || libro == null)
                {
                    return BadRequest("Usuario o Libro no encontrados.");
                }

                // Agregar el préstamo
                ctx.Prestamos.Add(value);
                ctx.SaveChanges();

                return Ok($"Prestamo: {value.PrestamoId} registrado correctamente");
            }
            catch (Exception ex)
            {
                return StatusCode(500, ex.InnerException?.Message ?? ex.Message);
            }
        }

        //[HttpPost("PostPrestamo")]
        //public string PostPrestamo([FromBody] Prestamo value)
        //{
        //    try
        //    {
        //        ctx.Prestamos.Add(value);    
        //        ctx.SaveChanges();

        //        return $"Prestamo: {value.PrestamoId} registrado correctamente";
        //    }
        //    catch (Exception ex)
        //    {
        //        return ex.InnerException!.Message;
        //    }
        //}

        // PUT api/<PrestamoController>/5
        [HttpPut("PutPrestamo")]
        public string PutPrestamo([FromBody] Prestamo value)
        {
            try
            {
                ctx.Prestamos.Update(value);
                ctx.SaveChanges();

                return $"Prestamo: {value.PrestamoId} actualizado correctamente";
            }
            catch (Exception ex)
            {
                return ex.InnerException!.Message;
            }
        }

        // DELETE api/<PrestamoController>/5
        [HttpDelete("DeletePrestamo/{id}")]
        public string DeletePrestamo(int id)
        {
            ctx.Prestamos.Find(id)!.Estado = "Eliminado";
            ctx.SaveChanges();

            return $"Prestamo {id} fue eliminado logicamente";
        }
    }
}
