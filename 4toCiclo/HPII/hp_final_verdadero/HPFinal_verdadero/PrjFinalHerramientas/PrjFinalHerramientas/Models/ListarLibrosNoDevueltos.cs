using System.ComponentModel.DataAnnotations;

namespace PrjFinalHerramientas.Models
{
    public class ListarLibrosNoDevueltos
    {
        [Key]
        public int PrestamoID { get; set; }
        public int UsuarioID { get; set; }
        public string UsuarioNombre { get; set; } = "";
        public int LibroID { get; set; }
        public string LibroTitulo { get; set; } = "";
        public DateOnly? FechaPrestamo { get; set; }
        public DateOnly? FechaDevolucion { get; set; }
    }
}
