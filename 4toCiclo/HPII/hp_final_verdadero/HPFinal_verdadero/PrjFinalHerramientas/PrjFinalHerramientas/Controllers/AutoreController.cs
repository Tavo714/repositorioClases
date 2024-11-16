using Microsoft.AspNetCore.Mvc;
using PrjFinalHerramientas.Models;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace PrjFinalHerramientas.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class AutoreController : ControllerBase
    {
        private readonly HpiifinalBibliotecaContext context;

        public AutoreController(HpiifinalBibliotecaContext _context)
        {
            context = _context;
        }
        // GET: api/<AutoreController>
        [HttpGet("GetAutores")]
        public List<Autore> GetAutores()
        {
            //var listaAutores = context.Autores.ToList();
            //return listaAutores;
            var listado = context.Autores.Where(c => c.Estado == "Activo").ToList();
            return listado;
        }

        // GET api/<AutoreController>/5
        [HttpGet("GetAutor/{id}")]
        public Autore GetAutor(int id)
        {
            var autorBuscado = context.Autores.Find(id);
            return autorBuscado!;
        }

        // POST api/<AutoreController>
        [HttpPost("PostAutor")]
        public String PostAutor([FromBody] Autore autor)
        {
            try
            {
                context.Autores.Add(autor); 
                context.SaveChanges();
                return $"Autor {autor.Nombre} fue registrado correctamente";
            }
            catch (Exception ex)
            {
                return ex.InnerException!.Message;
            }
        }

        // PUT api/<AutoreController>/5
        [HttpPut("PutAutor")]
        public String PutAutor([FromBody] Autore autor)
        {
            try
            {
                context.Autores.Update(autor);
                context.SaveChanges();
                return $"Autor {autor.AutorId}: {autor.Nombre} fue editado correctamente..";
            }
            catch (Exception ex)
            {
                return ex.InnerException!.Message;
            }
        }

        // DELETE api/<AutoreController>/5
        [HttpDelete("DeleteAutor/{id}")]
        public String DeleteAutor(int id)
        {
            var autorBuscado = context.Autores.Find(id);
            //if (autorBuscado == null)
            //{
            //    return "El autor no existe.";
            //}

            //// Remover el autor
            //context.Autores.Remove(autorBuscado);

            //// Guardar los cambios en la base de datos
            //context.SaveChanges();

            context.Autores.Find(id)!.Estado = "Inactivo";
            context.SaveChanges();

            return $"Autor {autorBuscado!.Nombre} eliminado exitosamente.";
        }
    }
}
