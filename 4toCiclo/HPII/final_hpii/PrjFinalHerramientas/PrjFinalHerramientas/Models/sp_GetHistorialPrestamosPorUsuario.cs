using System.ComponentModel.DataAnnotations;

namespace PrjFinalHerramientas.Models
{
    public class sp_GetHistorialPrestamosPorUsuario
    {      
        [Key]
        public int PrestamoId { get; set; }
        public string Libro { get; set; } = "";
        public DateTime FechaPrestamo { get; set; }
        public DateTime FechaDevolucion { get; set; }
        public string Estado { get; set; } = "";
        public string Distrito { get; set; } = "";

    }
}
