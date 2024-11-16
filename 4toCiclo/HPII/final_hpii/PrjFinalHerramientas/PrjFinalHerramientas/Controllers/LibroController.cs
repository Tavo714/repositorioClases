using Microsoft.AspNetCore.Mvc;
using PrjFinalHerramientas.Models;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace PrjFinalHerramientas.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class LibroController : ControllerBase
    {
        private readonly HpiifinalBibliotecaContext context;
        public LibroController(HpiifinalBibliotecaContext _context)
        {
            context = _context;
        }

        // GET: api/<LibroController>
        [HttpGet("GetLibros")]
        public List<Libro> GetLibros()
        {
            var listado = context.Libros.Where(c => c.Estado == "Activo").ToList();
            return listado;
        }

        // GET api/<LibroController>/5
        [HttpGet("GetLibro/{id}")]
        public Libro GetLibro(int id)
        {
            var libroBuscado = context.Libros.Find(id);
            return libroBuscado!;
        }

        // POST api/<LibroController>
        [HttpPost("PostLibro")]
        public String PostLibro([FromBody] Libro libro)
        {
            try
            {
                context.Libros.Add(libro);
                context.SaveChanges();
                return $"Libro: {libro.Titulo} registrado correctamente...";
            }
            catch (Exception ex)
            {
                return ex.InnerException!.Message;
            }
        }

        // PUT api/<LibroController>/5
        [HttpPut("PutLibro")]
        public String PutLibro( [FromBody] Libro libro)
        {
            try
            {
                context.Libros.Update(libro);
                context.SaveChanges();
                return $"Libro: {libro.LibroId} modificado correctamente...";
            }
            catch (Exception ex)
            {
                return ex.InnerException!.Message;
            }
        }

        // DELETE api/<LibroController>/5
        [HttpDelete("DeleteLibro/{id}")]
        public String DeleteLibro(int id)
        {
            var libroBuscado = context.Libros.Find(id);
            context.Libros.Find(id)!.Estado = "Inactivo";
            context.SaveChanges();

            return $"Libro {libroBuscado!.Titulo} eliminado exitosamente.";
        }
    }
}
