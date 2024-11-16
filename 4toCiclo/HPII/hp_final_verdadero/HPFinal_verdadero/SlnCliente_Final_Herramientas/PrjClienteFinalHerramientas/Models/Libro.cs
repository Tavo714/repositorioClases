using System.ComponentModel.DataAnnotations;

namespace PrjClienteFinalHerramientas.Models
{
    public class Libro
    {
        [Display(Name = "Identificador del Libro: ")]
        public int LibroId { get; set; }

        [Required(ErrorMessage = "El título del libro es obligatorio.")]
        [Display(Name = "Título: ")]
        public string Titulo { get; set; } = null!;

        [Display(Name = "Año de Publicación: ")]
        public int? AñoPublicacion { get; set; }

        [Display(Name = "Autor: ")]
        public int? AutorId { get; set; }

        [Required(ErrorMessage = "El stock es obligatorio.")]
        [Range(0, int.MaxValue, ErrorMessage = "El stock debe ser un número positivo.")]
        [Display(Name = "Stock: ")]
        public int Stock { get; set; }
        
        public string? Estado { get; set; } 
        
        public Autor? Autor { get; set; }
    }
}
